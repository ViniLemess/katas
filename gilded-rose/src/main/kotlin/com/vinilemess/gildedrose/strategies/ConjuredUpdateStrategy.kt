package com.vinilemess.gildedrose.strategies

import com.vinilemess.gildedrose.CONJURED_PREFIX
import com.vinilemess.gildedrose.Item

class ConjuredUpdateStrategy(private val defaultUpdateStrategy: DefaultUpdateStrategy) : UpdateItemStrategy {
    override fun updateItem(item: Item): Item {
        return if (item.name.startsWith(CONJURED_PREFIX)) {
            val updatedItem = updateQuality(item)
            updatedItem.decreaseSellIn()
            return updatedItem
        } else {
            defaultUpdateStrategy.updateItem(item)
        }
    }

    private fun updateQuality(item: Item): Item {
        if (item.sellIn == 0) item.decreaseQuality(4)
        else item.decreaseQuality(2)

        return item
    }
}