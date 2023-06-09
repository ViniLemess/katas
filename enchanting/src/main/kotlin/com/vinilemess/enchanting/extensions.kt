package com.vinilemess.enchanting


fun String.capitalizeFirstChar() :String {
    val capitalizedFirstChar = this.substring(0, 1).uppercase()
    return "${capitalizedFirstChar}${this.substring(1, this.length).lowercase()}"
}