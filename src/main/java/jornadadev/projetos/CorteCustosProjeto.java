package jornadadev.projetos;

/**
 * Projeto de corte de custos.
 */
public class CorteCustosProjeto extends Projeto {

    public CorteCustosProjeto() {
        super("Corte de custos", 150, 45);
    }

    @Override
    protected String mensagemConclusao() {
        return "Você cortou tanto custo que até o PowerPoint ficou em modo economia.";
    }
}
