
package com.quantumscript.helloWorld;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Platos {
    
    private Long idPlato;
    private String tipoComida;

    public Platos(Long idPlato, String tipoComida) {
        this.idPlato = idPlato;
        this.tipoComida = tipoComida;
    }

    public Platos() {
    }
    
    
    
}
