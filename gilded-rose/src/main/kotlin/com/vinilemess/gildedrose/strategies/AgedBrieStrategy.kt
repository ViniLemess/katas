package com.vinilemess.gildedrose.strategies

import com.vinilemess.gildedrose.Item

class AgedBrieStrategy: UpdateItemStrategy {
    override fun updateItem(item: Item): Item {
        item.increaseQuality()
        item.decreaseSellIn()
        return item
    }
}