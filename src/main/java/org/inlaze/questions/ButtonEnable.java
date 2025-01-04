package org.inlaze.questions;

import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static org.inlaze.ui.SignUplaze.BTN_SIGNUP;

@Slf4j
public class ButtonEnable implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        // Verifica si el botón está habilitado y lo retorna como verdadero o falso
        boolean isEnabled = BTN_SIGNUP.resolveFor(actor).isEnabled();

        // Aquí puedes agregar un log si es necesario para ver el estado del botón
        log.info("El botón de registro está habilitado: {}", isEnabled);

        return isEnabled;  // Retorna true si está habilitado, false si no lo está
    }
}
