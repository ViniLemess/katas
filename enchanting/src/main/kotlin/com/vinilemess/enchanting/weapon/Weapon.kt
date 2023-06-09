package com.vinilemess.enchanting.weapon

import com.vinilemess.enchanting.enchantment.Enchantment

interface Weapon {
    val originalName: String
    var enchantment: Enchantment?
    val baseStats: List<String>

    fun stats(): String {
        val baseStatsJoined = baseStats.joinToString("\n")
        val attribute = enchantment?.attribute
        return "$baseStatsJoined\n${attribute ?: ""}"
    }

    fun getWeaponName(): String {
        return enchantment?.let { "${it.prefix} $originalName" } ?: originalName
    }
}