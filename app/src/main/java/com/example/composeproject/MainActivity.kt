package com.example.composeproject


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeproject.component.ShowCelebration
import com.example.composeproject.component.cardTextViewUi
import com.example.composeproject.component.slotViewTwo
import com.example.composeproject.ui.theme.*
import com.example.composeproject.viewmodel.MainViewModel
import kotlin.time.ExperimentalTime

@ExperimentalTime
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SlotBarMachineTheme {
                Surface {
                    MainApp(viewModel)
                }
            }
        }
    }
}

@OptIn(ExperimentalTime::class)
@Composable
fun MainApp(viewModel: MainViewModel) {
    MainApp(
        isPlaying = viewModel.isPlaying,
        person = viewModel.person,
        squad = viewModel.Squad,
        isSuccess=viewModel.isSucceeded,
        countNumber = viewModel.countNumber,
        onStart = { viewModel.start() },
        onPause = { viewModel.pause() },
        onStop = { viewModel.stop() }
    )
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun MainApp(
    isPlaying: Boolean,
    person: String,
    squad: String,
    isSuccess : Boolean,
    countNumber : Int,
    onStart: () -> Unit = {},
    onPause: () -> Unit = {},
    onStop: () -> Unit = {},
) {
    Box(Modifier.background(color = Purple200)) {

    Scaffold (Modifier.background(color = Purple200)){

        Column(
            Modifier
                .fillMaxSize()
                .background(color = Purple200),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if(isSuccess)
            {
                ShowCelebration()

            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Game", color = Color.Black, style =  MaterialTheme.typography.caption, fontSize = 29.sp,fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier
                .weight(1f)
                .background(color = MaterialTheme.colors.primaryVariant))
            Row {
                val numberTransitionSpec: AnimatedContentScope<String>.() -> ContentTransform = {
                    slideInVertically(
                        initialOffsetY = { it }
                    ) + fadeIn() with slideOutVertically(
                        targetOffsetY = { -it }
                    ) + fadeOut() using SizeTransform(
                        false
                    )
                }

                CompositionLocalProvider(LocalTextStyle provides MaterialTheme.typography.h3) {

                    AnimatedContent(targetState = squad,
                        Modifier
                            .weight(1f)
                            .background(color = Teal200), transitionSpec = numberTransitionSpec) {
                        slotViewTwo(
                            Modifier
                                .fillMaxWidth()
                                .weight(1f)
                                .background(color = Teal200),
                            it
                        )                    }
                    AnimatedContent(targetState = person,Modifier.weight(1f), transitionSpec = numberTransitionSpec) {
                        slotViewTwo(
                            Modifier
                                .fillMaxWidth()
                                .weight(1f)
                                .background(color = Purple700),
                            it
                        )
                    }

                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            if (countNumber==5)
            {
                Text(text = "Sorry")

            }else{
                Text(text = "Your spin Count $countNumber")

            }
            Spacer(modifier = Modifier.height(40.dp))
            if(isSuccess) {
                Text(
                    text = "Match",
                    color = Color.Green,
                    fontSize = 29.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            
                AnimatedContent(targetState = isPlaying) {
                    if (it)
                    {
                        cardTextViewUi("Spin", onClickValue = onStop)

                    } else {
                        cardTextViewUi("Spin", onClickValue = onStart)
                    }
                }

            Spacer(modifier = Modifier.height(40.dp))

        }
    }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SlotBarMachineTheme {
        MainApp(
            false,
            "Engg",
            "Squad",
            false,
            0
        )
    }
}