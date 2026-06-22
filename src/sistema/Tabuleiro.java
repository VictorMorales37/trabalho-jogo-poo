package sistema;
import entidades.Jogador;
import util.Macros;

public class Tabuleiro {
    private final int dimensao;
    private final char[][] grid;

    public Tabuleiro(int dimensao) {
        this.dimensao = dimensao;
        grid = new char[dimensao][dimensao];
    }

    public char[][] getGrid() {
        return grid;
    }

    public int getDimensao() {
        return dimensao;
    }

    public void atualizar(Jogador j) {
        for (int x = 0; x < dimensao; x++) {
            for (int y = 0; y < dimensao; y++) {
                grid[x][y] = '.';
                if (j.getPosicaoX() == x && j.getPosicaoY() == y) {
                    grid[x][y] = Macros.SIMB_JOGADOR;
                }
            }
        }
    }
}
