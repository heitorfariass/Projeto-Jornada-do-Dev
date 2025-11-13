package jornadadev.personalizacao;

/**
 * Representa um pet ASCII para o jogador.
 */
public class Pet extends ItemPersonalizacao {

    public Pet(String nome, double preco, Raridade raridade, String asciiArt) {
        super(nome, preco, raridade, asciiArt);
    }

    @Override
    public String getTipo() {
        return "Pet";
    }
}
