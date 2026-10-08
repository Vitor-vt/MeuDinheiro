package com.example.myapplicationprimer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TelaMetaEconomia(
    meta: Double,
    economizado: Double,
    alterarMeta: (Double) -> Unit,
    voltar: () -> Unit
) {

    val novoValor = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "Meta de Economia",
            fontSize = 28.sp
        )

        Spacer(
            modifier = Modifier.height(25.dp)
        )

        Text(
            text = "Minha meta"
        )

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "R$ $meta",
                modifier = Modifier.padding(15.dp),
                fontSize = 22.sp
            )
        }

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        OutlinedTextField(
            value = novoValor.value,
            onValueChange = {
                novoValor.value = it
            },
            label = {
                Text("Digite uma nova meta")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        Text(
            text = "Já economizei"
        )

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "R$ $economizado",
                modifier = Modifier.padding(15.dp),
                fontSize = 22.sp
            )
        }

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        if (economizado >= meta) {

            Text(
                text = "Parabéns! Você atingiu sua meta!"
            )
        }

        if (economizado < meta) {

            Text(
                text = "Falta R$ ${meta - economizado} para atingir sua meta."
            )
        }

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        val progresso = (economizado / meta).coerceIn(0.0, 1.0)

        LinearProgressIndicator(
            progress = { progresso.toFloat() },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Button(
            onClick = {

                val valor = novoValor.value.toDoubleOrNull()

                if (valor != null) {
                    alterarMeta(valor)
                    novoValor.value = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Alterar meta")
        }

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        Button(
            onClick = {
                voltar()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Voltar")
        }
    }
}