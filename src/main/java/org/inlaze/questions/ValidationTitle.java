package org.inlaze.questions;

import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.inlaze.ui.SignIn.*;

@Slf4j
public class ValidationTitle implements Question<String> {

    private final String title;

    public ValidationTitle(String title) {
        this.title = title;
    }

    @Override
    public String answeredBy(Actor actor) {
        if (title.equals("Sign")) {
            actor.attemptsTo(
                    WaitUntil.the(TITLE_SIGNIN, isVisible()).forNoMoreThan(10).seconds()
            );
            log.info("Titulo de pagina loguear");
            return Text.of(TITLE_SIGNIN).answeredBy(actor);
        }
        if (title.equals("Panel")) {
            actor.attemptsTo(
                    WaitUntil.the(TITLE_SESION, isVisible()).forNoMoreThan(10).seconds()
            );
            log.info("Titulo de que inicio sesion");
            return Text.of(TITLE_SESION).answeredBy(actor);
        }
        if (title.equals("Nombre")) {
            actor.attemptsTo(
                    WaitUntil.the(NOMBRE_USUARIO, isVisible()).forNoMoreThan(10).seconds()
            );
            log.info("Titulo de que inicio sesion");
            return Text.of(NOMBRE_USUARIO).answeredBy(actor);
        }
        return null;
    }
    public static ValidationTitle signUpValidationTitle(String title){
        return new ValidationTitle(title);
    }
}
