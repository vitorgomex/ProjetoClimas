# 🌦️ Projeto Climas – Análise de Performance com Threads em Java

Este projeto compara o desempenho de diferentes implementações de um algoritmo de coleta e processamento de dados climáticos das 27 capitais brasileiras, utilizando a API [Open-Meteo](https://open-meteo.com/). As versões variam pela quantidade de threads utilizadas.

## 🧠 Objetivo

Avaliar como o uso de múltiplas threads influencia o tempo de execução de um programa Java, aplicando conceitos de computação concorrente e paralela.

## 🗂️ Estrutura do Projeto

- `src/br/com/vitor/temperatura/` – Contém as quatro versões do programa:
  - `TemperaturaCapitais.java` – 1 thread
  - `TemperaturaCapitais3Threads.java` – 3 threads
  - `TemperaturaCapitais9Threads.java` – 9 threads
  - `TemperaturaCapitais27Threads.java` – 27 threads
- `json-20250517.jar` – Biblioteca usada para manipulação de JSON.
- `out/` – Pasta para os arquivos `.class` compilados.
- `Relatorio_Tecnico_Projeto_Climas.pdf` – Relatório final do projeto com explicações teóricas, comparações e gráficos.

## ▶️ Como Executar

### Compilar

No terminal, dentro da raiz do projeto:

```bash
javac -cp ".;json-20250517.jar" -d out src/br/com/vitor/temperatura/*.java
Rodar (exemplo com 27 threads)
bash
Copiar
Editar
java -cp ".;json-20250517.jar;out" br.com.vitor.temperatura.TemperaturaCapitais27Threads
Altere o nome da classe para rodar outras versões.

📊 Resultados
As execuções foram feitas em 10 rodadas para cada versão, com os seguintes tempos médios:

Versão	Threads	Tempo Médio (ms)
Sequencial	1	6218
Concorrente 1	3	2222
Concorrente 2	9	1624
Paralela	27	1591

Gráfico de comparação incluído no relatório técnico.

📄 Relatório
Todo o detalhamento teórico, análise dos resultados e gráfico comparativo estão no arquivo:

📎 Relatorio_Tecnico_Projeto_Climas.pdf

📚 Referências
Tanenbaum, A. S., & Bos, H. (2015). Modern Operating Systems. Pearson.

Silberschatz, A., Galvin, P. B., & Gagne, G. (2018). Operating System Concepts. Wiley.

Open-Meteo API: https://open-meteo.com/

Artigo sobre multithreading
