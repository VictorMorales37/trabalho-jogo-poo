package Entidades;

import Util.Macros;

public class Caixa {
    private final TipoCaixa tipo;
    private int posicaoX;
    private int posicaoY;

    public Caixa(TipoCaixa tipo) {
        this.tipo = tipo;
    }

    public Caixa copia() {
        Caixa c = new Caixa(tipo);

        c.setPosicaoX(posicaoX);
        c.setPosicaoY(posicaoY);

        return c;
    }

    public TipoCaixa getTipo() { return tipo; }
    public int getPosicaoX() { return posicaoX; }
    public int getPosicaoY() { return posicaoY; }
    public void setPosicaoX(int x) { posicaoX = x; }
    public void setPosicaoY(int y) { posicaoY = y; }
    public char getSimbolo() { return Macros.SIMB_CAIXA; }
}