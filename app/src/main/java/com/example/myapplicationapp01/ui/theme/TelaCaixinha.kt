package com.example.myapplicationprimer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TelaCaixinha(
    dinheiroGuardado: Double,
    movimentacoes: List<MovimentacaoCaixinha>,
    abrirDetalhes: (MovimentacaoCaixinha) -> Unit,
    removerMovimentacao: (MovimentacaoCaixinha) -> Unit,
    guardarDinheiro: (Double) -> Unit,
    retirarDinheiro: (Double) -> Unit,
    voltar: () -> Unit
) {

    val valor = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "Minha Caixinha",
            fontSize = 28.sp
        )

        Spacer(
            modifier = Modifier.height(25.dp)
        )

        Text("Dinheiro guardado")

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "R$ $dinheiroGuardado",
                modifier = Modifier.padding(20.dp),
                fontSize = 24.sp
            )
        }

        Spacer(
            modifier = Modifier.height(25.dp)
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
            modifier = Modifier.height(15.dp)
        )

        Button(
            onClick = {
                val numero = valor.value.toDoubleOrNull()

                if (numero != null) {
                    guardarDinheiro(numero)
                    valor.value = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar dinheiro")
        }

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        Button(
            onClick = {
                val numero = valor.value.toDoubleOrNull()

                if (numero != null) {
                    retirarDinheiro(numero)
                    valor.value = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Retirar dinheiro")
        }

        Spacer(
            modifier = Modifier.height(15.dp)
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {

            items(movimentacoes) { movimentacao ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(15.dp)
                    ) {

                        Text(
                            text = "${movimentacao.tipo}: R$ ${movimentacao.valor}",
                            fontSize = 18.sp
                        )

                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )

                        Button(
                            onClick = {
                                abrirDetalhes(movimentacao)
                            },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Ver detalhes")
                        }

                        Spacer(
                            modifier = Modifier.height(5.dp)
                        )

                        Button(
                            onClick = {
                                removerMovimentacao(movimentacao)
                            },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Remover")
                        }
                    }
                }
            }
        }

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        Button(
            onClick = voltar,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Voltar")
        }
    }
}