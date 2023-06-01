package com.vinilemess.enchanting.weapon

import com.vinilemess.enchanting.enchantment.Enchantment

interface Weapon {
    var weaponName: String
    var enchantment: Enchantment?
    val baseStats: List<String>

    fun stats(): String {
        val baseStatsJoined = baseStats.joinToString("\n")
        val attribute = enchantment?.attribute
        return "$baseStatsJoined\n${attribute ?: ""}"
    }
}