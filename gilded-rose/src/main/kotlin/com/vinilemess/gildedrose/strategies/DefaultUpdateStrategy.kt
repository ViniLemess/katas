package com.vinilemess.gildedrose.strategies

import com.vinilemess.gildedrose.Item

class DefaultUpdateStrategy : UpdateItemStrategy {

    override fun updateItem(item: Item): Item {
        if (item.sellIn == 0) item.decreaseQuality(2)
        else item.decreaseQuality()

        item.decreaseSellIn()
        return item
    }
}