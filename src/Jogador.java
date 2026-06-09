public class Jogador {
    private char simbolo;
    private int velocidade;
    private int saude;
    private int percepcao;
    private int armaDardos = 0;
    private int kitsMedicos = 0;
    private boolean temBastao = false;
    private int posicaoX;
    private int posicaoY;

    public Jogador(Tabuleiro tabuleiro, char simbolo, int velocidade, int saude, int percepcao) {
        this.simbolo = simbolo;
        this.velocidade = velocidade;
        this.saude = saude;
        this.percepcao = percepcao;
    }
    public void setPercepcao(int p) {
        this.percepcao = p;
    }
    public void setTemBastao() {
        this.temBastao = true;
    }
    public boolean getTemBastao() {
        return this.temBastao;
    }
    public void acharDardos(int quantidadeDardos) {
        this.armaDardos = this.armaDardos + quantidadeDardos;
    }

    public int getArmaDardos() {
        return this.armaDardos;
    }
    public int usarArmaDardos(){
        if (this.armaDardos > 0){
            this.armaDardos--;
            return Macros.DANO_DARDOS;
        }
        else {
            System.out.println("Você não possui dardos para usar.");
            return 0;
        }
    }

    public void setPosicaoX(int posicaoX) {
        this.posicaoX = posicaoX;
    }
    public void setPosicaoY(int posicaoY) {
        this.posicaoY = posicaoY;
    }
    public int getPosicaoX() {
        return posicaoX;
    }
    public int getPosicaoY() {
        return posicaoY;
    }

    public int getKitsMedicos() {
        return this.kitsMedicos;
    }
    public void acharKitsMedicos() {
        this.kitsMedicos = this.kitsMedicos + 1;
    }
    public void curar() {
        if (kitsMedicos > 0) {
            kitsMedicos--;
            this.saude = Macros.SAUDE_JOGADOR;
        }
        else {
            System.out.println("Você não possui kits médicos para usar.");
        }
    }

}
