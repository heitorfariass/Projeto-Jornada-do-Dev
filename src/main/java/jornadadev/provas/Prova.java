package jornadadev.provas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Prova aplicada quando o jogador tenta ser promovido.
 */
public class Prova {

    private final List<Pergunta> perguntas;
    private final int acertosNecessarios;

    public Prova(int acertosNecessarios) {
        this.perguntas = new ArrayList<>();
        this.acertosNecessarios = acertosNecessarios;
    }

    public void adicionarPergunta(Pergunta pergunta) {
        perguntas.add(pergunta);
    }

    public boolean aplicar(Scanner scanner) {
        int acertos = 0;
        int numeroQuestao = 1;
        for (Pergunta pergunta : perguntas) {
            System.out.println("────────────────────────────────────────────");
            System.out.println("Questão " + numeroQuestao++ + ": " + pergunta.getEnunciado());
            String[] alternativas = pergunta.getAlternativas();
            for (int i = 0; i < alternativas.length; i++) {
                System.out.println("(" + (i + 1) + ") " + alternativas[i]);
            }
            int resposta = lerResposta(scanner, alternativas.length);
            if (resposta - 1 == pergunta.getIndiceCorreto()) {
                System.out.println("✅ Resposta correta!");
                acertos++;
            } else {
                System.out.println("❌ Resposta incorreta!");
            }
        }
        System.out.println("Você acertou " + acertos + " de " + perguntas.size() + " questões.");
        return acertos >= acertosNecessarios;
    }

    private int lerResposta(Scanner scanner, int limite) {
        while (true) {
            System.out.print("Escolha a alternativa: ");
            try {
                int resposta = Integer.parseInt(scanner.nextLine());
                if (resposta >= 1 && resposta <= limite) {
                    return resposta;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida, tente novamente.");
            }
            System.out.println("Digite um número entre 1 e " + limite + ".");
        }
    }
}
