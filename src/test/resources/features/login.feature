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