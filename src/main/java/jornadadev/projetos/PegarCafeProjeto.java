package jornadadev.projetos;

/**
 * Trabalho inicial de pegar café.
 */
public class PegarCafeProjeto extends Projeto {

    public PegarCafeProjeto() {
        super("Pegar Café", 10, 0);
    }

    @Override
    protected String mensagemConclusao() {
        return "Você retornou com o melhor café do andar. O time acordou instantaneamente.";
    }
}
