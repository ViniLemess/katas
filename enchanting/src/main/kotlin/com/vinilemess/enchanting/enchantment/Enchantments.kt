package com.vinilemess.enchanting.enchantment

enum class Enchantments (val enchantment: Enchantment) {
    ICE(Enchantment("Icy", "+5 ice damage")),
    FIRE(Enchantment("Inferno", "+5 fire damage")),
    LIFESTEAL(Enchantment("Vampire", "+5 lifesteal")),
    AGILITY(Enchantment("Quick", "+5 agility")),
    STRENGTH(Enchantment("Angry", "+5 strength"))
}