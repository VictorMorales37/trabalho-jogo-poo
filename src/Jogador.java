public class Jogador extends Personagem{

    private int percepcao;

    public Jogador(Tabuleiro tabuleiro, int vida, int dano, int percepcao) {
        super(tabuleiro, vida, dano);
        this.percepcao = percepcao;
    }
}
