import java.util.Scanner;
import java.util.Random;

public class Jogo {
    public static final Random RANDOM = new Random();
    private final Scanner scanner;
    private final Menu menu;
    private final Tabuleiro tabuleiro;
    private final Jogador jogador;
    private final SistemaMovimento sistemaMovimento;

    public Jogo(Scanner scanner) {
        this.scanner = scanner;
        menu = new Menu();
        tabuleiro = new Tabuleiro(Macros.TAMANHO_TABULEIRO);
        jogador = new Jogador(Macros.SIMB_JOGADOR, Macros.SAUDE_JOGADOR,
        Macros.VEL_JOGADOR, Macros.PERCEPCAO_INICIAL);
        sistemaMovimento = new SistemaMovimento();
    }
    private void setDificuldade() {
        int dificuldade = scanner.nextInt();
        jogador.setPercepcao(4 - dificuldade);
    }
    public void iniciarJogo() {
        menu.escolherDificuldade();
        setDificuldade();
        jogador.setPosicaoX(RANDOM.nextInt(tabuleiro.getDimensao()));
        jogador.setPosicaoY(RANDOM.nextInt(tabuleiro.getDimensao()));
        loopJogo();
    }
    private void loopJogo() {
        int opcao = 0;
        while (opcao != 2) {
            menu.opcoes();
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    tabuleiro.atualizar(jogador);
                    menu.mostrarTabuleiro(tabuleiro, jogador);
                    menu.opcoesMovimento();
                    sistemaMovimento.moverJogador(jogador, scanner);
                    tabuleiro.atualizar(jogador);
                    menu.mostrarTabuleiro(tabuleiro, jogador);
                    break;
                case 2:
                    break;
            }
        }
    }
}
