package jornadadev.projetos;

import java.util.Random;

import jornadadev.eventos.EventoAleatorio;
import jornadadev.model.Desenvolvedor;

/**
 * Projeto base executado pelo desenvolvedor.
 */
public abstract class Projeto {

    private static final String[] FRASES_HUMOR = {
            "O investidor odiou seu NFT. Ganhos reduzidos? Só se você deixar!",
            "O café acabou! XP travado? Melhor buscar um estoque no estoque secreto.",
            "Influencer shillou a empresa. A hype está real!",
            "Você digitou git push na master ao vivo. Quem nunca?",
            "Seu teclado mecânico acordou o escritório inteiro.",
            "Chegou uma requisição 500 do nada. Você respondeu com 418." };

    private final String nome;
    private final double recompensaBase;
    private final int xpBase;

    protected Projeto(String nome, double recompensaBase, int xpBase) {
        this.nome = nome;
        this.recompensaBase = recompensaBase;
        this.xpBase = xpBase;
    }

    public String getNome() {
        return nome;
    }

    public double getRecompensaBase() {
        return recompensaBase;
    }

    public int getXpBase() {
        return xpBase;
    }

    /**
     * Calcula o XP realmente concedido por um trabalho comum. Trabalhar deve
     * render apenas uma fração simbólica do valor original para incentivar a
     * busca por cursos como principal fonte de experiência.
     */
    public int getXpTrabalho() {
        if (xpBase <= 0) {
            return 0;
        }
        int reduzido = xpBase / 10;
        if (reduzido <= 0) {
            reduzido = 1;
        }
        return reduzido;
    }

    protected String fraseHumor(Random random) {
        return FRASES_HUMOR[random.nextInt(FRASES_HUMOR.length)];
    }

    public void concluir(Desenvolvedor desenvolvedor, EventoAleatorio evento, Random random) {
        double recompensaFinal = recompensaBase;
        int xpFinal = getXpTrabalho();

        if (evento != null && evento.estaAtivo()) {
            recompensaFinal = evento.aplicarNoDinheiro(recompensaFinal);
            xpFinal = evento.aplicarNoXp(xpFinal);
            evento.reduzirTurno();
            if (!evento.estaAtivo()) {
                System.out.println("O evento " + evento.getNome() + " perdeu força.");
            }
        }

        recompensaFinal = desenvolvedor.aplicarMultiplicadorCc(recompensaFinal);

        desenvolvedor.adicionarCoffeeCoins(recompensaFinal);
        desenvolvedor.adicionarXp(xpFinal);
        desenvolvedor.registrarTrabalho(nome);

        System.out.println("Você concluiu: " + nome);
        System.out.printf("Recompensa: %.0f CC$ | XP ganho: %d\n", recompensaFinal, xpFinal);
        System.out.println(mensagemConclusao());
        System.out.println(fraseHumor(random));
    }

    protected abstract String mensagemConclusao();
}
