package com.vinilemess.gildedrose.strategies

import com.vinilemess.gildedrose.Item

class AgedBrieStrategy : UpdateItemStrategy {
    override fun updateItem(item: Item): Item {
        if (item.sellIn == 0) item.increaseQuality(2)
        else item.increaseQuality()

        item.decreaseSellIn()
        return item
    }
}