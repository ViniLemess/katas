package com.vinilemess.enchanting.weapon

import com.vinilemess.enchanting.Enchantment

interface Weapon {
    var weaponName: String
    val baseStats: List<String>
    val enchantment: Enchantment?

    fun stats(): String
}