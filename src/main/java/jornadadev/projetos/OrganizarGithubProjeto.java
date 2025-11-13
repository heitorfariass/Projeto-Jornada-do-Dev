package jornadadev.projetos;

/**
 * Projeto de organizar o GitHub da empresa.
 */
public class OrganizarGithubProjeto extends Projeto {

    public OrganizarGithubProjeto() {
        super("Organizar GitHub", 30, 12);
    }

    @Override
    protected String mensagemConclusao() {
        return "Você criou uma estrutura de pastas tão limpa que dá vontade de morar lá.";
    }
}
