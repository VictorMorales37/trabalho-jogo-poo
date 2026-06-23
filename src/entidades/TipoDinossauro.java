package entidades;

import util.Macros;

public enum TipoDinossauro {
    COMPSOGNATO(Macros.SIMB_COMPSOGNATO, Macros.SAUDE_COMPSOGNATO, Macros.VEL_COMPSOGNATO),
    TROODONTE(Macros.SIMB_TROODONTE, Macros.SAUDE_TROODONTE, Macros.VEL_TROODONTE),
    VELOCIRAPTOR(Macros.SIMB_VELOCIRAPTOR, Macros.SAUDE_VELOCIRAPTOR, Macros.VEL_VELOCIRAPTOR),
    TREX(Macros.SIMB_TREX, Macros.SAUDE_TREX, 0);

    public final char simbolo;
    public final int saude;
    public final int velocidade;

    TipoDinossauro(char simbolo, int saude, int velocidade) {
        this.simbolo = simbolo;
        this.saude = saude;
        this.velocidade = velocidade;
    }
}