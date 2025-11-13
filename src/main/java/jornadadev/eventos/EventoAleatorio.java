package jornadadev.eventos;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Representa eventos aleatórios que impactam o trabalho do jogador por alguns turnos.
 */
public class EventoAleatorio {

    private final String nome;
    private final String descricao;
    private int turnosRestantes;
    private final double multiplicadorCc;
    private final double multiplicadorXp;
    private final boolean bloqueiaXp;
    private final double bonusCc;
    private final int bonusXp;

    public EventoAleatorio(String nome, String descricao, int turnosRestantes, double multiplicadorCc,
            double multiplicadorXp, boolean bloqueiaXp, double bonusCc, int bonusXp) {
        this.nome = nome;
        this.descricao = descricao;
        this.turnosRestantes = turnosRestantes;
        this.multiplicadorCc = multiplicadorCc;
        this.multiplicadorXp = multiplicadorXp;
        this.bloqueiaXp = bloqueiaXp;
        this.bonusCc = bonusCc;
        this.bonusXp = bonusXp;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getTurnosRestantes() {
        return turnosRestantes;
    }

    public void reduzirTurno() {
        turnosRestantes--;
    }

    public boolean estaAtivo() {
        return turnosRestantes > 0;
    }

    public double aplicarNoDinheiro(double valorBase) {
        double resultado = valorBase * multiplicadorCc + bonusCc;
        if (resultado < 0) {
            resultado = 0;
        }
        return resultado;
    }

    public int aplicarNoXp(int xpBase) {
        if (bloqueiaXp) {
            return 0;
        }
        int resultado = (int) Math.round(xpBase * multiplicadorXp + bonusXp);
        if (resultado < 0) {
            resultado = 0;
        }
        return resultado;
    }

    public static EventoAleatorio gerarAleatorio(Random random) {
        if (random.nextInt(100) >= 35) {
            return null;
        }

        List<EventoAleatorio> possibilidades = Arrays.asList(
                new EventoAleatorio("Investidor Pessimista", "O investidor odiou seu NFT. Ganhos reduzidos.", 3, 0.7, 1.0,
                        false, -3, 0),
                new EventoAleatorio("Falta de Café", "O café acabou! XP travado temporariamente.", 2, 1.0, 0.0, true,
                        0, 0),
                new EventoAleatorio("Influencer Empolgado", "Influencer shillou a empresa. +10% CC$ na próxima tarefa!", 1,
                        1.1, 1.0, false, 0, 0),
                new EventoAleatorio("Bug Misterioso", "Bug misterioso consome tempo. XP reduzido por alguns turnos.", 2,
                        1.0, 0.6, false, 0, 0),
                new EventoAleatorio("Airdrop Surpresa", "Solana caiu do céu! Bônus de moedas.", 2, 1.0, 1.0, false, 15, 0),
                new EventoAleatorio("Mentoria Relâmpago", "Um mentor turbo te ajudou. XP extra.", 1, 1.0, 1.3, false, 0, 5));

        return possibilidades.get(random.nextInt(possibilidades.size()));
    }
}
