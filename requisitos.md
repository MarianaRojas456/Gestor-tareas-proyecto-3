# Requisitos del Sistema e Historias de Usuario

*Proyecto:* Gestor de Tareas y Proyectos  
*Integrantes:* Mariana Rojas, Sofía Combita, Samuel Felipe Rojas  

---

## 2. Requisitos del Sistema funcionales y no funcioales

| ID | DESCRIPCIÓN | TIPO | CRITERIO DE VERIFICACIÓN |
| :--- | :--- | :--- | :--- |
| *RF-01* | El sistema debe permitir la creación de tareas simples especificando título, descripción, prioridad y fecha límite. | Funcional | Crear una tarea individual y verificar que aparezca registrada correctamente en el listado general del sistema. |
| *RF-02* | El sistema debe permitir crear proyectos o tareas compuestas que contengan subtareas de manera jerárquica y recursiva. | Funcional | Añadir subtareas a un proyecto contenedor y comprobar que la estructura multinivel se actualiza de forma integrada. |
| *RF-03* | El sistema debe validar las transiciones permitidas al cambiar el estado de una tarea (Pendiente → En curso → En revisión → Terminada). | Funcional | Intentar pasar una tarea de "Pendiente" a "Terminada" directamente y verificar que el sistema rechace la transición o emita un error. |
| *RF-04* | El sistema debe registrar las acciones del usuario para permitir la ejecución de las funciones de deshacer (undo) y rehacer (redo). | Funcional | Modificar el estado de una tarea, presionar la opción "Deshacer" y comprobar que la tarea recupera su estado previo inmediato. |
| *RF-05* | El sistema debe permitir instanciar proyectos completos a partir de plantillas predefinidas. | Funcional | Seleccionar una plantilla de proyecto, confirmar la acción y verificar que se genere automáticamente el árbol de tareas asociado. |
| *RF-06* | El sistema debe permitir ordenar y filtrar las tareas por prioridad, fecha límite o responsable asignado. | Funcional | Aplicar un filtro por prioridad alta y comprobar que el listado muestre exclusivamente las tareas que cumplen con dicho criterio. |
| *RNF-01* | El sistema debe estar desarrollado íntegramente en el lenguaje de programación Java. | No funcional | Revisar la estructura del repositorio y verificar que el código fuente y las clases principales estén construidas en Java. |
| *RNF-02* | El sistema debe garantizar que tanto la interfaz de consola como la interfaz gráfica (Swing) operen exactamente sobre el mismo núcleo de negocio. | No funcional | Ejecutar una operación de cambio en la consola y verificar que se refleje de manera inmediata en la interfaz gráfica. |
| *RNF-03* | El sistema debe contar con pruebas unitarias implementadas en JUnit para las clases donde se apliquen los patrones de diseño. | No funcional | Ejecutar la suite de pruebas unitarias en el entorno de desarrollo y verificar que todas las pruebas pasen con éxito. |
