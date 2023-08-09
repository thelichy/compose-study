/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.affirmations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.affirmations.data.DataSource
import com.example.affirmations.model.Affirmation
import com.example.affirmations.ui.theme.AffirmationsTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AffirmationsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AffirmationsApp()
                }
            }
        }
    }
}



@Preview (showBackground = true)
@Composable
fun AffirmationsApp() {
    val data = DataSource().loadAffirmations()

    AffirmationList(list = data, modifier = Modifier)
}


@Composable
fun AffirmationList(list: List<Affirmation>, modifier: Modifier) {
    LazyColumn(modifier = modifier) {
        items(list) {
            AffirmationCard(affirmation = it, modifier = Modifier)
        }
    }
}


@Composable
fun AffirmationCard(affirmation: Affirmation, modifier: Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(vertical = 20.dp, horizontal = 40.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(color = Color(red = 233, green = 237, blue = 241, alpha = 255))
    ) {
        Image(
            painter = painterResource(affirmation.imageResourceId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .fillMaxWidth()
                .height(150.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = stringResource(affirmation.stringResourceId),
            fontSize = 14.sp,
            color = Color.DarkGray,
            modifier = Modifier.padding(horizontal = 10.dp)
        )
        Spacer(modifier = Modifier.height(15.dp))
    }
}
