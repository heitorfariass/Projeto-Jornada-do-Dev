package jornadadev.personalizacao;

/**
 * Raridades disponíveis para itens cosméticos.
 */
public enum Raridade {
    COMUM("Comum"),
    INCOMUM("Incomum"),
    RARO("Raro"),
    LENDARIO("Lendário"),
    MITICO("Mítico");

    private final String nome;

    Raridade(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
