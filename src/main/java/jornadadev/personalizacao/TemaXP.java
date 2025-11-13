package jornadadev.personalizacao;

/**
 * Tema responsável por customizar a barra de XP.
 */
public class TemaXP extends ItemPersonalizacao {

    private final int tamanhoBarra;
    private final String preenchimento;
    private final String vazio;

    public TemaXP(String nome, double preco, Raridade raridade, String asciiArt, int tamanhoBarra, String preenchimento,
            String vazio) {
        super(nome, preco, raridade, asciiArt);
        this.tamanhoBarra = tamanhoBarra;
        this.preenchimento = preenchimento;
        this.vazio = vazio;
    }

    @Override
    public String getTipo() {
        return "Tema XP";
    }

    public String gerarBarra(double percentual) {
        int preenchidos = (int) Math.round(percentual * tamanhoBarra);
        if (preenchidos > tamanhoBarra) {
            preenchidos = tamanhoBarra;
        }
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < tamanhoBarra; i++) {
            if (i < preenchidos) {
                builder.append(preenchimento);
            } else {
                builder.append(vazio);
            }
        }
        builder.append("] ");
        int porcentagem = (int) Math.round(percentual * 100);
        if (porcentagem > 100) {
            porcentagem = 100;
        }
        builder.append(porcentagem).append("%");
        return builder.toString();
    }
}
