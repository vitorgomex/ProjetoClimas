# Projeto Climas

Este projeto em Java realiza requisições à API da Open-Meteo para obter dados de temperatura de todas as 27 capitais brasileiras durante o mês de janeiro de 2024. Foram implementadas quatro versões do experimento para comparar o desempenho com diferentes graus de concorrência: sequencial (1 thread) e concorrente (3, 9 e 27 threads).

## Objetivo

Avaliar o impacto do uso de múltiplas threads na performance de um algoritmo que coleta e processa dados climáticos em larga escala.

## Tecnologias Utilizadas

- Java 17
- API Open-Meteo (https://open-meteo.com/)
- Biblioteca JSON: `json-20250517.jar`
- Threads Java (classe `Runnable`)

## Organização do Projeto

ProjetoClimas/
├── src/
│ └── br/com/vitor/temperatura/
│ ├── Capital.java
│ ├── CapitalUtils.java
│ ├── TemperaturaCapitais.java
│ ├── TemperaturaCapitais3Threads.java
│ ├── TemperaturaCapitais9Threads.java
│ └── TemperaturaCapitais27Threads.java
├── json-20250517.jar
├── out/
└── README.md

bash

## Como Compilar e Executar

### Compilação

Abra o terminal na pasta raiz do projeto e execute:

```bash
javac -cp ".;json-20250517.jar" -d out src/br/com/vitor/temperatura/*.java
Execução
bash
Copiar
Editar
java -cp ".;json-20250517.jar;out" br.com.vitor.temperatura.TemperaturaCapitais
java -cp ".;json-20250517.jar;out" br.com.vitor.temperatura.TemperaturaCapitais3Threads
java -cp ".;json-20250517.jar;out" br.com.vitor.temperatura.TemperaturaCapitais9Threads
java -cp ".;json-20250517.jar;out" br.com.vitor.temperatura.TemperaturaCapitais27Threads
Resultados Obtidos
Abaixo estão os tempos médios de execução das quatro versões:

Versão	Nº de Threads	Tempo Médio de Execução
Sequencial	1	6362 ms
Concorrente	3	4716 ms
Concorrente	9	1864 ms
Concorrente	27	1134 ms
