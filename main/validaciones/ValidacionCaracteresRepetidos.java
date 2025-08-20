package ar.edu.utn.frba.dds.validadorDeContrasenia.validaciones;

public class ValidacionCaracteresRepetidos extends ValidacionCaracteresConsecutivos{
    @Override
    public boolean criterioDeDescarte(char caracterA, char caracterB) {
        return caracterA == caracterB;
    }
}
