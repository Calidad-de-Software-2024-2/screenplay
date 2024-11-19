package co.com.udea.certificacion.busqueda_de_vuelos_B.stepdefinitions;

import java.time.LocalDate;

import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import co.com.udea.certificacion.busqueda_de_vuelos_B.tasks.FillThe;
import co.com.udea.certificacion.busqueda_de_vuelos_B.tasks.OpenThe;
import co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces.FlightSearchPage;
import co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces.ListedFlightsPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class FiltrarPorFechas {

    Actor user = Actor.named("usuario");

    @Managed
    public WebDriver theDriver;

    @Before
    public void config() {
        user.can(BrowseTheWeb.with(theDriver));
        user.attemptsTo(OpenThe.flightSearchPage());
    }

    @Given("que el usuario ha ingresado un rango de fechas para la búsqueda")
    public void given() {
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        LocalDate afterTomorrow = LocalDate.now().plusDays(2);
        user.attemptsTo(FillThe.rountTripFields("Bucaramanga", "Santa Marta", tomorrow, afterTomorrow, 2));
    }

    @When("el usuario hace clic en buscar")
    public void when() {
        user.attemptsTo(Click.on(FlightSearchPage.SEARCH_BTN));
    }

    @Then("el sistema debe mostrar un mensaje indicando que no hay vuelos disponibles en el rango de fechas seleccionado")
    public void then() {
        WaitUntil.the(ListedFlightsPage.ERROR_MESSAGE, containsText("no flights"))
                .forNoMoreThan(5).seconds();
    }

}
