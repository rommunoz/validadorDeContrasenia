package ar.edu.utn.frba.dds.validadorDeContrasenia.validaciones;

public abstract class ValidacionCaracteresConsecutivos implements Validacion {
    @Override
    public boolean validarContrasenia(String contrasenia){
        char caracterA = contrasenia.charAt(0);
        char caracterB = contrasenia.charAt(1);
        for (int i = 2; i < contrasenia.length(); i++) {
            if(this.criterioDeDescarte(caracterA, caracterB)) return false;
            caracterA = caracterB;
            caracterB = contrasenia.charAt(i);
        }
        return true;
    }
    public abstract boolean criterioDeDescarte(char caracterA, char caracterB);//si se cumple, descarta la contrasenia
}
