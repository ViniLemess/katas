package com.vinilemess.gildedrose.strategies

import com.vinilemess.gildedrose.Item

class DefaultUpdateStrategy: UpdateItemStrategy {

    override fun updateItem(item: Item): Item {
        item.decreaseQuality(1)
        item.decreaseSellIn()
        return item
    }
}