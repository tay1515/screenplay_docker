Feature: Login


  Scenario: Inicio de sesion.
    Given Inicio sesion en el navegador "edge"
    When intento iniciar sesion con las credenciales
      | user   | password |
      | Jsmith | Demo1234 |