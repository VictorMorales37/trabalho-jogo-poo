package sistema;

import entidades.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SistemaItens {
    private final SistemaCombate sistemaCombate;

    public SistemaItens(SistemaCombate sistemaCombate) {
        this.sistemaCombate = sistemaCombate;
    }

    public void abrirCaixa(Jogador jogador, Caixa caixa, ArrayList<Dinossauro> dinossauros, Tabuleiro tabuleiro, Scanner scanner) {
        if (caixa == null) {
            return;
        }
        else if (caixa.getTipo() == TipoCaixa.KIT_MEDICO) {
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
            Dinossauro surpresa = new Dinossauro(TipoDinossauro.COMPSOGNATO.simbolo,
                    TipoDinossauro.COMPSOGNATO.saude,
                    TipoDinossauro.COMPSOGNATO.velocidade);
            surpresa.setPosicaoX(caixa.getPosicaoX());
            surpresa.setPosicaoY(caixa.getPosicaoY());
            dinossauros.add(surpresa);
            sistemaCombate.executarCombate(jogador, surpresa, tabuleiro, scanner);
        }
    }
}