package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ComposeArticleApp()
                }
            }
        }
    }
}

@Composable
fun ComposeArticleApp() {
    Column {
        Card(image = painterResource(R.drawable.bg_compose_background))
        Title(stringResource(R.string.article_title))
        Article(
            stringResource(R.string.article_shortContent),
            stringResource(R.string.article_longContent)
        )
    }
}

@Composable
private fun Card(image: Painter) {
    Image(
        painter = image,
        contentDescription = null,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
private fun Title(title: String = "Title") {
    Surface(modifier = Modifier.padding(
        start = 16.dp,
        end = 16.dp,
        top = 16.dp,
        bottom = 16.dp
    )) {
        Text(text = title, fontSize = 24.sp)
    }
}

@Composable
private fun Article(short: String = "Content", large: String = "Content") {
    Surface(
        modifier = Modifier.padding(
            start = 16.dp,
            end = 16.dp
        )
    ) {
        Text(
            text = short,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify
        )
    }
    Surface(
        modifier = Modifier.padding(
            start = 16.dp,
            end = 16.dp,
            top = 16.dp,
            bottom = 16.dp
        )
    ) {
        Text(
            text = large,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeArticleTheme {
        ComposeArticleApp()
    }
}