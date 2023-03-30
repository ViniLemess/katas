package com.vinilemess.gildedrose

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SulfurasItemSpecification {

    @Test
    fun qualityShouldNotChange_WhenUpdateQuality() {
        val items = listOf(Item(SULFURAS, 30, 80))
        val guildedRose = GildedRose(items)

        guildedRose.updateQuality();

        assertEquals(80, items[0].quality)
        assertEquals(30, items[0].sellIn)
    }

    @Test
    fun sellInShouldNotDecrease_WhenUpdateQuality() {
        val items = listOf(Item(SULFURAS, 0, 80))
        val guildedRose = GildedRose(items)

        guildedRose.updateQuality();

        assertEquals(0, items[0].sellIn)
    }
}