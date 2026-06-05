public class Compsognato extends Personagem {

    public Compsognato(Tabuleiro tabuleiro, int vida, int dano) {
        super(tabuleiro, 1, dano);
    }

    public void Movimento(int x, int y) {
        switch (RANDOM.nextInt(5)) {
            case 1:
                this.posicaoX++;
                break;
            case 2:
                this.posicaoX--;
                break;
            case 3:
                this.posicaoY++;
                break;
            case 4:
                this.posicaoY++;
                break;
        }
    }
}
