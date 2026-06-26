package sistema;
import sistema.movimentacao.Direcao;
import sistema.movimentacao.ResultadoMovimento;
import entidades.Dinossauro;
import entidades.Jogador;
import sistema.movimentacao.SistemaMovimento;
import java.util.ArrayList;
import util.Macros;
import java.util.Random;
import java.util.Scanner;


public class SistemaCombate {
    private static final Random RANDOM = new Random();
    // ----------------------------- ataque -----------------------------
    public int atacarMao(){
        int acerto = RANDOM.nextInt(6) + 1;

        if (acerto == 6){ // crítico
            return 2;
        }
        else if (acerto == 1 || acerto == 2){ // falha
            return 0;
        }
        else{
            return 1;
        }
    }
    public int atacarBastao(Jogador j) {
        if (j.getTemBastao()){
            int acerto = RANDOM.nextInt(6) + 1;
            if (acerto == 6){ // crítico
                return 2;
            }
            else if (acerto == 1){ // falha
                return 0;
            }
            else{
                return 1;
            }
        } else {
            System.out.println("Você ainda não tem bastão.");
            return 0;
        }
    }
    public int atacarArmaDardos(Jogador j){
        if (j.getArmaDardos() > 0){
            j.setArmaDardos(j.getArmaDardos() - 1);
            return Macros.DANO_DARDOS;
        }
        else {
            System.out.println("Você não possui dardos para usar.");
            return 0;
        }
    }
    public Dinossauro encontrarDinossauro(int x, int y, ArrayList<Dinossauro> dinos) {
        for (Dinossauro d : dinos) {
            if (d.getPosicaoX() == x && d.getPosicaoY() == y) {
                return d;
            }
        }
        return null;
    }

    public ResultadoCombate comecarCombate(Jogador jogador, Direcao direcao, ArrayList<Dinossauro> dinos, Tabuleiro tabuleiro, Scanner scanner) {
        int alvoX = jogador.getPosicaoX() + direcao.dx;
        int alvoY = jogador.getPosicaoY() + direcao.dy;

        Dinossauro alvo = encontrarDinossauro(alvoX, alvoY, dinos);
        if (alvo == null) return null;

        return executarCombate(jogador, alvo, tabuleiro, scanner);
    }

    public ResultadoCombate executarCombate(Jogador jogador, Dinossauro alvo, Tabuleiro tabuleiro ,Scanner scanner) {
        Menu menu = new Menu();
        LeitorDeInput leitorDeInput = new LeitorDeInput(scanner);

        while (jogador.getSaude() > 0 && alvo.getSaude() > 0) {
            menu.opcoesCombate(jogador); // 1 - mão | 2 - bastão | 3 - dardos | 4 - curar | 5 - fugir
            int input = leitorDeInput.lerInput(1, 5);

            int dano = switch (input) {
                case 1:
                    if (alvo.getSimbolo() == Macros.SIMB_TREX) {
                        System.out.println("Não é possível atacar o T-Rex sem armas!");
                        yield 0;
                    }
                    yield atacarMao();

                case 2:
                    yield atacarBastao(jogador);

                case 3:
                    if (alvo.getSimbolo() == Macros.SIMB_VELOCIRAPTOR) {
                        yield 0;
                    }
                    yield atacarArmaDardos(jogador);

                case 4:
                    curar(jogador); yield 0;

                case 5:
                    fugir(jogador, tabuleiro); yield -1;

                default:
                    yield 0;
            };

            // ------------------------------ dano do ataque do jogador ------------------------------

            if (dano == 0){
                System.out.println("Ataque falhou");
            }
            else if ( dano == -1 ){
                System.out.println("Voce fugiu");
                return ResultadoCombate.FUGIU;
            }
            else{
                System.out.println("Voce atacou o dinossauro");
                System.out.println("Ele recebeu " + dano + " de dano\n");
            }

            alvo.setSaude(alvo.getSaude() - dano);
            if (alvo.getSaude() <= 0){
                System.out.println("Voce derrotou o dinossauro!");
                return ResultadoCombate.VENCEU;
            }

            // ------------------------------ ataque do dinossauro ------------------------------
            System.out.println("Cuidado!");
            System.out.println("O dinossauro está tentando te atacar...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            boolean passouTestePercepcao = passouTestePercepcao(jogador);
            if ( passouTestePercepcao ){
                System.out.println("Voce conseguiu desviar.");
            }
            if (!passouTestePercepcao && alvo.getSimbolo() == Macros.SIMB_TREX) {
                System.out.println("T-REX TE ATACOU!!!");
                jogador.setSaude(jogador.getSaude() - 4);
            }
            else if (!passouTestePercepcao) {
                System.out.println("O dinossauro te atacou!");
                jogador.setSaude(jogador.getSaude() - 1);
            }


            if ( jogador.getSaude() <= 0){
                System.out.println("Voce morreu!");
                return ResultadoCombate.PERDEU;
            }

        }
        return null;
    }

    // ----------------------------- cura -----------------------------
    public void acharKitsMedicos(Jogador j) {
        j.setKitsMedicos(j.getKitsMedicos() + 1);
    }

    public void curar(Jogador j) {
        if (j.getKitsMedicos() > 0) {
            j.setKitsMedicos(j.getKitsMedicos() - 1);
            j.setSaude(Macros.SAUDE_JOGADOR);
        }
        else {
            System.out.println("Você não possui kits médicos para usar.");
        }
    }
    // ----------------------------- teste percepção -----------------------------

    public boolean passouTestePercepcao(Jogador j) {
        int dado = RANDOM.nextInt(3) + 1;
        return dado <= j.getPercepcao();
    }

    // ----------------------------- fugir -----------------------------
    public void fugir(Jogador jogador, Tabuleiro tabuleiro) {
        SistemaMovimento sistemaMovimento = new SistemaMovimento(tabuleiro.getGrid());
        ResultadoMovimento tentativaFuga = ResultadoMovimento.BLOQUEADO;
        Direcao[] direcoes = {Direcao.CIMA, Direcao.BAIXO, Direcao.ESQUERDA, Direcao.DIREITA};

        while (tentativaFuga != ResultadoMovimento.LIVRE) {
            Direcao direcaoAleatoria = direcoes[RANDOM.nextInt(direcoes.length)];
            tentativaFuga = sistemaMovimento.moverJogador(jogador, direcaoAleatoria);
        }
    }
}