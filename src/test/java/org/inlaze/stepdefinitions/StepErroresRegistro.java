package org.inlaze.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.actors.OnStage;
import org.inlaze.helpers.RandomEmail;
import org.inlaze.questions.ButtonEnable;
import org.inlaze.questions.ValidateNotMatch;
import org.inlaze.task.TaskSignUp;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.*;

@Slf4j
public class StepErroresRegistro {

    private final String email = RandomEmail.getInstance().getEmail();

    @And("ingresa un nombre incompleto")
    public void enterAnIncompleteName() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                TaskSignUp.registro(
                        "Prueba", this.email, "Password1", "Password1")
        );
    }

    @And("ingresa una {string} y {string} incorrecta")
    public void enterAnIncompletePassword(String password, String password2) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                TaskSignUp.registro("Prueba P", this.email, password, password2)
        );
    }

    @And("ingresa un {string} existente y incorrecto")
    public void enterAnExistingEmail(String correo) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                TaskSignUp.registro("Prueba P", correo, "Password1", "Password1")
        );
    }

    @And("no proporciona alguno de estos campos {string},{string}, {string}, {string}")
    public void doesNotProvideAnyOfTheseFields(String nombre,String correo,String password,String confirmacion) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                TaskSignUp.registro(nombre, correo, password, confirmacion)
        );
    }

    @Then("no debería habilitarse el botón de registro")
    public void registrationButtonShouldNotBeEnabled() {
        String btnHabilitado = "Sing up";
        log.info("Valor del botón: {}", new ButtonEnable(btnHabilitado).answeredBy(OnStage.theActorInTheSpotlight()));
        OnStage.theActorInTheSpotlight().should(seeThat(new ButtonEnable(btnHabilitado), is("false")));
    }

    @And("ingresa una contraseña y una confirmación diferente")
    public void enterPasswordAndDifferentConfirmation() {
        OnStage.theActorInTheSpotlight().attemptsTo(TaskSignUp.registro(
                "Prueba P", this.email, "Pass", "Password1"));
    }

    @Then("debería ver un mensaje de error")
    public void youShouldSeeAnErrorMessage(){
        log.info("Encontro: {}", ValidateNotMatch.validateNotMatch().answeredBy(theActorInTheSpotlight()));
        theActorInTheSpotlight().should(seeThat(
                ValidateNotMatch.validateNotMatch(), equalTo("Passwords do not match")));

    }

}
