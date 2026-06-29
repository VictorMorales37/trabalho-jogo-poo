package Entidades.Dinossauros;

import Entidades.Entidade;

public abstract class Dinossauro implements Entidade {

    protected int saude;
    protected int velocidade;
    protected int posicaoX;
    protected int posicaoY;

    public Dinossauro(int saude, int velocidade) {
        this.saude = saude;
        this.velocidade = velocidade;
    }

    public abstract Dinossauro copia();

    @Override
    public abstract char getSimbolo();

    @Override public void setPosicaoX(int x) { this.posicaoX = x; }
    @Override public void setPosicaoY(int y) { this.posicaoY = y; }
    @Override public void setSaude(int saude) { this.saude = saude; }
    @Override public int getPosicaoX() { return posicaoX; }
    @Override public int getPosicaoY() { return posicaoY; }
    @Override public int getSaude() { return saude; }
    public int getVelocidade() { return velocidade; }
    public boolean podeSerAtacadoSemArma() {
        return true;
    }

    public boolean podeSerAtacadoComDardos() {
        return true;
    }

    public int getDanoAtaque() {
        return 1;
    }
}