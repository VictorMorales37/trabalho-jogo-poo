package sistema;
import entidades.*;
import sistema.movimentacao.*;
import util.*;
import java.util.Scanner;
import java.util.Random;

public class Jogo {
    public static final Random RANDOM = new Random();
    private final Scanner scanner;
    private final Menu menu;
    private final Tabuleiro tabuleiro;
    private final Jogador jogador;
    private final SistemaMovimento sistemaMovimento;
    private final LeitorDeInput leitorDeInput;

    public Jogo() {
        scanner = new Scanner(System.in);
        menu = new Menu();
        tabuleiro = new Tabuleiro(Macros.TAMANHO_TABULEIRO);
        jogador = new Jogador(Macros.SIMB_JOGADOR, Macros.SAUDE_JOGADOR,
        Macros.VEL_JOGADOR, Macros.PERCEPCAO_INICIAL);
        sistemaMovimento = new SistemaMovimento(tabuleiro.getGrid());
        leitorDeInput = new LeitorDeInput(scanner);
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

        while (leitorDeInput.input != 2) { // MENU PRINCIPAL

            menu.menuPrincipal(); // 1 - mover personagem | 2 - sair do jogo
            leitorDeInput.input = leitorDeInput.lerInput();

            switch (leitorDeInput.input) {

                case 1: // MENU DE MOVIMENTO
                    while (leitorDeInput.input != 5) {

                        menu.mostrarTabuleiro(tabuleiro, jogador);
                        menu.opcoesMovimento(); // 1, 2, 3, 4 - direções | 5 - voltar

                        leitorDeInput.input = leitorDeInput.lerInput();
                        Direcao direcao = leitorDeInput.lerDirecao(leitorDeInput.input);
                        sistemaMovimento.moverJogador(jogador, direcao);

                        tabuleiro.atualizar(jogador);
                    }
                    break;
                case 2:
                    break;
            }
        }
    }
}
