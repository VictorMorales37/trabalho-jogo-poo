public class Tabuleiro {
    private final int dimensao;
    private String[][] grid;

    public Tabuleiro() {
        this.dimensao = 20;
        this.grid = new String[dimensao][dimensao];
    }

    //nao ta completo
    public void mostrarTabuleiro() {
        for (int i = 0; i < dimensao; i++) {
            for (int j = 0; j < dimensao; j++) {
                grid[i][j] = "+";
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int getDimensao(){
        return dimensao;
    }

}
