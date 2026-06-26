package entidades;

public class Jogador implements Entidade {
    private final char simbolo;
    private int saude;
    private int posicaoX;
    private int posicaoY;

    private int percepcao;
    private int armaDardos;
    private int kitsMedicos;
    private boolean temBastao = false;

    public Jogador(char simbolo, int velocidade, int saude, int percepcao) {
        armaDardos = 0;
        kitsMedicos = 0;
        this.simbolo = simbolo;
        this.saude = saude;
        this.percepcao = percepcao;
        posicaoX = -1;
        posicaoY = -1;
    }

    // ---------------------------- Override da interface ----------------------------
    @Override
    public void setPosicaoX(int x) {
        posicaoX = x;
    }

    @Override
    public void setPosicaoY(int y) {
        posicaoY = y;
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
    public void setSaude(int saude){
        this.saude = saude;
    }

    @Override
    public char getSimbolo(){
        return simbolo;
    }

    // ---------------------------- metodos do combate ----------------------------

    public void setTemBastao() {
        temBastao = true;
    }

    public boolean getTemBastao() {
        return temBastao;
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


    // ---------------------------- outros metodos ----------------------------

    public void setPercepcao(int p) {
        percepcao = p;
    }

    public int getPercepcao() {
        return percepcao;
    }
}
