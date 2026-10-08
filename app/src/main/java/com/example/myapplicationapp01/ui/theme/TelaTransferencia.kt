package com.example.myapplicationprimer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TelaTransferencia(
    saldo: Double,
    transferir: (Double, String) -> Unit,
    voltar: () -> Unit
) {

    val banco = remember {
        mutableStateOf("")
    }

    val destinatario = remember {
        mutableStateOf("")
    }

    val valor = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "Transferência",
            fontSize = 28.sp
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Text(
            text = "Saldo disponível: R$ %.2f".format(saldo)
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        OutlinedTextField(
            value = banco.value,
            onValueChange = {
                banco.value = it
            },
            label = {
                Text("Banco")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        OutlinedTextField(
            value = destinatario.value,
            onValueChange = {
                destinatario.value = it
            },
            label = {
                Text("Destinatário")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        OutlinedTextField(
            value = valor.value,
            onValueChange = {
                valor.value = it
            },
            label = {
                Text("Valor da transferência")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Button(
            onClick = {
                val numero = valor.value.toDoubleOrNull()

                if (
                    numero != null &&
                    numero > 0 &&
                    numero <= saldo
                ) {
                    transferir(numero, destinatario.value)

                    banco.value = ""
                    destinatario.value = ""
                    valor.value = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Transferir")
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