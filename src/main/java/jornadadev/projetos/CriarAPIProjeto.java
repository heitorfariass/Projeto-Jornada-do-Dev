package jornadadev.projetos;

/**
 * Projeto de criação de API.
 */
public class CriarAPIProjeto extends Projeto {

    public CriarAPIProjeto() {
        super("Criar API", 85, 35);
    }

    @Override
    protected String mensagemConclusao() {
        return "Você entregou uma API tão REST que ela tira férias em JSON.";
    }
}
