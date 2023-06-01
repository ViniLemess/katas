package com.vinilemess.enchanting

import com.vinilemess.enchanting.enchantment.Enchantment
import com.vinilemess.enchanting.weapon.Weapon

class EnchantmentTable(private val weapon: Weapon, private val magicBook: MagicBook) {

    fun enchant() {
        val enchantment: Enchantment = magicBook.summonEnchantment()
        weapon.enchantment = enchantment
        weapon.weaponName = "${enchantment.prefix} ${weapon.weaponName}"
    }

    fun describeWeapon(): String {
        return weapon.stats()
    }
}
