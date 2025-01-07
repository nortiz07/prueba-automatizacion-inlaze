# Proyecto de Automatización con Selenium y Serenity

Este proyecto utiliza **Selenium WebDriver** y **Serenity BDD** para realizar pruebas automatizadas de comportamiento (BDD) en una aplicación web. **Serenity BDD** se utiliza para generar informes detallados, mientras que **Selenium** se encarga de la interacción con la aplicación.

## Requisitos Previos

Antes de ejecutar el proyecto, asegúrate de tener las siguientes herramientas instaladas en tu máquina:

**Java 11 o superior**: Serenity y Selenium requieren Java para ejecutar las pruebas.
**Gradle**: Usado para gestionar dependencias y ejecutar las pruebas.
**Git**: Para clonar el repositorio.
**IDE**: Recomendado usar IntelliJ IDEA, Eclipse o cualquier otro IDE compatible con Java.

## Instalación

1. **Clonar el Repositorio:**

   ```bash
   $ gh repo clone nortiz07/prueba-automatizacion-inlaze
   $ cd prueba-automatizacion-inlaze

2. **Instalar Dependencias:**

El proyecto usa Gradle para gestionar las dependencias. Asegúrate de tener Gradle instalado y ejecuta el siguiente comando para instalar todas las dependencias necesarias:

        $ gradle clean build

3. **Configuración del Entorno:**


Si es necesario, configura los siguientes archivos:

- serenity.properties: Asegúrate de tener configuradas las propiedades de Serenity, como la URL base de la aplicación y el navegador a utilizar para las pruebas.
- webdriver.chrome.driver: Si estás utilizando ChromeDriver para ejecutar las pruebas, asegúrate de tener el chromedriver correspondiente para tu sistema operativo.
  Ejemplo de configuración de serenity.properties:

  serenity.project.name=Mi Proyecto de Pruebas Automatizadas
  serenity.driver=chrome
  serenity.headless=true
  base.url=http://mi-aplicacion-web.com

4. **Ejecución de las Pruebas**

Para ejecutar las pruebas, puedes usar Gradle. Aquí te dejo algunas opciones:

Ejecutar todas las pruebas:

      $ gradle clean verify

Ejecutar pruebas específicas:

Si deseas ejecutar un conjunto específico de pruebas, puedes utilizar un      Tag o Etiqueta para seleccionarlas. Ejemplo:

      $ gradle test --tests org.inlaze.runners.RunnerLogin

Ejecutar Pruebas con un Navegador Específico:

Si necesitas ejecutar las pruebas en un navegador específico, puedes          configurar el parámetro serenity.driver en el archivo serenity.properties,     o puedes especificar el navegador directamente al ejecutar el comando de      Gradle:
        
      $ gradle clean test -Dwebdriver.driver=edge

5. **Generación de Reportes**

   Serenity genera reportes detallados de las pruebas. Una vez que las           pruebas hayan terminado, los reportes estarán disponibles en el directorio     build/serenity. Abre el archivo index.html en tu navegador para ver los       detalles del reporte.

5. **Contribuir**

   Si deseas contribuir a este proyecto, sigue estos pasos:

    -  Realiza un fork del proyecto.
    - Crea una rama para tus cambios (git checkout -b            -feature/nueva-funcionalidad).
    - Realiza tus cambios y asegúrate de ejecutar las pruebas.
    - Envía un pull request con una descripción detallada de los cambios.


## Licencia
Este proyecto está bajo la Licencia MIT.