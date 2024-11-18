package co.com.udea.certificacion.busqueda_de_vuelos_B.stepdefinitions;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

import co.com.udea.certificacion.busqueda_de_vuelos_B.questions.Validation;
import co.com.udea.certificacion.busqueda_de_vuelos_B.questions.ValidationBusquedaError;

import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import co.com.udea.certificacion.busqueda_de_vuelos_B.tasks.BusquedaCorrecta;
import co.com.udea.certificacion.busqueda_de_vuelos_B.tasks.ConnectTo;
import co.com.udea.certificacion.busqueda_de_vuelos_B.tasks.OpenThe;
import co.com.udea.certificacion.busqueda_de_vuelos_B.tasks.FindOutThe;
import co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces.BuscarVuelo;
import co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces.GooglePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
public class FiltrarPorFechas {

    Actor usuario = Actor.named("usuario");
    
    @Managed(driver = "chrome",uniqueSession = true)
    public WebDriver theDriver;
    @Before
    public void config() {
        usuario.can(BrowseTheWeb.with(theDriver));
        setTheStage(new OnlineCast());
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("usuario");
    }

    @Given("la usuaria se conecta al servicio")
    public void thatTheUserConnectsToTheService() {
        usuario.attemptsTo(OpenThe.browser(new GooglePage()));
    }
    @And("ingresa el nombre de la aerolinea {string}")
    public void thatTheUserWantsToSearchForAFlight(String airlineName) {
        usuario.remember("airlineName", airlineName);
    }

    @When("se realiza la busqueda de vuelos por nombre de aerolinea")
    public void heEntersTheAirline() {
        usuario.attemptsTo(FindOutThe.wordKey());
       }
    

    @Then("se muestra una lista de vuelos de {string}")
    public void heShouldSeeTheFlightInformation(String airlineName) {
         GivenWhenThen.then(usuario).should(GivenWhenThen.seeThat(Validation.theSite(), Matchers.containsString("Actualidad")));
   }
   @Given("que el usuario ha ingresado un rango de fechas para la busqueda")
   public void givenTheUserHasEnteredADateRange() {
        usuario.attemptsTo(BusquedaCorrecta.enCampos());
       // Simula que la usuaria ha ingresado un rango de fechas
   }

   @When("no hay vuelos disponibles en las fechas seleccionadas")
   public void whenNoFlightsAreAvailableInTheSelectedDates() {
       // Aquí iría la lógica que verifica que no haya vuelos en el rango de fechas seleccionado
       usuario.attemptsTo(Click.on(BuscarVuelo.SEARCH_BUTTON));
   }

   @Then("el sistema debe mostrar un mensaje indicando {string}")
   public void thenTheSystemShouldShowNoFlightsMessage() {
       GivenWhenThen.then(usuario).should(GivenWhenThen.seeThat(ValidationBusquedaError.titleError(), Matchers.equalTo("No flights found for the given criteria.")));
   }

}
