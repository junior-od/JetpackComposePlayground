package com.example.jetpackcomposeplayground.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.jetpackcomposeplayground.R
import com.example.jetpackcomposeplayground.ui.theme.JetpackComposePlaygroundTheme
import com.example.jetpackcomposeplayground.ui.theme.Typography
import com.example.jetpackcomposeplayground.viewmodels.SplashViewModel

class SplashActivity : ComponentActivity() {
    private val splashViewModel: SplashViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition{
                splashViewModel.isLoading.value
            }
        }

        setContent {
            JetpackComposePlaygroundTheme() {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()) {
                    ImageCard(img = R.drawable.fine , title = "Robot" , contentDesc = "I am a\nlovely flower.")
                }
            }
        }

    }
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!", modifier = Modifier
        .padding(top = 10.dp))
}

@Composable
fun SplashImage(img: Int){
    Image(painter = painterResource(id = img),
        contentDescription = "Splash Image",
        modifier = Modifier.clip(CircleShape)
    )
}

@Composable
fun ImageCard(img : Int, title: String, contentDesc: String, modifier: Modifier = Modifier){

    Card (
        modifier = modifier.fillMaxWidth(0.5f).padding(10.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        //Box composable is for stacking items on top each other and can also align items
        Box(modifier = Modifier.height(150.dp)){
            Image(painter = painterResource(id = img),
                contentDescription = title,
                contentScale = ContentScale.Crop
            )

            Box(modifier = Modifier.fillMaxSize()
                .background(Brush.verticalGradient(listOf(
                    Color.Transparent,Color.Black), startY = 300f, endY = Float.POSITIVE_INFINITY, tileMode = TileMode.Clamp )))

            Box(modifier = Modifier.padding(10.dp).fillMaxSize(),
                contentAlignment = Alignment.BottomStart){
                Column() {
                    Text(text = title, style = Typography.h1, color = Color.White )
                    Text(text = contentDesc , style = Typography.body1, color = Color.White)
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    JetpackComposePlaygroundTheme {
        Column(modifier = Modifier
            .background(MaterialTheme.colors.background)
            .border(5.dp, Color.Blue)
            .padding(5.dp)
            .border(10.dp, Color.Green)
            .padding(10.dp)
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,

            ) {
            SplashImage(img = R.drawable.stuff)
            Spacer(modifier = Modifier.height(20.dp))
            Greeting2("Android")
        }



    }
}