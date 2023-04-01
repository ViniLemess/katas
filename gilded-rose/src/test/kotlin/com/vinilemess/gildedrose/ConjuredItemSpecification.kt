package com.vinilemess.gildedrose

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ConjuredItemSpecification {

    @Test
    fun `when update quality Of item with name starting with conjured quality should decrease by 2`() {
        val items = listOf(Item("$CONJURED_PREFIX Mana Cake", 30, 50))
        val guildedRose = GildedRose(items)

        guildedRose.updateQuality()

        assertEquals(48, items[0].quality)
        assertEquals(29, items[0].sellIn)
    }

    @Test
    fun `when update quality of item with conjured as starting name and sellIn equals to 0 quality should decrease by 4`() {
        val items = listOf(Item("$CONJURED_PREFIX Mana Cake", 0, 50))
        val guildedRose = GildedRose(items)

        guildedRose.updateQuality()

        assertEquals(46, items[0].quality)
        assertEquals(0, items[0].sellIn)
    }
}