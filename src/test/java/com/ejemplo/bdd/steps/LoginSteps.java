package com.ejemplo.bdd.steps;
import io.cucumber.java.es.*;
import org.junit.jupiter.api.Assertions;

public class LoginSteps {

    private String email;
    private String password;
    private String lastMessage;
    private boolean redirected = false;

    @Dado("que estoy en la página de inicio de sesión")
    public void estoyEnLogin() {
        lastMessage = null;
        redirected = false;
    }

    @Cuando("ingreso el email {string} y la contraseña {string}")
    public void ingresoCredenciales(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Cuando("pulso el botón Iniciar sesión")
    public void pulsoIniciarSesion() {
        // Simulación simple: en un proyecto real aquí llamarías a la API o usarías Selenium.
        if ("usuario@ejemplo.com".equals(email) && "Pass1234!".equals(password)) {
            redirected = true;
        } else if ("no-verificado@ej.com".equals(email) || "no-verificado@ej.com".equals(email)) {
            lastMessage = "Por favor verifica tu correo";
        } else {
            lastMessage = "Credenciales inválidas";
        }
    }

    @Entonces("soy redirigido al panel de usuario")
    public void soyRedirigido() {
        Assertions.assertTrue(redirected, "No se redirigió al panel de usuario");
    }

    @Entonces("veo el texto {string}")
    public void veoTexto(String texto) {
        Assertions.assertTrue(redirected, "No está en el panel para ver el texto: " + texto);
    }

    @Entonces("veo el mensaje {string}")
    public void veoMensaje(String mensajeEsperado) {
        Assertions.assertEquals(mensajeEsperado, lastMessage);
    }
}
