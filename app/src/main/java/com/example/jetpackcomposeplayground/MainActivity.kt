package com.example.jetpackcomposeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeplayground.ui.theme.JetpackComposePlaygroundTheme
import com.example.jetpackcomposeplayground.ui.theme.Purple200

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePlaygroundTheme {
                // A surface container using the 'background' color from the theme
                Greeting(Message("Compose Playground Stuff"))
            }
        }
    }
}

data class Message(val title: String)

@Composable
fun Greeting(msg: Message) {
    Text(text = msg.title)
}

@Composable
fun ScreenNavigator(title: String){
    Text(text = title)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposePlaygroundTheme {
        Row(modifier = Modifier.fillMaxHeight().fillMaxWidth().horizontalScroll(enabled = true,state = ScrollState(0)).background(color = Purple200, RectangleShape)) {
            Image(

                painter = painterResource(R.drawable.bluetooth),
                contentDescription = "Contact profile picture",
                modifier = Modifier
                    .size(60.dp)

            )

            Column {
                ScreenNavigator("Components Playground")
                Greeting(Message("Compose Playground"))
            }
        }

    }
}