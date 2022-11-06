package com.example.movie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movie.ui.theme.MovieComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting()
        }
    }
}

@Composable
fun Greeting() {
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.burger_image),
            contentDescription = "burger image",
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
        )
        Column(modifier = Modifier.padding(16.dp).fillMaxWidth()) {
            Text(text = "Meat berger", style = TextStyle(fontWeight = FontWeight.Bold))
            Spacer(modifier = Modifier.padding(top = 10.dp))
            Text(text = "2 Pieces of meat")
            Spacer(modifier = Modifier.padding(top = 10.dp))
            Text(text = "20$")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MovieComposeTheme {
        Greeting()
    }
}