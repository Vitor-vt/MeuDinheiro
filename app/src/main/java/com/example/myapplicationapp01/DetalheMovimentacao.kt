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
fun DetalheMovimentacao(
    movimentacao: Movimentacao,
    voltar: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "Detalhes da movimentação",
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
                    text = "Descrição: ${movimentacao.descricao}",
                    fontSize = 20.sp
                )

                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                Text(
                    text = "Tipo: ${movimentacao.tipo}"
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
                voltar()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Voltar")
        }
    }
}