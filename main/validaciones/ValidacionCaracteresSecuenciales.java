package ar.edu.utn.frba.dds.validadorDeContrasenia.validaciones;

public class ValidacionCaracteresSecuenciales extends ValidacionCaracteresConsecutivos{

    @Override
    public boolean criterioDeDescarte(char caracterA, char caracterB) {
        return caracterA == (char) (caracterB - 1) || caracterA == (char) (caracterB + 1);
    }
}
