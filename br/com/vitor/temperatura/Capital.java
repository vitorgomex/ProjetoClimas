package br.com.vitor.temperatura;

public class Capital {
    private final String nome;
    private final double latitude;
    private final double longitude;

    public Capital(String nome, double latitude, double longitude) {
        this.nome = nome;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getNome() {
        return nome;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
