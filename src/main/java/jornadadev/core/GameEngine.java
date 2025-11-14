package jornadadev.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import jornadadev.eventos.EventoAleatorio;
import jornadadev.loja.Curso;
import jornadadev.loja.Loja;
import jornadadev.model.Cargo;
import jornadadev.model.Desenvolvedor;
import jornadadev.personalizacao.Badge;
import jornadadev.personalizacao.ItemPersonalizacao;
import jornadadev.personalizacao.Pet;
import jornadadev.personalizacao.Raridade;
import jornadadev.personalizacao.Slogan;
import jornadadev.personalizacao.TemaXP;
import jornadadev.projetos.AnunciarRoadmapFakeProjeto;
import jornadadev.projetos.ArquiteturaDistribuidaProjeto;
import jornadadev.projetos.AutomatizarRelatorioProjeto;
import jornadadev.projetos.BuscarCanetasProjeto;
import jornadadev.projetos.CodarEndpointProjeto;
import jornadadev.projetos.CorteCustosProjeto;
import jornadadev.projetos.CriarAPIProjeto;
import jornadadev.projetos.CriarCICDProjeto;
import jornadadev.projetos.DebugarTelaProjeto;
import jornadadev.projetos.DocumentacaoInternaProjeto;
import jornadadev.projetos.HackathonSolanaProjeto;
import jornadadev.projetos.IntegrarSmartContractProjeto;
import jornadadev.projetos.OrganizarGithubProjeto;
import jornadadev.projetos.OrientarEquipeProjeto;
import jornadadev.projetos.PegarCafeProjeto;
import jornadadev.projetos.PitchInvestidoresProjeto;
import jornadadev.projetos.Projeto;
import jornadadev.projetos.RefatorarModuloCriticoProjeto;
import jornadadev.projetos.ReuniaoInutilProjeto;
import jornadadev.projetos.ResolverBugSimplesProjeto;
import jornadadev.projetos.AuditoriaSolanaProjeto;
import jornadadev.provas.Pergunta;

/**
 * Motor principal do jogo.
 */
public class GameEngine {

    private static final String CURSO_BASICO = "Curso Básico DEV";
    private static final String CURSO_GIT = "Workshop Git Ninja";
    private static final String CURSO_FRONT = "Curso Front Turbinado";
    private static final String CURSO_DEVOPS = "Especialização DevOps Solana";
    private static final String CURSO_LIDERANCA = "Mentoria Liderança Tech";
    private static final String CURSO_VISIONARIO = "Masterclass Visionário Web3";

    private final Scanner scanner;
    private final Random random;
    private Desenvolvedor desenvolvedor;
    private Loja loja;
    private EventoAleatorio eventoAtivo;
    private TemaXP temaPadrao;
    private Pet petPadrao;
    private Badge badgePadrao;
    private Pet recompensaTitanPet;
    private Badge recompensaTitanBadge;
    private TemaXP recompensaTitanTema;
    private final Map<String, String> requisitoCursoParaItem;

    public GameEngine() {
        this.scanner = new Scanner(System.in);
        this.random = new Random();
        this.requisitoCursoParaItem = new HashMap<>();
    }

    /**
     * Inicia o loop principal do jogo.
     */
    public void iniciar() {
        System.out.println("--------------------------------------------");
        System.out.println("         STARTUP SOLANA - JORNADA DO DEV");
        System.out.println("--------------------------------------------");
        System.out.print("Digite o nome do(a) dev: ");
        String nome = scanner.nextLine().trim();
        if (nome.isEmpty()) {
            nome = "Dev Anônimo";
        }
        desenvolvedor = new Desenvolvedor(nome);
        configurarLoja();
        configurarInventarioInicial();
        System.out.println("Bem-vindo(a), " + nome + "! Pegue seu crachá digital e prepare o café.");
        loopPrincipal();
    }

    private void configurarInventarioInicial() {
        temaPadrao = new TemaXP("Tema Padrão", 0, Raridade.COMUM, "", 10, "=", "-");
        badgePadrao = new Badge("Badge Café Lover", 0, Raridade.COMUM, "[Cafe]", "Café Lover");
        petPadrao = new Pet("Gato Byte", 0, Raridade.COMUM, " /\\_/\\\n( o.o )\n > ^ <");
        desenvolvedor.getInventario().adicionarTema(temaPadrao);
        desenvolvedor.getInventario().adicionarBadge(badgePadrao);
        desenvolvedor.getInventario().adicionarPet(petPadrao);
        desenvolvedor.setTemaAtual(temaPadrao);
        desenvolvedor.setBadgeAtual(badgePadrao);
        desenvolvedor.setPetAtual(petPadrao);
        configurarRecompensasTitan();
    }

