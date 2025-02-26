package org.inlaze.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.inlaze.questions.ButtonEnable;
import org.inlaze.task.TaskIncorrectosInicio;
import org.inlaze.task.TaskInicioSesion;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static org.hamcrest.Matchers.is;

@Slf4j
public class StepErroresInicio {

    @Before
    public void configuracionInicial() {
        setTheStage(new OnlineCast());
    }

    //revision quiero cambiar esto
    @Cuando("proporciona su {string} y {string}")
    public void provideYourEmailAndPassword(String email, String password) {
            log.info("Que llego {}", email);
            OnStage.theActorInTheSpotlight().attemptsTo(
                    TaskIncorrectosInicio.taskIncorrectosInicio(email, password)
            );
            log.info("Que llego si lo estoy haciendo bien? {}", email);
    }

    //ejercicio git
    @Then("no debería habilitarse el botón de incio sesion")
    public void registrationButtonShouldNotBeEnabled() {
        String btnHabilitado = "Sign in";
        log.info("Valor del botón: {}", new ButtonEnable(btnHabilitado).answeredBy(OnStage.theActorInTheSpotlight()));
        OnStage.theActorInTheSpotlight().should(seeThat(new ButtonEnable(btnHabilitado), is("false")));
    }

}
