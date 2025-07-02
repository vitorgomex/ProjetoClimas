package br.com.vitor.temperatura;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class ProcessadorGrupo implements Runnable {
    private final List<Capital> capitais;

    public ProcessadorGrupo(List<Capital> capitais) {
        this.capitais = capitais;
    }

    @Override
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
