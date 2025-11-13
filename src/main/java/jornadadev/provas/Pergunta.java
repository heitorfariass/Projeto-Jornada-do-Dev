package jornadadev.provas;

/**
 * Representa uma pergunta de prova.
 */
public class Pergunta {

    private final String enunciado;
    private final String[] alternativas;
    private final int indiceCorreto;

    public Pergunta(String enunciado, String[] alternativas, int indiceCorreto) {
        this.enunciado = enunciado;
        this.alternativas = alternativas;
        this.indiceCorreto = indiceCorreto;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public String[] getAlternativas() {
        return alternativas;
    }

    public int getIndiceCorreto() {
        return indiceCorreto;
    }
}
