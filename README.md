# 💰 Meu Dinheiro — Trabalhos 1, 2 e 3

## 📱 Sobre o projeto

O **Meu Dinheiro** é um aplicativo de controle financeiro desenvolvido em **Kotlin**, utilizando **Android Studio** e **Jetpack Compose**.

O aplicativo permite ao usuário controlar seu saldo, registrar entradas e gastos, acompanhar movimentações, guardar dinheiro em uma caixinha, definir metas de economia e realizar transferências.

O projeto começou no Trabalho 1, evoluiu no Trabalho 2 (MAF — Mínimo Aplicativo Funcional) e, no **Trabalho 3**, recebeu a implementação de um banco de dados local utilizando **Room Database**.

Essa atualização permite que os dados financeiros continuem armazenados mesmo depois de fechar e abrir o aplicativo.

---

## 🎯 Objetivo

O objetivo do aplicativo é oferecer uma forma simples de organizar o dinheiro, permitindo que o usuário registre suas movimentações e acompanhe sua situação financeira.

No Trabalho 3, o objetivo principal foi implementar a persistência dos dados, utilizando banco de dados local e operações CRUD.

---

## 🚀 Funcionalidades

O aplicativo possui:

- 💰 Controle de saldo
- ➕ Adição de entradas
- ➖ Registro de gastos
- 📋 Lista de movimentações
- 🔎 Visualização dos detalhes de uma movimentação
- ✏️ Edição de movimentações
- 🗑️ Exclusão de movimentações
- 🐷 Minha Caixinha
- 💵 Guardar dinheiro na Caixinha
- 💸 Retirar dinheiro da Caixinha
- 🗑️ Remover movimentações da Caixinha
- 🔎 Visualização dos detalhes da Caixinha
- 🎯 Definição de meta de economia
- 📊 Resumo financeiro
- 💳 Transferência
- 💾 Armazenamento local com Room Database

---

## 🛠️ Tecnologias utilizadas

- Kotlin
- Android Studio
- Jetpack Compose
- Material 3
- Navigation Compose
- LazyColumn
- Card
- MutableStateListOf (utilizado na etapa anterior)
- NavController
- NavHost
- Room Database
- SQLite
- KSP (Kotlin Symbol Processing)
- Kotlin Coroutines
- Flow
- SharedPreferences (para armazenar a meta de economia)

---

## 🧭 Navegação

A navegação do aplicativo foi organizada utilizando:

- `NavController`
- `NavHost`
- Objeto `Rotas`

As telas possuem rotas próprias, permitindo a navegação entre a tela inicial, movimentações, detalhes, caixinha, resumo, meta e transferência.

No Trabalho 3, as telas de detalhes foram adaptadas para utilizar o identificador (`ID`) do registro armazenado no banco de dados.

---

## 📋 Listas e detalhes

### Movimentações

Apresenta as entradas e gastos registrados pelo usuário.

Cada item apresenta:

- Descrição
- Tipo da movimentação
- Valor
- Botão para visualizar detalhes

Na versão atual, também é possível editar e excluir movimentações diretamente na tela de detalhes.

### Movimentações da Caixinha

Apresenta os depósitos e retiradas realizados na Caixinha.

Cada item possui:

- Tipo
- Valor
- Botão para visualizar detalhes
- Opção de remoção

As informações são armazenadas no banco de dados local.

---

## 🧩 Data Classes — Trabalho 2

No Trabalho 2, foram utilizadas duas `data class` para representar os dados do aplicativo:

### Movimentacao

Responsável por representar entradas e gastos.

### MovimentacaoCaixinha

Responsável por representar depósitos e retiradas da Caixinha.

No Trabalho 3, foram adicionadas entidades do Room para representar os registros persistidos no banco.

---

## 🔄 Evolução do Trabalho 1 para o Trabalho 2

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

# 🆕 Trabalho 3 — Implementação do banco de dados Room

## 💾 1. Banco de dados local

Nesta etapa, foi implementado o **Room Database**, biblioteca do Android utilizada para facilitar o armazenamento e a consulta de informações em um banco SQLite local.

Antes dessa implementação, os dados financeiros eram mantidos principalmente em memória.

Com o Room, os registros passam a ser armazenados no dispositivo, permitindo sua recuperação após fechar e abrir o aplicativo.

O banco é identificado pelo nome:

`meu_dinheiro.db`

---

## 🗄️ 2. Entidades do banco de dados

Foram criadas duas entidades utilizando a anotação `@Entity`.

### MovimentacaoEntity

Representa a tabela `movimentacoes`.

