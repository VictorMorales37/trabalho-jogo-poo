package sistema;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import entidades.*;
import sistema.movimentacao.*;
import util.*;

public class Jogo {
    public final Random random;
    private final Scanner scanner;
    private final Menu menu;
    private final Tabuleiro tabuleiro;
    private final Jogador jogador;
    private final SistemaMovimento sistemaMovimento;
    private final LeitorDeInput leitorDeInput;
    private final Spawner spawner;
    private ArrayList<Dinossauro> dinossauros;

    public Jogo() {
        random = new Random();
        spawner = new Spawner();
        scanner = new Scanner(System.in);
        tabuleiro = new Tabuleiro(Macros.TAMANHO_TABULEIRO);
        sistemaMovimento = new SistemaMovimento(tabuleiro.getGrid());
        menu = new Menu();
        jogador = spawner.spawnJogador(tabuleiro);
        leitorDeInput = new LeitorDeInput(scanner);
        dinossauros = new ArrayList<>();
    }
    private void setDificuldade() {
        int dificuldade = scanner.nextInt();
        jogador.setPercepcao(4 - dificuldade);
    }
    public void iniciarJogo() {
        menu.escolherDificuldade();
        setDificuldade();
        spawner.spawnDinossauros(tabuleiro, dinossauros);
        tabuleiro.atualizar(jogador, dinossauros);
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

                        tabuleiro.atualizar(jogador, dinossauros);
                    }
                    break;
                case 2:
                    break;
            }
        }
    }
}
