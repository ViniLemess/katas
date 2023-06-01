package com.vinilemess.enchanting

import com.vinilemess.enchanting.weapon.Weapon

class HDurance(private val weapon: Weapon, private val magicBook: MagicBook) {

    fun enchant() {
        // Implement here...
    }

    fun describeWeapon(): String {
        return weapon.stats()
    }
}
