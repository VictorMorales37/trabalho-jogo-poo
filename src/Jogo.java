import java.util.Scanner;
import java.util.Random;

public class Jogo {
    public static final Random RANDOM = new Random();
    private final SistemaMovimento sistemaMovimento;
    private final SistemaCombate sistemaCombate;
    private final Jogador jogador;
    private final Scanner scanner;
    private final Tabuleiro tabuleiro;
    private final Menu menu;

    public Jogo(Scanner scanner) {
        this.scanner = scanner;
        menu = new Menu();
        tabuleiro = new Tabuleiro(Macros.TAMANHO_TABULEIRO);
        jogador = new Jogador(Macros.SIMB_JOGADOR, Macros.SAUDE_JOGADOR,
        Macros.VEL_JOGADOR, Macros.PERCEPCAO_INICIAL);
        sistemaMovimento = new SistemaMovimento();
        sistemaCombate = new SistemaCombate();
    }

    private void setDificuldade() {
        int dificuldade = scanner.nextInt();
        menu.escolherDificuldade();
        jogador.setPercepcao(4 - dificuldade);
    }

    public void iniciarJogo() {

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
                    menu.mostrarTabuleiro(tabuleiro, jogador);
                    sistemaMovimento.moverJogador(jogador, scanner);
                    menu.mostrarTabuleiro(tabuleiro, jogador);

                    break;
                case 2:
                    break;
            }
        }
    }

}
