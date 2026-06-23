package sistema;

import entidades.*;
import util.Macros;

import java.util.ArrayList;
import java.util.Random;

public class Spawner {

    private final Random random;

    public Spawner() {
        this.random = new Random();
    }

    public Jogador spawnJogador(Tabuleiro t) {
        Jogador j = new Jogador(Macros.SIMB_JOGADOR, Macros.VEL_JOGADOR, Macros.SAUDE_JOGADOR, Macros.PERCEPCAO_INICIAL);
        while (!t.verificarPosicao(j.getPosicaoX(), j.getPosicaoY())) {
            j.setPosicaoX(random.nextInt(Macros.TAMANHO_TABULEIRO));
            j.setPosicaoY(random.nextInt(Macros.TAMANHO_TABULEIRO));
        }
        t.setPosicoesOcupadas(j.getPosicaoX(), j.getPosicaoY());
        return j;
    }

    private Dinossauro spawnDinossauro(Tabuleiro t, TipoDinossauro tipo) {
        Dinossauro d = new Dinossauro(tipo.simbolo, tipo.saude, tipo.velocidade);

        while (!t.verificarPosicao(d.getPosicaoX(), d.getPosicaoY())) {
            d.setPosicaoX(random.nextInt(Macros.TAMANHO_TABULEIRO));
            d.setPosicaoY(random.nextInt(Macros.TAMANHO_TABULEIRO));
        }

        t.setPosicoesOcupadas(d.getPosicaoX(), d.getPosicaoY());

        return d;
    }

    public void spawnDinossauros(Tabuleiro t, ArrayList<Dinossauro> dinos) {
        for (int i = 0; i < Macros.NUM_COMPSOGNATO; i++) {
            dinos.add(spawnDinossauro(t, TipoDinossauro.COMPSOGNATO));
        }
        for (int i = 0; i < Macros.NUM_TROODONTE; i++) {
            dinos.add(spawnDinossauro(t, TipoDinossauro.TROODONTE));
        }
        for (int i = 0; i < Macros.NUM_VELOCIRAPTOR; i++) {
            dinos.add(spawnDinossauro(t, TipoDinossauro.VELOCIRAPTOR));
        }
        for (int i = 0; i < Macros.NUM_TREX; i++) {
            dinos.add(spawnDinossauro(t, TipoDinossauro.TREX));
        }
    }
}
