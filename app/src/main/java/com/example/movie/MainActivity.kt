package com.example.movie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movie.ui.theme.MovieComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

data class Profile(val name: String, val age: String)

@Composable
fun Lists() {
    LazyColumn{
        messages.map { item { MessageCard(it) } }
    }
}

@Composable
fun Greeting(callBack: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.burger_image),
            contentDescription = "burger image",
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
        )
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Meat berger", fontSize = 20.sp)
                Text(
                    text = "20$",
                    style = TextStyle(color = Color.Blue),
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
            Spacer(modifier = Modifier.padding(top = 10.dp))
            Text(text = "2 Pieces of meat")
            Spacer(modifier = Modifier.padding(top = 10.dp))
            Button(
                onClick = { callBack.invoke() },
                modifier = Modifier.align(Alignment.CenterHorizontally),
            ) {
                Text(text = "Order Now")
            }
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