import java.util.Random;

public class Jogador {
    private char simbolo;
    private int velocidade;
    private int saude;
    private int percepcao;
    private int armaDardos;
    private int kitsMedicos;
    private boolean temBastao = false;
    private int posicaoX;
    private int posicaoY;

    public Jogador(char simbolo, int velocidade, int saude, int percepcao) {
        armaDardos = 0;
        kitsMedicos = 0;
        this.simbolo = simbolo;
        this.velocidade = velocidade;
        this.saude = saude;
        this.percepcao = percepcao;
    }
    public void setPercepcao(int p) {
        percepcao = p;
    }
    public void setPosicaoX(int x) {
        posicaoX = x;
    }
    public void setPosicaoY(int y) {
        posicaoY = y;
    }
    public void setTemBastao() {
        temBastao = true;
    }
    public void setSaude(int saude) {
        this.saude = saude;
    }
    public void setArmaDardos(int armaDardos) {
        this.armaDardos += armaDardos;
    }
    public void setKitsMedicos(int kitsMedicos) {
        this.kitsMedicos = kitsMedicos;
    }
    public int getKitsMedicos() {
        return kitsMedicos;
    }
    public int getArmaDardos() {
        return armaDardos;
    }
    public boolean getTemBastao() {
        return temBastao;
    }
    public int getPosicaoX() {
        return posicaoX;
    }
    public int getPosicaoY() {
        return posicaoY;
    }
}
