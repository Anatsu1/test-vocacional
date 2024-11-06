---
description: Manejo de la lógica para la respuesta del test vocacional
icon: square-js
cover: ../../.gitbook/assets/javascript-small-horizontal-4k.png
coverY: 0
---

# Test

## Implementación del Código

El siguiente código implementa un formulario que captura los datos de un usuario y procesa las respuestas de un test para recomendar un área de desarrollo basada en las fortalezas del usuario.&#x20;

* **Eficiencia:**
  * Desarrollo de Aplicaciones
  * Cloud Computing
  * Sistemas Embebidos
* **Abstracción:**
  * IA
  * Arquitectura de Software
  * Ciencia de Datos
* **Lógica:**
  * Backend
  * Seguridad Informática
  * Sistemas Operativos
* **Creatividad:**
  * Desarrollo Web
  * Videojuegos

A continuación se describe cómo está estructurado el código:

#### Captura de Datos

Se captura la información del formulario (nombre, apellido, teléfono y correo electrónico) y las respuestas a las preguntas del test utilizando los valores de los campos HTML:

```javascript
const nombre = document.getElementById('nombre').value;
const apellido = document.getElementById('apellido').value;
const telefono = document.getElementById('telefono').value;
const email = document.getElementById('email').value;
```

#### Procesamiento de Respuestas

Se inicializan las variables de puntaje y se recorren las respuestas para incrementar el puntaje correspondiente:

```javascript
let creatividad = 0;
let logica = 0;
let abstraccion = 0;
let eficiencia = 0;

respuestas.forEach(respuesta => {
  if (respuesta === "creatividad") creatividad++;
  if (respuesta === "logica") logica++;
  if (respuesta === "abstraccion") abstraccion++;
  if (respuesta === "eficiencia") eficiencia++;
});
```

#### Determinación del Área y Recomendación

El área con el mayor puntaje se determina mediante condiciones, y se genera una recomendación basada en el área destacada por ej:

```javascript
if (creatividad >= logica && creatividad >= abstraccion && creatividad >= eficiencia) {
  areaMayor = "Creatividad: Desarrollo Web/Videojuegos/Realidad Virtual y Aumentada";
  // código de recomendación para creatividad
}
```

#### Envío de Datos al Servidor

Se prepara un objeto `alumnoDTO` y se envían los datos al servidor mediante una solicitud POST:

```javascript
const alumnoDTO = {
    nombre: nombre,
    apellido: apellido,
    telefono: telefono,
    mail: email,
    areaRecomendada: areaMayor
};

fetch('http://localhost:8080/test', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json',
    },
    body: JSON.stringify(alumnoDTO),
})
.then(response => /* manejo de respuesta */)
.catch(error => console.error('Error:', error));
```

#### Reinicio del formulario

Una función `reiniciar` redirige a la página inicial para recomenzar el test:

```javascript
function reiniciar(){
    window.location.href="http://localhost:8080/test";
}
```

#### Ejemplo Sencillo de API para Recolección de Datos de un Test

Este ejemplo describe un servicio sencillo de API que permite recoger datos de un test a través de un endpoint de tipo `POST`. El servidor recibe los datos del usuario y el área recomendada según las respuestas al test.

**Endpoints**

* **POST /test**
  * **Descripción**: Recoge datos del usuario junto con el área recomendada.
  *   **Body**: Debe ser un objeto JSON con la estructura siguiente:

      ```json
      {
        "nombre": "Juan",
        "apellido": "Pérez",
        "telefono": "123456789",
        "mail": "juan.perez@example.com",
        "areaRecomendada": "Creatividad: Desarrollo Web/Videojuegos/Realidad Virtual y Aumentada"
      }
      ```
  *   **Respuesta Exitosa**: Devuelve un código HTTP 200 y un mensaje de confirmación:

      ```json
      {
        "status": "success",
        "message": "Datos recibidos correctamente."
      }
      ```
  *   **Error**: Si ocurre un error, devolverá un código HTTP 400 con el mensaje de error:

      ```json
      {
        "status": "error",
        "message": "Error al procesar la solicitud."
      }
      ```

Una vez recibido el json el controller con la solicitud HTTP "POST" con esa url, recibira el json para mapearlo como un semenjante de la clase AlumnoDTO, para posteriormente pasarlo a su semejante AlumnoModel, donde se guardara como un nuevo registro.

## Código completo

