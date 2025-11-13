package jornadadev.projetos;

/**
 * Projeto de debugar tela.
 */
public class DebugarTelaProjeto extends Projeto {

    public DebugarTelaProjeto() {
        super("Debugar tela", 38, 18);
    }

    @Override
    protected String mensagemConclusao() {
        return "Você encontrou o bug escondido atrás de uma div com display:none.";
    }
}
