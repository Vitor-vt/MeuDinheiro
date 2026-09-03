package com.example.myapplicationprimer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TelaMovimentacoes() {

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

        ItemMovimentacao(
            nome = "Entrada",
            valor = "+ R$ 100,00"
        )

        Spacer(
            modifier = Modifier.height(15.dp)
        )

        ItemMovimentacao(
            nome = "Gasto",
            valor = "- R$ 50,00"
        )

        Spacer(
            modifier = Modifier.height(15.dp)
        )

        ItemMovimentacao(
            nome = "Entrada",
            valor = "+ R$ 200,00"
        )
    }
}

@Composable
fun ItemMovimentacao(
    nome: String,
    valor: String
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
                text = nome,
                modifier = Modifier.weight(1f)
            )

            Text(
                text = valor
            )
        }
    }
}