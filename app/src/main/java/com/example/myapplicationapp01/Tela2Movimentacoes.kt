package com.example.myapplicationprimer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
fun TelaMovimentacoes(

    movimentacoes: List<String>,

    voltar: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "Movimentações",
            fontSize = 28.sp
        )


        Spacer(
            modifier = Modifier.height(30.dp)
        )


        if (movimentacoes.isEmpty()) {

            Text(
                text = "Nenhuma movimentação cadastrada."
            )

        } else {

            for (movimentacao in movimentacoes) {

                ItemMovimentacao(
                    texto = movimentacao
                )

                Spacer(
                    modifier = Modifier.height(15.dp)
                )
            }
        }


        Spacer(
            modifier = Modifier.height(30.dp)
        )


        Button(

            onClick = {
                voltar()
            },

            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                text = "Voltar"
            )
        }
    }
}


@Composable
fun ItemMovimentacao(

    texto: String
) {

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {

            Text(
                text = texto
            )
        }
    }
}