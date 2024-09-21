package com.edupablo.taller1app

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import com.edupablo.taller1app.ui.theme.Taller1AppTheme
import java.util.Calendar

class PantallaInicio : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Recuperar el color de fondo de SharedPreferences
        var backgroundColor by mutableStateOf(getSavedBackgroundColor())

        setContent {
            Taller1AppTheme {
                PantallaInicioScreen(
                    backgroundColor = backgroundColor,  // Aplicar el fondo dinámico
                    onNavigate = {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }
                )
            }
        }
    }

    // Recuperar el color desde SharedPreferences
    private fun getSavedBackgroundColor(): Color {
        val sharedPref = getSharedPreferences("app_preferences", Context.MODE_PRIVATE)
        val colorInt = sharedPref.getInt("background_color", Color.White.toArgb())
        return Color(colorInt)
    }
}

@Composable
fun PantallaInicioScreen(backgroundColor: Color, onNavigate: () -> Unit) {
    val greeting = getGreetingMessage()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(backgroundColor),  // Aplicar el fondo dinámico
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = greeting, style = MaterialTheme.typography.headlineLarge)

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = onNavigate) {
            Text("Ir a la pantalla principal")
        }
    }
}

fun getGreetingMessage(): String {
    val calendar = Calendar.getInstance()
    val hour = calendar.get(Calendar.HOUR_OF_DAY)

    return when (hour) {
        in 0..11 -> "Buenos días"
        in 12..20 -> "Buenas tardes"
        else -> "Buenas noches"
    }
}
