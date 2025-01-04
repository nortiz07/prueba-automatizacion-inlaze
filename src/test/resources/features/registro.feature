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

  Escenario: registro de usuario con contraseña incorrecta
    Cuando ingresa a la página de registro de Inlaze
    Y ingresa una contraseña incorrecta
    Entonces no debería habilitarse el botón de registro

  Escenario: registro de usuario fallido por contraseña diferente
    Cuando ingresa a la página de registro de Inlaze
    Y ingresa un correo válido
    Y ingresa una contraseña "Password1"
    Y ingresa una confirmacion de contraseña diferente "Pass"
    Entonces debería ver un mensaje de error "Passwords do not match"