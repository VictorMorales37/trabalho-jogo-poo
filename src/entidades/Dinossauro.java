package entidades;
import sistema.Tabuleiro;
import java.util.Random;

public abstract class Dinossauro implements Entidade {
    protected static final Random RANDOM = new Random();

    protected char simbolo;
    protected int posicaoX;
    protected int posicaoY;
    protected int saude;
    protected int velocidade;

    protected Dinossauro(char simbolo, Tabuleiro tabuleiro, int saude, int velocidade) {
        this.simbolo = simbolo;
        this.saude = saude;
        this.velocidade = velocidade;
    }
}
