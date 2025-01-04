package org.inlaze.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.inlaze.questions.ButtonEnable;
import org.inlaze.questions.ValidateElementsSignUp;
import org.inlaze.task.TaskAbrirWeb;
import org.inlaze.task.TaskIngresoRegistro;
import org.inlaze.task.TaskSign;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.*;

@Slf4j
public class StepLogin {

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

    @When("ingresa sus datos correctamente")
    public void enterYourDataCorrectly() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                TaskSign.registroExitoso("Oscar P", "oscar1@ejemplo.com", "Password1")
        );
    }

    @Then("debería poder registrar sus datos correctamente")
    public void youShouldBeAbleToRegisterYourDataCorrectly() {
        //String palabraEsperada = "Test";
        log.info("Encontro: {}", ValidateElementsSignUp.validateElementsSignUp().answeredBy(theActorInTheSpotlight()));
        //log.info("Esperada: {}", palabraEsperada);
        theActorInTheSpotlight().should(seeThat(
                ValidateElementsSignUp.validateElementsSignUp(), equalTo("Successful registration!")));
    }

    @When("ingresa un nombre incompleto")
    public void enterAnIncompleteName() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                TaskSign.registroExitoso("Prueba", "oscar1@ejemplo.com", "Password1")
        );
    }
    @Then("no debería habilitarse el botón de registro")
    public void registrationButtonShouldNotBeEnabled() {
        log.info("Valor del botón: {}", new ButtonEnable().answeredBy(OnStage.theActorInTheSpotlight()));
        OnStage.theActorInTheSpotlight().should(seeThat(new ButtonEnable(), is("false")));
    }

    @When("ingresa una contraseña incorrecta")
    public void enterAnIncompletePassword() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                TaskSign.registroExitoso("Prueba P", "oscar1@ejemplo.com", "Pass")
        );
    }

}
