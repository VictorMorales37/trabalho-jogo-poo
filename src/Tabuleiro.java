import java.util.Random;

public class Tabuleiro {
    private static final Random RANDOM = new Random();
    private final int dimensao;
    private final String[][] grid;
    private boolean[][] posOcupadas;
    private int[][] paredes;

    public Tabuleiro(int dimensao) {
        this.dimensao = dimensao;
        this.grid = new String[dimensao][dimensao];
        this.posOcupadas = new boolean[dimensao][dimensao];
    }

    public void mostrarTabuleiro(Jogador j) {
        for (int x = 0; x < dimensao; x++) {
            for (int y = 0; y < dimensao; y++) {
                grid[x][y] = ".";
                grid[j.getPosicaoX()][j.getPosicaoY()] = Character.toString(Macros.SIMB_JOGADOR);
                System.out.print(grid[x][y] + " ");
            }
            System.out.println();
        }
    }
    public int getDimensao(){
        return dimensao;
    }

    public int getCordenadaAleatoria(){
        return RANDOM.nextInt(dimensao);
    }

    public void setCaixaSuprimentos(int quantidade){
        for (int i = 0; i < quantidade; i++){
            int x = getCordenadaAleatoria();
            int y = getCordenadaAleatoria();

            grid[x][y] = "X";
        }
    }

    //public  temCaixaSuprimento(int x, int y) {
  //      if ( grid[x][y] == Character.toString(Macros.SIMB_CAIXA)){
//
    //    }
    //}
    }
