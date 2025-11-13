package jornadadev.loja;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jornadadev.model.Cargo;
import jornadadev.personalizacao.ItemPersonalizacao;

/**
 * Loja principal contendo cursos e itens cosméticos.
 */
public class Loja {

    private final List<Curso> cursos;
    private final List<ItemPersonalizacao> itens;

    public Loja() {
        this.cursos = new ArrayList<>();
        this.itens = new ArrayList<>();
    }

    public void adicionarCurso(Curso curso) {
        cursos.add(curso);
    }

    public void adicionarItem(ItemPersonalizacao item) {
        itens.add(item);
    }

    public List<Curso> getCursosDisponiveis(Cargo cargo) {
        return cursos.stream()
                .filter(curso -> cargo.ordinal() >= curso.getCargoMinimo().ordinal())
                .collect(Collectors.toList());
    }

    public List<ItemPersonalizacao> getItensDisponiveis(Cargo cargo) {
        return itens.stream()
                .filter(item -> filtrarPorCargo(item, cargo))
                .collect(Collectors.toList());
    }

    private boolean filtrarPorCargo(ItemPersonalizacao item, Cargo cargo) {
        switch (item.getTipo()) {
            case "Slogan":
                return cargo == Cargo.CEO;
            case "Tema XP":
            case "Badge":
            case "Pet":
            default:
                return true;
        }
    }
}
