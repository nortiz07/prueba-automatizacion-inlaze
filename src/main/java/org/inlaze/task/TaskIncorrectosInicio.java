package org.inlaze.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.inlaze.ui.SignUplaze.CAMPO_EMAIL;
import static org.inlaze.ui.SignUplaze.CAMPO_PASSWORD;

public class TaskIncorrectosInicio implements Task {

    private final String email;

    private final String password;

    public TaskIncorrectosInicio(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(CAMPO_EMAIL, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(email).into(CAMPO_EMAIL));

        actor.attemptsTo(WaitUntil.the(CAMPO_PASSWORD, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(password).into(CAMPO_PASSWORD));
    }

    public static TaskIncorrectosInicio taskIncorrectosInicio(String email, String password) {
        return new TaskIncorrectosInicio(email, password);
    }
}
