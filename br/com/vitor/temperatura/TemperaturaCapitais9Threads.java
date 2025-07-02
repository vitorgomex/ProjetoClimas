package br.com.vitor.temperatura;

import java.time.LocalDate;
import java.util.*;

public class TemperaturaCapitais9Threads {
    public static void main(String[] args) throws Exception {
        List<Capital> capitais = CapitalUtils.getCapitais();

        List<List<Capital>> grupos = new ArrayList<>();
        for (int i = 0; i < 9; i++) grupos.add(new ArrayList<>());
        for (int i = 0; i < capitais.size(); i++) grupos.get(i % 9).add(capitais.get(i));

        long total = 0;
        for (int rodada = 1; rodada <= 10; rodada++) {
            long inicio = System.currentTimeMillis();

            List<Thread> threads = new ArrayList<>();
            for (List<Capital> grupo : grupos) {
                Thread t = new Thread(new ProcessadorGrupo(grupo));
                threads.add(t);
                t.start();
            }

            for (Thread t : threads) t.join();

            long fim = System.currentTimeMillis();
            total += fim - inicio;
            System.out.println("Rodada " + rodada + ": " + (fim - inicio) + " ms");
        }

        System.out.println("Tempo medio: " + (total / 10) + " ms");
    }
}

class ProcessadorGrupo implements Runnable {
    private final List<Capital> capitais;

    public ProcessadorGrupo(List<Capital> capitais) {
        this.capitais = capitais;
    }

    public void run() {
        for (Capital capital : capitais) {
            try {
                String json = CapitalUtils.fazerRequisicao(capital);
                Map<LocalDate, List<Double>> temperaturas = CapitalUtils.processarDados(json);
                CapitalUtils.exibirResultados(capital.getNome(), temperaturas);
            } catch (Exception e) {
                System.err.println("Erro com " + capital.getNome() + ": " + e.getMessage());
            }
        }
    }
}
