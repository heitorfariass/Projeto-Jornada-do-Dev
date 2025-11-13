package jornadadev.personalizacao;

/**
 * Slogan usado apenas por CEOs.
 */
public class Slogan extends ItemPersonalizacao {

    private final String frase;

    public Slogan(String nome, double preco, Raridade raridade, String asciiArt, String frase) {
        super(nome, preco, raridade, asciiArt);
        this.frase = frase;
    }

    public String getFrase() {
        return frase;
    }

    @Override
    public String getTipo() {
        return "Slogan";
    }
}
