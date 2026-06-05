public class Jogador extends Personagem{

    private int percepcao;
    private int armaDardos = 0;
    private boolean temBastao = false;

    public Jogador(Tabuleiro tabuleiro, int vida, int dano, int percepcao) {
        super(tabuleiro, 5, 1);
        this.percepcao = percepcao;
    }

    public void setTemBastao(){
        this.temBastao = true;
    }
    public boolean getTemBastao(){
        return this.temBastao;
    }

    public void acharDardos(int quantidadeDardos){
        this.armaDardos = quantidadeDardos;
    }

}
