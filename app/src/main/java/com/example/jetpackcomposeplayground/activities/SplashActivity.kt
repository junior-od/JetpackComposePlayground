package com.example.jetpackcomposeplayground.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
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

    }
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!", modifier = Modifier.absolutePadding(0.dp,10.dp,0.dp,0.dp))
}

@Composable
fun SplashImage(img: Int){
    Image(painter = painterResource(id = img),
        contentDescription = "Splash Image",
        modifier = Modifier.clip(CircleShape)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
//    JetpackComposePlaygroundTheme {
//        Column(modifier = Modifier
//            .background(MaterialTheme.colors.background)
//            .fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center,
//
//            ) {
//            SplashImage(img = R.drawable.stuff)
//            Greeting2("Android")
//        }
//
//
//
//    }
}