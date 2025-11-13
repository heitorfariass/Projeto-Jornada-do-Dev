package jornadadev.projetos;

/**
 * Trabalho de buscar canetas.
 */
public class BuscarCanetasProjeto extends Projeto {

    public BuscarCanetasProjeto() {
        super("Buscar Canetas", 8, 0);
    }

    @Override
    protected String mensagemConclusao() {
        return "Você encontrou canetas suficientes para pintar um Data Center inteiro.";
    }
}
