package org.inlaze.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static org.inlaze.ui.SignIn.BTN_SIGNIN;

public class TaskIngresoRegistro implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_SIGNIN, isEnabled()).forNoMoreThan(10).seconds(),
                Click.on(BTN_SIGNIN)
        );
    }
}
