package org.inlaze.task;

import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.inlaze.ui.SignUplaze.*;

@Slf4j
public class TaskSign implements Task {

    private final String nombre;
    private final String email;
    private final String password;

    private final String confirmacion;

    public TaskSign(String nombre, String email, String password, String confirmacion) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.confirmacion = confirmacion;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        log.info("Iniciando registro de usuario con nombre: {}, correo: {}", nombre, email);

        // Espera a que el campo 'nombre' sea visible y luego ingresa el valor
        actor.attemptsTo(
                WaitUntil.the(CAMPO_NOMBRE, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(nombre).into(CAMPO_NOMBRE)
        );

        // Espera a que el campo de 'email' sea visible y luego ingresa el valor
        actor.attemptsTo(
                WaitUntil.the(CAMPO_EMAIL, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(email).into(CAMPO_EMAIL)
        );

        // Espera a que el campo 'password' sea visible, habilitado y que Angular haya procesado
        actor.attemptsTo(
                WaitUntil.the(CAMPO_PASSWORD, isVisible()).forNoMoreThan(10).seconds(),
                WaitUntil.the(CAMPO_PASSWORD, isEnabled()).forNoMoreThan(10).seconds(),
                Click.on(CAMPO_PASSWORD),  // Asegúrate de que el clic ocurre en el elemento correcto
                Enter.theValue(password).into(CAMPO_PASSWORD)
        );

        // Si es necesario, espera a que el campo de confirmación de la contraseña sea visible y luego ingresa el valor
        actor.attemptsTo(
                WaitUntil.the(CAMPO_CONFIRMARPASS, isVisible()).forNoMoreThan(10).seconds(),
                WaitUntil.the(CAMPO_CONFIRMARPASS, isEnabled()).forNoMoreThan(10).seconds(),
                Enter.theValue(confirmacion).into(CAMPO_CONFIRMARPASS)
        );
        log.info("Campo confirma");
    }

    public static TaskSign registro(String nombre, String email, String password, String confirmacion) {
        return new TaskSign(nombre, email, password, confirmacion);
    }
}
