public class Tabuleiro {
    private final int dimensao;
    private final String[][] grid;

    public Tabuleiro(int dimensao) {
        this.dimensao = dimensao;
        this.grid = new String[dimensao][dimensao];
    }

    public void mostrarTabuleiro(Jogador p) {
        for (int x = 0; x < dimensao; x++) {
            for (int y = 0; y < dimensao; y++) {
                if (p.posicaoX == x && p.posicaoY == y) {
                    grid[x][y] = Character.toString(Macros.SIMB_JOGADOR);
                    System.out.print(grid[x][y] + " ");
                }
                else {
                    grid[x][y] = ".";
                    System.out.print(grid[x][y] + " ");
                }
            }
            System.out.println();
        }
    }
    public int getDimensao(){
        return dimensao;
    }

}
