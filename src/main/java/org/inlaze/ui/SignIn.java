package org.inlaze.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://test-qa.inlaze.com/auth/sign-in")
public class SignIn extends PageObject {

    public static final Target BTN_SIGNUP = Target.the("Botón registro")
            .locatedBy("//a[contains(text(),'Sign up')]");

    public static final Target TITLE_SIGNIN = Target.the("Titulo sign in")
            .locatedBy("//h1");

    public static final Target TITLE_SESION = Target.the("Titulo al iniciar sesion")
            .locatedBy("//section[@class='mb-8']//h2");

    public static final Target BTN_SIGNIN = Target.the("Botón inicio sesion")
            .locatedBy("//button[text()=' Sign in ']");

    public static final Target NOMBRE_USUARIO = Target.the("Nombre al iniciar sesion")
            .locatedBy("//div[@class='flex gap-4 items-center']//h2");

    public static final Target BTN_USUARIO = Target.the("Botón para desplegar el menu")
            .locatedBy("//div[@class='w-10 rounded-full']//img");

    public static final Target BTN_CERRARSESION = Target.the("Botón cerrar sesion")
            .locatedBy("//ul[@tabindex='0']//li[3]");

}
