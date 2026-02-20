package io.github.sadeghi.geminichat.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import io.github.sadeghi.geminichat.ui.components.SpacerHeight
import io.github.sadeghi.geminichat.viewModel.SplashViewModel
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController,
    viewModel: SplashViewModel = hiltViewModel()
) {

    val isConnected by viewModel.isConnected.collectAsState()

    CompositionLocalProvider(
        LocalLayoutDirection provides LayoutDirection.Rtl
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            when (isConnected) {
                null -> {
                    Text(
                        text = "درحال بررسی اینترنت....",
                        color = Color.Green,
                        textAlign = TextAlign.Center
                    )
                    SpacerHeight(20)
                    CircularProgressIndicator()

                }

                false -> {
                    Text(
                        text = "اینترنت شما متصل نیست!",
                        color = Color.Red,
                        textAlign = TextAlign.Center
                    )
                    SpacerHeight(20)
                    Button(onClick = { viewModel.checkInternet() })
                    {
                        Text("تلاش مجدد")
                    }

                }

                else -> {
                    Text(
                        text = "درحال بارگذاری....",
                        color = Color.Blue,
                        textAlign = TextAlign.Center,
                        style = typography.bodyLarge
                    )

                    LaunchedEffect(Unit) {
                        delay(2000)
                        navController.navigate("chat") {
                            popUpTo("splash") {
                                inclusive = true
                            }
                        }
                    }

                }


            }
        }
    }
}