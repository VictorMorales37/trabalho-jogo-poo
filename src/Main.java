import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcao = 0;
        Tabuleiro t = new Tabuleiro();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecione Dificuldade:");
        System.out.println("1- Facil");
        System.out.println("2- Médio");
        System.out.println("3- Difícil");
        int dificuldade = scanner.nextInt();

        while (opcao != 2) {

            System.out.println("Menu:\n");

            System.out.println("1- Movimentar");
            System.out.println("2- Sair");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    t.mostrarTabuleiro();
                    break;

                case 2:
                    scanner.close();
                    break;
            }
        }


    }
}



// scanner.nextInt();      // int
// scanner.nextDouble();   // double
// scanner.next();         // uma palavra
// scanner.nextLine();     // uma linha inteira
// scanner.nextBoolean();  // boolean