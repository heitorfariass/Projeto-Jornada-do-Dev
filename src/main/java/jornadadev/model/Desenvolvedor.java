package jornadadev.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import jornadadev.personalizacao.Badge;
import jornadadev.personalizacao.Pet;
import jornadadev.personalizacao.Slogan;
import jornadadev.personalizacao.TemaXP;

/**
 * Representa o jogador, encapsulando todo o seu estado.
 */
public class Desenvolvedor {

    private final String nome;
    private Cargo cargoAtual;
    private double saldoCoffeeCoins;
    private int xpAtual;
    private final Set<String> cursosConcluidos;
    private final Map<String, Integer> contagemTrabalhos;
    private final Inventario inventario;

    private Pet petAtual;
    private Badge badgeAtual;
    private TemaXP temaAtual;
    private Slogan sloganAtual;

    private boolean modoTitanAtivo;
    private double multiplicadorXpPermanente;
    private double multiplicadorCcPermanente;

    public Desenvolvedor(String nome) {
        this.nome = nome;
        this.cargoAtual = Cargo.ESTAGIARIO_CAFE;
        this.saldoCoffeeCoins = 0;
        this.xpAtual = 0;
        this.cursosConcluidos = new HashSet<>();
        this.contagemTrabalhos = new HashMap<>();
        this.inventario = new Inventario();
        this.multiplicadorXpPermanente = 1.0;
        this.multiplicadorCcPermanente = 1.0;
    }

    public String getNome() {
        return nome;
    }

    public Cargo getCargoAtual() {
        return cargoAtual;
    }

    public void promover() {
        if (cargoAtual.possuiProximoCargo()) {
            cargoAtual = cargoAtual.getProximoCargo();
            xpAtual = 0;
        }
    }

    public double getSaldoCoffeeCoins() {
        return saldoCoffeeCoins;
    }

    public void adicionarCoffeeCoins(double quantidade) {
        saldoCoffeeCoins += quantidade;
        if (saldoCoffeeCoins < 0) {
            saldoCoffeeCoins = 0;
        }
    }

    public boolean gastarCoffeeCoins(double quantidade) {
        if (saldoCoffeeCoins >= quantidade) {
            saldoCoffeeCoins -= quantidade;
            return true;
        }
        return false;
    }

    public int getXpAtual() {
        return xpAtual;
    }

    public void adicionarXp(int quantidade) {
        int ganho = (int) Math.round(quantidade * multiplicadorXpPermanente);
        xpAtual += ganho;
        if (xpAtual < 0) {
            xpAtual = 0;
        }
    }

    public int getXpNecessarioProximaPromocao() {
        if (!cargoAtual.possuiProximoCargo()) {
            return 0;
        }
        return cargoAtual.getXpParaPromocao();
    }

    public double getPercentualXp() {
        if (!cargoAtual.possuiProximoCargo()) {
            return 1.0;
        }
        return Math.min(1.0, (double) xpAtual / cargoAtual.getXpParaPromocao());
    }

    public void concluirCurso(String nomeCurso) {
        cursosConcluidos.add(nomeCurso);
    }

    public boolean possuiCurso(String nomeCurso) {
        return cursosConcluidos.contains(nomeCurso);
    }

    public Set<String> getCursosConcluidos() {
        return new HashSet<>(cursosConcluidos);
    }

    public void registrarTrabalho(String nomeProjeto) {
        contagemTrabalhos.merge(nomeProjeto, 1, Integer::sum);
    }

    public int getQuantidadeTrabalhos(String nomeProjeto) {
        return contagemTrabalhos.getOrDefault(nomeProjeto, 0);
    }

    public Inventario getInventario() {
        return inventario;
    }

    public Pet getPetAtual() {
        return petAtual;
    }

    public void setPetAtual(Pet petAtual) {
        this.petAtual = petAtual;
    }

    public Badge getBadgeAtual() {
        return badgeAtual;
    }

    public void setBadgeAtual(Badge badgeAtual) {
        this.badgeAtual = badgeAtual;
    }

    public TemaXP getTemaAtual() {
        return temaAtual;
    }

    public void setTemaAtual(TemaXP temaAtual) {
        this.temaAtual = temaAtual;
    }

    public Slogan getSloganAtual() {
        return sloganAtual;
    }

    public void setSloganAtual(Slogan sloganAtual) {
        this.sloganAtual = sloganAtual;
    }

    public boolean isModoTitanAtivo() {
        return modoTitanAtivo;
    }

    public void ativarModoTitan() {
        if (!modoTitanAtivo) {
            modoTitanAtivo = true;
            multiplicadorXpPermanente += 0.20;
            multiplicadorCcPermanente += 0.10;
        }
    }

    public double aplicarMultiplicadorCc(double valorBase) {
        return valorBase * multiplicadorCcPermanente;
    }
}
