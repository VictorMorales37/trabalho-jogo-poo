package sistema;
import entidades.Jogador;
import util.Macros;
import java.util.Random;

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
    /* AAAAAAAAAAAA (aqui falta implementar muita coisa -> resultado movimento virar um dinossauro especifico do mapa)
     *
     *    public void comecarCombate(ResultadoMovimento resultadoMovimento) {
     *        Dinossauro alvo = encontrarDinossauroPorResultado(resultadoMovimento);
     *        if (alvo == null) return;
     *
     *        executarCombate(jogador, alvo);
     *    }
     */

    /*
        private void executarCombate(Jogador jogador, Dinossauro alvo) {
            while (jogador.getSaude() > 0 && alvo.getSaude() > 0) {

                menu.opcoesCombate(); // 1 - mão | 2 - bastão | 3 - dardos | 4 - curar | 5 - fugir
                leitorDeInput.input = leitorDeInput.lerInput(1, 5);

                int dano = switch (leitorDeInput.input) {
                    case 1 -> sistemaCombate.atacarMao();
                    case 2 -> sistemaCombate.atacarBastao(jogador);
                    case 3 -> sistemaCombate.atacarArmaDardos(jogador);
                    case 4 -> { sistemaCombate.curar(jogador); yield 0; } // yield é o return do switch
                    case 5 -> { sistemaCombate.fugir; yied 0 }
                    default -> 0;
                };

                alvo.setSaude(alvo.getSaude() - dano);
                // combate com dinossauro Rex é diferente
                if (!passouTestePercepcao(jogador)) { jogador.setSaude(jogador.getSaude() - 1); }
            }
            // Falta implementar:
            // remover os dinossauros do mapa e mover o jogador
            // combate com dinossauro Rex
            //

        }
     */
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
}