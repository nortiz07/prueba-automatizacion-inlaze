package org.inlaze.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.inlaze.task.TaskAbrirWeb;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class StepInicioExitoso {

    @Before
    public void configuracionInicial() {
        setTheStage(new OnlineCast());
    }

    @Given("que Oscar quiere iniciar sesión en la plataforma")
    public void thatOscarWantsToLogInToThePlatform() {
        theActorCalled("Oscar").wasAbleTo(TaskAbrirWeb.taskAbrirWeb());
    }

    @When("accede a la página de inicio de sesión")
    public void accessTheLoginPage() {
    }

    @And("proporciona sus credenciales correctamente")
    public void provideYourCredentialsCorrectly(){
    }

    @Then("debería visualizar el panel principal de la plataforma")
    public void youShouldSeeTheMainPlatformPanel(){}

}
