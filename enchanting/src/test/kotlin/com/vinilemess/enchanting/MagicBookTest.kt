package com.vinilemess.enchanting

import kotlin.test.DefaultAsserter.assertTrue
import kotlin.test.Test

class MagicBookTest {

    private val magicBook: MagicBook = MagicBook()
    private val iterations = 100000
    private val tolerance = (iterations * 0.01).toInt()

    @Test
    fun `Should return null 10 percent of the times summonEnchantment is called with range assertion`() {
        var nullCount = 0

        repeat(iterations) {
            val enchantment = magicBook.summonEnchantment()
            if (enchantment == null) {
                nullCount++
            }
        }

        val expectedNullCount = (iterations * 0.1).toInt()

        assertTrue(
            "The null count ($nullCount) should be close to $expectedNullCount",
            nullCount in (expectedNullCount - tolerance)..(expectedNullCount + tolerance)
        )

        println("Null count: $nullCount from $iterations iterations")
    }

    @Test
    fun `Should return null 10 percent of the times summonEnchantment is called with percentage assertion`() {
        var nullCount = 0

        repeat(iterations) {
            val enchantment = magicBook.summonEnchantment()
            if (enchantment == null) {
                nullCount++
            }
        }

        val expectedPercentage = 10

        assertTrue("The percentage of null returns should be around $expectedPercentage%",
            calculateRoundPercentage(iterations, nullCount) in (expectedPercentage - tolerance)..(expectedPercentage + tolerance))
    }

    @Test
    fun `Should return an Enchantment 90 percent of the times summonEnchantment is called with range assertion`() {
        var enchantmentCount = 0

        repeat(iterations) {
            val enchantment = magicBook.summonEnchantment()
            if (enchantment != null) {
                enchantmentCount++
            }
        }

        val expectedEnchantmentCount = (iterations * 0.9).toInt()

        assertTrue(
            "The enchantment count ($enchantmentCount) should be close to $expectedEnchantmentCount",
            enchantmentCount in (expectedEnchantmentCount - tolerance)..(expectedEnchantmentCount + tolerance)
        )

        println("Enchantment count: $enchantmentCount from $iterations iterations")
    }

    @Test
    fun `Should return an Enchantment 90 percent of the times summonEnchantment is called with percentage assertion`() {
        var enchantmentCount = 0

        repeat(iterations) {
            val enchantment = magicBook.summonEnchantment()
            if (enchantment != null) {
                enchantmentCount++
            }
        }

        val expectedPercentage = 90

        assertTrue("The percentage of null returns should be around $expectedPercentage%",
            calculateRoundPercentage(iterations, enchantmentCount) in (expectedPercentage - tolerance)..(expectedPercentage + tolerance))
    }
}