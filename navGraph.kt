package com.example.project1geography

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.project1geography.ui.theme.AdvancedLevel
import com.example.project1geography.ui.theme.GuessFlag
import com.example.project1geography.ui.theme.HomePage
import com.example.project1geography.ui.theme.TimerViewModel

@Composable
fun Nav(){

    val navController = rememberNavController()
    val timerViewModel: TimerViewModel = viewModel()
    NavHost(navController = navController, startDestination = "HomePage"){

        composable(route = "HomePage"){
            HomePage(navController, timerViewModel = timerViewModel)
        }
        composable(route = "GuessCountry"){
            GuessCountry(navController,timerViewModel = timerViewModel)
        }
        composable(route = "Guess Hints"){
            GuessHints(navController, timerViewModel = timerViewModel)
        }
        composable(route = "GuessFlag"){
            GuessFlag(navController, timerViewModel = timerViewModel)
        }
        composable(route = "Advanced Level"){
            AdvancedLevel(navController,timerViewModel = timerViewModel)
        }
    }

}
