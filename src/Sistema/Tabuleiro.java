package Sistema;
import Entidades.*;
import Entidades.Dinossauros.Dinossauro;
import Util.Macros;

import java.util.ArrayList;

public class Tabuleiro {
    private final int dimensao;
    private char[][] grid;
    private char[][] posicoesIniciais;
    private final boolean[][] posicoesOcupadas;
    private final ArrayList<int[]> paredes;

    public Tabuleiro(int dimensao) {
        this.dimensao = dimensao;
        grid = new char[dimensao][dimensao];
        posicoesIniciais = new char[dimensao][dimensao];
        posicoesOcupadas = new boolean[dimensao][dimensao];
        paredes = new ArrayList<>();
    }

    public char[][] getGrid() {
        return grid;
    }

    public void setGrid(char[][] novoGrid) {
        for (int i = 0; i < grid.length; i++) {
            System.arraycopy(novoGrid[i], 0, grid[i], 0, grid[i].length);
        }
    }

    public char[][] getPosicoesIniciais() {
        return posicoesIniciais;
    }

    public int getDimensao() {
        return dimensao;
    }

    public ArrayList<int[]> getParedes() {
        return paredes;
    }

    public boolean verificarPosicao(int x, int y) {
        if (x < 0 || x > dimensao) return false;
        if (y < 0 || y > dimensao) return false;

        for (int i = 0; i < dimensao; i++) {
            for (int j = 0; j < dimensao; j++) {
                if (i == x && j == y && posicoesOcupadas[i][j]) return false;
            }
        }
        return true;
    }

    public void salvarPosicoes() {
        posicoesIniciais = new char[dimensao][dimensao];

        for (int i = 0; i < dimensao; i++) {
            System.arraycopy(grid[i], 0, posicoesIniciais[i], 0, dimensao);
        }
    }

    public void setPosicoesOcupadas(int x, int y) {
        posicoesOcupadas[x][y] = true;
    }

    public void atualizar(Jogador j, ArrayList<Dinossauro> dinos, ArrayList<Caixa> caixas) {
        for (int x = 0; x < dimensao; x++) {
            for (int y = 0; y < dimensao; y++) {
                grid[x][y] = '.';
                if (j.getPosicaoX() == x && j.getPosicaoY() == y) {
                    grid[x][y] = Macros.SIMB_JOGADOR;
                }
                for (int[] parede : paredes) {
                    if (parede[0] == x && parede[1] == y) {
                        grid[x][y] = Macros.SIMB_PAREDE;
                    }
                }
                for (Dinossauro dinossauro : dinos) {
                    if (dinossauro.getPosicaoX() == x && dinossauro.getPosicaoY() == y) {
                        grid[x][y] = dinossauro.getSimbolo();
                    }
                }
                for (Caixa caixa : caixas) {
                    if (caixa.getPosicaoX() == x && caixa.getPosicaoY() == y) {
                        grid[x][y] = caixa.getSimbolo();
                    }
                }
            }
        }
    }

    public boolean[][] calcularVisibilidade(Jogador j) {
        boolean[][] visivel = new boolean[dimensao][dimensao];
        int x = j.getPosicaoX();
        int y = j.getPosicaoY();

        visivel[x][y] = true;

        // cima
        for (int cx = x - 1; cx >= 0; cx--) {
            visivel[cx][y] = true;
            if (grid[cx][y] != '.' && grid[cx][y] != Macros.SIMB_JOGADOR) break;
        }

        // baixo
        for (int cx = x + 1; cx < dimensao; cx++) {
            visivel[cx][y] = true;
            if (grid[cx][y] != '.' && grid[cx][y] != Macros.SIMB_JOGADOR) break;
        }

        // esquerda
        for (int cy = y - 1; cy >= 0; cy--) {
            visivel[x][cy] = true;
            if (grid[x][cy] != '.' && grid[x][cy] != Macros.SIMB_JOGADOR) break;
        }

        // direita
        for (int cy = y + 1; cy < dimensao; cy++) {
            visivel[x][cy] = true;
            if (grid[x][cy] != '.' && grid[x][cy] != Macros.SIMB_JOGADOR) break;
        }

        return visivel;
    }
}
