package org.inlaze.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.inlaze.ui.SignUplaze.MENSAJE_EXITOSO;

public class ValidateElementsSignUp implements Question<String> {

    public static ValidateElementsSignUp validateElementsSignUp() {
        return new ValidateElementsSignUp();
    }

    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(MENSAJE_EXITOSO, isVisible()).forNoMoreThan(10).seconds()
        );
        return Text.of(MENSAJE_EXITOSO).answeredBy(actor);
    }
}

