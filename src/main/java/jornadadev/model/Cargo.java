package jornadadev.model;

/**
 * Enum que representa os cargos possíveis do desenvolvedor.
 */
public enum Cargo {
    ESTAGIARIO_CAFE("Estagiário Café", 20),
    ESTAGIARIO_DEV("Estagiário Dev", 50),
    JUNIOR("Júnior", 100),
    PLENO("Pleno", 180),
    SENIOR("Sênior", 260),
    CEO("CEO", -1);

    private final String nomeExibicao;
    private final int xpParaPromocao;

    Cargo(String nomeExibicao, int xpParaPromocao) {
        this.nomeExibicao = nomeExibicao;
        this.xpParaPromocao = xpParaPromocao;
    }

    public String getNomeExibicao() {
        return nomeExibicao;
    }

    public int getXpParaPromocao() {
        return xpParaPromocao;
    }

    public Cargo getProximoCargo() {
        int index = ordinal();
        Cargo[] valores = values();
        if (index + 1 < valores.length) {
            return valores[index + 1];
        }
        return this;
    }

    public boolean possuiProximoCargo() {
        return this != CEO;
    }
}
