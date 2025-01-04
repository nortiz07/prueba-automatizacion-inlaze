package org.inlaze.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import org.inlaze.ui.SignUplaze;

public class TaskAbrirWeb implements Task {

    //llama la clase de ui donde se tiene la url
    private SignUplaze signUplaze;

    // crea un metodo de la clase para llamarla
    public static TaskAbrirWeb taskAbrirWeb() {
        return Tasks.instrumented(TaskAbrirWeb.class);
    }

    //el actor intenta abrir la web
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(signUplaze));
    }

}
