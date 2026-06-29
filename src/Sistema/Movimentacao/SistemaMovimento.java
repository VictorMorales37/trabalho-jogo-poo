package Sistema.Movimentacao;
import Entidades.*;
import Entidades.Dinossauros.Dinossauro;
import Util.Macros;

import java.util.Random;

public class SistemaMovimento {
    private final char[][] grid;
    private final Random random;

    public SistemaMovimento(char[][] grid, Random random) {
        this.grid = grid;
        this.random = random;
    }

    public ResultadoMovimento verificaMovimento(int x, int y){

        if ((x < 0 || x >= Macros.TAMANHO_TABULEIRO) || (y < 0 || y >= Macros.TAMANHO_TABULEIRO) || grid[x][y] == Macros.SIMB_PAREDE){
            return ResultadoMovimento.BLOQUEADO;
        }
        else if (grid[x][y] == Macros.SIMB_COMPSOGNATO) {
            return ResultadoMovimento.ENCONTROU_COMPSOGNATO;
        }
        else if (grid[x][y] == Macros.SIMB_TROODONTE) {
            return ResultadoMovimento.ENCONTROU_TROODONTE;
        }
        else if (grid[x][y] == Macros.SIMB_VELOCIRAPTOR) {
            return ResultadoMovimento.ENCONTROU_VELOCIRAPTOR;
        }
        else if (grid[x][y] == Macros.SIMB_TREX) {
            return ResultadoMovimento.ENCONTROU_TREX;
        }
        else if (grid[x][y] == Macros.SIMB_CAIXA) {
            return ResultadoMovimento.ENCONTROU_CAIXA;
        }
        return ResultadoMovimento.LIVRE;
    }

    public ResultadoMovimento moverJogador(Jogador j, Direcao direcao) {
        int novoX = j.getPosicaoX() + direcao.dx;
        int novoY = j.getPosicaoY() + direcao.dy;

        ResultadoMovimento resultado = verificaMovimento(novoX, novoY);

        if (resultado == ResultadoMovimento.LIVRE || resultado == ResultadoMovimento.ENCONTROU_CAIXA) {
            j.setPosicaoX(novoX);
            j.setPosicaoY(novoY);
        }
        return resultado;
    }
    public Direcao direcaoAleatoria() {
        int val = random.nextInt(4);
        return switch (val) {
            case 0 -> Direcao.CIMA;
            case 1 -> Direcao.BAIXO;
            case 2 -> Direcao.DIREITA;
            case 3 -> Direcao.ESQUERDA;
            default -> Direcao.INVALIDA;
        };
    }
    public boolean moverDinossauro(Dinossauro d, Jogador jogador) {
        for (int i = 0; i < d.getVelocidade(); i++) {
            int novoX;
            int novoY;
            int tentativas = 0;
            do {
                Direcao direcaoAleatoria = direcaoAleatoria();
                novoX = d.getPosicaoX() + direcaoAleatoria.dx;
                novoY = d.getPosicaoY() + direcaoAleatoria.dy;
                tentativas++;
            } while ((verificaMovimento(novoX, novoY) != ResultadoMovimento.LIVRE &&
                    !(novoX == jogador.getPosicaoX() && novoY == jogador.getPosicaoY()))
                    && tentativas < 4);

            if (tentativas >= 4) return false;

            d.setPosicaoX(novoX);
            d.setPosicaoY(novoY);

            if (d.getPosicaoX() == jogador.getPosicaoX() &&
                    d.getPosicaoY() == jogador.getPosicaoY()) {
                return true;
            }
        }
        return false;
    }
}
