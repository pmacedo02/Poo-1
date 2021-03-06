package com.company;


public class Cliente {

    private String nome;

    private String email;

    private String senha;

    private Localizacao endereco;

    public Cliente(String nome, String email, String senha, Localizacao endereco) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public Localizacao getEndereco() {
        return endereco;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}

