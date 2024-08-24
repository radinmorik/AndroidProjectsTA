package no.hiof.radinm.buttonandcolors

import androidx.compose.ui.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import no.hiof.radinm.buttonandcolors.ui.theme.ButtonAndColorsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ButtonAndColorsTheme {

                // Creating a  list of different colors
                val colors = listOf(
                    Color.Red, Color.Blue, Color.Green, Color.Magenta, Color.Cyan)

                // Creating a state to hold the current background color. Each time this value changes, the colors changes
                var backgroundColor by remember { mutableStateOf(Color.White)}


                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            // Setting the starting background color as white
                            .background(color = backgroundColor),
                        contentAlignment = Alignment.Center
                    ) {
                        Button(onClick = {
                            // Changing the backgroundColor state to different colors from our List. The .random func will pick random colors from the list.
                            backgroundColor = colors.random()
                        }) {
                            // Simple button text
                            Text(text = "Click me!")
                        }
                    }
                }
            }
        }
    }



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ButtonAndColorsTheme {
    }
}