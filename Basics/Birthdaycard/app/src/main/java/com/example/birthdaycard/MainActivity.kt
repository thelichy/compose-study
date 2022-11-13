package com.example.birthdaycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.birthdaycard.ui.theme.BirthdayCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BirthdayCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BirthdayCardWithImage(to = "Thierry", from = "Android")
                }
            }
        }
    }
}

@Composable
fun BirthdayCardWithText(to: String = "Android", from: String = "Someone") {
    Surface(color = Color.Green) {
        Column {
        Text(
            text = "Happy Birthday $to!",
            fontSize = 32.sp,
            modifier = Modifier
                .fillMaxWidth()
        )
        Text(
            text = "From: $from.",
            fontSize = 30.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.Start)
        )
        YellowText("Yellow")
        }
    }
}

@Composable
fun YellowText(message: String = "") {
    Surface(color = Color.Red) {
        Text(text = message, modifier = Modifier.padding(24.dp), color = Color.Yellow)
    }    
}


@Composable
fun BirthdayCardWithImage(to: String = "Android", from: String = "Someone") {
    val image = painterResource(R.drawable.androidparty)
    Box {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        BirthdayCardWithText(to = to, from = from)
    }
}

@Preview(showBackground = false)
@Composable
fun BirthdayCardPreview() {
    BirthdayCardTheme {
        BirthdayCardWithImage("Thierry", "Android")
    }
}
