package com.example.myapplicationprimer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DetalheMovimentacaoCaixinha(
    movimentacao: MovimentacaoCaixinha,
    remover: () -> Unit,
    voltar: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "Detalhes da Caixinha",
            fontSize = 28.sp
        )

        Spacer(
            modifier = Modifier.height(25.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    text = "Tipo: ${movimentacao.tipo}",
                    fontSize = 20.sp
                )

                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                Text(
                    text = "Valor: R$ ${movimentacao.valor}",
                    fontSize = 20.sp
                )
            }
        }

        Spacer(
            modifier = Modifier.height(25.dp)
        )

        Button(
            onClick = {
                remover()
                voltar()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Remover movimentação")
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