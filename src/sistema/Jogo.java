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
    private final SistemaCombate sistemaCombate;
    private final LeitorDeInput leitorDeInput;
    private final Spawner spawner;
    private final ArrayList<Dinossauro> dinossauros;

    public Jogo() {
        random = new Random();
        spawner = new Spawner();
        scanner = new Scanner(System.in);
        tabuleiro = new Tabuleiro(Macros.TAMANHO_TABULEIRO);
        sistemaMovimento = new SistemaMovimento(tabuleiro.getGrid());
        sistemaCombate = new SistemaCombate();
        menu = new Menu();
        jogador = spawner.spawnJogador(tabuleiro);
        leitorDeInput = new LeitorDeInput(scanner);
        dinossauros = new ArrayList<>();

    }
    private void setDificuldade() {
        int dificuldade = leitorDeInput.lerInput(1, 3);
        jogador.setPercepcao(4 - dificuldade);
    }
    public void iniciarJogo() {
        menu.escolherDificuldade();
        setDificuldade();
        spawner.spawnDinossauros(tabuleiro, dinossauros);
        tabuleiro.atualizar(jogador, dinossauros);
        loopJogo();
        menu.mensagemSaida();
    }

    private void loopJogo() {
        int inputMenu = 0;
        while (inputMenu != 2) { // MENU PRINCIPAL
            menu.menuPrincipal(); // 1 - mover personagem | 2 - sair do jogo
            inputMenu = leitorDeInput.lerInput(1, 2);

            if (inputMenu == 1) {

                int inputMovimento = 0;

                while (inputMovimento != 5) {

                    menu.mostrarTabuleiro(tabuleiro, jogador);
                    menu.opcoesMovimento(); // 1, 2, 3, 4 - direções | 5 - voltar
                    inputMovimento = leitorDeInput.lerInput(1, 5);

                    if (inputMovimento != 5) {
                        Direcao direcao = leitorDeInput.lerDirecao(inputMovimento);
                        ResultadoMovimento resMovimento = sistemaMovimento.moverJogador(jogador,direcao);
                        menu.avisoMovimento(resMovimento);

                        if (resMovimento != ResultadoMovimento.LIVRE && resMovimento != ResultadoMovimento.BLOQUEADO) {
                            ResultadoCombate resCombate = sistemaCombate.comecarCombate(jogador, direcao, dinossauros, tabuleiro, scanner);
                            if (resCombate == ResultadoCombate.PERDEU) {
                                return;
                            }
                            else if (resCombate == ResultadoCombate.VENCEU) {
                                // o que fazer quando o jogador matar um dinossauro
                            }
                        }

                        tabuleiro.atualizar(jogador, dinossauros);
                    }

                } // movimentação e combate

            }

        } // loop do jogo

    }
}
