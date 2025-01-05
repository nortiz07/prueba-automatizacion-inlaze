package org.inlaze.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://test-qa.inlaze.com/auth/sign-in")
public class SignUplaze extends PageObject {

    public static final Target CAMPO_NOMBRE = Target.the("Campo nombre")
            .locatedBy("//*[@id=\"full-name\"]");

    public static final Target CAMPO_EMAIL = Target.the("Campo email")
            .locatedBy("//*[@id=\"email\"]");

    public static final Target CAMPO_PASSWORD = Target.the("Campo password")
            .locatedBy("//app-password[@id='password']//input[@type='password']");

    public static final Target CAMPO_CONFIRMARPASS = Target.the("Campo confirmar password")
            .locatedBy("//app-password[@id='confirm-password']//input[@type='password']");

    public static final Target BTN_SIGNUP = Target.the("Botón crear usuario")
            .locatedBy("//button[text()=' Sign up ']");

    public static final Target MENSAJE_EXITOSO = Target.the("Mensaje registro exitoso")
            .locatedBy("//div[@role='alert']//div[contains(@class, 'text-sm')]");

    public static final Target MENSAJE_PASS_NOTMATCH = Target.the(
            "Mensaje de error contraseñas no coinciden")
                    .locatedBy("//span[contains(@class, 'label-text-alt') and contains(@class, 'text-error')]");

}
