package com.company;

public class Drone {

    private int identificador;

    private double cargaMaxima;

    private int autonomiaKm;

    private Localizacao base;

    public Drone(int identificador, double cargaMaxima, int autonomiaKm, Localizacao base) {
        this.identificador = identificador;
        this.cargaMaxima = cargaMaxima;
        this.autonomiaKm = autonomiaKm;
        this.base = base;
    }

    public int getIdentificador() {
        return identificador;
    }

    public double getCargaMaxima() {
        return cargaMaxima;
    }

    public int getAutonomiaKm() {
        return autonomiaKm;
    }

    public Localizacao getBase() {
        return base;
    }

    @Override
    public String toString() {
        return "Drone{" +
                "identificador=" + identificador +
                ", cargaMaxima=" + cargaMaxima +
                ", autonomiaKm=" + autonomiaKm +
                ", base=" + base +
                '}';
    }
}

