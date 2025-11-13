package jornadadev.projetos;

/**
 * Projeto de criação de pipeline CI/CD.
 */
public class CriarCICDProjeto extends Projeto {

    public CriarCICDProjeto() {
        super("Criar CI/CD", 100, 42);
    }

    @Override
    protected String mensagemConclusao() {
        return "Deploy contínuo tão suave que parece manteiga devops.";
    }
}
