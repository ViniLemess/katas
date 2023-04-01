package com.vinilemess.gildedrose

import com.vinilemess.gildedrose.strategies.AgedBrieStrategy
import com.vinilemess.gildedrose.strategies.BackstagePassStrategy
import com.vinilemess.gildedrose.strategies.DefaultUpdateStrategy
import com.vinilemess.gildedrose.strategies.SulfurasStrategy

class GildedRose(private val items: List<Item>) {

    private val itemUpdateStrategies = mapOf(
        AGED_BRIE to AgedBrieStrategy(),
        BACKSTAGE_PASS to BackstagePassStrategy(),
        SULFURAS to SulfurasStrategy(),
    ).withDefault { DefaultUpdateStrategy() }

    fun updateQuality() {
        items.map { item ->
            updateItemQuality(item)
        }
    }

    private fun updateItemQuality(item: Item): Item {
        return itemUpdateStrategies.getValue(item.name).updateItem(item)
    }
}