    private void configurarRecompensasTitan() {
        recompensaTitanPet = new Pet("Titã Vigia", 0, Raridade.MITICO, " /\\_/\\\\\n( o_O )\n/| TT |\\");
        recompensaTitanBadge = new Badge("Badge Olhar de Titã", 0, Raridade.MITICO, "[TITAN]", "Olhar de Titã");
        recompensaTitanTema = new TemaXP("Tema Núcleo Titã", 0, Raridade.MITICO, "", 20, "#", "-");
    }

    private void configurarLoja() {
        loja = new Loja();
        loja.adicionarCurso(new Curso(CURSO_BASICO, 110, 25, Cargo.ESTAGIARIO_CAFE,
                "Aprenda a diferença entre ; e : sem chorar."));
        loja.adicionarCurso(new Curso(CURSO_GIT, 220, 30, Cargo.ESTAGIARIO_DEV,
                "Aprenda a não quebrar o repositório da empresa."));
        loja.adicionarCurso(new Curso(CURSO_FRONT, 350, 45, Cargo.JUNIOR,
                "Deixe telas tão polidas que refletem bugs."));
        loja.adicionarCurso(new Curso(CURSO_DEVOPS, 600, 60, Cargo.PLENO,
                "Integração total com pipelines e Solana."));
        loja.adicionarCurso(new Curso(CURSO_LIDERANCA, 900, 80, Cargo.SENIOR,
                "Comande squads com voz de radialista."));
        loja.adicionarCurso(new Curso(CURSO_VISIONARIO, 1500, 100, Cargo.CEO,
                "Fale Web3 enquanto gesticula com NFTs."));

        // Pets
        adicionarItemLoja(new Pet("Lhama Café", 120, Raridade.COMUM, " (^^ )\n/|:::|\\\n  UU"), null);
        adicionarItemLoja(new Pet("Solana Fox", 280, Raridade.INCOMUM, " /\\  /\\\n( -o_o)\n \\_/\\/"), CURSO_GIT);
        adicionarItemLoja(new Pet("Neon Kraken", 780, Raridade.RARO, " (]~~)\n/|  |\\\n^^  ^^"), CURSO_DEVOPS);
        adicionarItemLoja(new Pet("Titã Mascote", 1800, Raridade.LENDARIO, "  /\\__/\\\n ( o_o )\n  /    \\"), CURSO_LIDERANCA);

        // Badges
        adicionarItemLoja(new Badge("Badge Bug Slayer", 240, Raridade.INCOMUM, "<BUG>", "Bug Slayer"), CURSO_GIT);
        adicionarItemLoja(new Badge("Badge Chain Master", 620, Raridade.RARO, "{SOL}", "Chain Master"), CURSO_DEVOPS);
        adicionarItemLoja(new Badge("Badge Titan Founder", 1500, Raridade.LENDARIO, "[Fogo]", "Titan Founder"),
                CURSO_LIDERANCA);

        // Temas XP
        adicionarItemLoja(new TemaXP("Tema Caféinômico", 150, Raridade.COMUM, "", 12, "C", "."), CURSO_BASICO);
        adicionarItemLoja(new TemaXP("Tema Pixelado", 320, Raridade.INCOMUM, "", 14, "#", "."), CURSO_FRONT);
        adicionarItemLoja(new TemaXP("Tema Solana Wave", 800, Raridade.RARO, "", 16, "~", "."), CURSO_DEVOPS);
        adicionarItemLoja(new TemaXP("Tema Mítico Titãs", 3800, Raridade.MITICO, "", 18, "*", "."),
                CURSO_LIDERANCA);

        // Slogans
        adicionarItemLoja(new Slogan("Slogan Solana Turbo", 3600, Raridade.LENDARIO, "#SOLANA",
                "Solana voa, café não acaba."), CURSO_VISIONARIO);
        adicionarItemLoja(new Slogan("Slogan Titans United", 4200, Raridade.MITICO, "#TITAN",
                "Construindo muralhas de inovação."), CURSO_VISIONARIO);
    }

    private void adicionarItemLoja(ItemPersonalizacao item, String cursoNecessario) {
        loja.adicionarItem(item);
        if (cursoNecessario != null) {
            requisitoCursoParaItem.put(item.getNome(), cursoNecessario);
        }
    }

