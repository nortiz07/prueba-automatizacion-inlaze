package org.inlaze.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.inlaze.ui.SignUplaze.MENSAJE_PASS_NOTMATCH;

public class ValidateNotMatch implements Question<String> {

    public static ValidateNotMatch validateNotMatch(){
        return new ValidateNotMatch();
    }

    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(MENSAJE_PASS_NOTMATCH, isVisible()).forNoMoreThan(10).seconds()
        );
        return Text.of(MENSAJE_PASS_NOTMATCH).answeredBy(actor);
    }
}
