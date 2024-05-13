package sh.lumin.skysim.utils.evaluators


import sh.lumin.skysim.utils.API
import sh.lumin.skysim.utils.PetUtils
import sh.lumin.skysim.utils.Utils

object PlayerEvaluator {
    private val itemTypes = listOf("inventory", "equipments", "enderchest", "armor", "wardrobe", "pets")
                                        // total nw -> most valuable items -> category worths
    fun valuePlayer(name: String): Triple<Long, Map<String, List<Pair<String, Int>>>, Map<String, Long>> {

        val items = API.getPlayerItems(name)
        val valueMap = mutableMapOf<String, Long>()
        //
        val topItemsMap = mutableMapOf<String, List<Pair<String, Int>>>()
        //

        // Calculate values for standard item types
        for (type in itemTypes) {
            val itemList = items[type]
            val totalValue = itemList?.filterNot { it.isJsonNull }?.sumOf {
                ItemEvaluator.valueItem(it.asJsonObject)
            } ?: 0

            valueMap[type] = totalValue.toLong()

            // Find top 5 most valuable items for the current type
            val topItems = itemList?.asSequence()?.filterNot { it.isJsonNull }?.map { it.asJsonObject }?.map {
                val itemName = it["name"]?.asString ?: PetUtils.petNameMap[it["type"]?.asString] ?: "Unknown Item"
                //
                val stars = (itemName.substringAfterLast(' ', itemName)).windowed(3).count { f -> f == "§c✪" }
                //
                val formattedName = itemName.replace("§c✪", "") + "✪".repeat(stars) + Utils.getStar(stars)
                //
                Pair("${Utils.removeFormatting(formattedName)} (**${Utils.formatNumber(ItemEvaluator.valueItem(it).toLong())}**)", ItemEvaluator.valueItem(it))
            }?.sortedByDescending { it.second }?.take(5)?.toList() ?: listOf()

            topItemsMap[type] = topItems
        }


        // Calculate value for vaults
        var vaultValue = 0L
        items["vaults"]?.let { vaults ->
            vaults.asJsonArray.forEach { subvault ->
                subvault.asJsonObject.get("items").asJsonArray?.let { itemList ->
                    vaultValue += itemList.filterNot { item -> item.isJsonNull }.sumOf { item ->
                        ItemEvaluator.valueItem(item.asJsonObject)
                    }
                }
            }
        }
        //
        val topVaultItems = items["vaults"]?.asJsonArray?.asSequence()?.flatMap { it.asJsonObject["items"].asJsonArray }
            ?.filterNot { it.isJsonNull }
            ?.map { it.asJsonObject }?.mapNotNull {
                val itemName = it["name"]
                if (!itemName.isJsonNull) {
                    Pair("${Utils.removeFormatting(itemName.asString)} (**${Utils.formatNumber(ItemEvaluator.valueItem(it).toLong())}**)", ItemEvaluator.valueItem(it))
                } else {
                    null // Skip items without names
                }
            }?.sortedByDescending { it.second }
            ?.take(5)?.toList() ?: listOf()
        //
        topItemsMap["vaults"] = topVaultItems
        //
        valueMap["vaults"] = vaultValue
        //
        val (bits, purse, bank) = API.getPlayerMoney(name)
        valueMap["purse"] = bits
        // Calculate total value
        val totalValue = valueMap.values.sum()
        valueMap["coins"] = purse.toLong()
        valueMap["bank"] = bank.toLong()
        //
        return Triple(totalValue, topItemsMap, valueMap)
    }
}