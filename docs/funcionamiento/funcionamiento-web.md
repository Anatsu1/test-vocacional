---
description: Funcionamiento general del flujo de datos y de la página web
icon: dice-d6
cover: ../.gitbook/assets/shutterstock_1078387013-scaled (1).jpg
coverY: 0
---

# Funcionamiento Web

#### A continuación, se describe el flujo esperado para el uso de la aplicación de test vocacional, desde la toma del test hasta la gestión de los registros.

1. **Realización del Test Vocacional**
   * El usuario accede a la página principal de la aplicación y realiza el test vocacional. El test consiste en preguntas predefinidas que ayudarán a determinar el área recomendada para el usuario (por ejemplo, programación, diseño, etc.).
   * Al completar el test, el sistema procesa las respuestas y calcula el área recomendada para el usuario, que se asigna automáticamente en el resultado.
2. **Guardado de Datos del Alumno**
   * Al terminar el test, el usuario completa los datos personales (nombre, apellido, correo electrónico, teléfono) y el sistema guarda esta información en la base de datos junto con el área recomendada obtenida del test.
   * Este guardado se realiza a través de la función `saveAlumno`, que convierte los datos ingresados en un objeto `alumnoModel` y lo guarda en la base de datos.
3. **Visualización de Registros en una Tabla**
   * La aplicación cuenta con una sección de administración donde el personal autorizado puede ver todos los registros de alumnos en una tabla.
   * La tabla muestra columnas con la información relevante, como nombre, apellido, teléfono, correo electrónico y área recomendada. Estos datos se obtienen a través de la función `devolverAlumnos` en `alumnoService`.
4. **Edición de Registros**
   * Si el personal necesita actualizar la información de un alumno (por ejemplo, si el alumno cambia de teléfono o correo), puede hacer clic en el botón de edición en la tabla.
   * Esto permite modificar los datos del alumno, y al guardar, el sistema actualiza la información en la base de datos a través de la función `guardarRegistro`.
5. **Eliminación de Registros**
   * La aplicación también permite eliminar registros de alumnos, ya sea por solicitud o para mantener la base de datos limpia.
   * Al hacer clic en el botón de eliminar en la tabla, el sistema elimina el registro seleccionado de la base de datos con la función `eliminarRegistro`.
6. **Exportación de Registros a Excel**
   * Para reportes o análisis, el personal autorizado puede exportar la lista completa de alumnos a un archivo Excel.
   * La función `exportarDatos` genera un archivo Excel con todos los registros, que el usuario puede descargar. El archivo contiene columnas como nombre, apellido, teléfono, correo electrónico y área recomendada.

#### Diagrama de Flujo Sencillo

1. Usuario realiza el test
2. Usuario completa datos personales y guarda&#x20;
3. **Sistema calcula área recomendada y la muestra al usuario (alumno)**
4. **Sistema guarda datos en base de datos**
5. Personal visualiza registros en tabla
   * **Editar**: Actualizar información y guardar → Sistema actualiza base de datos
   * **Eliminar**: Quitar registro → Sistema elimina de base de datos
   * **Exportar**: Generar archivo Excel → Descarga del archivo

Este flujo garantiza que la información se capture, administre y acceda de manera efectiva dentro de la aplicación, ofreciendo opciones de gestión completas para los datos del test vocacional.
