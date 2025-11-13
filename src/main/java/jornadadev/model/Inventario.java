package jornadadev.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jornadadev.personalizacao.Badge;
import jornadadev.personalizacao.Pet;
import jornadadev.personalizacao.Slogan;
import jornadadev.personalizacao.TemaXP;

/**
 * Inventário do jogador contendo os itens cosméticos adquiridos.
 */
public class Inventario {

    private final List<Pet> pets;
    private final List<Badge> badges;
    private final List<TemaXP> temas;
    private final List<Slogan> slogans;

    public Inventario() {
        this.pets = new ArrayList<>();
        this.badges = new ArrayList<>();
        this.temas = new ArrayList<>();
        this.slogans = new ArrayList<>();
    }

    public void adicionarPet(Pet pet) {
        pets.add(pet);
    }

    public boolean possuiPet(String nome) {
        return pets.stream().anyMatch(p -> p.getNome().equalsIgnoreCase(nome));
    }

    public void adicionarBadge(Badge badge) {
        badges.add(badge);
    }

    public boolean possuiBadge(String nome) {
        return badges.stream().anyMatch(b -> b.getNome().equalsIgnoreCase(nome));
    }

    public void adicionarTema(TemaXP tema) {
        temas.add(tema);
    }

    public boolean possuiTema(String nome) {
        return temas.stream().anyMatch(t -> t.getNome().equalsIgnoreCase(nome));
    }

    public void adicionarSlogan(Slogan slogan) {
        slogans.add(slogan);
    }

    public boolean possuiSlogan(String nome) {
        return slogans.stream().anyMatch(s -> s.getNome().equalsIgnoreCase(nome));
    }

    public List<Pet> getPets() {
        return Collections.unmodifiableList(pets);
    }

    public List<Badge> getBadges() {
        return Collections.unmodifiableList(badges);
    }

    public List<TemaXP> getTemas() {
        return Collections.unmodifiableList(temas);
    }

    public List<Slogan> getSlogans() {
        return Collections.unmodifiableList(slogans);
    }
}
