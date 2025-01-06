package org.inlaze.questions;

import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static org.inlaze.ui.SignIn.BTN_SIGNIN;
import static org.inlaze.ui.SignUplaze.BTN_SIGNUP;

@Slf4j
public class ButtonEnable implements Question<String> {

    private final String btnHabilitado;

    public ButtonEnable(String btnHabilitado) {
        this.btnHabilitado = btnHabilitado;
    }

    @Override
    public String answeredBy(Actor actor) {
        if (btnHabilitado.equals("Sing up")) {
            // Verifica si el botón está habilitado y lo retorna como verdadero o falso
            boolean visible = BTN_SIGNUP.resolveFor(actor).isEnabled();

            // Log para ver el estado del botón
            log.info("El botón de registro está habilitado: {}", visible);

            return String.valueOf(visible);  // Retorna true si está habilitado, false si no lo está
        }
        if (btnHabilitado.equals("Sign in")){
            // Verifica si el botón está habilitado y lo retorna como verdadero o falso
            boolean visible = BTN_SIGNIN.resolveFor(actor).isEnabled();

            // Log para ver el estado del botón
            log.info("El botón de inicio está habilitado: {}", visible);

            return String.valueOf(visible);  // Retorna true si está habilitado, false si no lo está
        }
        return null;
    }

    public static ButtonEnable buttonEnable(String btnHabilitado){
        return new ButtonEnable(btnHabilitado);
    }
}
