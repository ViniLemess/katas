package com.vinilemess.enchanting

import com.vinilemess.enchanting.enchantment.Enchantment
import com.vinilemess.enchanting.weapon.Weapon

class EnchantmentTable(private val weapon: Weapon, private val magicBook: MagicBook) {

    fun enchant() {
        weapon.enchantment = magicBook.summonEnchantment()
    }

    fun describeWeapon(): String {
        return weapon.stats()
    }
}
