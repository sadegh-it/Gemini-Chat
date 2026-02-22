package io.github.sadeghi.geminichat.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.github.sadeghi.geminichat.ui.screen.ChatScreen
import io.github.sadeghi.geminichat.ui.screen.SplashScreen

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController()
){
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    ){
        composable(Screens.Splash.route){
            SplashScreen(navController)
        }
        composable(Screens.Chat.route){
            ChatScreen()
        }


    }
}