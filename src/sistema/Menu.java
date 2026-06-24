package sistema;
import sistema.movimentacao.ResultadoMovimento;
import entidades.Jogador;

public class Menu {
    public void menuPrincipal() {
        System.out.println("1- Movimentar");
        System.out.println("2- Sair");
    }
    public void escolherDificuldade() {
        System.out.println("Bem vindo, Jogador!");
        System.out.println("Selecione Dificuldade:");
        System.out.println("1- Fácil");
        System.out.println("2- Médio");
        System.out.println("3- Difícil");
    }
    public void mostrarTabuleiro(Tabuleiro t, Jogador j) {
        for (int x = 0; x < t.getDimensao(); x++) {
            for (int y = 0; y < t.getDimensao(); y++) {
                System.out.print(t.getGrid()[x][y] + " ");
            }
            System.out.println();
        }
    }
    public void opcoesMovimento() {
        System.out.println("1 - ^");
        System.out.println("2 - <");
        System.out.println("3 - >");
        System.out.println("4 - v");
        System.out.println("5 - Voltar");
    }
    public void opcoesCombate() {
        System.out.println("Escolha opção de ação:");
        System.out.println("1- Atacar com as Mãos");
        System.out.println("2- Atacar com Bastão");
        System.out.println("3- Atacar com Dardos");
        System.out.println("4- Curar");
        System.out.println("5- Fugir do combate");
    }

    public void avisoMovimento(ResultadoMovimento resultado) {
        if ( resultado == ResultadoMovimento.BLOQUEADO){
            System.out.println("Movimento não permitido");
        }
        else if (resultado == ResultadoMovimento.ENCONTROU_COMPSOGNATO){
            System.out.println("Encontrou compsognato!");
        }
        else if (resultado == ResultadoMovimento.ENCONTROU_TROODONTE){
            System.out.println("Encontrou troodonte!");
        }
        else if (resultado == ResultadoMovimento.ENCONTROU_VELOCIRAPTOR){
            System.out.println("Encontrou velociraptor!");
        }
        else if (resultado == ResultadoMovimento.ENCONTROU_TREX){
            System.out.println("Encontrou Tiranossauro Rex!");
        }
    }
}
