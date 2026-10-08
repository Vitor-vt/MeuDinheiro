# 💰 Meu Dinheiro — Trabalho 2 (MAF)

## 📱 Sobre o projeto

O **Meu Dinheiro** é um aplicativo simples de controle financeiro desenvolvido em **Kotlin** utilizando **Android Studio** e **Jetpack Compose**.

O aplicativo permite ao usuário controlar seu saldo, registrar entradas e gastos, acompanhar movimentações, guardar dinheiro em uma caixinha, definir uma meta de economia e realizar transferências.

Este projeto corresponde ao **Trabalho 2 — MAF (Mínimo Aplicativo Funcional)** e representa a evolução do aplicativo desenvolvido no Trabalho 1.

---

## 🎯 Objetivo

O objetivo do aplicativo é oferecer uma forma simples de organizar o dinheiro, permitindo que o usuário registre suas movimentações e acompanhe sua situação financeira.

---

## 🚀 Funcionalidades

O aplicativo possui:

- 💰 Controle de saldo
- ➕ Adição de entradas
- ➖ Registro de gastos
- 📋 Lista de movimentações
- 🔎 Visualização dos detalhes de uma movimentação
- 🐷 Minha Caixinha
- 💵 Guardar dinheiro na Caixinha
- 💸 Retirar dinheiro da Caixinha
- 🗑️ Remover movimentações da Caixinha
- 🔎 Visualização dos detalhes da Caixinha
- 🎯 Definição de meta de economia
- 📊 Resumo do mês
- 💳 Transferência

---

## 🛠️ Tecnologias utilizadas

- Kotlin
- Android Studio
- Jetpack Compose
- Material 3
- Navigation Compose
- LazyColumn
- Card
- MutableStateListOf
- NavController
- NavHost

---

## 🧭 Navegação

A navegação do aplicativo foi organizada utilizando:

- `NavController`
- `NavHost`
- Objeto `Rotas`

As telas possuem rotas próprias, permitindo a navegação entre a tela inicial, movimentações, detalhes, caixinha, resumo, meta e transferência.

---

## 📋 Listas e detalhes

O aplicativo possui duas listas principais:

### Movimentações

Apresenta as entradas e gastos registrados pelo usuário.

Cada item apresenta:

- Descrição
- Tipo da movimentação
- Valor
- Botão para visualizar os detalhes

### Movimentações da Caixinha

Apresenta os depósitos e retiradas realizados na Caixinha.

Cada item possui:

- Tipo
- Valor
- Botão para visualizar detalhes
- Botão para remover a movimentação

---

## 🧩 Data Classes

Foram utilizadas duas `data class` para representar os dados do aplicativo:

### Movimentacao

Responsável por representar entradas e gastos.

### MovimentacaoCaixinha

Responsável por representar depósitos e retiradas da Caixinha.

---

## 🔄 Evolução do Trabalho 1

O Trabalho 2 evoluiu o aplicativo desenvolvido anteriormente, adicionando novas funcionalidades e melhorando sua organização.

Foram adicionados:

- Navegação utilizando `NavHost` e `NavController`
- Organização das rotas utilizando o objeto `Rotas`
- Listas utilizando `LazyColumn`
- Componentes `Card`
- Duas `data class`
- Lista reativa utilizando `mutableStateListOf`
- Telas de detalhes
- Funcionalidade de remoção de movimentações
- Maior organização entre as telas do aplicativo

---

## 🆕 Novas telas

Foram adicionadas telas de detalhes para permitir que o usuário selecione uma movimentação e visualize suas informações individualmente.

Também foram desenvolvidas funcionalidades relacionadas à **Minha Caixinha**, permitindo guardar e retirar dinheiro e visualizar suas movimentações.

Essas novas telas foram criadas para deixar o aplicativo mais completo e facilitar a utilização pelo usuário.

---

## 🏗️ Organização do código

O projeto foi organizado separando as telas e os modelos de dados em arquivos diferentes.

Exemplos:

- `MainActivity.kt` — controle principal e navegação
- `Rotas.kt` — definição das rotas
- `Movimentacao.kt` — modelo de movimentação
- `MovimentacaoCaixinha.kt` — modelo da Caixinha
- `TelaMovimentacoes.kt` — lista de movimentações
- `DetalheMovimentacao.kt` — detalhes da movimentação
- `TelaCaixinha.kt` — tela da Caixinha
- `DetalheMovimentacaoCaixinha.kt` — detalhes da Caixinha
- `TelaResumoMes.kt` — resumo mensal
- `TelaMetaEconomia.kt` — meta de economia
- `TelaTransferencia.kt` — transferências
- `TelaSobre.kt` — informações sobre o aplicativo

Essa organização facilita a manutenção e permite que cada tela tenha uma responsabilidade mais específica.

---

## ⚖️ Decisões e complexidade

Uma das principais decisões foi utilizar listas reativas com `mutableStateListOf`.

Essa escolha permite que as alterações realizadas nas movimentações sejam refletidas automaticamente na interface.

Também foram utilizadas telas de detalhes para que o usuário possa selecionar uma movimentação específica e visualizar suas informações.

Na Caixinha, a tela de detalhes possui uma funcionalidade adicional de remoção da movimentação. Isso foi feito para tornar a tela mais interativa e atender aos requisitos do MAF.

---

## 🧠 Dificuldades encontradas

Durante o desenvolvimento, uma das principais dificuldades foi organizar a navegação entre várias telas.

A solução foi utilizar o `NavController` juntamente com o `NavHost`, criando rotas específicas para cada tela.

Outra dificuldade foi trabalhar com listas que precisavam ser atualizadas automaticamente. Para isso, foi utilizado o `mutableStateListOf`.

---

## ▶️ Como executar o projeto

1. Instale o **Android Studio**.
2. Clone ou baixe este repositório.
3. Abra o projeto no Android Studio.
4. Aguarde a sincronização do Gradle.
5. Execute o aplicativo em um emulador Android ou dispositivo físico.
6. Pressione **Run ▶** para iniciar o aplicativo.

---

## 📸 Demonstração

## 🎥 Vídeo de demonstração

[▶️ Clique aqui para assistir ao vídeo do aplicativo](https://youtu.be/IYNQxHGVsd4)

Durante a apresentação/entrega do trabalho podem ser adicionadas capturas de tela ou um vídeo demonstrando:

- Tela inicial
- Registro de entrada
- Registro de gasto
- Lista de movimentações
- Tela de detalhes
- Minha Caixinha
- Detalhes da Caixinha
- Resumo do mês
- Meta de economia
- Transferência

---

## 👨‍💻 Autores

**Vitor Augusto Costa**

**Rafael**

**Cesar**


Projeto desenvolvido para fins acadêmicos.