Campos:

| Campo | Tipo | Descrição |
|---|---|---|
| id | Long | Identificador único |
| descricao | String | Descrição da movimentação |
| valor | Double | Valor financeiro |
| tipo | String | Entrada, gasto ou transferência |
| data | Long | Data do registro em timestamp |

### MovimentacaoCaixinhaEntity

Representa a tabela `movimentacoes_caixinha`.

Campos:

| Campo | Tipo | Descrição |
|---|---|---|
| id | Long | Identificador único |
| valor | Double | Valor movimentado |
| tipo | String | Depósito ou retirada |
| data | Long | Data do registro em timestamp |

As duas entidades utilizam `@PrimaryKey(autoGenerate = true)` para gerar identificadores automaticamente.

---

## 🔧 3. Interfaces DAO

Foram criadas duas interfaces com a anotação `@Dao`.

### MovimentacaoDao

Responsável pelo acesso aos dados das movimentações financeiras.

Possui métodos para:

- Inserir movimentações.
- Consultar todas as movimentações.
- Consultar uma movimentação pelo ID.
- Atualizar uma movimentação.
- Excluir uma movimentação.

### CaixinhaDao

Responsável pelo acesso aos registros da Caixinha.

Possui métodos para:

- Inserir depósitos e retiradas.
- Consultar os registros da Caixinha.
- Consultar um registro pelo ID.
- Atualizar registros.
- Excluir registros.

As operações utilizam anotações do Room como `@Insert`, `@Query`, `@Update` e `@Delete`.

---

## 🏗️ 4. Classe Database e Singleton

Foi criada a classe `MeuDinheiroDatabase`, utilizando a anotação `@Database`.

Essa classe centraliza o acesso às entidades e aos DAOs.

A implementação utiliza o padrão **Singleton**, mantendo uma instância compartilhada do banco durante a execução do aplicativo.

O banco é inicializado utilizando `Room.databaseBuilder()`.

---

## 🔄 5. Operações CRUD

O Trabalho 3 implementa as quatro operações fundamentais de gerenciamento de dados.

| Operação | Funcionalidade |
|---|---|
| Create | Adicionar entradas, gastos e registros da Caixinha |
| Read | Consultar listas e detalhes |
| Update | Editar informações existentes |
| Delete | Excluir registros armazenados |

Essas operações são realizadas por meio dos DAOs.

---

## 🔎 6. Consulta de detalhes pelo ID

As telas de detalhes foram adaptadas para consultar os registros diretamente no banco de dados.

Quando o usuário seleciona uma movimentação, seu ID é utilizado na navegação.

O DAO realiza a consulta correspondente, permitindo recuperar o registro correto.

Isso evita depender apenas da posição do item em uma lista.

---

## ⚡ 7. Kotlin Coroutines e Dispatchers.IO

Foram utilizadas Kotlin Coroutines para executar operações de banco de dados de maneira assíncrona.

As operações de escrita são realizadas utilizando:

`withContext(Dispatchers.IO)`

Essa abordagem permite executar as operações de entrada e saída fora da thread principal, evitando bloquear a interface do aplicativo.

Também foi utilizado `Flow` para observar as informações armazenadas no banco e atualizar as telas quando os registros são modificados.

---

## 💰 8. Cálculo de saldo e Caixinha

O saldo financeiro é calculado considerando as movimentações registradas.

As entradas aumentam o saldo, enquanto os gastos e transferências diminuem o valor disponível.

Na Caixinha, os depósitos aumentam o valor guardado e as retiradas diminuem esse total.

Como os cálculos utilizam os registros armazenados, alterações e exclusões podem ser refletidas nos valores apresentados.

A meta de economia é armazenada separadamente utilizando `SharedPreferences`.

---

## 🧪 9. Testes realizados

O aplicativo foi executado no Android Studio utilizando um emulador Pixel 9.

Foram realizados os seguintes testes manuais:

| Teste | Resultado |
|---|---|
| Abrir o aplicativo | Aprovado |
| Guardar dinheiro na Caixinha | Aprovado |
| Fechar e reabrir mantendo o saldo da Caixinha | Aprovado |
| Adicionar uma movimentação financeira | Aprovado |
| Consultar a movimentação cadastrada | Aprovado |
| Fechar e reabrir mantendo a movimentação | Aprovado |
| Editar uma movimentação | Aprovado |
| Verificar a alteração após reabrir | Aprovado |
| Excluir uma movimentação | Aprovado |
| Confirmar a exclusão após reabrir | Aprovado |

