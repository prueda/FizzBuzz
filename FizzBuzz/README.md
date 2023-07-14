# Solución
Se creó una clase controller para el manejo de solicitudes HTTP, una clase para representar la respuesta JSON. 
Se creó el servicio donde está toda la funcionalidad o la lógica de este ejercicio que devuelve la fizzbuzz list.
Se creó el repository encargado de realizar las operaciones de persistencia.
Se crearon 3 functional tests usando mockito, para simular el servicio.

Se creó una base de datos en Mysql.

# Create table
```query
CREATE TABLE `fizz_buzz` (
`TIMESTAMP` timestamp NOT NULL,
`CODE` int NOT NULL AUTO_INCREMENT,
`DESCRIPTION` varchar(45) DEFAULT NULL,
`LIST` varchar(100) DEFAULT NULL,
`STATUS` int DEFAULT NULL,
`ERROR` varchar(45) DEFAULT NULL,
`EXCEPTION` varchar(45) DEFAULT NULL,
`MESSAGE` varchar(45) DEFAULT NULL,
`PATH` varchar(45) DEFAULT NULL,
PRIMARY KEY (`CODE`),
UNIQUE KEY `CODE_UNIQUE` (`CODE`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
```
