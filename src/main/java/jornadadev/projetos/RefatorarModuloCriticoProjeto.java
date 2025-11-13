package jornadadev.projetos;

/**
 * Projeto de refatoração crítica.
 */
public class RefatorarModuloCriticoProjeto extends Projeto {

    public RefatorarModuloCriticoProjeto() {
        super("Refatorar módulo crítico", 170, 70);
    }

    @Override
    protected String mensagemConclusao() {
        return "O módulo agora tem menos ifs que uma prova de lógica.";
    }
}
