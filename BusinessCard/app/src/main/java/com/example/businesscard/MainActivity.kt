package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                BusinessCardApp()
            }
        }
    }
}


@Composable
fun BusinessCardApp(modifier: Modifier = Modifier) {
    val imAndroid = painterResource(R.drawable.im_android)
    val icPhone   = painterResource(R.drawable.ic_phone)
    val icMail    = painterResource(R.drawable.ic_mail)

    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(color = Color(0xFF001614))
            .fillMaxSize()
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = imAndroid, contentDescription = null, modifier = Modifier
                    .width(128.dp)
                    .height(128.dp)
            )
            Text(
                text = "thelichy",
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier.padding(top = 40.dp)
            )
            Text(
                text = "Developer",
                fontSize = 16.sp,
                color = Color(0xFF4589A5),
                fontWeight = FontWeight.W600
            )
        }

        Column {
            IconTextRow(image = icPhone, text = "+55 (11) 11111-1111")
            IconTextRow(image = icMail, text = "thelichy@thecompany.co")
        }
    }
}

@Composable
fun IconTextRow(image: Painter, text: String) {
    Row {
        Image(
            painter = image, contentDescription = null, modifier = Modifier
                .width(22.dp)
                .height(22.dp)
        )
        Spacer(modifier = Modifier.width(15.dp))
        Text(text = text, color = Color.White)
    }
    Spacer(modifier = Modifier.height(10.dp))
}


@Preview (showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardApp()
}
