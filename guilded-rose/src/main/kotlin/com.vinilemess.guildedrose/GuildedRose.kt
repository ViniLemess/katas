package com.vinilemess.guildedrose

private const val SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros"

private const val BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert"

private const val AGED_BRIE = "Aged Brie"

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            if (items[i].name != AGED_BRIE && items[i].name != BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT) {
                if (items[i].quality > 0 && items[i].name != SULFURAS_HAND_OF_RAGNAROS) {
                    items[i].quality = items[i].quality - 1
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1

                    if (items[i].name == BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT) {
                        if (items[i].sellIn < 11 && items[i].quality < 50) {
                            items[i].quality = items[i].quality + 1
                        }

                        if (items[i].sellIn < 6 && items[i].quality < 50) {
                            items[i].quality = items[i].quality + 1
                        }
                    }
                }
            }

            if (items[i].name != SULFURAS_HAND_OF_RAGNAROS) {
                items[i].sellIn = items[i].sellIn - 1
            }

            if (items[i].sellIn < 0) {
                if (items[i].name != AGED_BRIE) {
                    if (items[i].name != BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT) {
                        if (items[i].quality > 0 && items[i].name != SULFURAS_HAND_OF_RAGNAROS) {
                            items[i].quality = items[i].quality - 1
                        }
                    } else {
                        items[i].quality = items[i].quality - this.items[i].quality
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1
                    }
                }
            }
        }
    }

}