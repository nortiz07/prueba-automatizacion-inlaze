package org.inlaze.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.inlaze.helpers.RandomEmail;
import org.inlaze.questions.ValidateElementsSignUp;
import org.inlaze.task.TaskAbrirWeb;
import org.inlaze.task.TaskBtnRegistrar;
import org.inlaze.task.TaskIngresoRegistro;
import org.inlaze.task.TaskSignUp;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

@Slf4j
public class StepRegistroExitoso {

    @Before
    public void configuracionInicial() {
        setTheStage(new OnlineCast());
    }

    @Given("que Oscar quiere registrarse")
    public void whatOscarWantsToRegister() {
        theActorCalled("Oscar").wasAbleTo(TaskAbrirWeb.taskAbrirWeb());
    }

    @When("ingresa a la página de registro de Inlaze")
    public void enterInlazeRegistrationPage() {
        log.info("DA CLIC AL BOTON ");
        OnStage.theActorInTheSpotlight().attemptsTo(new TaskIngresoRegistro());
    }

    @And("ingresa sus datos correctamente")
    public void enterYourDataCorrectly() {
        String email = RandomEmail.getInstance().getEmail();
        OnStage.theActorInTheSpotlight().attemptsTo(
                TaskSignUp.registro("Oscar P", email, "Password1", "Password1")
        );
        log.info("Termino el registro ");
    }

    @Then("debería poder registrar sus datos correctamente")
    public void youShouldBeAbleToRegisterYourDataCorrectly() {
        theActorInTheSpotlight().attemptsTo(new TaskBtnRegistrar());
        //String palabraEsperada = "Test";
        log.info("Encontro: {}", ValidateElementsSignUp.validateElementsSignUp().answeredBy(theActorInTheSpotlight()));
        //log.info("Esperada: {}", palabraEsperada);
        theActorInTheSpotlight().should(seeThat(
                ValidateElementsSignUp.validateElementsSignUp(), equalTo("Successful registration!")));
    }


}
