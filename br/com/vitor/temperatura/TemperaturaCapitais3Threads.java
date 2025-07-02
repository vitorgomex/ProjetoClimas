package br.com.vitor.temperatura;

import java.time.LocalDate;
import java.util.*;

public class TemperaturaCapitais3Threads {
    public static void main(String[] args) throws Exception {
        List<Capital> capitais = CapitalUtils.getCapitais();

        List<Capital> grupo1 = capitais.subList(0, 9);
        List<Capital> grupo2 = capitais.subList(9, 18);
        List<Capital> grupo3 = capitais.subList(18, 27);

        long total = 0;
        for (int i = 0; i < 10; i++) {
            long inicio = System.currentTimeMillis();

            Thread t1 = new Thread(new ProcessadorGrupo(grupo1));
            Thread t2 = new Thread(new ProcessadorGrupo(grupo2));
            Thread t3 = new Thread(new ProcessadorGrupo(grupo3));

            t1.start(); t2.start(); t3.start();
            t1.join(); t2.join(); t3.join();

            long fim = System.currentTimeMillis();
            total += fim - inicio;
            System.out.println("Rodada " + (i + 1) + ": " + (fim - inicio) + " ms");
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
