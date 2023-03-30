package com.vinilemess.gildedrose

import com.sun.org.slf4j.internal.LoggerFactory

class GildedRose(var items: List<Item>) {

    val logger = LoggerFactory.getLogger(GildedRose::class.java)

    fun updateQuality() {
        val updatedItems = arrayListOf<Item>()
        items.forEach { item ->
            updatedItems.add(updateItemQuality(item))
        }
    }

    private fun updateItemQuality(item: Item): Item {
        var qualityChange = 1

        if (item.name.startsWith("Conjured")) {
            qualityChange = 2
        }

        when (item.name) {
            AGED_BRIE -> item.increaseQuality()
            BACKSTAGE_PASS -> updateBackstagePass(item)
            SULFURAS -> logger.debug("No quality updates for the item {}", item)
            else -> item.decreaseQuality(qualityChange)
        }

        if (item.name != SULFURAS) {
            item.sellIn = (item.sellIn - 1).coerceAtLeast(0)
        }

        if (item.sellIn <= 0) {
            when (item.name) {
                AGED_BRIE -> item.increaseQuality()
                BACKSTAGE_PASS -> item.quality = 0
                SULFURAS -> logger.debug("No quality updates for the item {}", item)
                else -> item.decreaseQuality(qualityChange)
            }
        }
        return item
    }

    private fun updateBackstagePass(item: Item) {
        when {
            item.sellIn <= 0 -> item.quality = 0
            item.sellIn <= 5 -> item.increaseQuality(3)
            item.sellIn <= 10 -> item.increaseQuality(2)
            else -> item.increaseQuality(1)
        }
    }

    private fun Item.increaseQuality(amount: Int = 1) {
        quality = (quality + amount).coerceAtMost(50)
    }

    private fun Item.decreaseQuality(amount: Int) {
        quality = (quality - amount).coerceAtLeast(0)
    }
}