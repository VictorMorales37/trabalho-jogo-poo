import java.util.Random;

public class Personagem {

    protected static final Random RANDOM = new Random();

    protected int vida;
    protected int posicaoX;
    protected int posicaoY;
    protected int dano;

    protected Personagem(Tabuleiro tabuleiro, int vida, int dano) {
        this.vida = vida;
        this.posicaoX = RANDOM.nextInt(tabuleiro.getDimensao());
        this.posicaoY = RANDOM.nextInt(tabuleiro.getDimensao());
        this.dano = dano;
    }
}
