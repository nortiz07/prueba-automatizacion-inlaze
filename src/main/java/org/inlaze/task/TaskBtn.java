package org.inlaze.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.inlaze.ui.SignIn.BTN_SIGNIN;
import static org.inlaze.ui.SignUplaze.BTN_SIGNUP;

public class TaskBtn implements Task {

    private final String btnText;

    public TaskBtn(String btnText) {
        this.btnText = btnText;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (btnText.equals("Sign up")) {
            // Espera a que el botón "Sign up" esté habilitado y luego hace clic
            actor.attemptsTo(
                    WaitUntil.the(BTN_SIGNUP, isVisible()).forNoMoreThan(10).seconds(),
                    WaitUntil.the(BTN_SIGNUP, isEnabled()).forNoMoreThan(10).seconds(),
                    Click.on(BTN_SIGNUP)
            );
        }
        if (btnText.equals("Sign in")) {
            actor.attemptsTo(
                    WaitUntil.the(BTN_SIGNIN, isVisible()).forNoMoreThan(10).seconds(),
                    WaitUntil.the(BTN_SIGNIN, isEnabled()).forNoMoreThan(10).seconds(),
                    Click.on(BTN_SIGNIN)
            );
        }
    }

    public static TaskBtn taskBtnRegistrar(String btnText) {
        return new TaskBtn(btnText);
    }
}
