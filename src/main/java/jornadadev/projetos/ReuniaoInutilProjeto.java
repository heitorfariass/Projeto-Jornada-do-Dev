package jornadadev.projetos;

/**
 * Projeto de reunião inútil.
 */
public class ReuniaoInutilProjeto extends Projeto {

    public ReuniaoInutilProjeto() {
        super("Reunião inútil", 120, 30);
    }

    @Override
    protected String mensagemConclusao() {
        return "Você saiu da reunião sem saber o que aconteceu, mas ganhou CC$.";
    }
}
