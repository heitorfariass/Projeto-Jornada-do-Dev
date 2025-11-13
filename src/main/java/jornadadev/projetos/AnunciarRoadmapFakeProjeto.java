package jornadadev.projetos;

/**
 * Projeto de anúncio de roadmap fake.
 */
public class AnunciarRoadmapFakeProjeto extends Projeto {

    public AnunciarRoadmapFakeProjeto() {
        super("Anunciar roadmap fake", 260, 100);
    }

    @Override
    protected String mensagemConclusao() {
        return "Roadmap anunciado! Agora é só entregar... algum dia.";
    }
}