    private void loopPrincipal() {
        boolean rodando = true;
        while (rodando) {
            exibirMenuPrincipal();
            String opcao = scanner.nextLine().trim();
            if (verificarComandoSecreto(opcao)) {
                continue;
            }
            switch (opcao) {
                case "1":
                    menuTrabalhar();
                    break;
                case "2":
                    menuLoja();
                    break;
                case "3":
                    menuPromocao();
                    break;
                case "4":
                    menuInventario();
                    break;
                case "5":
                    menuSecreto();
                    break;
                case "6":
                    rodando = false;
                    System.out.println("Até logo! Sua carteira de CC$ ficará esperando.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private void exibirMenuPrincipal() {
        System.out.println("\n--------------------------------------------");
        System.out.println("         STARTUP SOLANA - JORNADA DO DEV");
        System.out.println("--------------------------------------------");
        Pet pet = desenvolvedor.getPetAtual();
        if (pet != null) {
            System.out.println(pet.getAsciiArt());
        } else {
            System.out.println("(sem pet)");
        }
        String badgeTexto = desenvolvedor.getBadgeAtual() != null ? desenvolvedor.getBadgeAtual().getTextoBadge()
                : "Sem badge";
        String nomePet = pet != null ? pet.getNome() : "Nenhum";
        System.out.print("Dev: " + desenvolvedor.getNome());
        if (desenvolvedor.getBadgeAtual() != null) {
            System.out.print("  " + desenvolvedor.getBadgeAtual().getAsciiArt());
        }
        System.out.println();
        System.out.println("Badge: " + badgeTexto + "   Pet: " + nomePet);
        System.out.println("Cargo: " + desenvolvedor.getCargoAtual().getNomeExibicao());
        if (desenvolvedor.getSloganAtual() != null) {
            System.out.println("Slogan: " + desenvolvedor.getSloganAtual().getFrase());
        }
        System.out.printf("Moedas (CC$): %.0f CC$%n", desenvolvedor.getSaldoCoffeeCoins());
        System.out.println("XP Atual: " + gerarBarraXp());
        if (eventoAtivo != null && eventoAtivo.estaAtivo()) {
            System.out.println("Evento ativo: " + eventoAtivo.getNome() + " - " + eventoAtivo.getDescricao()
                    + " (restam " + eventoAtivo.getTurnosRestantes() + " turnos)");
        }
        if (desenvolvedor.isModoTitanAtivo()) {
            System.out.println("Modo Titã pulsando em suas veias.");
        }
        System.out.println("--------------------------------------------");
        System.out.println("[1] Trabalhar");
        System.out.println("[2] Loja");
        System.out.println("[3] Subir de Cargo");
        System.out.println("[4] Inventário");
        if (desenvolvedor.getCargoAtual() == Cargo.CEO) {
            System.out.println("[5] ???");
        } else {
            System.out.println("[5] ??? (bloqueado até CEO)");
        }
        System.out.println("[6] Sair");
        System.out.print("Digite uma opção: ");
    }

    private String gerarBarraXp() {
        double percentual = desenvolvedor.getPercentualXp();
        if (desenvolvedor.isModoTitanAtivo()) {
            int tamanho = 10;
            int preenchidos = (int) Math.round(percentual * tamanho);
            if (preenchidos > tamanho) {
                preenchidos = tamanho;
            }
            StringBuilder builder = new StringBuilder();
            builder.append("XP: [");
            for (int i = 0; i < tamanho; i++) {
                builder.append(i < preenchidos ? "*" : ".");
            }
            builder.append("] ");
            builder.append((int) Math.round(percentual * 100)).append("%");
            return builder.toString();
        }
        TemaXP tema = desenvolvedor.getTemaAtual() != null ? desenvolvedor.getTemaAtual() : temaPadrao;
        return "XP: " + tema.gerarBarra(percentual);
    }

    private void menuTrabalhar() {
        List<Projeto> projetos = obterProjetosDisponiveis();
        if (projetos.isEmpty()) {
            System.out.println("Nenhum projeto disponível. Talvez faça um curso primeiro.");
            return;
        }
        System.out.println("Selecione um trabalho:");
        for (int i = 0; i < projetos.size(); i++) {
            Projeto projeto = projetos.get(i);
            System.out.printf("(%d) %s - CC$: %.0f | XP: %d%n", i + 1, projeto.getNome(),
                    projeto.getRecompensaBase(), projeto.getXpTrabalho());
        }
        System.out.println("(0) Voltar");
        int escolha = lerOpcaoNumerica(0, projetos.size());
        if (escolha == 0) {
            return;
        }
        Projeto selecionado = projetos.get(escolha - 1);
        System.out.println("Você respirou fundo antes de iniciar: " + selecionado.getNome());
        selecionado.concluir(desenvolvedor, eventoAtivo, random);
        if (eventoAtivo != null && !eventoAtivo.estaAtivo()) {
            eventoAtivo = null;
        }
        if (eventoAtivo == null) {
            eventoAtivo = EventoAleatorio.gerarAleatorio(random);
            if (eventoAtivo != null) {
                System.out.println("Novo evento: " + eventoAtivo.getNome() + " - " + eventoAtivo.getDescricao());
            }
        }
    }

    private List<Projeto> obterProjetosDisponiveis() {
        List<Projeto> projetos = new ArrayList<>();
        Cargo cargo = desenvolvedor.getCargoAtual();
        switch (cargo) {
            case ESTAGIARIO_CAFE:
                projetos.add(new PegarCafeProjeto());
                projetos.add(new BuscarCanetasProjeto());
                break;
            case ESTAGIARIO_DEV:
                projetos.add(new ResolverBugSimplesProjeto());
                projetos.add(new DocumentacaoInternaProjeto());
                projetos.add(new OrganizarGithubProjeto());
                break;
            case JUNIOR:
                projetos.add(new CodarEndpointProjeto());
                projetos.add(new DebugarTelaProjeto());
                projetos.add(new AutomatizarRelatorioProjeto());
                break;
            case PLENO:
                projetos.add(new CriarAPIProjeto());
                projetos.add(new IntegrarSmartContractProjeto());
                projetos.add(new CriarCICDProjeto());
                if (desenvolvedor.possuiCurso(CURSO_DEVOPS)) {
                    projetos.add(new HackathonSolanaProjeto());
                }
                break;
            case SENIOR:
                projetos.add(new RefatorarModuloCriticoProjeto());
                projetos.add(new ArquiteturaDistribuidaProjeto());
                projetos.add(new AuditoriaSolanaProjeto());
                projetos.add(new OrientarEquipeProjeto());
                break;
            case CEO:
                projetos.add(new PitchInvestidoresProjeto());
                projetos.add(new ReuniaoInutilProjeto());
                projetos.add(new AnunciarRoadmapFakeProjeto());
                projetos.add(new CorteCustosProjeto());
                break;
            default:
                break;
        }
        return projetos;
    }

    private void menuLoja() {
        boolean naLoja = true;
        while (naLoja) {
            System.out.println("\nLoja da Startup");
            System.out.println("(1) Aba de Cursos");
            System.out.println("(2) Aba de Personalização");
            System.out.println("(0) Voltar");
            String entrada = scanner.nextLine().trim();
            if (verificarComandoSecreto(entrada)) {
                continue;
            }
            switch (entrada) {
                case "1":
                    abaCursos();
                    break;
                case "2":
                    abaPersonalizacao();
                    break;
                case "0":
                    naLoja = false;
                    break;
                default:
                    System.out.println("Escolha inválida.");
                    break;
            }
        }
    }

    private void abaCursos() {
        List<Curso> cursos = loja.getCursosDisponiveis(desenvolvedor.getCargoAtual());
        if (cursos.isEmpty()) {
            System.out.println("Nenhum curso disponível agora.");
            return;
        }
        System.out.println("Cursos disponíveis:");
        for (int i = 0; i < cursos.size(); i++) {
            Curso curso = cursos.get(i);
            String status = desenvolvedor.possuiCurso(curso.getNome()) ? "(concluído)" : "";
            System.out.printf("(%d) %s - Preço: %.0f CC$ | XP: %d %s%n", i + 1, curso.getNome(), curso.getPreco(),
                    curso.getXpConcedido(), status);
            System.out.println("     -> " + curso.getDescricao());
        }
        System.out.println("(0) Voltar");
        int escolha = lerOpcaoNumerica(0, cursos.size());
        if (escolha == 0) {
            return;
        }
        Curso selecionado = cursos.get(escolha - 1);
        if (desenvolvedor.possuiCurso(selecionado.getNome())) {
            System.out.println("Você já concluiu esse curso.");
            return;
        }
        if (!desenvolvedor.gastarCoffeeCoins(selecionado.getPreco())) {
            System.out.println("CC$ insuficientes.");
            return;
        }
        desenvolvedor.concluirCurso(selecionado.getNome());
        desenvolvedor.adicionarXp(selecionado.getXpConcedido());
        System.out.println("Curso concluído! Você sente a mente expandindo como memória RAM nova.");
    }

    private void abaPersonalizacao() {
        List<ItemPersonalizacao> itens = loja.getItensDisponiveis(desenvolvedor.getCargoAtual());
        List<ItemPersonalizacao> filtrados = new ArrayList<>();
        for (ItemPersonalizacao item : itens) {
            String requisito = requisitoCursoParaItem.get(item.getNome());
            if (requisito != null && !desenvolvedor.possuiCurso(requisito)) {
                continue;
            }
            filtrados.add(item);
        }
        if (filtrados.isEmpty()) {
            System.out.println("Nenhum item disponível agora. Faça mais cursos!");
            return;
        }
        System.out.println("Itens disponíveis:");
        for (int i = 0; i < filtrados.size(); i++) {
            ItemPersonalizacao item = filtrados.get(i);
            System.out.printf("(%d) [%s] %s - Preço: %.0f CC$%n", i + 1, item.getTipo(), item.getNome(),
                    item.getPreco());
        }
        System.out.println("(0) Voltar");
        int escolha = lerOpcaoNumerica(0, filtrados.size());
        if (escolha == 0) {
            return;
        }
        ItemPersonalizacao item = filtrados.get(escolha - 1);
        boolean jaPossui = false;
        switch (item.getTipo()) {
            case "Pet":
                jaPossui = desenvolvedor.getInventario().possuiPet(item.getNome());
                break;
            case "Badge":
                jaPossui = desenvolvedor.getInventario().possuiBadge(item.getNome());
                break;
            case "Tema XP":
                jaPossui = desenvolvedor.getInventario().possuiTema(item.getNome());
                break;
            case "Slogan":
                jaPossui = desenvolvedor.getInventario().possuiSlogan(item.getNome());
                break;
            default:
                break;
        }
        if (jaPossui) {
            System.out.println("Você já possui esse item.");
            return;
        }
        if (!desenvolvedor.gastarCoffeeCoins(item.getPreco())) {
            System.out.println("CC$ insuficientes.");
            return;
        }
        switch (item.getTipo()) {
            case "Pet":
                desenvolvedor.getInventario().adicionarPet((Pet) item);
                desenvolvedor.setPetAtual((Pet) item);
                break;
            case "Badge":
                desenvolvedor.getInventario().adicionarBadge((Badge) item);
                desenvolvedor.setBadgeAtual((Badge) item);
                break;
            case "Tema XP":
                desenvolvedor.getInventario().adicionarTema((TemaXP) item);
                desenvolvedor.setTemaAtual((TemaXP) item);
                break;
            case "Slogan":
                desenvolvedor.getInventario().adicionarSlogan((Slogan) item);
                desenvolvedor.setSloganAtual((Slogan) item);
                break;
            default:
                break;
        }
        System.out.println("Item adquirido! Seu avatar brilhou por alguns segundos.");
    }

    private void menuPromocao() {
        Cargo cargo = desenvolvedor.getCargoAtual();
        if (!cargo.possuiProximoCargo()) {
            System.out.println("Você já é CEO. Não há mais cargos, só reuniões.");
            return;
        }
        int xpNecessario = cargo.getXpParaPromocao();
        if (desenvolvedor.getXpAtual() < xpNecessario) {
            System.out.println("Você precisa de mais XP para tentar a promoção. Necessário: " + xpNecessario);
            return;
        }
        boolean aprovado = aplicarProva(cargo);
        if (aprovado) {
            desenvolvedor.promover();
            System.out.println("Parabéns! Novo cargo: " + desenvolvedor.getCargoAtual().getNomeExibicao());
            if (desenvolvedor.getCargoAtual() == Cargo.CEO) {
                System.out.println("Desbloqueou o menu misterioso.");
            }
        } else {
            System.out.println("Reprovado por pouco! Reveja aqueles slides duvidosos.");
        }
    }

    private boolean aplicarProva(Cargo cargoAtual) {
        jornadadev.provas.Prova prova;
        if (cargoAtual == Cargo.SENIOR) {
            prova = new jornadadev.provas.Prova(15);
        } else {
            prova = new jornadadev.provas.Prova(5);
        }
        adicionarPerguntasPorCargo(prova, cargoAtual);
        System.out.println("Hora da prova! Respire e lembre do Ctrl+S.");
        return prova.aplicar(scanner);
    }

    private void adicionarPerguntasPorCargo(jornadadev.provas.Prova prova, Cargo cargoAtual) {
        switch (cargoAtual) {
            case ESTAGIARIO_CAFE:
                adicionarPergunta(prova, "Qual comando git lista o estado atual do repositório?", "git status",
                        "git checkin", "git files", 0);
                adicionarPergunta(prova, "Qual palavra-chave em Java define uma classe?", "define", "class", "module", 1);
                adicionarPergunta(prova, "Qual estrutura repete enquanto a condição é verdadeira?", "if", "switch",
                        "while", 2);
                adicionarPergunta(prova, "Qual tipo primitivo armazena números inteiros?", "String", "int", "boolean", 1);
                adicionarPergunta(prova, "Qual método imprime texto no console?", "System.out.println", "console.log",
                        "print()", 0);
                adicionarPergunta(prova, "Ao clonar um repositório remoto usa-se qual comando?", "git copy", "git clone",
                        "git pull", 1);
                break;
            case ESTAGIARIO_DEV:
                adicionarPergunta(prova, "Qual comando combina commits de uma branch na atual?", "git clone", "git status",
                        "git merge", 2);
                adicionarPergunta(prova, "Qual arquivo descreve dependências em um projeto Maven?", "build.gradle",
                        "pom.xml", "package-lock.json", 1);
                adicionarPergunta(prova, "Qual tipo representa texto imutável em Java?", "String", "StringBuilder",
                        "char", 0);
                adicionarPergunta(prova, "Qual anotação indica sobrescrita de método?", "@Inject", "@Bean",
                        "@Override", 2);
                adicionarPergunta(prova, "Qual estrutura mantém ordem de inserção e pares chave-valor?", "HashSet",
                        "TreeMap", "LinkedHashMap", 2);
                adicionarPergunta(prova, "Qual comando atualiza o repositório local com mudanças remotas?", "git pull",
                        "git revert", "git stash", 0);
                break;
            case JUNIOR:
                adicionarPergunta(prova, "Qual status HTTP indica que um recurso foi criado?", "200", "201", "404", 1);
                adicionarPergunta(prova, "No Spring Boot, qual anotação expõe um endpoint REST?", "@RestController",
                        "@Entity", "@Repository", 0);
                adicionarPergunta(prova, "Qual estrutura mantém chave-valor em ordem natural?", "HashMap", "TreeMap",
                        "LinkedList", 1);
                adicionarPergunta(prova, "Qual anotação injeta dependência pelo construtor?", "@Value", "@Component",
                        "@Autowired", 2);
                adicionarPergunta(prova, "Qual padrão isola o acesso a dados do domínio?", "Observer", "Composite",
                        "Repository", 2);
                adicionarPergunta(prova, "Qual classe de concorrência representa uma fila bloqueante?", "ArrayList",
                        "LinkedBlockingQueue", "StringBuffer", 1);
                break;
            case PLENO:
                adicionarPergunta(prova, "Qual serviço gerencia pipelines dentro do GitHub?", "GitHub Actions",
                        "Git SVN", "Git Flow", 0);
                adicionarPergunta(prova, "No Docker, qual comando inicia um container a partir de uma imagem?",
                        "docker build", "docker stop", "docker run", 2);
                adicionarPergunta(prova, "Qual métrica acompanha a latência percebida pelos usuários?", "CPU idle",
                        "P95 de resposta", "Tamanho do log", 1);
                adicionarPergunta(prova, "Qual padrão arquitetural facilita eventos assíncronos?", "Event sourcing",
                        "Singleton", "Adapter", 0);
                adicionarPergunta(prova, "Qual ferramenta IaC utiliza arquivos com extensão .tf?", "Ansible", "Puppet",
                        "Terraform", 2);
                adicionarPergunta(prova, "Qual comando reescreve commits locais antes de enviar?", "git revert",
                        "git rebase -i", "git status", 1);
                break;
            case SENIOR:
                adicionarPergunta(prova, "Em arquitetura hexagonal, o que são as portas?", "Classes de teste",
                        "Interfaces que expõem casos de uso", "Scripts de build", 1);
                adicionarPergunta(prova, "Qual engine de mensagens usa AMQP 0-9-1 por padrão?", "RabbitMQ", "Kafka",
                        "Redis Streams", 0);
                adicionarPergunta(prova, "Qual técnica baseia o consenso Raft?", "Proof of Work", "Protocolo Gossip",
                        "Eleição de líder com log replicado", 2);
                adicionarPergunta(prova, "Qual métrica SRE mede o tempo até recuperação?", "MTTR", "MTTF", "MTBF", 0);
                adicionarPergunta(prova, "No Kubernetes, qual objeto mantém o estado desejado de pods?", "Service",
                        "Deployment", "ConfigMap", 1);
                adicionarPergunta(prova, "Qual estratégia de rollout reduz tráfego antigo gradualmente?", "Blue-green",
                        "Recreate", "Canary", 2);
                adicionarPergunta(prova, "Em DDD, qual elemento coordena lógica entre agregados?", "Entity",
                        "Domain Service", "Value Object", 1);
                adicionarPergunta(prova, "Qual formato binário é usado pelo gRPC por padrão?", "Protocol Buffers",
                        "YAML", "Thrift", 0);
                adicionarPergunta(prova, "Qual comando git mantém alterações no stage ao desfazer um commit?",
                        "git revert HEAD", "git reset --hard HEAD~1", "git reset --soft HEAD~1", 2);
                adicionarPergunta(prova, "Qual técnica distribui carga global usando roteamento de borda?", "Sticky session",
                        "Anycast DNS", "Web socket", 1);
                adicionarPergunta(prova, "Qual ferramenta consulta métricas com PromQL?", "Prometheus",
                        "Grafana Loki", "Zipkin", 0);
                adicionarPergunta(prova, "Qual nível de consistência garante que leituras respeitam ordem causal?",
                        "Consistência eventual", "Consistência forte", "Consistência causal", 2);
                adicionarPergunta(prova, "Qual mecanismo do PostgreSQL habilita replicação lógica?", "Logical Decoding",
                        "Hot standby", "Autovacuum", 0);
                adicionarPergunta(prova, "Qual abordagem verifica compatibilidade entre serviços?", "Testes unitários",
                        "Testes de contrato", "Testes de fumaça", 1);
                adicionarPergunta(prova, "Qual política segue o princípio nunca confiar, sempre verificar?",
                        "OAuth2 Client Credentials", "Basic Auth", "Zero Trust", 2);
                adicionarPergunta(prova, "Qual biblioteca Java provê fluxos reativos assíncronos?", "Project Reactor",
                        "JUnit", "JDBC", 0);
                adicionarPergunta(prova, "Qual algoritmo de cache remove o item menos utilizado recentemente?", "FIFO",
                        "LRU", "Round Robin", 1);
                adicionarPergunta(prova, "Qual comando kubectl aplica alterações mantendo histórico?", "kubectl delete -f",
                        "kubectl get -f", "kubectl apply -f", 2);
                break;
            default:
                adicionarPerguntasPorCargo(prova, Cargo.ESTAGIARIO_CAFE);
                break;
        }
    }

    private void adicionarPergunta(jornadadev.provas.Prova prova, String enunciado, String alternativa1,
            String alternativa2, String alternativa3, int indiceCorreto) {
        prova.adicionarPergunta(new Pergunta(enunciado, new String[] { alternativa1, alternativa2, alternativa3 },
                indiceCorreto));
    }

    private void menuInventario() {
        boolean noInventario = true;
        while (noInventario) {
            System.out.println("\n[Inventário]");
            System.out.println("1. Escolher Pet");
            System.out.println("2. Escolher Badge");
            System.out.println("3. Escolher Tema de XP");
            System.out.println("4. Slogans desbloqueados");
            System.out.println("0. Voltar");
            String entrada = scanner.nextLine().trim();
            if (verificarComandoSecreto(entrada)) {
                continue;
            }
            switch (entrada) {
                case "1":
                    selecionarPet();
                    break;
                case "2":
                    selecionarBadge();
                    break;
                case "3":
                    selecionarTema();
                    break;
                case "4":
                    selecionarSlogan();
                    break;
                case "0":
                    noInventario = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    private void selecionarPet() {
        List<Pet> pets = new ArrayList<>(desenvolvedor.getInventario().getPets());
        if (pets.isEmpty()) {
            System.out.println("Nenhum pet encontrado. Visite a loja!");
            return;
        }
        for (int i = 0; i < pets.size(); i++) {
            Pet pet = pets.get(i);
            System.out.println("(" + (i + 1) + ") " + pet.getNome());
            System.out.println(pet.getAsciiArt());
        }
        System.out.println("(0) Voltar");
        int escolha = lerOpcaoNumerica(0, pets.size());
        if (escolha == 0) {
            return;
        }
        Pet selecionado = pets.get(escolha - 1);
        desenvolvedor.setPetAtual(selecionado);
        System.out.println(selecionado.getNome() + " agora corre pelo escritório.");
    }

    private void selecionarBadge() {
        List<Badge> badges = new ArrayList<>(desenvolvedor.getInventario().getBadges());
        if (badges.isEmpty()) {
            System.out.println("Sem badges. Hora de comprar algumas.");
            return;
        }
        for (int i = 0; i < badges.size(); i++) {
            Badge badge = badges.get(i);
            System.out.println("(" + (i + 1) + ") " + badge.getNome() + " " + badge.getAsciiArt());
        }
        System.out.println("(0) Voltar");
        int escolha = lerOpcaoNumerica(0, badges.size());
        if (escolha == 0) {
            return;
        }
        Badge selecionada = badges.get(escolha - 1);
        desenvolvedor.setBadgeAtual(selecionada);
        System.out.println("Badge equipada! " + selecionada.getTextoBadge() + " reluz ao lado do seu nome.");
    }

    private void selecionarTema() {
        List<TemaXP> temas = new ArrayList<>(desenvolvedor.getInventario().getTemas());
        if (temas.isEmpty()) {
            System.out.println("Sem temas disponíveis.");
            return;
        }
        for (int i = 0; i < temas.size(); i++) {
            TemaXP tema = temas.get(i);
            System.out.println("(" + (i + 1) + ") " + tema.getNome());
            System.out.println("Exemplo: " + tema.gerarBarra(0.65));
        }
        System.out.println("(0) Voltar");
        int escolha = lerOpcaoNumerica(0, temas.size());
        if (escolha == 0) {
            return;
        }
        TemaXP selecionado = temas.get(escolha - 1);
        desenvolvedor.setTemaAtual(selecionado);
        System.out.println("Tema atualizado! O XP agora tem outro brilho.");
    }

    private void selecionarSlogan() {
        if (desenvolvedor.getCargoAtual() != Cargo.CEO) {
            System.out.println("Apenas CEOs podem gritar slogans.");
            return;
        }
        List<Slogan> slogans = new ArrayList<>(desenvolvedor.getInventario().getSlogans());
        if (slogans.isEmpty()) {
            System.out.println("Você ainda não comprou slogans.");
            return;
        }
        for (int i = 0; i < slogans.size(); i++) {
            Slogan slogan = slogans.get(i);
            System.out.println("(" + (i + 1) + ") " + slogan.getNome());
            System.out.println("    " + slogan.getFrase());
        }
        System.out.println("(0) Voltar");
        int escolha = lerOpcaoNumerica(0, slogans.size());
        if (escolha == 0) {
            return;
        }
        Slogan selecionado = slogans.get(escolha - 1);
        desenvolvedor.setSloganAtual(selecionado);
        System.out.println("Slogan estampado no topo do menu!");
    }

    private void menuSecreto() {
        if (desenvolvedor.getCargoAtual() != Cargo.CEO) {
            System.out.println("As muralhas ainda não revelaram o segredo.");
            return;
        }
        System.out.println("Uma palavra ecoou pelas muralhas...");
        System.out.println("Gritada pelos membros do Esquadrão de Reconhecimento.");
        System.out.println("Talvez você deva digitá-la quando sentir que é hora.");
    }

    private boolean verificarComandoSecreto(String entrada) {
        if ("SASAGEYO".equalsIgnoreCase(entrada)) {
            if (!desenvolvedor.isModoTitanAtivo()) {
                ativarModoTitan();
            } else {
                System.out.println("Você já está em forma de Titã. Respire fundo e domine o mundo.");
            }
            return true;
        }
        return false;
    }

    private void ativarModoTitan() {
        desenvolvedor.ativarModoTitan();
        concederRecompensasTitan();
        System.out.println("TRANSFORMAÇÃO EM TITÃ ATIVADA");
        System.out.println("         ( o_o )  << olhos verdes brilhando");
        System.out.println("Você sente muita fome.");
        System.out.println("Sua energia desperta como a de um Titã.");
    }

    private void concederRecompensasTitan() {
        if (recompensaTitanPet == null || recompensaTitanBadge == null || recompensaTitanTema == null) {
            configurarRecompensasTitan();
        }
        jornadadev.model.Inventario inventario = desenvolvedor.getInventario();
        if (!inventario.possuiPet(recompensaTitanPet.getNome())) {
            inventario.adicionarPet(recompensaTitanPet);
            desenvolvedor.setPetAtual(recompensaTitanPet);
            System.out.println("Titã Vigia agora responde ao seu chamado.");
        }
        if (!inventario.possuiBadge(recompensaTitanBadge.getNome())) {
            inventario.adicionarBadge(recompensaTitanBadge);
            desenvolvedor.setBadgeAtual(recompensaTitanBadge);
            System.out.println("Badge Olhar de Titã se fixou no seu crachá.");
        }
        if (!inventario.possuiTema(recompensaTitanTema.getNome())) {
            inventario.adicionarTema(recompensaTitanTema);
            desenvolvedor.setTemaAtual(recompensaTitanTema);
            System.out.println("Tema Núcleo Titã iluminou sua barra de XP.");
        }
    }

    private int lerOpcaoNumerica(int minimo, int maximo) {
        while (true) {
            System.out.print("Escolha: ");
            String entrada = scanner.nextLine().trim();
            if (verificarComandoSecreto(entrada)) {
                return minimo; // retorna ao menu atual
            }
            try {
                int numero = Integer.parseInt(entrada);
                if (numero >= minimo && numero <= maximo) {
                    return numero;
                }
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido.");
            }
            System.out.println("Digite um número entre " + minimo + " e " + maximo + ".");
        }
    }
}
