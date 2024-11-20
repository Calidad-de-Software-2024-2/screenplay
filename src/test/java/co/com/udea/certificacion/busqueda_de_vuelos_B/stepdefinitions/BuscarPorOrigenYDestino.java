package co.com.udea.certificacion.busqueda_de_vuelos_B.stepdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

import java.time.LocalDate;

import org.openqa.selenium.WebDriver;

import co.com.udea.certificacion.busqueda_de_vuelos_B.interactions.SelectCity;
import co.com.udea.certificacion.busqueda_de_vuelos_B.interactions.SelectDate;
import co.com.udea.certificacion.busqueda_de_vuelos_B.interactions.SelectPassengers;
import co.com.udea.certificacion.busqueda_de_vuelos_B.questions.FlightProperty;
import co.com.udea.certificacion.busqueda_de_vuelos_B.questions.TextIsVisible;
import co.com.udea.certificacion.busqueda_de_vuelos_B.tasks.OpenThe;
import co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces.FlightSearchPage;
import co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces.ListedFlightsPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;

public class BuscarPorOrigenYDestino {

    Actor user = Actor.named("usuario");
    String originCity = "Barranquilla";
    String destinationCity = "Cali";

    @Managed
    public WebDriver theDriver;

    @Before
    public void config() {
        user.can(BrowseTheWeb.with(theDriver));
    }

    @Given("que el usuario esta en la pagina de busqueda de vuelos")
    public void given() {
        user.attemptsTo(OpenThe.flightSearchPage());
    }

    @And("ha rellenado los demás campos necesarios")
    public void and() {
        user.attemptsTo(SelectDate.departureDate(LocalDate.now(), false),
                SelectPassengers.of(3));
    }

    @When("el usuario selecciona un origen y destino")
    public void when() {
        user.attemptsTo(SelectCity.origin(originCity),
                SelectCity.destination(destinationCity));
    }

    @And("procede con la búsqueda")
    public void andSearch() {
        user.attemptsTo(Click.on(FlightSearchPage.SEARCH_BTN));
    }

    @Then("el sistema muestra los vuelos disponibles para el origen y destino seleccionados")
    public void then() {
        ListOfWebElementFacades a = ListedFlightsPage.A_FLIGHT_CARD.resolveAllFor(user);
        for (WebElementFacade el : a) {
            user.should(seeThat(FlightProperty.origin(el), equalToIgnoringCase(originCity)),
                    seeThat(FlightProperty.destination(el), equalToIgnoringCase(destinationCity)));
        }
    }

    @When("el usuario intenta proceder con la busqueda sin seleccionar un origen y destino")
    public void whenEx() {
        user.attemptsTo(Click.on(FlightSearchPage.SEARCH_BTN));
    }

    @Then("el sistema muestra un mensaje de error indicando que se debe seleccionar un origen y destino")
    public void thenEx() {
        user.should(seeThat(TextIsVisible.originCityRequired()),
                seeThat(TextIsVisible.destinationCityRequired()));
    }

}
