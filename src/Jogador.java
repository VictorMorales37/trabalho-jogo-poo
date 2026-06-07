public class Jogador extends Personagem{
    private int percepcao;
    private int armaDardos = 0;
    private int kitsMedicos = 0;
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
        this.armaDardos = this.armaDardos + quantidadeDardos;
    }
    public int getArmaDardos(){
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

    public int getKitsMedicos(){
        return this.kitsMedicos;
    }
    public void acharKitsMedicos(){
        this.kitsMedicos = this.kitsMedicos + 1;
    }
    public void curar(){
        if ( kitsMedicos > 0) {
            kitsMedicos--;
            this.saude = Macros.SAUDE_JOGADOR;
        }
        else{
            System.out.println("Você não possui kits médicos para usar.");
        }
    }

}
