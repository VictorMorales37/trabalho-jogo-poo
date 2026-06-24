package sistema.movimentacao;
import entidades.*;
import util.Macros;

public class SistemaMovimento {
    private final char[][] grid;

    public SistemaMovimento(char[][] grid) {
        this.grid = grid;
    }

    public ResultadoMovimento moverJogador(Jogador j, Direcao direcao) {
        int novoX = j.getPosicaoX() + direcao.dx;
        int novoY = j.getPosicaoY() + direcao.dy;

        ResultadoMovimento resultado = verificaMovimento(novoX, novoY);

        if (resultado == ResultadoMovimento.LIVRE) {
            j.setPosicaoX(novoX);
            j.setPosicaoY(novoY);
        }
        return resultado;
    }

    public void moverDinossauro(Dinossauro d, Direcao direcao) {
        int novoX = (d.getPosicaoX() + direcao.dx) * d.getVelocidade();
        int novoY = (d.getPosicaoY() + direcao.dy) * d.getVelocidade();

        ResultadoMovimento resultado = verificaMovimento(novoX, novoY);

        if (resultado == ResultadoMovimento.LIVRE) {
            d.setPosicaoX(novoX);
            d.setPosicaoY(novoY);
        }
    }

    public ResultadoMovimento verificaMovimento(int x, int y){

        if ((x < 0 || x >= Macros.TAMANHO_TABULEIRO) || (y < 0 || y >= Macros.TAMANHO_TABULEIRO)){
            return ResultadoMovimento.BLOQUEADO;
        }
        else if (grid[x][y] == Macros.SIMB_JOGADOR) {
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
            return ResultadoMovimento.ENCONTROU_ITEM;
        }
        else {
            return ResultadoMovimento.LIVRE;
        }

    }


}
