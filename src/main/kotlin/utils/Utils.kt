package sh.lumin.skysim.utils

import java.text.DecimalFormat
import java.text.NumberFormat

object Utils {
    private val formatter: NumberFormat = NumberFormat.getInstance()

    fun removeFormatting(text: String) = text.replace("[\u00a7&][0-9a-fk-or]".toRegex(), "")

    fun parseRomanNumeral(roman: String): Int {
        val map = mapOf('I' to 1, 'V' to 5, 'X' to 10, 'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000)
        var result = 0
        var prevValue = 0

        for (i in roman.indices.reversed()) {
            val value = map[roman[i]] ?: throw IllegalArgumentException("Invalid Roman numeral")
            result += if (value < prevValue) -value else value
            prevValue = value
        }
        return result
    }
    private val stars = listOf("", "➊", "➋", "➌", "➍", "➎")
    fun getStar(star: Int) = stars[star]

    fun getRarityByName(name: String): String {
        return when(name.substring(0, 2)) {
            "§c", "§b", "§d" -> "MYTHIC"
            "§6" -> "LEGENDARY"
            "§5" -> "EPIC"
            "§9" -> "RARE"
            "§a" -> "UNCOMMON"
            "§f" -> "COMMON"
            else -> ""
        }
    }

    fun getRarityString(rarity: String): String {
        return when(rarity) {
            "VERY_SPECIAL", "SPECIAL", "EXCLUSIVE", "SUPREME" -> "MYTHIC"
            "LEGENDARY" -> "LEGENDARY"
            "EPIC" -> "EPIC"
            "RARE" -> "RARE"
            "UNCOMMON" -> "UNCOMMON"
            "COMMON" -> "COMMON"
            else -> ""
        }
    }

    fun formatNumber(value: Float): String {
        val arr = arrayOf("", "k", "M", "B", "T", "P", "E")
        var index = 0
        var realValue = value
        while (realValue / 1000.0F >= 1.0F) {
            realValue /= 1000.0F
            index++
        }
        val decimalFormat = DecimalFormat("#.#")
        val formattedValue = if (realValue < 1000000.0F)
            decimalFormat.format(realValue)
        else
            realValue.toInt().toString()
        val finalResult = "$formattedValue${arr[index]}".replace(",", ".")
        return if (value <= 20000.0F && value > 0.0F)
            Math.round(value).toString()
        else
            finalResult
    }

    fun formatNumber(value: Long): String = formatNumber(value.toFloat())

    fun commaify(number: Number): String {
        return formatter.format(number)
    }
}