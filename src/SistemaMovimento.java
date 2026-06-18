import java.util.Scanner;

public class SistemaMovimento {

    public void moverJogador(Jogador j, Scanner s) {
        int choice = 0;
        choice = s.nextInt();
        switch (choice) { // y = colunas      x = linhas
            case 1:
                if (movimentoValido(j.getPosicaoX() - 1)) {
                    j.setPosicaoX(j.getPosicaoX() - 1); // ^
                } else {
                    System.out.println("Movimento não permitido");
                }
                break;
            case 2:
                if (movimentoValido(j.getPosicaoY() - 1)){
                    j.setPosicaoY(j.getPosicaoY() - 1); // <
                } else {
                    System.out.println("Movimento não permitido");
                }
                break;
            case 3:
                if (movimentoValido(j.getPosicaoY() + 1)){
                    j.setPosicaoY(j.getPosicaoY() + 1); // >
                } else {
                    System.out.println("Movimento não permitido");
                }
                break;
            case 4:
                if (movimentoValido(j.getPosicaoX() + 1)){
                    j.setPosicaoX(j.getPosicaoX() + 1); // v
                } else {
                    System.out.println("Movimento não permitido");
                }
                break;
        }
    }

    public boolean movimentoValido(int num){
        return !(num < 0 || num >= Macros.TAMANHO_TABULEIRO);
    }


}
