package com.vinilemess.gildedrose

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class AgedBrieItemSpecification {

    @Test
    fun qualityShouldIncreaseBy1_WhenUpdateQuality() {
        val items = listOf(Item(AGED_BRIE, 30, 30))
        val guildedRose = GildedRose(items)

        guildedRose.updateQuality();

        assertEquals(31, items[0].quality)
        assertEquals(29, items[0].sellIn)
    }

    @Test
    fun whenUpdateItemWithSellInEqualTo0_qualityShouldIncreaseBy2() {
        val items = listOf(Item(AGED_BRIE, 0, 30))
        val guildedRose = GildedRose(items)

        guildedRose.updateQuality();

        assertEquals(32, items[0].quality)
        assertEquals(0, items[0].sellIn)
    }

    @Test
    fun qualityShouldNotBeGreaterThan50_whenUpdateQuality() {
        val items = listOf(Item(AGED_BRIE, 30, 50))
        val guildedRose = GildedRose(items)

        guildedRose.updateQuality();

        assertTrue { items[0].quality <= 50 }
        assertEquals(29, items[0].sellIn)
    }
}