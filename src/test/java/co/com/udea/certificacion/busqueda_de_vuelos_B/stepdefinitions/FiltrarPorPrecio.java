package co.com.udea.certificacion.busqueda_de_vuelos_B.stepdefinitions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.serenitybdd.screenplay.GivenWhenThen;
import co.com.udea.certificacion.busqueda_de_vuelos_B.questions.ValidatePriceRange;
import co.com.udea.certificacion.busqueda_de_vuelos_B.tasks.CorrectFlightSearch;
import co.com.udea.certificacion.busqueda_de_vuelos_B.tasks.FilterBy;
import co.com.udea.certificacion.busqueda_de_vuelos_B.tasks.OpenThe;
import co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces.ListedFlightsPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
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
        user.attemptsTo(CorrectFlightSearch.with(),
                WaitUntil.the(By.xpath(ListedFlightsPage.A_FLIGHT_CARD.getCssOrXPathSelector()),
                        WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds());

    }

    @When("el usuario filtra por un rango de precios")
    public void when() {
        user.attemptsTo(FilterBy.price());
    }

@Then("el sistema debe mostrar solo los vuelos que estén dentro del rango de precios seleccionado")
public void then() {
    Actor actor = Actor.named("Tester").whoCan(BrowseTheWeb.with(theDriver));

    // Validar que todos los precios estén dentro del rango especificado usando el formato GivenWhenThen
    GivenWhenThen.then(actor).should(GivenWhenThen.seeThat(ValidatePriceRange.isWithin("100,200", ListedFlightsPage.PRICE_P)));
}

}