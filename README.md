# DEMO-KAFKA-CONSUMER

demo-consumer-kafka es una cápsula de conocimiento para entender cómo se configura un listener que escucha un topico en kafka. En este caso, se hace mediante un listener que recibe un DTO Cliente y lo guarda en una base de datos PostgreSQL.

## CONFIGURACIÓN PREVIA

Para iniciar la aplicación, debes ir a la carpeta /docker-compose y ejecutar el siguiente comando, en caso de que no se haya ejecutado antes. Se requiere previamente haber instalado Docker (se recomienda Rancher Desktop por la licencia):

```
docker-compose up -d
```

En caso de querer otro modelo en la base de datos, debes modificar el archivo DDL_DEMO_KAFKA.sql según tus necesidades.

Podrás validar si la base de datos PostgreSQL y Kafka se han levantado correctamente con los siguientes datos:

```
postgres:

host: http://localhost:5432
user: postgres
password: postgres
database: kafka-demo

kafka (usando consola web):

http://localhost:9090/
```

Una vez configurado, puedes probar la aplicación haciendo uso de API expuesta en por la aplicación demo-kafka-producer:

```
path:
http://localhost:8080/api/v1/client

body:
{
    "name":"pepito",
    "last_name":"perez",
    "password":"123456789",
    "email":"pepito.perez@pragma.com.co"
}
```


El listener recibirá el cliente y lo almacenará en la base de datos.

En la consola web de Kafka podrás ver los tópicos y los consumidores suscritos a ese tópico.

# REQUERIMIENTOS

<ol>
    <li>Java JDK 17</li>
    <li>Maven LastVersion</li>
</ol>

# PARA EJECUTAR LA APLICACIÓN

```
cd existing_repo
mvn spring-boot:run

or

usar IDE de preferencia

```
