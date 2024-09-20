package com.edupablo.taller1app

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.edupablo.taller1app.ui.theme.Taller1AppTheme
import java.util.Calendar

class PantallaInicio : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Taller1AppTheme {
                // Definir la interfaz de PantallaInicio
                PantallaInicioScreen(
                    onNavigate = {
                        // Lógica para navegar a MainActivity
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }
                )
            }
        }
    }
}

@Composable
fun PantallaInicioScreen(onNavigate: () -> Unit) {
    // Obtener el saludo basado en la hora del día
    val greeting = getGreetingMessage()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Mostrar saludo personalizado
        Text(
            text = greeting,
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Botón para navegar a la actividad principal
        Button(onClick = onNavigate) {
            Text("Ir a la pantalla principal")
        }
    }
}

// Función para determinar el saludo según la hora
fun getGreetingMessage(): String {
    val calendar = Calendar.getInstance()
    val hour = calendar.get(Calendar.HOUR_OF_DAY)

    return when (hour) {
        in 0..11 -> "Buenos días"
        in 12..20 -> "Buenas tardes"
        else -> "Buenas noches"
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaInicioScreenPreview() {
    Taller1AppTheme {
        PantallaInicioScreen(onNavigate = {})
    }
}
