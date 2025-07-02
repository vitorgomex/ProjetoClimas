package br.com.vitor.temperatura;


import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class ProcessadorUnico implements Runnable {
    private final Capital capital;

    public ProcessadorUnico(Capital capital) {
        this.capital = capital;
    }

    @Override
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
