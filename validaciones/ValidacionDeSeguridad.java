package ar.edu.utn.frba.dds.validadorDeContrasenia.validaciones;

import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class ValidacionDeSeguridad implements Validacion {
    @Getter
    @Setter
    private String pathArchivo;
    private ArrayList<String> archivoEnArray;

    public ValidacionDeSeguridad(String pathArchivo){
        this.pathArchivo = pathArchivo;
        this.archivoEnArray = new ArrayList<>();
    }

    public boolean validarContrasenia(String contrasenia){
        if (this.archivoEnArray.isEmpty()) {
            File archivo = new File(this.pathArchivo);
            try {
                this.cargarEnArray(archivo);
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
                exit(-1);
            }
        }
        return ! this.archivoEnArray.contains(contrasenia);
    }

    private void cargarEnArray(File archivo) throws FileNotFoundException {
        Scanner scanner = new Scanner(archivo);
        String linea = scanner.nextLine();
        while (scanner.hasNextLine()) {
            this.archivoEnArray.add(linea);
            linea = scanner.nextLine() ;
        }
    }
}
