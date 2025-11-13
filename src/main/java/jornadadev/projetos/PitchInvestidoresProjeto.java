package jornadadev.projetos;

/**
 * Projeto de pitch para investidores.
 */
public class PitchInvestidoresProjeto extends Projeto {

    public PitchInvestidoresProjeto() {
        super("Pitch para investidores", 230, 95);
    }

    @Override
    protected String mensagemConclusao() {
        return "Você usou tantos buzzwords que levantou uma rodada Série Z.";
    }
}
