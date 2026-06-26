package entidades;

import util.Macros;

public class Caixa {
    private final TipoCaixa tipo;
    private int posicaoX;
    private int posicaoY;

    public Caixa(TipoCaixa tipo) {
        this.tipo = tipo;
    }

    public TipoCaixa getTipo() { return tipo; }
    public int getPosicaoX() { return posicaoX; }
    public int getPosicaoY() { return posicaoY; }
    public void setPosicaoX(int x) { posicaoX = x; }
    public void setPosicaoY(int y) { posicaoY = y; }
    public char getSimbolo() { return Macros.SIMB_CAIXA; }
}