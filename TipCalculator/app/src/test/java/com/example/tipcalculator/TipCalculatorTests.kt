package com.example.tipcalculator

import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.NumberFormat

class TipCalculatorTests {
    @Test
    fun calculateTip_10PercentRoundUp() {
        val amount = 20.0
        val percent = 10.0
        val expected = NumberFormat.getCurrencyInstance().format(2)
        val actual = calculateTip(amount, percent, false)
        assertEquals(expected, actual)
    }
}