```javascript
// Escucha el evento de envío del formulario
document.getElementById('testForm').addEventListener('submit', function(event) {
    // Evita que el formulario se envíe de forma tradicional, para manejar el proceso con JavaScript
    event.preventDefault();

    // Captura los datos del formulario (nombre, apellido, teléfono y correo electrónico)
    const nombre = document.getElementById('nombre').value;
    const apellido = document.getElementById('apellido').value;
    const telefono = document.getElementById('telefono').value;
    const email = document.getElementById('email').value;

    // Captura las respuestas del test (p1 a p10)
    const p1 = document.getElementById('p1').value;
    const p2 = document.getElementById('p2').value;
    const p3 = document.getElementById('p3').value;
    const p4 = document.getElementById('p4').value;
    const p5 = document.getElementById('p5').value;
    const p6 = document.getElementById('p6').value;
    const p7 = document.getElementById('p7').value;
    const p8 = document.getElementById('p8').value;
    const p9 = document.getElementById('p9').value;
    const p10 = document.getElementById('p10').value;

    // Inicializa los puntajes para cada área
    let creatividad = 0;
    let logica = 0;
    let abstraccion = 0;
    let eficiencia = 0;

    // Crea un arreglo con las respuestas del test
    const respuestas = [p1, p2, p3, p4, p5, p6, p7, p8, p9, p10];
    
    // Recorre las respuestas y aumenta el puntaje correspondiente según el área seleccionada por el usuario
    respuestas.forEach(respuesta => {
      if (respuesta === "creatividad") creatividad++; // Si la respuesta es "creatividad", incrementa el puntaje de creatividad
      if (respuesta === "logica") logica++; // Si la respuesta es "logica", incrementa el puntaje de lógica
      if (respuesta === "abstraccion") abstraccion++; // Si la respuesta es "abstraccion", incrementa el puntaje de abstracción
      if (respuesta === "eficiencia") eficiencia++; // Si la respuesta es "eficiencia", incrementa el puntaje de eficiencia
    });

    // Variables para determinar el área con mayor puntaje y la recomendación asociada
    let areaMayor = '';
    let recomendacion = '';

    // Determina el área con el mayor puntaje
    if (creatividad >= logica && creatividad >= abstraccion && creatividad >= eficiencia) {
      areaMayor = "Creatividad: Desarrollo Web/Videojuegos/Realidad Virtual y Aumentada";
      recomendacion = `
          <div class='card mt-4'>
              <div class='card-header bg-primary text-white'>
                  <h3>Creatividad</h3>
              </div>
              <div class='card-body'>
                  <p><strong>Descripción:</strong> Eres una persona que disfruta idear soluciones innovadoras y visualmente atractivas. La creatividad es tu mayor fortaleza, por lo que podrías desarrollarte en áreas de la programación que requieren un enfoque centrado en la experiencia del usuario y el diseño. Te gustará trabajar en proyectos donde la apariencia y la interacción sean prioritarias.</p>
                  <h5>Áreas recomendadas:</h5>
                  <ul>
                      <li>Desarrollo Web: Aquí se valora mucho la creatividad en el diseño de interfaces. Serás responsable de crear sitios web visualmente atractivos y funcionales, lo que implica trabajar con frontend (HTML, CSS, JavaScript) y frameworks como React o Vue.</li>
                      <li>Videojuegos: En esta área podrás desarrollar mundos interactivos e inmersivos. Los motores de juego como Unity (C#) o Unreal Engine (C++) te permitirán explotar tu creatividad al máximo.</li>
                      <li>Realidad Virtual y Aumentada: Crear experiencias inmersivas es un campo en crecimiento, donde tu creatividad te permitirá diseñar interfaces de usuario innovadoras e interacciones sensoriales.</li>
                  </ul>
                  <h5>Recomendación de lenguajes:</h5>
                  <p>HTML, CSS, JavaScript, Unity (C#), Unreal Engine (C++).</p>
              </div>
          </div>`;
    } else if (logica >= creatividad && logica >= abstraccion && logica >= eficiencia) {
      areaMayor = "Lógica: Backend/Seguridad Informática/Sistemas Operativos y Embebidos";
      recomendacion = `
          <div class='card mt-4'>
              <div class='card-header bg-success text-white'>
                  <h3>Lógica</h3>
              </div>
              <div class='card-body'>
                  <p><strong>Descripción:</strong> Si tus fortalezas están en la lógica, te sientes cómodo/a resolviendo problemas complejos mediante el uso de algoritmos y estructuras organizadas. Las áreas que dependen de la estructura, la resolución de problemas y la eficiencia serán las más adecuadas para ti.</p>
                  <h5>Áreas recomendadas:</h5>
                  <ul>
                      <li>Backend y Arquitectura de Sistemas: Aquí serás responsable de crear la lógica que impulsa los sistemas y aplicaciones. Podrás trabajar en la creación de APIs, bases de datos, y sistemas distribuidos utilizando lenguajes como Python, Java o C++.</li>
                      <li>Seguridad Informática: En este campo, necesitarás aplicar tu capacidad lógica para desarrollar sistemas seguros, prevenir ataques y proteger la información. La seguridad informática es una disciplina en constante crecimiento.</li>
                      <li>Sistemas Operativos y Embebidos: Este área te permitirá trabajar en la creación y optimización de sistemas que controlan hardware específico o sistemas operativos complejos.</li>
                  </ul>
                  <h5>Recomendación de lenguajes:</h5>
                  <p>Python, Java, C, C++, Rust.</p>
              </div>
          </div>`;
    } else if (abstraccion >= creatividad && abstraccion >= logica && abstraccion >= eficiencia) {
      areaMayor = "Abstracción: Inteligencia Artificial/Arquitectura de Software/Data Science";
      recomendacion = `
          <div class='card mt-4'>
              <div class='card-header bg-warning text-dark'>
                  <h3>Abstracción</h3>
              </div>
              <div class='card-body'>
                  <p><strong>Descripción:</strong> Te destacas en la capacidad de ver el panorama completo y conceptualizar ideas complejas. Las áreas que requieren pensamiento abstracto, como la inteligencia artificial, el diseño de arquitecturas o el desarrollo de sistemas, serán las más atractivas para ti.</p>
                  <h5>Áreas recomendadas:</h5>
                  <ul>
                      <li>Inteligencia Artificial y Machine Learning: En este campo, trabajarás con grandes cantidades de datos, aplicando modelos matemáticos y algoritmos complejos para que las máquinas puedan "aprender" y tomar decisiones.</li>
                      <li>Arquitectura de Software: Esta área requiere la capacidad de diseñar y planificar la estructura de sistemas a gran escala, donde se valora mucho la habilidad de abstracción.</li>
                      <li>Data Science: Aquí tu capacidad de trabajar con datos abstractos será clave para extraer información útil y desarrollar soluciones basadas en datos.</li>
                  </ul>
                  <h5>Recomendación de lenguajes:</h5>
                  <p>Python, R, MATLAB, Julia.</p>
              </div>
          </div>`;
    } else {
      areaMayor = "Eficiencia: Desarrollo de Aplicaciones/Cloud Computing/Sistemas Embebidos";
      recomendacion = `
          <div class='card mt-4'>
              <div class='card-header bg-danger text-white'>
                  <h3>Ejecución/Eficiencia</h3>
              </div>
              <div class='card-body'>
                  <p><strong>Descripción:</strong> Si sobresales en la ejecución, eres alguien que busca soluciones funcionales y prácticas. Te atraen los proyectos donde puedes ver resultados rápidamente y optimizar procesos de manera eficiente.</p>
                  <h5>Áreas recomendadas:</h5>
                  <ul>
                      <li>Desarrollo de Aplicaciones Móviles o de Escritorio: Estas áreas son ideales si disfrutas crear productos que las personas puedan usar de inmediato. La eficiencia en la implementación es clave en el desarrollo de aplicaciones.</li>
                      <li>Cloud Computing: En este campo, desarrollarás soluciones escalables y optimizadas para funcionar en la nube, lo que requiere una mentalidad práctica y orientada a resultados.</li>
                      <li>Sistemas Embebidos: Si te gusta implementar soluciones que optimicen recursos y funcionen en entornos con limitaciones de hardware, esta área será ideal para ti.</li>
                  </ul>
                  <h5>Recomendación de lenguajes:</h5>
                  <p>Java, Swift, Kotlin, Go, Python (para scripting en cloud).</p>
              </div>
          </div>`;
    }

    // Muestra el resultado del test y las recomendaciones en el HTML
    const resultadoDiv = document.getElementById('resultado');
    resultadoDiv.innerHTML = `
        <h3>¡Hola ${nombre} ${apellido}!</h3>
        <p>Resultados del test:</p>
        <p><strong>Área recomendada:</strong> ${areaMayor}</p>
        <p>${recomendacion}</p>
    `;

    // Deshabilita el botón de enviar para evitar que el formulario se envíe nuevamente
    document.getElementById("bttnSubmit").disabled = true;
    document.getElementById("bttnSubmit").className = "btn btn-secondary btn-block"; // Cambia el estilo del botón de submit
    document.getElementById("bttnRehacer").className = "btn btn-primary btn-block"; // Habilita el botón de reiniciar

    // Envía los datos al servidor mediante una solicitud POST
    const alumnoDTO = {
        nombre: nombre,
        apellido: apellido,
        telefono: telefono,
        mail: email,
        areaRecomendada: areaMayor
    };

    fetch('http://localhost:8080/test', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(alumnoDTO),
    })
    .then(response => {
        // Verifica si la respuesta del servidor fue exitosa
        if (!response.ok) {
            throw new Error(`Error del servidor: ${response.status}`);
        }
        return response.json(); // Si la respuesta es exitosa, devuelve los datos
    })
    .then(data => {
        // Maneja la respuesta del servidor
        console.log('Éxito:', data);
    })
    .catch((error) => {
        // Si ocurre un error, lo muestra en la consola
        console.error('Error:', error);
    });
});

// Función para reiniciar el formulario
function reiniciar(){
    window.location.href="http://localhost:8080/test"; // Redirige a la página de inicio para reiniciar el test
}

```
