package com.example.tipcalculator

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.example.tipcalculator.ui.theme.TipCalculatorTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class TipUITests {
    @get:Rule
    val composeTestRule = createComposeRule()


    @Test
    fun calculate_10PercentTip() {
        val expected = NumberFormat.getCurrencyInstance().format(2.0)

        composeTestRule.setContent {
            TipCalculatorTheme {
                TipCalculatorApp()
            }
        }

        composeTestRule.onNodeWithText("Bill Amount").performTextInput("20")
        composeTestRule.onNodeWithText("Tip Percentage").performTextInput("10")
        composeTestRule.onNodeWithText("Tip Amount: $expected").assertExists("Node not found")
    }
}
