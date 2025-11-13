package jornadadev.projetos;

/**
 * Projeto especial disponível apenas após curso avançado.
 */
public class HackathonSolanaProjeto extends Projeto {

    public HackathonSolanaProjeto() {
        super("Hackathon Solana Secreto", 140, 55);
    }

    @Override
    protected String mensagemConclusao() {
        return "Você venceu o hackathon e ganhou stickers que valem mais que bitcoin.";
    }
}
