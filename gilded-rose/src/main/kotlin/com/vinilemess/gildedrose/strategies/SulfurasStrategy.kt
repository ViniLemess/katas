package com.vinilemess.gildedrose.strategies

import com.sun.org.slf4j.internal.LoggerFactory
import com.vinilemess.gildedrose.Item

class SulfurasStrategy: UpdateItemStrategy {

    private val log = LoggerFactory.getLogger(SulfurasStrategy::class.java)

    override fun updateItem(item: Item): Item {
        log.debug("No quality updates for the item {}", item)
        return item
    }
}