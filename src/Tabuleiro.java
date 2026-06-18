import java.util.Random;

public class Tabuleiro {
    private final int dimensao;
    private final String[][] grid;
    private boolean[][] posOcupadas;

    public Tabuleiro(int dimensao) {
        this.dimensao = dimensao;
        this.grid = new String[dimensao][dimensao];
        this.posOcupadas = new boolean[dimensao][dimensao];
    }

    public String[][] getGrid() {
        return grid;
    }

    public int getDimensao() {
        return dimensao;
    }
}
