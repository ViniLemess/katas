package com.vinilemess.gildedrose

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class BackstagePassItemSpecification {

    @Test
    fun `quality should increase by 1 when update quality`() {
        val items = listOf(Item(BACKSTAGE_PASS, 30, 30))
        val guildedRose = GildedRose(items)

        guildedRose.updateQuality();

        assertEquals(31, items[0].quality)
        assertEquals(29, items[0].sellIn)
    }

    @Test
    fun `when update item with sellIn less than or equal to 0 quality should be 0`() {
        val items = listOf(Item(BACKSTAGE_PASS, 0, 0))
        val guildedRose = GildedRose(items)

        guildedRose.updateQuality();

        assertEquals(0, items[0].quality)
        assertEquals(0, items[0].sellIn)
    }

    @Test
    fun `when update item with sellIn less than or equal to 10 quality should increase by 2`() {
        val items = listOf(Item(BACKSTAGE_PASS, 10, 30))
        val guildedRose = GildedRose(items)

        guildedRose.updateQuality();

        assertEquals(32, items[0].quality)
        assertEquals(9, items[0].sellIn)
    }

    @Test
    fun `when update item with sellIn less than or equal to 5 quality should increase by 3`() {
        val items = listOf(Item(BACKSTAGE_PASS, 5, 30))
        val guildedRose = GildedRose(items)

        guildedRose.updateQuality();

        assertEquals(33, items[0].quality)
        assertEquals(4, items[0].sellIn)
    }

    @Test
    fun `quality should not be greater than 50 when update quality`() {
        val items = listOf(Item(BACKSTAGE_PASS, 30, 50))
        val guildedRose = GildedRose(items)

        guildedRose.updateQuality();

        assertTrue { items[0].quality <= 50 }
        assertEquals(29, items[0].sellIn)
    }
}