package entidades;

public class Dinossauro implements Entidade {

    protected char simbolo;
    protected int saude;
    protected int velocidade;

    protected int posicaoX;
    protected int posicaoY;

    public Dinossauro(char simbolo, int saude, int velocidade) {
        this.simbolo = simbolo;
        this.saude = saude;
        this.velocidade = velocidade;
    }

    @Override
    public void setPosicaoX(int x) {
        this.posicaoX = x;
    }

    @Override
    public void setPosicaoY(int y) {
        this.posicaoY = y;
    }

    @Override
    public void setSaude(int saude) {
        this.saude = saude;
    }

    @Override
    public int getPosicaoX() {
        return posicaoX;
    }

    @Override
    public int getPosicaoY() {
        return posicaoY;
    }

    @Override
    public int getSaude() {
        return saude;
    }

    @Override
    public char getSimbolo() {
        return simbolo;
    }

    public int getVelocidade() {
        return velocidade;
    }
}
