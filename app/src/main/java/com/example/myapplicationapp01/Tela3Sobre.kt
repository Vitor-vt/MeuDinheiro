

package com.example.myapplicationprimer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TelaSobre() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "Sobre",
            fontSize = 28.sp
        )

        Spacer(
            modifier = Modifier.height(30.dp)
        )

        InformacoesApp()
    }
}

@Composable
fun InformacoesApp() {

    Card {

        Column(
            modifier = Modifier.padding(20.dp)
        ) {

            Text(
                text = "Meu Dinheiro",
                fontSize = 24.sp
            )

            Spacer(
                modifier = Modifier.height(15.dp)
            )

            Text(
                text = "Aplicativo simples para controle de entradas e gastos."
            )

            Spacer(
                modifier = Modifier.height(15.dp)
            )

            Text(
                text = "Projeto acadêmico"
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            Text(
                text = "Versão 1.0"
            )
        }
    }
}