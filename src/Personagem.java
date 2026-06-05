import java.util.Random;

public class Personagem {

    protected static final Random RANDOM = new Random();

    protected int velocidade;
    protected int vida;
    protected int posicaoX;
    protected int posicaoY;
    protected int dano;

    protected Personagem(Tabuleiro tabuleiro, int vida, int dano, int velocidade) {
        this.vida = vida;
        this.posicaoX = RANDOM.nextInt(tabuleiro.getDimensao());
        this.posicaoY = RANDOM.nextInt(tabuleiro.getDimensao());
        this.dano = dano;
        this.velocidade = velocidade;
    }

    public int getVidaRestante(){
        return this.vida;
    }

    public void Movimento(Tabuleiro t, int x, int y, int velocidade) {

        int possibilidade = RANDOM.nextInt(5);
        switch (possibilidade) {
            case 1:
                if ((posicaoX + velocidade) < t.getDimensao()) {
                    this.posicaoX += velocidade;
                    break;
                }
                else possibilidade++;
            case 2:
                if (posicaoX - velocidade > 0) {
                    this.posicaoX -= velocidade;
                    break;
                }
                else possibilidade++;
            case 3:
                if ((posicaoY + velocidade) < t.getDimensao()) {
                    this.posicaoY -= velocidade;
                    break;
                }
                else possibilidade++;
            case 4:
                if (posicaoY - velocidade > 0) {
                    this.posicaoY -= velocidade;
                    break;
                }
                else possibilidade = 1;
        }
    }
}

