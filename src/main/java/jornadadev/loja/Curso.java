package jornadadev.loja;

import jornadadev.model.Cargo;

/**
 * Representa um curso disponível para compra na loja.
 */
public class Curso {

    private final String nome;
    private final double preco;
    private final int xpConcedido;
    private final Cargo cargoMinimo;
    private final String descricao;

    public Curso(String nome, double preco, int xpConcedido, Cargo cargoMinimo, String descricao) {
        this.nome = nome;
        this.preco = preco;
        this.xpConcedido = xpConcedido;
        this.cargoMinimo = cargoMinimo;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getXpConcedido() {
        return xpConcedido;
    }

    public Cargo getCargoMinimo() {
        return cargoMinimo;
    }

    public String getDescricao() {
        return descricao;
    }
}
