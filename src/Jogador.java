import java.util.Random;
import java.util.Scanner;

public class Jogador {
    public static final Random RANDOM = new Random();
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

    public void mover(Scanner s) {
        int choice = 0;
        System.out.println("1 - ^");
        System.out.println("2 - <");
        System.out.println("3 - >");
        System.out.println("4 - v");

        choice = s.nextInt();
        switch (choice) { // y = colunas      x = linhas
            case 1:
                if (isMoveValid(getPosicaoX() - 1)) {
                    setPosicaoX(getPosicaoX() - 1); // ^
                } else {
                    System.out.println("Movimento não permitido");
                }
                break;
            case 2:
                if (isMoveValid(getPosicaoY() - 1)){
                    setPosicaoY(getPosicaoY() - 1); // <
                } else {
                    System.out.println("Movimento não permitido");
                }
                break;
            case 3:
                if (isMoveValid(getPosicaoY() + 1)){
                    setPosicaoY(getPosicaoY() + 1); // >
                } else {
                    System.out.println("Movimento não permitido");
                }
                break;
            case 4:
                if (isMoveValid(getPosicaoX() + 1)){
                    setPosicaoX(getPosicaoX() + 1); // v
                } else {
                    System.out.println("Movimento não permitido");
                }
                break;
        }
    }

    public boolean isMoveValid(int num){
        return !(num < 0 || num >= Macros.TAMANHO_TABULEIRO);
    }

    // ----------------------------- ataque -----------------------------

    public int atacarMao(){
        int acerto = RANDOM.nextInt(6) + 1;

        if (acerto == 6){ // crítico
            return 2;
        }
        else if (acerto == 1 || acerto == 2){ // falha
            return 0;
        }
        else{
            return 1;
        }
    }

    public int atacarBastao() {
        if (this.temBastao){
            int acerto = RANDOM.nextInt(6) + 1;
            if (acerto == 6){ // crítico
                return 2;
            }
            else if (acerto == 1){ // falha
                return 0;
            }
            else{
                return 1;
            }
        } else {
            System.out.println("Você ainda não tem bastão.");
            return 0;
        }
    }
    public void acharBastao(){
        this.temBastao = true;
    }
    public boolean temBastao(){
        return this.temBastao;
    }

    public void acharDardos(int quantidadeDardos) {
        this.armaDardos = this.armaDardos + quantidadeDardos;
    }
    public int quantidadeArmaDardos() {
        return this.armaDardos;
    }
    public int atacarArmaDardos(){
        if (this.armaDardos > 0){
            this.armaDardos--;
            return Macros.DANO_DARDOS;
        }
        else {
            System.out.println("Você não possui dardos para usar.");
            return 0;
        }
    }

    // ----------------------------- cura -----------------------------

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
            System.out.println("Você não possui kits médicos para usar.");
        }
        else {
            System.out.println("Você não possui kits médicos para usar.");
        }
    }
}
