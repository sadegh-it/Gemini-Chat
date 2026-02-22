package io.github.sadeghi.geminichat.navigation

sealed class Screens (val route: String) {
    object Splash : Screens("splash")
    object Chat : Screens("chat")

}
