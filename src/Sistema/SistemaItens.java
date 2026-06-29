package Sistema;

import Entidades.*;
import Entidades.Dinossauros.Compsognato;
import Entidades.Dinossauros.Dinossauro;

import java.util.ArrayList;

public class SistemaItens {
    private final SistemaCombate sistemaCombate;

    public SistemaItens(SistemaCombate sistemaCombate) {
        this.sistemaCombate = sistemaCombate;
    }

    public TipoCaixa abrirCaixa(Jogador jogador, Caixa caixa, ArrayList<Dinossauro> dinossauros,
                           Tabuleiro tabuleiro, Menu menu, LeitorDeInput leitorDeInput) {

        if (caixa.getTipo() == TipoCaixa.KIT_MEDICO) {
            System.out.println("Você encontrou Kit Médico");
            jogador.setKitsMedicos(jogador.getKitsMedicos() + 1);
        }
        else if (caixa.getTipo() == TipoCaixa.BASTAO) {
            System.out.println("Você encontrou Bastão");
            jogador.setTemBastao();
        }
        else if (caixa.getTipo() == TipoCaixa.ARMA_DARDOS) {
            System.out.println("Você encontrou munição para arma de dardos");
            jogador.setArmaDardos(jogador.getArmaDardos() + 1);
        }
        else if (caixa.getTipo() == TipoCaixa.COMPSOGNATO_SURPRESA) {
            System.out.println("Cuidado! Um compsognato estava atrás da caixa");
        }
        return caixa.getTipo();
    }
}