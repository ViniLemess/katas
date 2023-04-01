package com.vinilemess.gildedrose

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class NormalItemSpecification {

    @Test
    fun qualityShouldDecreaaseBy1_WhenUpdateQuality() {
        val items = listOf(Item("Arthur Sword", 30, 50))
        val guildedRose = GildedRose(items)

        guildedRose.updateQuality()

        assertEquals(49, items[0].quality)
        assertEquals(29, items[0].sellIn)
    }

    @Test
    fun whenUpdateQualityWithSellInEqualTo0_qualityShouldDecreaseBy2() {
        val items = listOf(Item("Arthur Sword", 0, 50))
        val guildedRose = GildedRose(items)

        guildedRose.updateQuality()

        assertEquals(48, items[0].quality)
        assertEquals(0, items[0].sellIn)
    }

    @Test
    fun qualityShouldNotBeLessThan0_whenUpdateQuality() {
        val items = listOf(Item("Arthur Sword", 30, 0))
        val guildedRose = GildedRose(items)

        guildedRose.updateQuality()

        assertTrue { items[0].quality >= 0 }
        assertEquals(29, items[0].sellIn)
    }
}