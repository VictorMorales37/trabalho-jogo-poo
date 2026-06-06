public class Jogador extends Personagem{
    private int percepcao;
    private int armaDardos = 0;
    private boolean temBastao = false;

    public Jogador(char simbolo, Tabuleiro tabuleiro, int saude, int velocidade, int percepcao) {
        super(simbolo, tabuleiro, saude, velocidade);
        this.percepcao = percepcao;
    }

    public void setPercepcao(int p) {
        this.percepcao = p;
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
