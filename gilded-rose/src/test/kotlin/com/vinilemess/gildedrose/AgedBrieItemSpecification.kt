package com.vinilemess.gildedrose

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class AgedBrieItemSpecification {

    @Test
    fun `quality should increase by 1 when update quality`() {
        val items = listOf(Item(AGED_BRIE, 30, 30))
        val guildedRose = GildedRose(items)

        guildedRose.updateQuality();

        assertEquals(31, items[0].quality)
        assertEquals(29, items[0].sellIn)
    }

    @Test
    fun `when update item with sellIn equal to 0 quality should increase by 2`() {
        val items = listOf(Item(AGED_BRIE, 0, 30))
        val guildedRose = GildedRose(items)

        guildedRose.updateQuality();

        assertEquals(32, items[0].quality)
        assertEquals(0, items[0].sellIn)
    }

    @Test
    fun `quality should not be greater than 50 when update quality`() {
        val items = listOf(Item(AGED_BRIE, 30, 50))
        val guildedRose = GildedRose(items)

        guildedRose.updateQuality();

        assertTrue { items[0].quality <= 50 }
        assertEquals(29, items[0].sellIn)
    }
}