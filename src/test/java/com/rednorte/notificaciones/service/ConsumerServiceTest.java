package com.rednorte.notificaciones.service;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class ConsumerServiceTest {

  @Test
  void consumir_imprimeMensajeEnConsola() {
    ConsumerService consumerService = new ConsumerService();
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(output));

    try {
      consumerService.consumir("citaId=1,pacienteId=10");

      assertThat(output.toString())
          .contains("[ms-notificaciones] Evento de cita recibida:")
          .contains("citaId=1,pacienteId=10");
    } finally {
      System.setOut(originalOut);
    }
  }
}
