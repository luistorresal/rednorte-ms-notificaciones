# RedNorte MS Notificaciones

Microservicio consumidor de eventos Kafka para el caso semestral RedNorte.

## Objetivo

Escuchar eventos de citas creadas publicados por `rednorte-ms-citas` en el topic `citas.creadas`.

## Requisitos

- Java 21+
- Maven Wrapper (`mvnw.cmd`)
- Kafka corriendo en `localhost:9092`

## Levantar Kafka

Desde la carpeta `C:/Users/syste/Downloads/kafka/kafka`:

```bash
docker compose up -d
```

## Ejecucion local

Desde la carpeta del proyecto:

```bash
./mvnw.cmd spring-boot:run
```

El servicio corre en puerto `8086`.

## Configuracion

Archivo: `src/main/resources/application.properties`

- `spring.kafka.bootstrap-servers=localhost:9092`
- `spring.kafka.consumer.group-id=notificaciones-group`
- Topic escuchado: `citas.creadas`

## Prueba funcional

1. Levantar Kafka.
2. Levantar `rednorte-ms-notificaciones`.
3. Levantar `rednorte-ms-citas`.
4. Crear una cita desde frontend.
5. Ver consola de notificaciones:

```text
[ms-notificaciones] Evento de cita recibida: ...
```
