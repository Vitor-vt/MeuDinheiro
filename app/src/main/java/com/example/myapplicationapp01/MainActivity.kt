package com.example.myapplicationprimer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            MaterialTheme {

                MeuAplicativo()

            }
        }
    }
}


@Composable
fun MeuAplicativo() {

    val tela = remember {
        mutableStateOf(1)
    }

    if (tela.value == 1) {

        TelaInicial(
            abrirMovimentacoes = {
                tela.value = 2
            },

            abrirSobre = {
                tela.value = 3
            }
        )

    } else if (tela.value == 2) {

        TelaMovimentacoes()

    } else {

        TelaSobre()

    }
}


@Composable
fun TelaInicial(
    abrirMovimentacoes: () -> Unit,
    abrirSobre: () -> Unit
) {

    val valor = remember {
        mutableStateOf("")
    }

    val saldo = remember {
        mutableStateOf(500.0)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "Meu Dinheiro",
            fontSize = 28.sp
        )

        Spacer(
            modifier = Modifier.height(30.dp)
        )

        Text(
            text = "Saldo atual"
        )

        Text(
            text = "R$ ${saldo.value}",
            fontSize = 30.sp
        )

        Spacer(
            modifier = Modifier.height(30.dp)
        )

        OutlinedTextField(
            value = valor.value,

            onValueChange = {
                valor.value = it
            },

            label = {
                Text("Digite um valor")
            },

            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        BotoesDinheiro(

            adicionar = {

                val numero = valor.value.toDoubleOrNull()

                if (numero != null) {

                    saldo.value = saldo.value + numero

                    valor.value = ""
                }
            },

            retirar = {

                val numero = valor.value.toDoubleOrNull()

                if (numero != null) {

                    saldo.value = saldo.value - numero

                    valor.value = ""
                }
            }
        )

        Spacer(
            modifier = Modifier.height(25.dp)
        )

        Button(
            onClick = {
                abrirMovimentacoes()
            },
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                text = "Ver movimentações"
            )
        }

        Spacer(
            modifier = Modifier.height(15.dp)
        )

        Button(
            onClick = {
                abrirSobre()
            },
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                text = "Sobre"
            )
        }
    }
}


@Composable
fun BotoesDinheiro(
    adicionar: () -> Unit,
    retirar: () -> Unit
) {

    Button(
        onClick = {
            adicionar()
        },
        modifier = Modifier.fillMaxWidth()
    ) {

        Text(
            text = "Adicionar entrada"
        )
    }

    Spacer(
        modifier = Modifier.height(15.dp)
    )

    Button(
        onClick = {
            retirar()
        },
        modifier = Modifier.fillMaxWidth()
    ) {

        Text(
            text = "Adicionar gasto"
        )
    }
}