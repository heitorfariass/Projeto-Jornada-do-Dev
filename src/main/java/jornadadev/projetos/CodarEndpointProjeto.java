package jornadadev.projetos;

/**
 * Projeto de codar endpoint.
 */
public class CodarEndpointProjeto extends Projeto {

    public CodarEndpointProjeto() {
        super("Codar endpoint", 45, 20);
    }

    @Override
    protected String mensagemConclusao() {
        return "Seu endpoint respondeu mais rápido que o bot do suporte.";
    }
}
