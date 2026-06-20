package input;

import movimentacao.Direcao;

import java.util.Scanner;

public class LeitorDeInput {
    private final Scanner scanner;

    public LeitorDeInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public Direcao lerInput() {
        int input = scanner.nextInt();
        return switch (input) {
            case 1 -> Direcao.CIMA;
            case 2 -> Direcao.ESQUERDA;
            case 3 -> Direcao.DIREITA;
            case 4 -> Direcao.BAIXO;
            default -> Direcao.INVALIDA;
        };
    }
}
