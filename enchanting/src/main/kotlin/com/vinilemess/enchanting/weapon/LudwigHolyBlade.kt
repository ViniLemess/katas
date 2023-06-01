package com.vinilemess.enchanting.weapon

import com.vinilemess.enchanting.enchantment.Enchantment

class LudwigHolyBlade(
    override var weaponName: String = "Ludwig's Holy Blade",
    override var enchantment: Enchantment?
) : Weapon {

    override val baseStats: List<String> = listOf(
        "100 Physical Attack",
        "250 Durability",
        "100 Special Attack to Kin and Beasts"
    )
}