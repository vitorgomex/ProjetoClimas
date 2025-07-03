# Projeto Climas 🌤️

Este projeto coleta e processa dados climáticos das 27 capitais brasileiras utilizando a API da Open-Meteo. O objetivo é comparar o desempenho de diferentes versões concorrentes do algoritmo, variando o número de threads utilizadas.

## 📌 Objetivos
- Coletar dados de temperatura de janeiro de 2024 via API Open-Meteo.
- Comparar desempenho entre execuções com 1, 3, 9 e 27 threads.
- Analisar o impacto da paralelização no tempo de execução do algoritmo.

## 🧪 Versões Implementadas
- `TemperaturaCapitais.java`: versão sequencial (1 thread)
- `TemperaturaCapitais3Threads.java`: versão concorrente com 3 threads
- `TemperaturaCapitais9Threads.java`: versão concorrente com 9 threads
- `TemperaturaCapitais27Threads.java`: versão concorrente com 27 threads

## 📈 Resultados Médios Obtidos

| Nº de Threads | Tempo Médio (ms) |
|---------------|------------------|
| 1             | 6218             |
| 3             | 2222             |
| 9             | 1624             |
| 27            | 1591             |

> Os testes demonstram uma redução significativa do tempo com aumento de threads até certo ponto. Após 9 threads, o ganho se estabiliza, indicando saturação dos recursos de hardware disponíveis.

## 📄 Relatório Técnico

O relatório técnico completo contendo fundamentação teórica, explicações e gráficos comparativos está disponível em:
👉 [`Relatorio_Tecnico_Projeto_Climas.pdf`](./Relatorio_Tecnico_Projeto_Climas.pdf)

## 🔧 Tecnologias Utilizadas
- Java 17
- API Open-Meteo
- Multithreading
- JSON (org.json)

## 📚 Referências
- Tanenbaum, A. S. & Bos, H. *Modern Operating Systems*, Pearson, 2015.
- Open-Meteo API: https://open-meteo.com/
- Oracle Java Docs: https://docs.oracle.com/javase/8/docs/api/
