#language: es

Característica: Registro de usuario en Inlaze
  Como usuario
  Quiero registrarme
  Para poder iniciar sesión en la plataforma

  Antecedentes:
    Dado que Oscar quiere registrarse

  Escenario: registro de usuario
    Cuando ingresa a la página de registro de Inlaze
    Y ingresa sus datos correctamente
    Entonces debería poder registrar sus datos correctamente

  Escenario: registro de usuario sin nombre completo
    Cuando ingresa a la página de registro de Inlaze
    Y ingresa un nombre incompleto
    Entonces no debería habilitarse el botón de registro

  Esquema del escenario: registro de usuario con contraseña incorrecta
    Cuando ingresa a la página de registro de Inlaze
    Y ingresa una "<contrasena>" y "<confirmacion>" incorrecta
    Entonces no debería habilitarse el botón de registro

    Ejemplos:
      | contrasena | confirmacion |
      | Pass       | Pass         |
      | password1  | password1    |
      | Pass1      | Pass1        |

  Escenario: registro de usuario fallido por contraseña diferente
    Cuando ingresa a la página de registro de Inlaze
    Y ingresa una contraseña y una confirmación diferente
    Entonces debería ver un mensaje de error

  Esquema del escenario: registro de usuario fallido por correo ya existente
    Cuando ingresa a la página de registro de Inlaze
    Y ingresa un "<correo>" existente y incorrecto
    Entonces no debería habilitarse el botón de registro

    Ejemplos:
      | correo          |
      | oscar@oscar.com |
      | oscar@          |
      | oscar.co        |

  Esquema del escenario: Registro con datos incompletos
    Cuando ingresa a la página de registro de Inlaze
    Y no proporciona alguno de estos campos "<nombre>","<email>", "<contrasena>", "<confirmacion>"
    Entonces no debería habilitarse el botón de registro

    Ejemplos:
      | nombre  | email           | contrasena | confirmacion |
      |         | oscar@oscar.com | Password1  | Password1    |
      | Oscar P |                 | Password1  | Password1    |
      | Oscar P | oscar@oscar.com |            | Password1    |
      | Oscar P | oscar@oscar.com | Password1  |              |