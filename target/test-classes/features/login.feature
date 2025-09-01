Feature: Login de usuario
  Como usuario registrado
  Quiero iniciar sesión con email y contraseña
  Para acceder a mi panel

  Background:
    Given que estoy en la página de inicio de sesión

  Scenario: Inicio de sesión exitoso
    When ingreso el email "usuario@ejemplo.com" y la contraseña "Pass1234!"
    And pulso el botón Iniciar sesión
    Then soy redirigido al panel de usuario
    And veo el texto "Bienvenido, Usuario"

  Scenario Outline: Mensajes de error en login
    When ingreso el email "<email>" y la contraseña "<password>"
    And pulso el botón Iniciar sesión
    Then veo el mensaje "<mensaje>"

    Examples:
      | email                | password     | mensaje                     |
      | usuario@ejemplo.com  | wrong        | Credenciales inválidas      |
      | no-verificado@ej.com | Pass1234!    | Por favor verifica tu correo|
