import java.util.Scanner;
import java.util.Random;

public class Jogo {
    public static final Random RANDOM = new Random();
    private final Jogador jogador;
    private final Scanner scanner;
    private final Tabuleiro tabuleiro;

    public Jogo(Scanner scanner) {
        this.scanner = scanner;
        this.tabuleiro = new Tabuleiro(Macros.TAMANHO_TABULEIRO);
        this.jogador = new Jogador(Macros.SIMB_JOGADOR, tabuleiro, Macros.SAUDE_JOGADOR,
                                   Macros.VEL_JOGADOR, 0);
    }
    public void setDificuldade() {
        System.out.println("Bem vindo, Jogador!");
        System.out.println("Selecione Dificuldade:");
        System.out.println("1- Fácil");
        System.out.println("2- Médio");
        System.out.println("3- Difícil");

        int dificuldade = scanner.nextInt();
        this.jogador.setPercepcao(4 - dificuldade);
    }

    public void iniciarJogo() {

        jogador.posicaoX = RANDOM.nextInt(tabuleiro.getDimensao());
        jogador.posicaoY = RANDOM.nextInt(tabuleiro.getDimensao());

        int opcao = 0;

        while (opcao != 2) {
            System.out.println("1- Movimentar");
            System.out.println("2- Sair");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    tabuleiro.mostrarTabuleiro(jogador);
                    break;
                case 2:
                    break;
            }
        }
    }

    public void encerrarJogo() {
    }
}