package org.inlaze.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.inlaze.ui.SignUplaze.BTN_SIGNUP;

public class TaskBtnRegistrar implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        // Espera a que el botón "Sign up" esté habilitado y luego hace clic
        actor.attemptsTo(
                WaitUntil.the(BTN_SIGNUP, isVisible()).forNoMoreThan(10).seconds(),
                WaitUntil.the(BTN_SIGNUP, isEnabled()).forNoMoreThan(10).seconds(),
                Click.on(BTN_SIGNUP)
        );
    }
}
