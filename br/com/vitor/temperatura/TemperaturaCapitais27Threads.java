package br.com.vitor.temperatura;

import java.time.LocalDate;
import java.util.*;

public class TemperaturaCapitais27Threads {
    public static void main(String[] args) throws Exception {
        List<Capital> capitais = CapitalUtils.getCapitais();

        long inicio = System.currentTimeMillis();

        List<Thread> threads = new ArrayList<>();
        for (Capital capital : capitais) {
            Thread t = new Thread(new ProcessadorUnico(capital));
            threads.add(t);
            t.start();
        }

        for (Thread t : threads) t.join();

        long fim = System.currentTimeMillis();
        System.out.println("Tempo total com 27 threads: " + (fim - inicio) + " ms");
    }
}

class ProcessadorUnico implements Runnable {
    private final Capital capital;

    public ProcessadorUnico(Capital capital) {
        this.capital = capital;
    }

    public void run() {
        try {
            String json = CapitalUtils.fazerRequisicao(capital);
            Map<LocalDate, List<Double>> temperaturas = CapitalUtils.processarDados(json);
            CapitalUtils.exibirResultados(capital.getNome(), temperaturas);
        } catch (Exception e) {
            System.err.println("Erro com " + capital.getNome() + ": " + e.getMessage());
        }
    }
}
