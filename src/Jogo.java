import java.util.Scanner;
import java.util.Random;

public class Jogo {
    public static final Random RANDOM = new Random();
    private final Scanner scanner;
    private final Menu menu;
    private final Tabuleiro tabuleiro;
    private final Jogador jogador;
    private final SistemaMovimento sistemaMovimento;
    private int input;

    public Jogo() {
        scanner = new Scanner(System.in);
        menu = new Menu();
        tabuleiro = new Tabuleiro(Macros.TAMANHO_TABULEIRO);
        jogador = new Jogador(Macros.SIMB_JOGADOR, Macros.SAUDE_JOGADOR,
        Macros.VEL_JOGADOR, Macros.PERCEPCAO_INICIAL);
        sistemaMovimento = new SistemaMovimento(tabuleiro.getGrid());
    }
    private void setDificuldade() {
        int dificuldade = scanner.nextInt();
        jogador.setPercepcao(4 - dificuldade);
    }
    public void iniciarJogo() {
        input = 0;
        menu.escolherDificuldade();
        setDificuldade();
        jogador.setPosicaoX(RANDOM.nextInt(tabuleiro.getDimensao()));
        jogador.setPosicaoY(RANDOM.nextInt(tabuleiro.getDimensao()));
        loopJogo();
    }
    private void loopJogo() {
        while (input != 2) {
            menu.menuPrincipal(); // 1 - mover personagem | 2 - sair do jogo
            input = scanner.nextInt();
            switch (input) {
                case 1:
                    while (input != 5) {
                        tabuleiro.atualizar(jogador);
                        menu.mostrarTabuleiro(tabuleiro, jogador);
                        menu.opcoesMovimento(); // 1, 2, 3, 4 - direções | 5 - voltar
                        input = scanner.nextInt();
                        sistemaMovimento.moverJogador(jogador, input);
                    }
                    break;
                case 2:
                    break;
            }
        }
    }
}
