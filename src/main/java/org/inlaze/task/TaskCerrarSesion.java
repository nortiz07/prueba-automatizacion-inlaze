package org.inlaze.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.inlaze.ui.SignIn.BTN_CERRARSESION;
import static org.inlaze.ui.SignIn.BTN_USUARIO;

public class TaskCerrarSesion implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_USUARIO, isVisible()).forNoMoreThan(10).seconds(),
                WaitUntil.the(BTN_USUARIO, isEnabled()).forNoMoreThan(10).seconds(),
                Click.on(BTN_USUARIO)
        );

        actor.attemptsTo(
                WaitUntil.the(BTN_CERRARSESION, isVisible()).forNoMoreThan(10).seconds(),
                WaitUntil.the(BTN_CERRARSESION, isEnabled()).forNoMoreThan(10).seconds(),
                Click.on(BTN_CERRARSESION)
        );
    }
}
