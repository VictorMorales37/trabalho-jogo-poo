import java.util.Random;

public class Personagem {
    protected static final Random RANDOM = new Random();

    protected char simbolo;
    protected int posicaoX;
    protected int posicaoY;
    protected int saude;
    protected int velocidade;

    protected Personagem(char simbolo, Tabuleiro tabuleiro, int saude, int velocidade) {
        this.simbolo = simbolo;
        this.saude = saude;
        this.velocidade = velocidade;
    }

    public int getsaude(){
        return this.saude;
    }

    public void Movimento(Tabuleiro t, int x, int y) {
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