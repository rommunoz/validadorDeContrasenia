package ar.edu.utn.frba.dds.validadorDeContrasenia.validaciones;

import lombok.Getter;
import lombok.Setter;

public class ValidacionPoliticaLongitud implements Validacion {
    @Getter
    @Setter
    private static Integer longitudMinima = 8;
    @Override
    public boolean validarContrasenia(String contrasenia) {
        String contraseniaSinMasDeUnEspacio = contrasenia.replaceAll("\\s{2,}", " ");
        if (contraseniaSinMasDeUnEspacio.length() < longitudMinima) {
            System.out.print("La longitud de caracteres sin espacios consecutivos no supera la longitud requerida: " + longitudMinima.toString());
            return false;
        }
        return true;
    }
}
