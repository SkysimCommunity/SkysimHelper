package sh.lumin.skysim.utils.evaluators

import com.google.gson.JsonObject

val ITEM_PRICE_MAP = mutableMapOf(
    // DIMOON
    "HIDDEN_EXCRARION" to 2_000_000,
    "HIDDEN_DIMOONIZARY_DAGGER" to 600_000,
    //
    "HIDDEN_GIGACHAD_HELMET" to 75_000,
    "HIDDEN_GIGACHAD_CHESTPLATE" to 1_300_000,
    "HIDDEN_GIGACHAD_LEGGINGS" to 1_200_000,
    "HIDDEN_GIGACHAD_BOOTS" to 200_000,
    // SLAYERS
    "HIDDEN_SHARD_DIAMOND" to 85_000,
    "HIDDEN_WARDEN_CATALYST" to 5_000,
    "HIDDEN_GYRO_EYE" to 12_000,
    "HIDDEN_REFINED_POWDER" to 6_000,
    "HIDDEN_ETHERWARP_CONDUIT" to 8_000,
    "HIDDEN_DEMONS_EYE" to 1_200_000,
    "HIDDEN_DEMONS_PEARL" to 2_100_000,
    // EQUIP
    "HIDDEN_VOIDLING_RING" to 2_000_000,
    "HIDDEN_VOIDLING_BELT" to 10_000,
    "HIDDEN_VOIDLING_NECKLACE" to 2_000_000,
    "HIDDEN_LUCKINESS_NECKLACE" to 165_000,
    "HIDDEN_BERSERKER_GLOVE" to 165_000,
    // ARMOR
    "HIDDEN_VOIDLINGS_WARDEN_HELMET" to 2_750_000,
    "HIDDEN_VOIDINVADER_CHESTPLATE" to 3_300_000,
    "HIDDEN_VOIDINVADER_LEGGINGS" to 3_200_000,
    "HIDDEN_VOIDINVADER_BOOTS" to 2_200_000,
    // WEAPONS
    "HIDDEN_VOIDCRUSHER_BLADE" to 4_200_000,
    // DUNGEONS
    "HIDDEN_ELDVORGR_FURY" to 2_000_000,
    "HIDDEN_HODS_BOW" to 850_000,
    // THURM, SHADOWSTRIKE
    "HIDDEN_ELDVORGR_HELMET" to 2_300_000,
    "HIDDEN_ELDVORGR_CHESTPLATE" to 4_000_000,
    "HIDDEN_ELDVORGR_LEGGINGS" to 3_500_000,
    "HIDDEN_ELDVORGR_BOOTS" to 2_300_000,
    //
    "HIDDEN_ARCANE_HELMET" to 2_400_000,
    "HIDDEN_ARCANE_CHESTPLATE" to 4_100_000,
    "HIDDEN_ARCANE_LEGGINGS" to 3_600_000,
    "HIDDEN_ARCANE_BOOTS" to 2_400_000,
    //
    "HIDDEN_GRACEFUL_HELMET" to 2_400_000,
    "HIDDEN_GRACEFUL_CHESTPLATE" to 4_100_000,
    "HIDDEN_GRACEFUL_LEGGINGS" to 3_600_000,
    "HIDDEN_GRACEFUL_BOOTS" to 2_400_000,
    //
    "HIDDEN_BASTION_HELMET" to 2_400_000,
    "HIDDEN_BASTION_CHESTPLATE" to 4_100_000,
    "HIDDEN_BASTION_LEGGINGS" to 3_600_000,
    "HIDDEN_BASTION_BOOTS" to 2_400_000,
    //
    "HIDDEN_SKALDIC_HELMET" to 2_400_000,
    "HIDDEN_SKALDIC_CHESTPLATE" to 4_100_000,
    "HIDDEN_SKALDIC_LEGGINGS" to 3_600_000,
    "HIDDEN_SKALDIC_BOOTS" to 2_400_000,
    // MINING
    // PETS
    "HIDDEN_RADIOACTIVE_GOLEM" to 420_000, // unknown max!
    // PARTS
    "HIDDEN_DRILL_FUEL_TANK" to 18_200,
    "HIDDEN_BASE_DRILL_ENGINE" to 27_300,
    // DRILLS
    "HIDDEN_ROOKIE_DRILL" to 5_000,
    "HIDDEN_POLONIUM_DRILL" to 335_000,
    "HIDDEN_RADIUM_DRILL" to 650_500,
    "HIDDEN_FRANCIUM_DRILL" to 1_026_000,
    "HIDDEN_URANIUM_DRILL" to 1_491_500,
    "HIDDEN_FUSION_DRILL" to 6_782_500,
    // ARMOR
    "HIDDEN_POLONIUM_HELMET" to 24_960,
    "HIDDEN_POLONIUM_CHESTPLATE" to 43_680,
    "HIDDEN_POLONIUM_LEGGINGS" to 37_440,
    "HIDDEN_POLONIUM_BOOTS" to 18_720,
    //
    "HIDDEN_RADIUM_HELMET" to 56_920,
    "HIDDEN_RADIUM_CHESTPLATE" to 99_610,
    "HIDDEN_RADIUM_LEGGINGS" to 37_440,
    "HIDDEN_RADIUM_BOOTS" to 42_690,
    //
    "HIDDEN_FRANCIUM_HELMET" to 95_992,
    "HIDDEN_FRANCIUM_CHESTPLATE" to 167_986,
    "HIDDEN_FRANCIUM_LEGGINGS" to 143_988,
    "HIDDEN_FRANCIUM_BOOTS" to 71_994,
    //
    "HIDDEN_URANIUM_HELMET" to 145_720,
    "HIDDEN_URANIUM_CHESTPLATE" to 255_010,
    "HIDDEN_URANIUM_LEGGINGS" to 218_580,
    "HIDDEN_URANIUM_BOOTS" to 109_290,
    //
    "HIDDEN_ULTRA_FUSION_HELMET" to 473_600,
    "HIDDEN_ULTRA_FUSION_CHESTPLATE" to 829_600,
    "HIDDEN_ULTRA_FUSION_LEGGINGS" to 710_400,
    "HIDDEN_ULTRA_FUSION_BOOTS" to 355_200,
    // EQUIPMENT
    "HIDDEN_BASIC_MINER_RING" to 115_000,
    "HIDDEN_DECENT_MINER_RING" to 160_000,
    "HIDDEN_GREAT_MINER_RING" to 215_000,
    "HIDDEN_CRAZY_MINER_RING" to 285_000,
    "HIDDEN_INSANE_MINER_RING" to 810_000,
    "HIDDEN_MINESHAFTER_BELT" to 40_000,
    "HIDDEN_MINESHAFTER_GLOVE" to 50_000,
    "HIDDEN_RADICAL_GLOVE" to 46_620,
    "HIDDEN_MINER_NECKLACE" to 20_800,
    // ORES
    "HIDDEN_RAW_POLONIUM" to 2,
    "HIDDEN_RAW_RADIUM" to 3,
    "HIDDEN_RAW_FRANCI" to 4,
    "HIDDEN_RAW_URANIUM" to 5,
    //
    "HIDDEN_ENCHANTED_POLONIUM" to 260,
    "HIDDEN_ENCHANTED_RADIUM" to 333,
    "HIDDEN_ENCHANTED_FRANCI" to 407,
    "HIDDEN_ENCHANTED_URANIUM" to 518,
    //
    "HIDDEN_COMPRESSED_POLONIUM" to 35_000,
    "HIDDEN_COMPRESSED_RADIUM" to 45_000,
    "HIDDEN_COMPRESSED_FRANCI" to 55_000,
    "HIDDEN_COMPRESSED_URANIUM" to 70_000,
    // MISC
    "HIDDEN_DONATOR_HELMET" to 800_000
)

object ItemEvaluator {
    fun valueItem(item: JsonObject): Int {
        val typeElement = item["type"] ?: return 0
        if (typeElement.isJsonNull) return 0
        val type = typeElement.asString ?: return 0
        //
        if(item.has("xp")) {
            return PetEvaluator.valuePet(item)
        }
        //
        var value = ITEM_PRICE_MAP[type] ?: 0

        val quantityElement = item["amount"]
        if (quantityElement != null && !quantityElement.isJsonNull) {
            value *= quantityElement.asInt
        }

        val nameElement = item["name"]
        if (nameElement != null && !nameElement.isJsonNull) {
            val name = nameElement.asString
            if (quantityElement?.asInt != 1) {
                item.remove("name")
                item.addProperty("name", "${quantityElement}x $name")
            }
        }

        val loreElement = item["lore"] ?: return value
        if (loreElement.isJsonNull) return 0

        val enchantmentsValue = EnchantmentEvaluator.valueEnchants(loreElement.asJsonArray.map { it.asString })
        value += enchantmentsValue

        value += StarEvaluator.valueItem(item)

        return value
    }
}