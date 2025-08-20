package ar.edu.utn.frba.dds.validadorTest;

import ValidadorDeContrasenias.validaciones.*;
import ValidadorDeContrasenias.validador.ValidadorDeContrasenia;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidadorTest {

  private ValidadorDeContrasenia validador;

  @BeforeEach
  void setUp() {
    String pathArchivoPeoresContrasenias = "src/main/java/ValidadorDeContrasenias/resources/10k-worst-passwords.txt";
    this.validador = new ValidadorDeContrasenia();
    this.validador.addValidacion(new ValidacionDeSeguridad(pathArchivoPeoresContrasenias));
    this.validador.addValidacion(new ValidacionPoliticaLongitud());
    this.validador.addValidacion(new ValidacionCaracteresRepetidos());
    this.validador.addValidacion(new ValidacionCaracteresSecuenciales());
  }

  @Test
  @DisplayName("La contraseña es una de las 10k peores contraseñas")
  public void laContraseniaNoEsSegura() {
    Assertions.assertFalse(this.validador.validarContrasenia("letmein"));
  }

  @Test
  public void laContraseniaNoTieneRepeticiones() {
    Assertions.assertTrue(this.validador.validarContrasenia("asjoer1369palo"));
  }

  @Test
  @DisplayName("Cumple seguridad pero contiene repeticion de letras")
  public void laContraseniaTieneRepeticiones() {
    Assertions.assertFalse(this.validador.validarContrasenia("AAassjoer13679palo"));
  }

  @Test
  @DisplayName("Cumple seguridad pero no alcanza la longitud mínima requerida (8)"
      + " espacios simples cuentan como caracter")
  public void laContraseniaEsCorta() {
    Assertions.assertFalse(this.validador.validarContrasenia("d5.CR06"));
  }

  @Test
  @DisplayName("Cumple seguridad y alcanza 9 caracteres de largo")
  public void contraseniaValidaConEspacios() {
    Assertions.assertTrue(this.validador.validarContrasenia("f i t r y"));
  }

  @Test
  @DisplayName("Cumple seguridad y los espacios consecutivos cuentan como 1")
  public void contraseniaNoValidaConEspacios() {
    Assertions.assertFalse(this.validador.validarContrasenia("f  i     try"));
  }

  @Test
  @DisplayName("Cumple todo")
  public void laContraseniaNoTieneSecuencia() {
    Assertions.assertTrue(this.validador.validarContrasenia("acte3g5i94k"));
  }

  @Test
  @DisplayName("Cumple seguridad pero contiene secuencia de letras")
  public void laContraseniaTieneSecuencia() {
    Assertions.assertFalse(this.validador.validarContrasenia("abcdefghijk"));
  }

  @Test
  @DisplayName("Cumple segurdad y políticas")
  public void contraseniaSegura() {
    Assertions.assertTrue(this.validador.validarContrasenia("q$tY%-1pJ0?p8n"));
  }
}
