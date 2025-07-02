package br.com.vitor.temperatura;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class CapitalUtils {
    public static List<Capital> getCapitais() {
        return Arrays.asList(
            new Capital("AC", -9.97499, -67.8243),
            new Capital("AL", -9.6658, -35.735),
            new Capital("AP", 0.0349, -51.0694),
            new Capital("AM", -3.1019, -60.025),
            new Capital("BA", -12.9714, -38.5014),
            new Capital("CE", -3.7172, -38.5433),
            new Capital("DF", -15.7797, -47.9297),
            new Capital("ES", -20.3155, -40.3128),
            new Capital("GO", -16.6864, -49.2643),
            new Capital("MA", -2.5307, -44.3068),
            new Capital("MT", -15.601, -56.0974),
            new Capital("MS", -20.4697, -54.6201),
            new Capital("MG", -19.8157, -43.9542),
            new Capital("PA", -1.455, -48.5022),
            new Capital("PB", -7.12, -34.845),
            new Capital("PR", -25.4291, -49.2675),
            new Capital("PE", -8.0476, -34.877),
            new Capital("PI", -5.0892, -42.8016),
            new Capital("RJ", -22.9068, -43.1729),
            new Capital("RN", -5.7945, -35.211),
            new Capital("RS", -30.0318, -51.2065),
            new Capital("RO", -8.7608, -63.8999),
            new Capital("RR", 2.819, -60.6733),
            new Capital("SC", -27.5954, -48.548),
            new Capital("SP", -23.5505, -46.6333),
            new Capital("SE", -10.9472, -37.0731),
            new Capital("TO", -10.2491, -48.3243)
        );
    }

    public static String fazerRequisicao(Capital capital) throws Exception {
        Locale.setDefault(Locale.US);
        String urlStr = String.format(
            Locale.US,
            "https://archive-api.open-meteo.com/v1/archive?latitude=%.4f&longitude=%.4f&start_date=2024-01-01&end_date=2024-01-31&hourly=temperature_2m",
            capital.getLatitude(), capital.getLongitude()
        );
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder content = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        conn.disconnect();
        return content.toString();
    }

    public static Map<LocalDate, List<Double>> processarDados(String json) {
        Map<LocalDate, List<Double>> temperaturasPorDia = new HashMap<>();
        JSONObject obj = new JSONObject(json);
        JSONArray tempos = obj.getJSONObject("hourly").getJSONArray("time");
        JSONArray temps = obj.getJSONObject("hourly").getJSONArray("temperature_2m");
        for (int i = 0; i < tempos.length(); i++) {
            String dataHora = tempos.getString(i);
            double temp = temps.getDouble(i);
            LocalDate dia = LocalDate.parse(dataHora.substring(0, 10));
            temperaturasPorDia.computeIfAbsent(dia, k -> new ArrayList<>()).add(temp);
        }
        return temperaturasPorDia;
    }

    public static void exibirResultados(String nome, Map<LocalDate, List<Double>> mapa) {
        System.out.println("\n" + nome + ":");
        for (LocalDate dia : mapa.keySet()) {
            List<Double> temps = mapa.get(dia);
            double media = temps.stream().mapToDouble(d -> d).average().orElse(Double.NaN);
            double min = temps.stream().mapToDouble(d -> d).min().orElse(Double.NaN);
            double max = temps.stream().mapToDouble(d -> d).max().orElse(Double.NaN);
            System.out.printf("%s - Media: %.2f C, Minima: %.2f C, Maxima: %.2f C\n", dia, media, min, max);
        }
    }
}
