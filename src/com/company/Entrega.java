package com.company;

import java.util.Date;

public class Entrega {

    private int numero;

    private String descricao;

    private String data;

    private double peso;

    private String situacao;

    private Localizacao origem;

    private Localizacao destino;

    private String drone;

    private String cliente;

    public double calculaValor() {
        return 0;
    }

    public Entrega(int numero, String descricao, String data, double peso, String situacao, Localizacao origem, Localizacao destino, String drone, String cliente) {
        this.numero = numero;
        this.descricao = descricao;
        this.data = data;
        this.peso = peso;
        this.situacao = situacao;
        this.origem = origem;
        this.destino = destino;
        this.drone = drone;
        this.cliente = cliente;
    }

    public int getNumero() {
        return numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getData() {
        return data;
    }

    public double getPeso() {
        return peso;
    }

    public String getSituacao() {
        return situacao;
    }

    public Localizacao getOrigem() {
        return origem;
    }

    public Localizacao getDestino() {
        return destino;
    }

    public String getDrone() {
        return drone;
    }

    public String getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        return "Entrega{" +
                "numero=" + numero +
                ", descricao='" + descricao + '\'' +
                ", data='" + data + '\'' +
                ", peso=" + peso +
                ", situacao='" + situacao + '\'' + "\n" +
                ", origem=" + origem + "\n" +
                ", destino=" + destino + "\n" +
                ", drone='" + drone + '\'' +
                '}';
    }
}
