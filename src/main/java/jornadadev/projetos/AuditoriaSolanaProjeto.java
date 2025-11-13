package jornadadev.projetos;

/**
 * Projeto de auditoria em Solana.
 */
public class AuditoriaSolanaProjeto extends Projeto {

    public AuditoriaSolanaProjeto() {
        super("Auditoria Solana", 210, 85);
    }

    @Override
    protected String mensagemConclusao() {
        return "Nenhum exploit passou despercebido pelo seu olhar laser.";
    }
}
