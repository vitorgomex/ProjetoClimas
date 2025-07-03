# Projeto Climas - Comparativo de Execução com Threads em Java

Este projeto tem como objetivo analisar o impacto da programação concorrente, por meio do uso de múltiplas threads, na coleta e processamento de dados climáticos das 27 capitais brasileiras utilizando a API Open-Meteo.

## 🔧 Tecnologias Utilizadas
- Java 17
- Biblioteca externa: `org.json` (json-20250517.jar)
- API Open-Meteo: https://open-meteo.com/
- IDE recomendada: Visual Studio Code ou qualquer editor compatível com Java
- Linha de comando (PowerShell ou Terminal)

## 📁 Estrutura de Pastas
ProjetoClimas/
│
├── src/
│ └── br/com/vitor/temperatura/
│ ├── TemperaturaCapitais.java
│ ├── TemperaturaCapitais3Threads.java
│ ├── TemperaturaCapitais9Threads.java
│ └── TemperaturaCapitais27Threads.java
│
├── out/ # Arquivos .class compilados
├── json-20250517.jar # Biblioteca para manipulação de JSON
├── Relatorio_Tecnico_Projeto_Climas.pdf
└── grafico.png # Gráfico comparativo dos tempos

## 📈 Objetivo do Experimento

Avaliar o desempenho de quatro versões de um mesmo algoritmo Java, variando a quantidade de threads utilizadas para processar requisições simultâneas à API Open-Meteo:

- `TemperaturaCapitais.java`: execução sequencial (1 thread)
- `TemperaturaCapitais3Threads.java`: uso de 3 threads
- `TemperaturaCapitais9Threads.java`: uso de 9 threads
- `TemperaturaCapitais27Threads.java`: uso de 27 threads (uma por capital)

O programa coleta dados de temperatura de janeiro de 2024 e calcula média, mínima e máxima por dia.

## ▶️ Como Executar

Antes de tudo, compile os arquivos Java:

```bash
javac -cp ".;json-20250517.jar" -d out src/br/com/vitor/temperatura/*.java
Depois, execute uma das versões:

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

📊 Resultados Obtidos
Nº de Threads	Tempo Médio (ms)
1	6218
3	2222
9	1624
27	1591

O gráfico com esses resultados está disponível em grafico.png.

📄 Relatório
O relatório técnico contendo a explicação teórica, análise dos resultados e referências bibliográficas está disponível no arquivo:

👉 Relatorio_Tecnico_Projeto_Climas.pdf
