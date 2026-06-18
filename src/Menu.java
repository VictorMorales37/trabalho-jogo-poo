public class Menu {

    //use o menu para os prints

    public void opcoes() {
        System.out.println("1- Movimentar");
        System.out.println("2- Sair");
    }

    public void escolherDificuldade() {
        System.out.println("Bem vindo, Jogador!");
        System.out.println("Selecione Dificuldade:");
        System.out.println("1- Fácil");
        System.out.println("2- Médio");
        System.out.println("3- Difícil");
    }
    //ARRUMAR vvvvv
    public void mostrarTabuleiro(Tabuleiro t, Jogador j) {
        for (int x = 0; x < t.getDimensao(); x++) {
            for (int y = 0; y < t.getDimensao(); y++) {
                t.grid[x][y] = ".";
                t.grid[j.getPosicaoX()][j.getPosicaoY()] = Character.toString(Macros.SIMB_JOGADOR);
                System.out.print(t.grd[x][y] + " ");
            }
            System.out.println();
        }
    }

    public void opcoesMovimento() {
        System.out.println("1 - ^");
        System.out.println("2 - <");
        System.out.println("3 - >");
        System.out.println("4 - v");
    }

}
