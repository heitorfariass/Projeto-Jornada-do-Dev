package jornadadev.projetos;

/**
 * Projeto de documentação interna.
 */
public class DocumentacaoInternaProjeto extends Projeto {

    public DocumentacaoInternaProjeto() {
        super("Documentação interna", 20, 10);
    }

    @Override
    protected String mensagemConclusao() {
        return "Você escreveu documentação tão boa que até o futuro você entendeu.";
    }
}
