package com.vinilemess.gildedrose

open class Item(var name: String, var sellIn: Int, var quality: Int) {
    override fun toString(): String {
        return """
            name: $name
            sellIn: $sellIn
            quality: $quality
        """.trimIndent()
    }
}