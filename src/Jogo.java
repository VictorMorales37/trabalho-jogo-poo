import java.util.Scanner;

public class Jogo {

    private Scanner scanner;

    public Jogo(Scanner scanner) {
        this.scanner = scanner;
    }

    public void jogar() {
        int opcao = 0;

        Tabuleiro t = new Tabuleiro();
        System.out.println("Bem vindo, Jogador!");
        System.out.println("Selecione Dificuldade:");
        System.out.println("1- Fácil");
        System.out.println("2- Médio");
        System.out.println("3- Difícil");

        int dificuldade = scanner.nextInt();

        Jogador j = new Jogador(t, 5, 1, 4 - dificuldade);

        while (opcao != 2) {
            System.out.println("1- Movimentar");
            System.out.println("2- Sair");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    t.mostrarTabuleiro();
                    break;
                case 2:
                    return;
            }

            // Exemplo:
            if (j.getVidaRestante() < 1) {
                return;
            }
        }
    }
}