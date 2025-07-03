# 🌦️ Projeto Climas – Análise de Performance com Threads em Java

Este projeto compara o desempenho de diferentes implementações de um algoritmo de coleta e processamento de dados climáticos das 27 capitais brasileiras, utilizando a API [Open-Meteo](https://open-meteo.com/). As versões variam pela quantidade de threads utilizadas.

## 🧠 Objetivo

Avaliar como o uso de múltiplas threads influencia o tempo de execução de um programa Java, aplicando conceitos de computação concorrente e paralela.

📁 Estrutura de Pastas
src/br/com/vitor/temperatura/

Capital.java

CapitalUtils.java

TemperaturaCapitais.java

TemperaturaCapitais3Threads.java

TemperaturaCapitais9Threads.java

TemperaturaCapitais27Threads.java

out/: arquivos .class compilados

json-20250517.jar: biblioteca externa para manipulação de JSON

Relatorio_Tecnico_Projeto_Climas.pdf: relatório técnico com análise completa

grafico.png: gráfico comparativo dos tempos de execução

README.md: este arquivo com as instruções do projeto


bash
Copiar
Editar

## ▶️ Como Compilar e Executar

### Compilação

Abra o terminal na pasta raiz do projeto e execute:

```bash
javac -cp ".;json-20250517.jar" -d out src/br/com/vitor/temperatura/*.java
Execução
Escolha uma das versões para executar:

bash
Copiar
Editar
# Versão sequencial
java -cp ".;json-20250517.jar;out" br.com.vitor.temperatura.TemperaturaCapitais

# Versão com 3 threads
java -cp ".;json-20250517.jar;out" br.com.vitor.temperatura.TemperaturaCapitais3Threads

# Versão com 9 threads
java -cp ".;json-20250517.jar;out" br.com.vitor.temperatura.TemperaturaCapitais9Threads

# Versão com 27 threads
java -cp ".;json-20250517.jar;out" br.com.vitor.temperatura.TemperaturaCapitais27Threads
📉 Resultados
As execuções foram realizadas em 10 rodadas para cada versão. Abaixo, o tempo médio de execução:

Versão	Nº de Threads	Tempo Médio (ms)
Sequencial	1	6218
Concorrente 1	3	2222
Concorrente 2	9	1624
Paralela	27	1591
