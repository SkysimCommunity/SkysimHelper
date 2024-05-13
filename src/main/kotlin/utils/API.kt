package sh.lumin.skysim.utils

import com.google.gson.GsonBuilder
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import okhttp3.OkHttpClient
import okhttp3.Request
import sh.lumin.skysim.SS_API

object API {
    private val client = OkHttpClient()
    private const val baseURL = "https://api.skysim.sbs/"
    private val gson = GsonBuilder().serializeNulls().disableHtmlEscaping().setPrettyPrinting().create()
    //
    fun getPlayerItems(name: String): Map<String, JsonArray> {
        val request = Request.Builder()
            .get()
            .url("$baseURL?key=$SS_API&type=PLAYER_ITEMS&param=$name")
            .build()

        val response = client.newCall(request).execute()
        //
        val items = gson.fromJson(response.body?.string(), JsonObject::class.java)
        //
        val itemMap = mutableMapOf<String, JsonArray>()
        val itemTypes = listOf("inventory", "equipments", "enderchest", "armor", "wardrobe", "vaults", "pets")
        //
        for(type in itemTypes) {
            if(items.has(type)) {
                val item = items.get(type)
                if(item != null && !item.isJsonNull) {
                    itemMap[type] = item.asJsonArray
                }
            } else {
                itemMap[type] = JsonArray()
            }
        }
        //
        return itemMap
    }

    fun getPlayerBits(name: String): Long {
        val request = Request.Builder().get()
            .url("$baseURL?key=$SS_API&type=PLAYER_INFO&param=$name").build()
        val response = client.newCall(request).execute()
        //
        val info = gson.fromJson(response.body?.string(), JsonObject::class.java)
        //
        return info.get("bits").asLong
    }

    fun getPlayerMoney(name: String): Triple<Long, Double, Double> {
        val request = Request.Builder().get()
            .url("$baseURL?key=$SS_API&type=PLAYER_INFO&param=$name").build()
        val response = client.newCall(request).execute()
        //
        val info = gson.fromJson(response.body?.string(), JsonObject::class.java)
        //
        return Triple(
            info.get("bits").asLong,
            info.get("coins").asDouble,
            info.get("bankCoins").asDouble
        )
    }
}
