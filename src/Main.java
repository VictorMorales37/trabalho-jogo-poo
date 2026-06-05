import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean jogarNovamente = true;

        while (jogarNovamente) {

            Jogo jogo = new Jogo(scanner);
            jogo.jogar();

            System.out.println("Jogar novamente?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");

            int resposta = scanner.nextInt();

            jogarNovamente = (resposta == 1);
        }

        scanner.close();
    }
}