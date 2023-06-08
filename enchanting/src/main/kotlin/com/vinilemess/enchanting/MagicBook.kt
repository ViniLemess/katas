package com.vinilemess.enchanting

import com.vinilemess.enchanting.enchantment.Enchantment
import com.vinilemess.enchanting.enchantment.Enchantments
import kotlin.random.Random

class MagicBook {

    private val enchantments = Enchantments.values()

    fun summonEnchantment(): Enchantment {
        return enchantments[Random.nextInt(enchantments.size)].enchantment
    }
}