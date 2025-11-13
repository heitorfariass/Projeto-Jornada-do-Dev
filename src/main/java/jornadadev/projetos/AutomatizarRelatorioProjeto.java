package jornadadev.projetos;

/**
 * Projeto de automatizar relatório.
 */
public class AutomatizarRelatorioProjeto extends Projeto {

    public AutomatizarRelatorioProjeto() {
        super("Automatizar relatório", 55, 22);
    }

    @Override
    protected String mensagemConclusao() {
        return "O relatório agora é enviado antes do chefe pedir. Milagre!";
    }
}
