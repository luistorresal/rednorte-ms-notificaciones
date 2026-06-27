package com.rednorte.notificaciones.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @KafkaListener(topics = "citas.creadas", groupId = "notificaciones-group")
    public void consumir(String mensaje) {
        System.out.println("[ms-notificaciones] Evento de cita recibida: " + mensaje);
    }
}
