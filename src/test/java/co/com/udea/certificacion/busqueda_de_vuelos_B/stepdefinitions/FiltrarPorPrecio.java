package co.com.udea.certificacion.busqueda_de_vuelos_B.stepdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static org.hamcrest.Matchers.anyOf;

import org.openqa.selenium.WebDriver;

import co.com.udea.certificacion.busqueda_de_vuelos_B.questions.CheckIfPrice;
import co.com.udea.certificacion.busqueda_de_vuelos_B.tasks.DoA;
import co.com.udea.certificacion.busqueda_de_vuelos_B.tasks.FilterBy;
import co.com.udea.certificacion.busqueda_de_vuelos_B.tasks.OpenThe;
import co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces.ListedFlightsPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class FiltrarPorPrecio {
    Actor user = Actor.named("usuario");

    @Managed
    public WebDriver theDriver;

    @Before
    public void config() {
        user.can(BrowseTheWeb.with(theDriver));
        user.attemptsTo(OpenThe.flightSearchPage());
    }

    @Given("que el usuario ha realizado una busqueda que arroje resultados")
    public void given() {
        user.attemptsTo(DoA.searchWithResults());

    }

    @When("el usuario filtra por un rango de precios")
    public void when() {
        user.attemptsTo(FilterBy.priceRange("100to200"));
    }
    
    @When("el usuario filtra por un rango de precios que no tiene vuelos disponibles")
    public void noFlightsFilter() {
        user.attemptsTo(FilterBy.priceRange("200to300"));
    }

    @Then("el sistema debe mostrar solo los vuelos que estén dentro del rango de precios seleccionado")
    public void then() {
        user.should(seeThat(CheckIfPrice.isWithin(new Double[] { 100d, 200d }, ListedFlightsPage.A_PRICE_TAG)));
    }
    @Then("el sistema debe mostrar un mensaje indicando que no hay vuelos disponibles en el rango seleccionado")
    public void noFlightsAvailable() {
        user.attemptsTo(
                WaitUntil.the(ListedFlightsPage.ERROR_MESSAGE, anyOf(containsText("No flights")))
                        .forNoMoreThan(15).seconds());
    }
    
}