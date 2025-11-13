package jornadadev.personalizacao;

/**
 * Badge exibida ao lado do nome do jogador.
 */
public class Badge extends ItemPersonalizacao {

    private final String textoBadge;

    public Badge(String nome, double preco, Raridade raridade, String asciiArt, String textoBadge) {
        super(nome, preco, raridade, asciiArt);
        this.textoBadge = textoBadge;
    }

    public String getTextoBadge() {
        return textoBadge;
    }

    @Override
    public String getTipo() {
        return "Badge";
    }
}
