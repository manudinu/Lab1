package com.example.lab1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab1.ui.theme.Lab1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainContent()
                }
            }
        }
    }
}

@Composable
fun MainContent() {
    // Define custom colors once, use consistently
    val primaryColor = Color(0xFF6200EE) // Example: Purple
    val secondaryColor = Color(0xFF03DAC5) // Example: Teal
    val buttonColor = Color(0xFFBB86FC) // Example: Light Purple
    val primaryTextColor = Color(0xFFF2E7FE) // A light color for contrast against purple
    val buttonTextColor = Color.Black // Dark color for button text

    var greeting by remember { mutableStateOf("Hello, World!") }
    var isRotated by remember { mutableStateOf(false) }
    val rotationAngle by animateFloatAsState(if (isRotated) 360f else 0f)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(primaryColor, secondaryColor)
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = greeting,
                style = MaterialTheme.typography.headlineMedium.copy(
                    color = primaryTextColor,
                    fontWeight = FontWeight.Bold
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(16.dp)
                    .rotate(rotationAngle)
            )
            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    greeting = if (greeting == "Hello, World!") "Welcome to Manoj's World!" else "Hello, World!"
                    isRotated = !isRotated
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = buttonColor
                ),
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier
                    .padding(16.dp)
                    .height(56.dp)
                    .width(200.dp)
            ) {
                Text(
                    text = "Tap!",
                    style = MaterialTheme.typography.labelLarge.copy(
                        color = buttonTextColor, // Set "Tap!" button text to black
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                )
            }
        }
    }
}