package com.example.movie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movie.ui.theme.MovieComposeTheme


@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        messages.map { item { MessageCard(it) } }
    }
}
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieComposeTheme {
                Surface {
                    Conversation(SampleData.conversationSample)
                }
            }
        }
    }
}


@Composable
fun MessageCard(msg: Message) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_nuclear),
            contentDescription = "",
            Modifier
                .padding(end = 8.dp)
                .size(40.dp)
                .border(
                    width = 1.5.dp,
                    color = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(12.dp)
                )
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.FillBounds
        )
        // We keep track if the message is expanded or not in this
        // variable
        var isExpanded by remember { mutableStateOf(false) }

        Column(modifier = Modifier
            .clickable { isExpanded = !isExpanded }
            .fillMaxWidth()) {
            Text(text = msg.author)
            Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 1.5.dp) {
                Text(
                    text = msg.body, style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MovieComposeTheme {
        TopicsList(
            topics = listOf(
                TopicModel(
                    image = R.drawable.ic_nuclear,
                    name = "Name1", details = "45"
                ),
                TopicModel(
                    image = R.drawable.burger_image,
                    name = "Name2", details = "45"
                ),
                TopicModel(
                    image = R.drawable.ic_nuclear,
                    name = "Name3", details = "45"
                ),
                TopicModel(
                    image = R.drawable.burger_image,
                    name = "Name4", details = "45"
                ),
                TopicModel(
                    image = R.drawable.ic_nuclear,
                    name = "Name5", details = "45"
                ),
            )
        )
    }
}

data class TopicModel(val image: Int, val name: String, val details: String)

@Composable
fun TopicShape(topicModel: TopicModel, selected: Boolean = false) {
    val radius by animateDpAsState(targetValue = if (selected) 20.dp else 0.dp)
    Card(shape = RoundedCornerShape(topStart = radius), modifier = Modifier.padding(8.dp)) {
        Row {
            Box {
                Image(painter = painterResource(id = topicModel.image), contentDescription = "")
                if (selected)
                    Icon(imageVector = Icons.Filled.Done, contentDescription = "")
            }
            Text(text = topicModel.name, modifier = Modifier.padding(16.dp))
        }
    }
}

@Composable
fun TopicsList(topics: List<TopicModel>) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(topics) { topic ->
            TopicShape(topicModel = topic)
        }
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