package com.example.artgallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artgallery.ui.theme.ArtGalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtGalleryTheme {
                ArtGalleryApp()
            }
        }
    }
}


@Preview (showBackground = true)
@Composable
fun ArtGalleryApp(modifier: Modifier = Modifier) {
    var position by remember { mutableStateOf(0) }

    val image = when(position) {
        0 -> R.drawable.cat
        1 -> R.drawable.pier
        2 -> R.drawable.wood
        else -> R.drawable.tower
    }
    val text = when(position) {
        0 -> stringResource(R.string.cat)
        1 -> stringResource(R.string.pier)
        2 -> stringResource(R.string.wood)
        else -> stringResource(R.string.tower)
    }

    fun goNext() {
        if (position == 3) {
            position = 0
        } else {
            position++
        }
    }

    fun goPrevious() {
        if (position == 0) {
            position = 3
        } else {
            position--
        }
    }




    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 80.dp, vertical = 150.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(modifier = Modifier.padding(10.dp) , shadowElevation = 15.dp) {
            Image(painter = painterResource(image), contentDescription = null)
        }

        Spacer(modifier = Modifier.height(20.dp))
        Text(text = text)
        Spacer(modifier = Modifier.height(20.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            Button(onClick = { goPrevious() }) {
                Text(text = stringResource(R.string.previous))
            }
            Button(onClick = { goNext() }) {
                Text(text = stringResource(R.string.next))
            }
        }
    }
}
