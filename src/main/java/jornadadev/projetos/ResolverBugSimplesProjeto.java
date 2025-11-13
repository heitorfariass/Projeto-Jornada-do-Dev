package jornadadev.projetos;

/**
 * Projeto de resolução de bug simples.
 */
public class ResolverBugSimplesProjeto extends Projeto {

    public ResolverBugSimplesProjeto() {
        super("Resolver bug simples", 25, 8);
    }

    @Override
    protected String mensagemConclusao() {
        return "Você corrigiu o bug com um print suspeito e ninguém percebeu.";
    }
}