Os testes demonstraram o funcionamento das operações principais e a persistência dos dados nos cenários avaliados.

---

## 🏗️ 10. Organização do código

O projeto foi organizado separando telas, modelos e componentes relacionados ao banco de dados.

Entre os arquivos utilizados estão:

- `MainActivity.kt` — controle principal, navegação e integração com os dados
- `Rotas.kt` — definição das rotas
- `Movimentacao.kt` — modelo de movimentação
- `MovimentacaoCaixinha.kt` — modelo da Caixinha
- `BancoDados.kt` — entidades, DAOs e classe Room Database
- `DetalhesBanco.kt` — telas de detalhes integradas ao banco
- `TelaMovimentacoes.kt` — lista de movimentações
- `TelaCaixinha.kt` — tela da Caixinha
- `TelaResumoMes.kt` — resumo financeiro
- `TelaMetaEconomia.kt` — meta de economia
- `TelaTransferencia.kt` — transferências
- `TelaSobre.kt` — informações sobre o aplicativo

Essa organização facilita a manutenção e a evolução do projeto.

---

## ⚖️ 11. Decisões e complexidade

No Trabalho 2, uma das principais decisões foi utilizar listas reativas com `mutableStateListOf`, permitindo atualizar a interface automaticamente.

No Trabalho 3, a principal decisão foi implementar o Room para armazenar os registros de maneira persistente.

O Room foi escolhido por oferecer integração com Kotlin, suporte a consultas SQL, entidades, DAOs e operações assíncronas.

Outra decisão foi utilizar `Flow` para observar os registros do banco e atualizar a interface conforme os dados são modificados.

O padrão Singleton foi utilizado para centralizar a criação da instância do banco.

---

## 🧠 12. Dificuldades encontradas

Durante o desenvolvimento dos trabalhos, uma das primeiras dificuldades foi organizar a navegação entre várias telas.

A solução foi utilizar `NavController` e `NavHost`, criando rotas específicas.

Outra dificuldade foi trabalhar com listas que precisavam ser atualizadas automaticamente.

No Trabalho 3, surgiram dificuldades relacionadas à configuração do Kotlin, Gradle, KSP e Room.

Também ocorreram problemas durante a compilação e a configuração do emulador Android.

Esses problemas foram tratados por meio da revisão dos arquivos de configuração, sincronização do Gradle, limpeza dos arquivos temporários de compilação e testes no emulador.

Após os ajustes, foi possível executar o aplicativo e realizar testes das funcionalidades de persistência.

---

## ▶️ Como executar o projeto

1. Instale o **Android Studio**.
2. Clone ou baixe este repositório.
3. Abra a pasta principal do projeto no Android Studio.
4. Aguarde a sincronização do Gradle.
5. Configure um emulador Android ou conecte um dispositivo físico compatível.
6. Selecione o módulo `app`.
7. Pressione **Run ▶** para iniciar o aplicativo.

O Room cria o banco de dados local automaticamente quando ele é inicializado pelo aplicativo.

Não é necessário instalar um servidor de banco de dados externo.

---

## 📸 Demonstração

As funcionalidades que podem ser demonstradas incluem:

- Tela inicial
- Registro de entrada
- Registro de gasto
- Lista de movimentações
- Tela de detalhes
- Edição e exclusão de movimentações
- Minha Caixinha
- Detalhes da Caixinha
- Resumo financeiro
- Meta de economia
- Transferência
- Persistência dos dados após fechar e reabrir o aplicativo

### 🎥 Vídeo de demonstração — Trabalho 2

[▶️ Clique aqui para assistir ao vídeo do aplicativo](https://youtu.be/IYNQxHGVsd4)

### 🎥 Vídeo de demonstração — Trabalho 3

*[Parte 3 do APP.](https://youtu.be/22sGwhTUWVk)*

---

## 👨‍💻 Autores

**Vitor Augusto Costa**

**Rafael**

**Rick**

---

## ✅ Conclusão

O desenvolvimento do Meu Dinheiro permitiu aplicar conceitos de desenvolvimento Android, programação em Kotlin, construção de interfaces com Jetpack Compose e navegação entre telas.

No Trabalho 2, o aplicativo evoluiu com novas funcionalidades, listas reativas e telas de detalhes.

No Trabalho 3, a implementação do Room Database permitiu armazenar informações financeiras localmente, realizar operações CRUD e recuperar dados após fechar e reabrir o aplicativo.

Com essas melhorias, o Meu Dinheiro tornou-se um aplicativo mais completo, organizado e preparado para futuras evoluções.
