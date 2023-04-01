package com.vinilemess.gildedrose.strategies

import com.vinilemess.gildedrose.Item
 interface UpdateItemStrategy {

    fun updateItem(item: Item): Item

    fun Item.increaseQuality(amount: Int = 1) {
        quality = (quality + amount).coerceAtMost(50)
    }

    fun Item.decreaseQuality(amount: Int) {
        quality = (quality - amount).coerceAtLeast(0)
    }

    fun Item.decreaseSellIn() {
        sellIn = (sellIn - 1).coerceAtLeast(0)
    }
}