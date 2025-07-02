package br.com.vitor.temperatura;

import java.time.LocalDate;
import java.util.*;
//import org.json.JSONArray;
//import org.json.JSONObject;

public class TemperaturaCapitais {

    public static void main(String[] args) throws Exception {
        List<Capital> capitais = CapitalUtils.getCapitais();

        long total = 0;

        for (int i = 1; i <= 10; i++) {
            long inicio = System.currentTimeMillis();

            for (Capital capital : capitais) {
                String json = CapitalUtils.fazerRequisicao(capital);
                Map<LocalDate, List<Double>> temperaturas = CapitalUtils.processarDados(json);
                CapitalUtils.exibirResultados(capital.getNome(), temperaturas);
            }

            long fim = System.currentTimeMillis();
            long tempo = fim - inicio;
            total += tempo;
            System.out.println("Rodada " + i + ": " + tempo + " ms");
        }

        System.out.println("Tempo medio: " + (total / 10) + " ms");
    }
}
