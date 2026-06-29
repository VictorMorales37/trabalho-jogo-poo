package Sistema;

import Entidades.*;
import Entidades.Dinossauros.*;
import Util.Macros;

import java.util.ArrayList;
import java.util.Random;

public class Spawner {

    private final Random random;

    public Spawner() {
        this.random = new Random();
    }

    public Jogador spawnJogador(Tabuleiro t) {
        Jogador j = new Jogador(Macros.SIMB_JOGADOR, Macros.SAUDE_JOGADOR, Macros.PERCEPCAO_INICIAL);
        while (!t.verificarPosicao(j.getPosicaoX(), j.getPosicaoY())) {
            j.setPosicaoX(random.nextInt(Macros.TAMANHO_TABULEIRO));
            j.setPosicaoY(random.nextInt(Macros.TAMANHO_TABULEIRO));
        }
        t.setPosicoesOcupadas(j.getPosicaoX(), j.getPosicaoY());
        return j;
    }

    private Dinossauro spawnDinossauro(Tabuleiro t, TipoDinossauro tipo) {
        Dinossauro d = switch (tipo) {
            case COMPSOGNATO -> new Compsognato();
            case TROODONTE   -> new Troodonte();
            case VELOCIRAPTOR -> new Velociraptor();
            case TREX        -> new TiranossauroRex();
        };

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

    public void spawnCaixas(Tabuleiro t, ArrayList<Caixa> caixas) {
        TipoCaixa[] tipos = {
                TipoCaixa.KIT_MEDICO,
                TipoCaixa.BASTAO,
                TipoCaixa.ARMA_DARDOS,
                TipoCaixa.COMPSOGNATO_SURPRESA
        };

        for (TipoCaixa tipo : tipos) {
            Caixa c = new Caixa(tipo);
            do {
                c.setPosicaoX(random.nextInt(Macros.TAMANHO_TABULEIRO));
                c.setPosicaoY(random.nextInt(Macros.TAMANHO_TABULEIRO));
            } while (!t.verificarPosicao(c.getPosicaoX(), c.getPosicaoY()));

            t.setPosicoesOcupadas(c.getPosicaoX(), c.getPosicaoY());
            caixas.add(c);
        }
    }

    public void spawnParedes(Tabuleiro t) {
        int numSegmentos = (int)(Macros.TAMANHO_TABULEIRO * 0.5);

        for (int i = 0; i < numSegmentos; i++) {
            int tamanho = 3 + random.nextInt(3);
            boolean vertical = random.nextBoolean();
            int x = random.nextInt(Macros.TAMANHO_TABULEIRO);
            int y = random.nextInt(Macros.TAMANHO_TABULEIRO);

            for (int j = 0; j < tamanho; j++) {
                int px = vertical ? x + j : x;
                int py = vertical ? y : y + j;
                if (px < Macros.TAMANHO_TABULEIRO && py < Macros.TAMANHO_TABULEIRO
                        && t.verificarPosicao(px, py)) {
                    t.setPosicoesOcupadas(px, py);
                    t.getParedes().add(new int[]{px, py});
                }
            }
        }
    }
}
