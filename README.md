# Gestor de Tareas en Java

Repositorio del proyecto del parcial 3 de Ingeniería de Software II.

**Integrantes:** Mariana Rojas, Sofía Combita y Samuel Felipe Rojas  
**Materia:** Ingeniería de Software II  
**Lenguaje:** Java

## 1. Descripción del proyecto

Aplicación desarrollada en Java para gestionar tareas mediante una arquitectura organizada por paquetes y patrones de diseño.

## 2. Funcionalidades y patrones implementados

### Patrón Prototype
Permite crear copias independientes de plantillas de tareas mediante el método `clonar()`.

### Patrón Strategy
Permite cambiar la forma de ordenar las tareas utilizando diferentes estrategias:

- Ordenar tareas por prioridad.
- Ordenar tareas por título.

### Núcleo del sistema
Contiene las clases principales para representar y gestionar tareas:

- `Tarea`: representa una tarea con título y nivel de prioridad.
- `GestorTareas`: permite agregar tareas y obtenerlas ordenadas.
- `EstrategiaOrdenTareas`: define el comportamiento de ordenamiento.

## 3. Estructura de paquetes

- `main/java/com/gestortareas/nucleo`: clases principales del sistema.
- `main/java/com/gestortareas/estrategias`: implementación del patrón Strategy.
- `main/java/com/gestortareas/patrones`: implementación del patrón Prototype.
- `src/test/java/com/gestortareas`: pruebas unitarias del proyecto.

## 4. Pruebas unitarias

Se utilizan JUnit 5 para verificar el funcionamiento de los patrones implementados.

Las pruebas comprueban:

- La clonación independiente de las plantillas de tareas.
- El ordenamiento de tareas por prioridad.
- El ordenamiento de tareas por título.

**Resultado de ejecución:** 3 pruebas ejecutadas, 0 fallos y 0 errores.

## 5. Compilación y ejecución

El proyecto utiliza Maven para administrar la compilación y las pruebas.

Para ejecutar las pruebas desde la terminal:

```bash
mvn test
```

Para compilar y generar el paquete:

```bash
mvn package
```

## 6. Tecnologías utilizadas

- Java.
- Maven.
- JUnit 5.
- IntelliJ IDEA.
- Git y GitHub.

## 7. Estado del proyecto

El núcleo del sistema y los patrones Prototype y Strategy cuentan con implementación y pruebas unitarias.

Las demás funcionalidades del alcance general del proyecto se encuentran sujetas a su desarrollo e integración.