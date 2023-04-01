package com.vinilemess.gildedrose

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ConjuredItemSpecification {

    @Test
    fun whenUpdateQualityOfItemWithNameStartingWithConjured_qualityShouldDecreaseBy2() {
        val items = listOf(Item("$CONJURED_PREFIX Mana Cake", 30, 50))
        val guildedRose = GildedRose(items)

        guildedRose.updateQuality()

        assertEquals(48, items[0].quality)
        assertEquals(29, items[0].sellIn)
    }

    @Test
    fun whenUpdateQualityOfItemWithNameStartingWithConjured_AndSellInEqualsTo0_qualityShouldDecreaseBy4() {
        val items = listOf(Item("$CONJURED_PREFIX Mana Cake", 0, 50))
        val guildedRose = GildedRose(items)

        guildedRose.updateQuality()

        assertEquals(46, items[0].quality)
        assertEquals(0, items[0].sellIn)
    }
}