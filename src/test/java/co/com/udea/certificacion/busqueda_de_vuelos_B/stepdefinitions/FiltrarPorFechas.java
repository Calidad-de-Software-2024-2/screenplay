package co.com.udea.certificacion.busqueda_de_vuelos_B.stepdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.containsStringIgnoringCase;

import java.time.LocalDate;

import org.openqa.selenium.WebDriver;

import co.com.udea.certificacion.busqueda_de_vuelos_B.tasks.FillFields;
import co.com.udea.certificacion.busqueda_de_vuelos_B.tasks.OpenThe;
import co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces.FlightSearchPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;

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
        user.attemptsTo(FillFields.with("Bucaramanga", "Santa Marta", tomorrow, 2));
    }

    @When("el usuario hace clic en buscar")
    public void when() {
        user.attemptsTo(Click.on(FlightSearchPage.SEARCH_BTN));
    }

    @Then("el sistema debe mostrar un mensaje indicando que no hay vuelos disponibles en el rango de fechas seleccionado")
    public void then() {
        user.should(seeThat(Text.of(By.tagName("p")),
                anyOf(containsStringIgnoringCase("No flights"),
                        containsStringIgnoringCase("No hay vuelos"))));
    }

}
