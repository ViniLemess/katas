package com.vinilemess.gildedrose

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

private const val ARTHUR_SWORD = "Arthur Sword"

class NormalItemSpecification {

    @Test
    fun `quality should decreaase by 1 when update quality`() {
        val items = listOf(Item(ARTHUR_SWORD, 30, 50))
        val guildedRose = GildedRose(items)

        guildedRose.updateQuality()

        assertEquals(49, items[0].quality)
        assertEquals(29, items[0].sellIn)
    }

    @Test
    fun `when update quality with sellIn equal to 0 quality should decrease by 2`() {
        val items = listOf(Item(ARTHUR_SWORD, 0, 50))
        val guildedRose = GildedRose(items)

        guildedRose.updateQuality()

        assertEquals(48, items[0].quality)
        assertEquals(0, items[0].sellIn)
    }

    @Test
    fun `quality should not be less than 0 when update quality`() {
        val items = listOf(Item(ARTHUR_SWORD, 30, 0))
        val guildedRose = GildedRose(items)

        guildedRose.updateQuality()

        assertTrue { items[0].quality >= 0 }
        assertEquals(29, items[0].sellIn)
    }
}