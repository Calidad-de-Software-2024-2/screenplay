package co.com.udea.certificacion.busqueda_de_vuelos_B.stepdefinitions;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static org.hamcrest.Matchers.anyOf;

import java.time.LocalDate;

import org.openqa.selenium.WebDriver;

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
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class BuscarPorFechas {

    Actor user = Actor.named("usuario");

    @Managed
    public WebDriver theDriver;

    @Before
    public void config() {
        user.can(BrowseTheWeb.with(theDriver));
        user.attemptsTo(OpenThe.flightSearchPage());
    }

    @Given("que el usuario está ingresando un rango de fechas para la búsqueda donde la fecha maxima es anterior a la fecha mínima")
    public void queElUsuarioEstaSeleccionandoUnRangoDeFechasParaLaBusqueda() {
        LocalDate departureDay = LocalDate.now().plusDays(2);
        LocalDate dayBeforeDeparture = departureDay.minusDays(1);
        user.attemptsTo(FillThe.roundTripFields("Bucaramanga", "Pereira", departureDay, dayBeforeDeparture, 2));
    }

    @Then("el sistema muestra un mensaje de error indicando que la fecha máxima no puede ser anterior a la fecha mínima")
    public void elSistemaMuestraMensajeErrorFechaMaximaAnteriorFechaMinima() {
        WaitUntil.the(ListedFlightsPage.ERROR_MESSAGE, WebElementStateMatchers.containsText("No flights"))
                .forNoMoreThan(5).seconds();
    }

    @Given("que el usuario ha ingresado un rango de fechas para la búsqueda")
    public void given() {
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        LocalDate afterTomorrow = LocalDate.now().plusDays(2);
        user.attemptsTo(FillThe.roundTripFields("Bucaramanga", "Pereira", tomorrow, afterTomorrow, 2));
    }

    @When("el usuario hace clic en buscar")
    public void when() {
        user.attemptsTo(Click.on(FlightSearchPage.SEARCH_BTN));
    }

    @Then("el sistema debe mostrar un mensaje indicando que no hay vuelos disponibles en el rango de fechas seleccionado")
    public void then() {
        user.attemptsTo(
                WaitUntil.the(ListedFlightsPage.ERROR_MESSAGE, anyOf(containsText("INTERNAL_ERROR")))
                        .forNoMoreThan(15).seconds());
    }

}
