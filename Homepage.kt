package com.example.project1geography.ui.theme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.project1geography.GuessCountry
import com.example.project1geography.GuessHints
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// timer class to start timer, stop timer and reset
class TimerViewModel : ViewModel() {
    private var elapsedTime = mutableIntStateOf(10)
    var isRunning by mutableStateOf(false)
    private var timerJob: Job? = null

    val liveElapsedTime: State<Int> = elapsedTime
    var onCountdownFinished: () -> Unit = {}

    fun startTimer() {
        if (!isRunning) {
            isRunning = true
            timerJob = CoroutineScope(Dispatchers.Default).launch {
                while (isRunning) {
                    delay(1000)
                    elapsedTime.intValue--
                    if(elapsedTime.intValue == 0){
                        stopTimer()
                        break
                    }
                }
                onCountdownFinished()
            }
        }
    }

    fun stopTimer() {
        isRunning = false
        timerJob?.cancel()
    }
    fun resetTimer(){
        elapsedTime.intValue = 10
    }
}
// to connect the timer from homepage to other 4 games
class HomePage : ComponentActivity() {
    private val timerViewModel: TimerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController() // Obtain NavHostController
            NavHost(navController, startDestination = "homePage") {
                composable("homePage") {
                    HomePage(navController = navController, timerViewModel = timerViewModel)
                }
                composable("guessCountry") {
                    GuessCountry(navController = navController, timerViewModel = timerViewModel)
                }
                composable("GuessHints") {
                   GuessHints(navController = navController, timerViewModel = timerViewModel)
                }
                composable("GuessFlag") {
                    GuessFlag(navController = navController, timerViewModel = timerViewModel)
                }
                composable("AdvancedLevel") {
                    AdvancedLevel(navController = navController, timerViewModel = timerViewModel)
                }
            }
        }
    }
}


// main homepage function that includes 4 buttons and the switch to turn the timer on
@Composable
fun HomePage(navController: NavHostController, timerViewModel: TimerViewModel){
    Column {
        Text(text = "Timer: ${timerViewModel.liveElapsedTime.value} seconds")

        // Switch for timer
        Switch(
            checked = timerViewModel.isRunning,
            onCheckedChange = { isChecked ->
                if (isChecked) {
                    timerViewModel.startTimer()
                } else {
                    timerViewModel.stopTimer()
                }
                if(timerViewModel.liveElapsedTime.value == 0){
                    timerViewModel.resetTimer()
                    timerViewModel.startTimer()
                }
            }
        )

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Geography Quiz",
                style = TextStyle(
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                )
            )

            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            ) {
                Button(
                    onClick = {
                        navController.navigate(route = "GuessCountry")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(10.dp, color = Color.Black)
                        .height(120.dp)
                        .weight(1f), // Each button takes up the same proportion of the available space
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                    shape = CutCornerShape(8.dp)
                ) {
                    Text(text = "Guess the Country", fontSize = 40.sp)
                }
                Button(
                    onClick = {
                        navController.navigate(route = "Guess Hints")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(10.dp, color = Color.Black)
                        .height(120.dp)
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan),
                    shape = CutCornerShape(8.dp)
                ) {
                    Text(text = "Guess Hints", fontSize = 40.sp)
                }
                Button(
                    onClick = {
                        navController.navigate(route = "GuessFlag")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(10.dp, color = Color.Black)
                        .height(120.dp)
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
                    shape = CutCornerShape(8.dp)
                ) {
                    Text(text = "Guess the Flag", fontSize = 40.sp)
                }
                Button(
                    onClick = {
                        navController.navigate(route = "Advanced Level")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(10.dp, color = Color.Black)
                        .height(120.dp)
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                    shape = CutCornerShape(8.dp)
                ) {
                    Text(text = "Advanced Level", fontSize = 40.sp)
                }
            }
        }
    }
}
