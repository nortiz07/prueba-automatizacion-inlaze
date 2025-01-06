package org.inlaze.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.inlaze.questions.ValidationTitle;
import org.inlaze.task.TaskAbrirWeb;
import org.inlaze.task.TaskBtn;
import org.inlaze.task.TaskCerrarSesion;
import org.inlaze.task.TaskInicioSesion;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

@Slf4j
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
        String title = "Sign";
        log.info("Titulo pagina: {}", new ValidationTitle(title).answeredBy(theActorInTheSpotlight()));
        theActorInTheSpotlight().should(seeThat(
                new ValidationTitle(title), equalTo("Sign in")));
    }

    @And("proporciona sus credenciales correctamente")
    public void provideYourCredentialsCorrectly() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                TaskInicioSesion.inicioSesion("prueba@prueba.com", "Password1")
        );
        log.info("Inicio sesion");
    }

    @Then("debería visualizar el panel principal de la plataforma")
    public void youShouldSeeTheMainPlatformPanel() {
        String btnText = "Sign in";
        theActorInTheSpotlight().attemptsTo(new TaskBtn(btnText));
        String title = "Panel";
        theActorInTheSpotlight().should(seeThat(new ValidationTitle(title), equalTo("Welcome to Lorem")));
    }

    @And("su nombre de usuario")
    public void yourUsername() {
        String nombre = "Nombre";
        theActorInTheSpotlight().should(seeThat(new ValidationTitle(nombre), equalTo("Prueba rete")));
    }

    @And("poder finalizar sesión correctamente")
    public void beAbleToLogOutCorrectly(){
        theActorInTheSpotlight().attemptsTo(new TaskCerrarSesion());
        String title = "Sign";
        log.info("CERRE SESION BIEN : {}", new ValidationTitle(title).answeredBy(theActorInTheSpotlight()));
        theActorInTheSpotlight().should(seeThat(
                new ValidationTitle(title), equalTo("Sign in")));
    }
}
