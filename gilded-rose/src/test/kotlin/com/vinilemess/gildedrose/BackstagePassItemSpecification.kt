package com.vinilemess.gildedrose

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class BackstagePassItemSpecification {

    @Test
    fun qualityShouldIncreaseBy1_WhenUpdateQuality() {
        val items = listOf(Item(BACKSTAGE_PASS, 30, 30))
        val guildedRose = GildedRose(items)

        guildedRose.updateQuality();

        assertEquals(31, items[0].quality)
        assertEquals(29, items[0].sellIn)
    }

    @Test
    fun whenUpdateItemWithSellInLessThanOrEqualTo0_qualityShouldBe0() {
        val items = listOf(Item(BACKSTAGE_PASS, 0, 0))
        val guildedRose = GildedRose(items)

        guildedRose.updateQuality();

        assertEquals(0, items[0].quality)
        assertEquals(0, items[0].sellIn)
    }

    @Test
    fun whenUpdateItemWithSellInLessThanOrEqualTo10_qualityShouldIncreaseBy2() {
        val items = listOf(Item(BACKSTAGE_PASS, 10, 30))
        val guildedRose = GildedRose(items)

        guildedRose.updateQuality();

        assertEquals(32, items[0].quality)
        assertEquals(9, items[0].sellIn)
    }

    @Test
    fun whenUpdateItemWithSellInLessThanOrEqualTo5_qualityShouldIncreaseBy3() {
        val items = listOf(Item(BACKSTAGE_PASS, 5, 30))
        val guildedRose = GildedRose(items)

        guildedRose.updateQuality();

        assertEquals(33, items[0].quality)
        assertEquals(4, items[0].sellIn)
    }

    @Test
    fun qualityShouldNotBeGreaterThan50_whenUpdateQuality() {
        val items = listOf(Item(BACKSTAGE_PASS, 30, 50))
        val guildedRose = GildedRose(items)

        guildedRose.updateQuality();

        assertTrue { items[0].quality <= 50 }
        assertEquals(29, items[0].sellIn)
    }
}