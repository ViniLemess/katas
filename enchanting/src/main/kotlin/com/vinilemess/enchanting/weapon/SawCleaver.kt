package com.vinilemess.enchanting.weapon

import com.vinilemess.enchanting.enchantment.Enchantment

class SawCleaver(
    override var weaponName: String = "SawCleaver",
    override var enchantment: Enchantment?
) : Weapon {

    override val baseStats: List<String> = listOf(
        "90 Physical Attack",
        "200 Durability",
        "100 Special Attack to Kin and Beasts"
    )
}