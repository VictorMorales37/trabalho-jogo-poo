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
    private final SistemaItens sistemaItens;
    private final LeitorDeInput leitorDeInput;
    private final Spawner spawner;
    private final ArrayList<Dinossauro> dinossauros;
    private final ArrayList<Caixa> caixas;

    public Jogo() {
        random = new Random();
        spawner = new Spawner();
        scanner = new Scanner(System.in);
        tabuleiro = new Tabuleiro(Macros.TAMANHO_TABULEIRO);
        sistemaMovimento = new SistemaMovimento(tabuleiro.getGrid(), random);
        sistemaCombate = new SistemaCombate(random);
        sistemaItens = new SistemaItens(sistemaCombate);
        menu = new Menu();
        jogador = spawner.spawnJogador(tabuleiro);
        leitorDeInput = new LeitorDeInput(scanner);
        dinossauros = new ArrayList<>();
        caixas = new ArrayList<>();

    }
    private void setDificuldade() {
        int dificuldade = leitorDeInput.lerInput(1, 3);
        jogador.setPercepcao(4 - dificuldade);
    }
    public void iniciarJogo() {
        menu.escolherDificuldade();
        setDificuldade();
        spawner.spawnDinossauros(tabuleiro, dinossauros);
        spawner.spawnCaixas(tabuleiro, caixas);
        tabuleiro.atualizar(jogador, dinossauros, caixas);
        loopJogo();
    }

    private void loopJogo() {

        int inputOpcoes = 0;

        while (inputOpcoes != 2) { // MENU PRINCIPAL

            menu.menuPrincipal(); // 1 - mover personagem | 2 - sair do jogo
            inputOpcoes = leitorDeInput.lerInput(1, 2);

            if (inputOpcoes == 1) { //MOVIMENTACAO

                int inputMovimento = 0;

                while (inputMovimento != 5) {

                    if (dinossauros.isEmpty()) {
                        menu.mensagemVitoria();
                        return;
                    }

                    menu.mostrarTabuleiro(tabuleiro);
                    menu.opcoesMovimento(); // 1, 2, 3, 4 - direções | 5 - voltar

                    inputMovimento = leitorDeInput.lerInput(1, 5);
                    Direcao direcao = leitorDeInput.lerDirecao(inputMovimento);

                    if (inputMovimento == 5) continue;

                    ResultadoMovimento resMovimento = sistemaMovimento.moverJogador(jogador, direcao);
                    menu.avisoMovimento(resMovimento);

                    if (resMovimento == ResultadoMovimento.ENCONTROU_CAIXA) {
                        for (Caixa c : caixas) {
                            if (c.getPosicaoX() == jogador.getPosicaoX()
                                    && c.getPosicaoY() == jogador.getPosicaoY()) {
                                sistemaItens.abrirCaixa(jogador, c, dinossauros, tabuleiro, menu, leitorDeInput);
                                caixas.remove(c);
                                break;
                            }
                        }
                    }
                    else if (resMovimento != ResultadoMovimento.LIVRE &&
                            resMovimento != ResultadoMovimento.BLOQUEADO) {

                        Dinossauro morto = null;
                        ResultadoCombate resCombate;

                        for (Dinossauro d : dinossauros) {
                            if (d.getPosicaoX() != jogador.getPosicaoX() + direcao.dx ||
                                d.getPosicaoY() != jogador.getPosicaoY() + direcao.dy) {
                                continue;
                            }
                            resCombate =
                                    sistemaCombate.combate(
                                            jogador, d,
                                            menu, leitorDeInput,
                                            tabuleiro);

                            if (resCombate == ResultadoCombate.PERDEU) {
                                menu.mensagemDerrota();
                                return;
                            }
                            if (resCombate == ResultadoCombate.VENCEU) morto = d;
                        }

                        if (morto != null) {
                            dinossauros.remove(morto);
                            tabuleiro.atualizar(jogador, dinossauros, caixas);
                            sistemaMovimento.moverJogador(jogador, direcao);
                        }
                    }
                    tabuleiro.atualizar(jogador, dinossauros, caixas);
                    for (Dinossauro d : dinossauros) {
                        sistemaMovimento.moverDinossauro(d);
                        tabuleiro.atualizar(jogador, dinossauros, caixas);
                    }
                }
            }
        }
    }
}