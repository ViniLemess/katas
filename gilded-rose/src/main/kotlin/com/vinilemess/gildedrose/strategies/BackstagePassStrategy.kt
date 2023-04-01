package com.vinilemess.gildedrose.strategies

import com.vinilemess.gildedrose.Item

class BackstagePassStrategy: UpdateItemStrategy {
    override fun updateItem(item: Item): Item {
        when {
            item.sellIn <= 0 -> item.quality = 0
            item.sellIn <= 5 -> item.increaseQuality(3)
            item.sellIn <= 10 -> item.increaseQuality(2)
            else -> item.increaseQuality(1)
        }
        item.decreaseSellIn()
        return item
    }
}