# 🚀 Jornada do Dev - Do estágio ao CEO de uma empresa especializada em Cryptomoedas
Projeto da disciplina de Programação Orientada a Objetos.
Jogo que simula a evolução de um profissional de TI, desde os primeiros passos como estagiário, até alcançar o topo da carreira
como CEO de uma grande empresa.

<img width="500" height="500" alt="415c5459-594b-4e5a-a8c7-56671dfd3cb1-removebg-preview" src="https://github.com/user-attachments/assets/70e8f962-dc11-4e90-9a15-7dc744b93d79" />

## 📌 Descrição
O Jornada do Dev apresenta uma narrativa interativa em que o jogador administra a carreira de um desenvolvedor dentro de uma startup fictícia focada em Solana.
Cada ação é realizada via menu no terminal, permitindo:
1. Trabalhar em projetos
2. Participar de cursos
3. Comprar itens cosméticos
4. Disputar promoções até alcançar o cargo de CEO.

A experiência combina gerenciamento de recursos, evolução de habilidades e eventos aleatórios que afetam o desempenho em cada rodada.

## ❓ Features/Recursos
1. `Sistema econômico` baseado em CoffeeCoins e ganho de experiência para desbloquear novos cargos e atividades.
2. `Loja` com duas abas distintas (cursos e personalização), permitindo investir em progresso técnico ou em itens cosméticos.
3. `Conjunto de projetos` desbloqueados por cargo, garantindo desafios diferentes conforme o jogador avança na carreira.
4. `Provas de promoção` com perguntas de múltipla escolha que testam conhecimentos antes de conceder novos cargos.
5. `Eventos aleatórios` positivos ou negativos que modificam recompensas temporariamente, mantendo cada sessão imprevisível.

## 💻 Programa em execução
- Iniciando o jogo:

<img width="826" height="622" alt="Captura de tela 2025-11-21 085922" src="https://github.com/user-attachments/assets/77a9d5dc-4111-46b6-9446-5f1dc9740071" />

- Prova para subir de cargo:

<img width="929" height="504" alt="Captura de tela 2025-11-21 090220" src="https://github.com/user-attachments/assets/d5e55eca-1954-4800-80c5-ce97a53ebbc1" />

- Easter Egg no cargo CEO:
  
<img width="935" height="492" alt="Captura de tela 2025-11-20 232016" src="https://github.com/user-attachments/assets/a0159616-e7e2-4b8a-b0c7-6964958143ff" />



## 🗺️ Instruções de execução
1. Instale o [JDK 17](https://adoptium.net/) ou versão superior e certifique-se de que o comando `java` está disponível no terminal.
2. Clone o repositório e abra a pasta do projeto no VS Code ou no terminal de sua preferência.
3. Compile os arquivos fonte com `javac -d out $(find src/main/java -name "*.java")` (Linux/macOS) ou utilize um arquivo de lista `sources.txt` para compilar no Windows.
4. Execute o jogo com `java -cp out jornadadev.Main`.
5. No VS Code, também é possível usar a extensão "Extension Pack for Java" e acionar o botão **Run** diretamente na classe `Main` para compilar e iniciar o aplicativo automaticamente.

## 📨 Diagrama UML
![projetoJornadaDev (1)](https://github.com/user-attachments/assets/f9eca9fe-87fc-4a58-9764-2d28317e969d)


## 📦 Pacotes do código
- `jornadadev`: contém a classe `Main`, ponto de entrada da aplicação.
- `jornadadev.core`: motor do jogo, responsável pelo loop principal, menus e gerenciamento geral.
- `jornadadev.eventos`: define os eventos aleatórios que alteram temporariamente as recompensas.
- `jornadadev.loja`: inclui a loja, cursos e regras para compra de itens.
- `jornadadev.model`: classes de domínio como desenvolvedor, cargos e inventário.
- `jornadadev.personalizacao`: itens cosméticos (temas, badges, pets e slogans).
- `jornadadev.projetos`: catálogo de atividades e projetos disponíveis durante a progressão da carreira.
- `jornadadev.provas`: implementação das avaliações exigidas nas promoções de cargo.

## 👤 Integrantes
- Heitor Farias - [LinkedIn](https://www.linkedin.com/in/heitorfariassantos/)
- Nina Lira
- Matheus Souto
