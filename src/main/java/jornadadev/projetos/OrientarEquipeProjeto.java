package jornadadev.projetos;

/**
 * Projeto de orientação da equipe.
 */
public class OrientarEquipeProjeto extends Projeto {

    public OrientarEquipeProjeto() {
        super("Orientar equipe", 160, 60);
    }

    @Override
    protected String mensagemConclusao() {
        return "Mentoria entregue! O squad agora até usa retrospectiva direito.";
    }
}
