package org.iesharia.corroutines

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Corroutines()
        }
    }
}

@Composable
fun Corroutines() {
    var text by remember { mutableStateOf("Presiona el botón para sumar") }
    var quehacer by remember { mutableStateOf("Iniciar") }
    var suma by remember { mutableIntStateOf(0) }
    var operando1 by remember { mutableIntStateOf(3) }
    var operando2 by remember { mutableIntStateOf(5) }

    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = text)
        Row {
            Text(text = operando1.toString())
            Text(text = " + ")
            Text(text = operando2.toString())
            Text(text = " = $suma")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            coroutineScope.launch {
                text = "Cargando..."
                delay(3000)
                suma = operando1 + operando2
                text = "Suma Completada"
                quehacer = "Sumar"
                            }
            if (quehacer=="Sumar")
                operando1=operando1*2
                operando2=operando2*3
                suma=0
                quehacer="Iniciar"
        }) {
            Text(quehacer)
        }
    }
}
