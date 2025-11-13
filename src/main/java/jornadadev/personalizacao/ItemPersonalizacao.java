package jornadadev.personalizacao;

/**
 * Base para todos os itens cosméticos do jogo.
 */
public abstract class ItemPersonalizacao {

    private final String nome;
    private final double preco;
    private final Raridade raridade;
    private final String asciiArt;

    protected ItemPersonalizacao(String nome, double preco, Raridade raridade, String asciiArt) {
        this.nome = nome;
        this.preco = preco;
        this.raridade = raridade;
        this.asciiArt = asciiArt;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public Raridade getRaridade() {
        return raridade;
    }

    public String getAsciiArt() {
        return asciiArt;
    }

    public abstract String getTipo();
}
