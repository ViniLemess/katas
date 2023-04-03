package com.vinilemess.gildedrose.strategies

import com.vinilemess.gildedrose.Item
import org.slf4j.LoggerFactory

class SulfurasStrategy: UpdateItemStrategy {

    private val log = LoggerFactory.getLogger(SulfurasStrategy::class.java)

    override fun updateItem(item: Item): Item {
        log.info("No quality updates for the item {}", item.name)
        return item
    }
}