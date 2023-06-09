package com.vinilemess.enchanting

import com.vinilemess.enchanting.enchantment.Enchantment
import com.vinilemess.enchanting.enchantment.Enchantments
import kotlin.random.Random

class MagicBook {

    private val enchantments = Enchantments.values()

    fun summonEnchantment(): Enchantment? {
        if (Random.nextDouble() < 0.1) {
            return null
        }
        return enchantments[Random.nextInt(enchantments.size)].enchantment
    }
}