package org.inlaze.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class SignIn extends PageObject {

    public static final Target BTN_SIGNIN = Target.the("Botón registro")
            .locatedBy("//a[contains(text(),'Sign up')]");

    public static final Target TITLE_SIGNIN = Target.the("Titulo sign in")
            .locatedBy("//h1");
}
