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
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

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

    val saldo = remember {
        mutableStateOf(0.0)
    }

    val entradas = remember {
        mutableStateOf(0.0)
    }

    val gastos = remember {
        mutableStateOf(0.0)
    }

    val meta = remember {
        mutableStateOf(0.0)
    }

    val dinheiroGuardado = remember {
        mutableStateOf(0.0)
    }

    val movimentacoes = remember {
        mutableStateListOf<Movimentacao>()
    }

    val movimentacoesCaixinha = remember {
        mutableStateListOf<MovimentacaoCaixinha>()
    }

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Rotas.INICIO
    ) {

        composable(Rotas.INICIO) {
            TelaInicial(
                saldo = saldo.value,

                adicionarEntrada = { numero ->
                    saldo.value += numero
                    entradas.value += numero

                    movimentacoes.add(
                        Movimentacao(
                            descricao = "Entrada",
                            valor = numero,
                            tipo = "Entrada"
                        )
                    )
                },

                adicionarGasto = { numero ->
                    saldo.value -= numero
                    gastos.value += numero

                    movimentacoes.add(
                        Movimentacao(
                            descricao = "Gasto",
                            valor = numero,
                            tipo = "Gasto"
                        )
                    )
                },

                abrirMovimentacoes = {
                    navController.navigate(Rotas.MOVIMENTACOES)
                },

                abrirSobre = {
                    navController.navigate(Rotas.SOBRE)
                },

                abrirResumo = {
                    navController.navigate(Rotas.RESUMO)
                },

                abrirMeta = {
                    navController.navigate(Rotas.META)
                },

                abrirCaixinha = {
                    navController.navigate(Rotas.CAIXINHA)
                },

                abrirTransferencia = {
                    navController.navigate(Rotas.TRANSFERENCIA)
                }
            )
        }

        composable(Rotas.MOVIMENTACOES) {
            TelaMovimentacoes(
                movimentacoes = movimentacoes,

                abrirDetalhes = { movimentacao ->
                    val indice = movimentacoes.indexOf(movimentacao)

                    navController.navigate(
                        "${Rotas.DETALHE_MOVIMENTACAO}/$indice"
                    )
                },

                voltar = {
                    navController.popBackStack()
                }
            )
        }

        composable("${Rotas.DETALHE_MOVIMENTACAO}/{indice}") { backStackEntry ->

            val indice = backStackEntry.arguments
                ?.getString("indice")
                ?.toIntOrNull()

            if (indice != null && indice in movimentacoes.indices) {

                DetalheMovimentacao(
                    movimentacao = movimentacoes[indice],
                    voltar = {
                        navController.popBackStack()
                    }
                )
            }
        }

        composable(Rotas.CAIXINHA) {

            TelaCaixinha(
                dinheiroGuardado = dinheiroGuardado.value,

                movimentacoes = movimentacoesCaixinha,

                abrirDetalhes = { movimentacao ->

                    val indice = movimentacoesCaixinha.indexOf(movimentacao)

                    navController.navigate(
                        "${Rotas.DETALHE_CAIXINHA}/$indice"
                    )
                },

                removerMovimentacao = { movimentacao ->
                    movimentacoesCaixinha.remove(movimentacao)
                },

                guardarDinheiro = { valor ->

                    dinheiroGuardado.value += valor

                    movimentacoesCaixinha.add(
                        MovimentacaoCaixinha(
                            valor = valor,
                            tipo = "Depósito"
                        )
                    )
                },

                retirarDinheiro = { valor ->

                    dinheiroGuardado.value -= valor

                    movimentacoesCaixinha.add(
                        MovimentacaoCaixinha(
                            valor = valor,
                            tipo = "Retirada"
                        )
                    )
                },

                voltar = {
                    navController.popBackStack()
                }
            )
        }

        composable("${Rotas.DETALHE_CAIXINHA}/{indice}") { backStackEntry ->

            val indice = backStackEntry.arguments
                ?.getString("indice")
                ?.toIntOrNull()

            if (indice != null && indice in movimentacoesCaixinha.indices) {

                DetalheMovimentacaoCaixinha(
                    movimentacao = movimentacoesCaixinha[indice],

                    remover = {
                        movimentacoesCaixinha.removeAt(indice)
                    },

                    voltar = {
                        navController.popBackStack()
                    }
                )
            }
        }

        composable(Rotas.SOBRE) {
            TelaSobre(
                voltar = {
                    navController.popBackStack()
                }
            )
        }

        composable(Rotas.RESUMO) {
            TelaResumoMes(
                entradas = entradas.value,
                gastos = gastos.value,
                voltar = {
                    navController.popBackStack()
                }
            )
        }

        composable(Rotas.META) {
            TelaMetaEconomia(
                meta = meta.value,
                economizado = dinheiroGuardado.value,

                alterarMeta = { novoValor ->
                    meta.value = novoValor
                },

                voltar = {
                    navController.popBackStack()
                }
            )
        }

        composable(Rotas.TRANSFERENCIA) {
            TelaTransferencia(
                saldo = saldo.value,

                transferir = { valor, destino ->
                    saldo.value -= valor
                },

                voltar = {
                    navController.popBackStack()
                }
            )
        }
    }
}

@Composable
fun TelaInicial(
    saldo: Double,
    adicionarEntrada: (Double) -> Unit,
    adicionarGasto: (Double) -> Unit,
    abrirMovimentacoes: () -> Unit,
    abrirSobre: () -> Unit,
    abrirResumo: () -> Unit,
    abrirMeta: () -> Unit,
    abrirCaixinha: () -> Unit,
    abrirTransferencia: () -> Unit
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
            text = "Meu Dinheiro",
            fontSize = 28.sp
        )

        Spacer(
            modifier = Modifier.height(30.dp)
        )

        Text("Saldo atual")

        Text(
            text = "R$ $saldo",
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
                    adicionarEntrada(numero)
                    valor.value = ""
                }
            },

            retirar = {
                val numero = valor.value.toDoubleOrNull()

                if (numero != null) {
                    adicionarGasto(numero)
                    valor.value = ""
                }
            }
        )

        Spacer(
            modifier = Modifier.height(25.dp)
        )

        Button(
            onClick = abrirMovimentacoes,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ver movimentações")
        }

        Spacer(
            modifier = Modifier.height(15.dp)
        )

        Button(
            onClick = abrirResumo,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Resumo do mês")
        }

        Spacer(
            modifier = Modifier.height(15.dp)
        )

        Button(
            onClick = abrirMeta,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Meta de economia")
        }

        Spacer(
            modifier = Modifier.height(15.dp)
        )

        Button(
            onClick = abrirCaixinha,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Minha Caixinha")
        }

        Spacer(
            modifier = Modifier.height(15.dp)
        )

        Button(
            onClick = abrirTransferencia,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Transferência")
        }
    }
}

@Composable
fun BotoesDinheiro(
    adicionar: () -> Unit,
    retirar: () -> Unit
) {

    Button(
        onClick = adicionar,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Adicionar entrada")
    }

    Spacer(
        modifier = Modifier.height(15.dp)
    )

    Button(
        onClick = retirar,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Adicionar gasto")
    }
}