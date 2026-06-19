import java.util.Scanner;

public class SistemaMovimento {
    int choice;
    char[][] grid;

    public SistemaMovimento(char[][] grid) {
        this.grid = grid;
    }

    public void moverJogador(Jogador j, Scanner s) {
        choice = 0;
        choice = s.nextInt();
        switch (choice) { // y = colunas      x = linhas
            case 1:
                if (movimentoValido(j.getPosicaoX() - 1, j.getPosicaoY()) == 0) {
                    j.setPosicaoX(j.getPosicaoX() - 1); // ^
                }
                break;
            case 2:
                if (movimentoValido(j.getPosicaoX(), j.getPosicaoY() - 1) == 0){
                    j.setPosicaoY(j.getPosicaoY() - 1); // <
                }
                break;
            case 3:
                if (movimentoValido(j.getPosicaoX(), j.getPosicaoY() + 1) == 0){
                    j.setPosicaoY(j.getPosicaoY() + 1); // >
                }
                break;
            case 4:
                if (movimentoValido(j.getPosicaoX() + 1, j.getPosicaoY()) == 0){
                    j.setPosicaoX(j.getPosicaoX() + 1); // v
                }
                break;
        }
    }

    public int movimentoValido(int x, int y){
        // adicionar colisão com as paredes
        // retorna 0 se o movimento é valido
        // retorna 1 se o movimenta para fora do mapa ou bater em parede
        // retorna 2 se o movimento faz o personagem com compsognato
        // retorna 3 se o movimento faz o personagem com troodonte
        // retorna 4 se o movimento faz o personagem com velociraptor
        // retorna 5 se o movimento faz o personagem com TRex
        // retorna 6 se o movimento faz o personagem colidir com item

        if ((x < 0 || x >= Macros.TAMANHO_TABULEIRO) || (y < 0 || y >= Macros.TAMANHO_TABULEIRO)){
            return 1;
        }
        else if (grid[x][y] == Macros.SIMB_JOGADOR) {
            return 1;
        }
        else if (grid[x][y] == Macros.SIMB_COMPSOGNATO) {
            return 2;
        }
        else if (grid[x][y] == Macros.SIMB_TROODONTE) {
            return 3;
        }
        else if (grid[x][y] == Macros.SIMB_VELOCIRAPTOR) {
            return 4;
        }
        else if (grid[x][y] == Macros.SIMB_TREX) {
            return 5;
        }
        else if (grid[x][y] == Macros.SIMB_CAIXA) {
            return 6;
        }
        else {
            return 0;
        }

    }


}
