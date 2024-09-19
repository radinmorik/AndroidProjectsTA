package no.hiof.radinm.navigation

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import no.hiof.radinm.navigation.ui.theme.NavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = Route.SCREEN_ONE) {
                    composable(route = Route.SCREEN_ONE) {
                        ScreenOne(
                            navigateToScreenTwo = {
                                navController.navigate(Route.SCREEN_TWO)
                            }
                        )
                    }
                    composable(route = Route.SCREEN_TWO) {
                        ScreenTwo(
                            navigateToScreenThree = {
                                navController.navigate(Route.SCREEN_THREE)
                            },
                            navigateBack = {
                                navController.popBackStack()
                            }
                        )
                    }
                    composable(route = Route.SCREEN_THREE) {
                        ScreenThree(
                            navigateBack = {
                                navController.popBackStack()
                            },
                            navigateBackToScreenOne = {
                                navController.popBackStack(Route.SCREEN_ONE, inclusive = false)
                            }
                        )

                    }
                }
            }
        }
    }

    object Route {
        const val SCREEN_ONE = "screen_one"
        const val SCREEN_TWO = "screen_two"
        const val SCREEN_THREE = "screen_three"
    }


    @Composable
    fun ScreenOne(
        navigateToScreenTwo: () -> Unit
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Text(text = "Screen 1")
            Button(onClick = { navigateToScreenTwo() }) {
                Text(text = "Go to next screen")
            }
        }
    }

    @Composable
    fun ScreenTwo(
        navigateToScreenThree: () -> Unit,
        navigateBack: () -> Unit
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )

        {
            Text(text = "Screen 2")
            Button(onClick = { navigateToScreenThree() }) {
                Text(text = "Go to next screen")
            }
            Button(onClick = { navigateBack() }) {
                Text(text = "Navigate back")
            }
        }
    }

    @Composable
    fun ScreenThree(
        navigateBack: () -> Unit,
        navigateBackToScreenOne: () -> Unit
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Image(painter = painterResource(id = R.drawable.images), contentDescription = "Patrick", modifier = Modifier.size(400.dp))
            Text(text = "Screen 3")
            Button(onClick = { navigateBack() }) {
                Text(text = "Go to next screen")
            }
            Button(onClick = { navigateBackToScreenOne() }) {
                Text(text = "Navigate back to screen 1")
            }

        }
    }
}


