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
}