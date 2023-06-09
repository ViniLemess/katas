package com.vinilemess.enchanting

fun calculateRoundPercentage(base: Int, part: Int): Int {
    return (part.toDouble() / base * 100).toInt()
}