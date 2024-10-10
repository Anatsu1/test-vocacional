document.getElementById('testForm').addEventListener('submit', function(event) {
    event.preventDefault();

    // Capturar los datos del formulario
    const nombre = document.getElementById('nombre').value;
    const apellido = document.getElementById('apellido').value;
    const telefono = document.getElementById('telefono').value;
    const email = document.getElementById('email').value;

    // Capturar las respuestas del test
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

    // Calcular resultados
    let creatividad = 0;
    let logica = 0;
    let abstraccion = 0;
    let eficiencia = 0;

    // Sumar puntaje en base a las respuestas
    const respuestas = [p1, p2, p3, p4, p5, p6, p7, p8, p9, p10];
    respuestas.forEach(respuesta => {
      if (respuesta === "creatividad") creatividad++;
      if (respuesta === "logica") logica++;
      if (respuesta === "abstraccion") abstraccion++;
      if (respuesta === "eficiencia") eficiencia++;
    });

    // Determinar el área con mayor puntaje
    let areaMayor = '';
    let recomendacion = '';

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

    // Mostrar resultado
    const resultadoDiv = document.getElementById('resultado');
    resultadoDiv.innerHTML = `
      <h3>¡Hola ${nombre} ${apellido}!</h3>
      <p>Resultados del test:</p>
      <ul>
        <li>Creatividad: ${creatividad}</li>
        <li>Lógica: ${logica}</li>
        <li>Abstracción: ${abstraccion}</li>
        <li>Eficiencia: ${eficiencia}</li>
      </ul>
      <p>Tu resultado principal está en el área de <strong>${areaMayor}</strong>.</p>
      ${recomendacion}
      <h4><strong>UTN</strong> Información de contacto</h4>
      <p>Recorda que para tener la mejor base en programacion, para vos y tu futuro, veni a estudiar con nosotros a la UTN Extension Aulica Necochea.</p>
      <p>Aprenderas todo lo necesario para tu carrera profesional, con excelentes profesores y la mejor atencion.</p>
      <p>Coordinadora General | <strong>Marcela Abete</strong> | </p>
      <p>Teléfono: 2262 59-2103</p>
      <p>Instagram: extensioneco_utn</p>
      <h3><strong>UTN APRENDEMOS DEL MAR<strong></h4>
    `;
    resultadoDiv.focus();
    document.getElementById("bttnSubmit").disabled = true;
    document.getElementById("bttnSubmit").className = "btn btn-secondary btn-block";
    document.getElementById("bttnRehacer").className = "btn btn-primary btn-block";

        // Crear el objeto JSON para enviar
        const alumnoDTO = {
          nombre: nombre,
          apellido: apellido,
          telefono: telefono,
          mail: email,
          areaRecomendada: areaMayor
        };

        // Enviar el JSON en una petición POST
    fetch('http://localhost:8080/test', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(alumnoDTO),
    })
    .then(response => {
        if (!response.ok) {
            // Si la respuesta no es exitosa (códigos 4xx o 5xx)
            throw new Error(`Error del servidor: ${response.status}`);
        }
        return response.json(); // Solo intenta parsear si el response es OK
    })
    .then(data => {
        console.log('Éxito:', data);
    })
    .catch((error) => {
        console.error('Error:', error);
    });

  });

function reiniciar(){
    window.location.href="http://localhost:8080/test";
}