package jornadadev.projetos;

/**
 * Projeto de arquitetura distribuída.
 */
public class ArquiteturaDistribuidaProjeto extends Projeto {

    public ArquiteturaDistribuidaProjeto() {
        super("Arquitetura distribuída", 190, 80);
    }

    @Override
    protected String mensagemConclusao() {
        return "Você distribuiu tanto o sistema que até o café ficou em micro serviços.";
    }
}
