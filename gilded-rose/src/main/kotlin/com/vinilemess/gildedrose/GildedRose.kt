package com.vinilemess.gildedrose

import com.vinilemess.gildedrose.strategies.*

class GildedRose(private val items: List<Item>) {

    private val itemUpdateStrategies = mapOf(
        AGED_BRIE to AgedBrieStrategy(),
        BACKSTAGE_PASS to BackstagePassStrategy(),
        SULFURAS to SulfurasStrategy(),
    ).withDefault { ConjuredUpdateStrategy(DefaultUpdateStrategy()) }

    fun updateQuality() {
        items.map { item ->
            updateItemQuality(item)
        }
    }

    private fun updateItemQuality(item: Item): Item {
        return itemUpdateStrategies.getValue(item.name).updateItem(item)
    }
}