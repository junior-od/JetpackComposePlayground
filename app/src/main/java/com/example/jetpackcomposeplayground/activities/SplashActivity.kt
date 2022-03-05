package com.example.jetpackcomposeplayground.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.jetpackcomposeplayground.R
import com.example.jetpackcomposeplayground.ui.theme.JetpackComposePlaygroundTheme
import com.example.jetpackcomposeplayground.ui.theme.Typography
import com.example.jetpackcomposeplayground.viewmodels.SplashViewModel
import kotlinx.coroutines.launch
import kotlin.random.Random

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
            val scaffoldState = rememberScaffoldState()
            var textFieldState by remember {
                mutableStateOf("")
            }
            val scope = rememberCoroutineScope() //scope we can use within a composable, used only for callbacks
            Scaffold(modifier = Modifier.fillMaxSize(),
                    scaffoldState = scaffoldState) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()) {
//                        Greeting2(name = textFieldState)
                        TextField(value = textFieldState ,
                            singleLine = true,
                            textStyle = Typography.h1,
//                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            label = {
                             Text(text = "Enter your name") } ,
                            onValueChange = {
                            textFieldState = it
                        })

                        Spacer(modifier = Modifier.padding(vertical = 5.dp))
                        Button(onClick = {
                            scope.launch {
                                scaffoldState.snackbarHostState.showSnackbar(message = "Hi $textFieldState",duration = SnackbarDuration.Short)
                            }
                        }) {
                            Text(text = "Greet Me")
                        }


                    }
//                Snackbar {
//                    Text(text = "hey there")
//                }
            }
            

            //playground stuff
//            JetpackComposePlaygroundTheme() {
//                val color = remember {
//                    mutableStateOf(Color.Black)
//                }//state, remember is so that it doesn't call the initial value again after first draw on create
//
//                Column(modifier = Modifier
//                    .fillMaxSize()) {
//                    ImageCard(img = R.drawable.fine ,
//                        title = "Robot" ,
//                        contentDesc = "I am a\nlovely flower.")
//
//                    Text(text = buildAnnotatedString {
//                        append("Don't have an account? ")
//                        withStyle(
//                            style = SpanStyle(
//                                color = color.value,
//                                fontSize = 14.sp,
//                                fontWeight = FontWeight.Bold,
//
//                            )
//                        ){
//                            append("Sign Up ")
//                        }
//
//                    },
//                        color = Color.Gray,
//                        style = Typography.body1
//                    )
//                    ColorBox(color, modifier = Modifier.fillMaxSize(0.1f)){
//                        color.value = it
//                    }
//                }
//            }
        }

    }
}

@Composable
fun ColorBox(color: MutableState<Color>,modifier: Modifier, updateColor: (Color) -> Unit){
//    val color = remember {
//        mutableStateOf(Color.Black)
//    }//state, remember is so that it doesn't call the initial value again after first draw on create
    Box(modifier = modifier
        .background(color.value)
        .clickable {
            updateColor(
                Color(
                    Random.nextFloat(), Random.nextFloat(), Random.nextFloat(), 1f
                )
            )
        }) {

    }

}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!", modifier = Modifier
        .padding(vertical = 10.dp))
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
        modifier = modifier
            .fillMaxWidth(0.5f)
            .padding(10.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        //Box composable is for stacking items on top each other and can also align items
        Box(modifier = Modifier.height(150.dp)){
            Image(painter = painterResource(id = img),
                contentDescription = title,
                contentScale = ContentScale.Crop
            )

            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            Color.Transparent, Color.Black
                        ), startY = 300f, endY = Float.POSITIVE_INFINITY, tileMode = TileMode.Clamp
                    )
                ))

            Box(modifier = Modifier
                .padding(10.dp)
                .fillMaxSize(),
                contentAlignment = Alignment.BottomStart){
                Column() {
                    Text(text = title,
                        style = Typography.h1,
                        color = Color.White,
                        textDecoration = TextDecoration.Underline ,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center )
                    Text(text = contentDesc ,
                        style = Typography.body1,
                        color = Color.White,modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        textDecoration = TextDecoration.LineThrough)
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