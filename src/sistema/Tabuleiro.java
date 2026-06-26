package sistema;
import entidades.*;
import util.Macros;

import java.util.ArrayList;

public class Tabuleiro {
    private final int dimensao;
    private final char[][] grid;
    private final boolean[][] posicoesOcupadas;

    public Tabuleiro(int dimensao) {
        this.dimensao = dimensao;
        grid = new char[dimensao][dimensao];
        posicoesOcupadas = new boolean[dimensao][dimensao];
    }

    public char[][] getGrid() {
        return grid;
    }

    public int getDimensao() {
        return dimensao;
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

    public void setPosicoesOcupadas(int x, int y) {
        posicoesOcupadas[x][y] = true;
    }

    public void atualizar(Jogador j, ArrayList<Dinossauro> dinos,  ArrayList<Caixa> caixas) {
        for (int x = 0; x < dimensao; x++) {
            for (int y = 0; y < dimensao; y++) {
                grid[x][y] = '.';
                if (j.getPosicaoX() == x && j.getPosicaoY() == y) {
                    grid[x][y] = Macros.SIMB_JOGADOR;
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
}
