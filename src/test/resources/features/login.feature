#language: es

Característica: Login de usuario en Inlaze
  Como usuario
  Quiero iniciar sesión
  Para poder acceder al panel principal de Inlaze

  Antecedentes:
    Dado que Oscar quiere iniciar sesión en la plataforma

  Escenario: Inicio de sesión exitoso
    Cuando accede a la página de inicio de sesión
    Y proporciona sus credenciales correctamente
    Entonces debería visualizar el panel principal de la plataforma
    Y su nombre de usuario
    Y poder finalizar sesión correctamente

  Esquema del escenario: Inicio sesion con datos incompletos
    Cuando accede a la página de inicio de sesión
    Y proporciona su "<email>" y "<contrasena>"
    Entonces no debería habilitarse el botón de incio sesion

    Ejemplos:
      | email             | contrasena |
      |                   | Password1  |
      | prueba@prueba.com |            |
      | prueba            | Pass       |
      | prueba@p          | password1  |
      | prueba.co         | Password1  |
