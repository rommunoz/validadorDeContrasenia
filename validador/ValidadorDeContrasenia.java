package ar.edu.utn.frba.dds.validadorDeContrasenia.validador;

import ar.edu.utn.frba.dds.validadorDeContrasenia.validaciones.Validacion;
import lombok.Getter;
import java.util.*;

@Getter
public class ValidadorDeContrasenia {
    private List<Validacion> validaciones;

    public ValidadorDeContrasenia(){
        this.validaciones = new ArrayList<>();
    }

    public void addValidacion(Validacion validacion){
        this.getValidaciones().add(validacion);
    }

    public boolean validarContrasenia(String contrasenia) {
        return this.validaciones.stream().allMatch(v -> v.validarContrasenia(contrasenia));
    }
}