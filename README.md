# Gestor-tareas-proyecto-3
Repositorio para el parcial 3 de ingenieria de software II- Gestor de tareas.

*Integrantes:* Mariana Rojas, Sofia Combita, Samuel Felipe Rojas  
*Materia:* Ingeniería de Software II  
*Lenguaje:* Java  

---

## 1. Alcance

### Funcionalidades a implementar
1. *Jerarquía de Tareas y Proyectos (Patrón Composite):* Creación de tareas simples y tareas compuestas (proyectos/fases) que contienen subtareas de manera recursiva, permitiendo calcular avances y tiempos de forma unificada.
   
2. *Gestión de Estados y Transiciones (Patrón State):* Manejo de estados (Pendiente, En curso, En revisión, Terminada) con reglas estrictas y validadas sobre las transiciones de flujo permitidas.
   
3. *Historial de Acciones y Deshacer/Rehacer (Patrón Command):* Capacidad de registrar cada acción del usuario para permitir revertir (undo) o re-aplicar (redo) modificaciones sobre las tareas.
   
4. *Plantillas de Proyectos Recurrentes (Patrón Prototype):* Creación rápida de estructuras repetitivas de tareas y proyectos mediante clonación de plantillas predefinidas.
   
5. *Filtrado y Ordenamiento:* Opciones para ordenar y filtrar listados de tareas según prioridad, fecha límite y responsable asignado.
   
6. *Interfaz Dual (Consola y GUI):* Operación completa de la aplicación tanto desde la terminal como mediante una interfaz gráfica sencilla (Java Swing) compartiendo exactamente el mismo núcleo de negocio.
   
### Funcionalidades excluidas y razón
* *Sincronización en la nube en tiempo real / Bases de datos remotas:* Las excluimos porque el objetivo principal del proyecto es demostrar la correcta aplicación de patrones de diseño orientados a objetos y arquitectura limpia en una aplicación local en Java, entonces la quitamos para evitar añadir complejidad de infraestructura de red que distrajera del dominio del problema.
  

## 2. Instrucciones de Compilación y Ejecución

### Prerrequisitos
* Tener instalado *Java Development Kit (JDK 17 o superior)* en tu equipo.
* Un entorno de desarrollo recomendado como *IntelliJ IDEA* o *NetBeans*, o bien utilizar la terminal de comandos.

# Gestor de Tareas en Java

Aplicación de gestión de tareas desarrollada en Java para el proyecto de Ingeniería de Software II, con interfaz por consola e interfaz gráfica sobre un núcleo compartido y aplicación de patrones de diseño.

## Estructura de paquetes
- `src/principal/java/com/gestortareas/patrones`: Implementación de patrones de diseño (`Prototype`, etc.)
- `src/principal/java/com/gestortareas/iu/consola`: Interfaz por consola (`MainConsola`)
- `src/principal/java/com/gestortareas/iu/grafica`: Interfaz gráfica
- `src/prueba/java/com/gestortareas/patrones`: Pruebas unitarias (`TareaPlantillaTest`)
- src/com/gestortareas/patrones: Implementación del patrón Prototype.
- src/com/gestortareas/iu/grafica: Interfaz gráfica desarrollada con Java Swing.
- test/com/gestortareas/patrones: Pruebas unitarias del patrón Prototype.
  
 ## Interfaz gráfica
La aplicación cuenta con una interfaz gráfica desarrollada mediante Java Swing.

- La ventana principal permite:
- Crear tareas indicando nombre, prioridad, fecha límite y estado.
- Visualizar las tareas registradas en una tabla.
- Eliminar tareas seleccionadas.
- Crear tareas a partir de plantillas utilizando el patrón Prototype.

El botón de creación desde plantilla utiliza una plantilla base y genera una copia independiente que puede personalizarse.

El módulo de creación de proyectos todavía se encuentra en desarrollo.

## Ejecución de la interfaz gráfica

Para iniciar la interfaz se debe ejecutar la clase VentanaPrincipal, ubicada en el paquete com.gestortareas.iu.grafica.
## Compilación y ejecución

### Consola
```bash
mkdir -p out
javac -d out $(find src/principal/java -name "*.java")
java -cp out com.gestortareas.iu.consola.MainConsola
