package co.com.udea.certificacion.busqueda_de_vuelos_B.stepdefinitions;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import org.openqa.selenium.WebDriver;

import co.com.udea.certificacion.busqueda_de_vuelos_B.questions.ValidateClassSelection;
import co.com.udea.certificacion.busqueda_de_vuelos_B.tasks.CorrectFlightSearch;
import co.com.udea.certificacion.busqueda_de_vuelos_B.tasks.OpenThe;
import co.com.udea.certificacion.busqueda_de_vuelos_B.tasks.SelectClass;
import co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces.ClassDetails;
import co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces.ListedFlightsPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class SeleccionarClase {

    Actor user = Actor.named("usuario");

    @Managed
    public WebDriver theDriver;

    @Before
    public void config() {
        user.can(BrowseTheWeb.with(theDriver));
        user.attemptsTo(OpenThe.flightSearchPage());
    }

    @Given("el usuario abre la lista desplegable de clases")
    public void elUsuarioAbreLaListaDesplegableDeClases() {
        user.attemptsTo(CorrectFlightSearch.with());
        user.attemptsTo(
                WaitUntil.the(ListedFlightsPage.CATEGORY_BTN, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(ListedFlightsPage.CATEGORY_BTN));

    }

    @When("el usuario selecciona una clase de vuelo {string}")
    public void elUsuarioSeleccionaUnaClaseDeVuelo(String flightClass) {
        user.remember("flightClass", flightClass);
        user.attemptsTo(SelectClass.with(flightClass));
    }

    @Then("el sistema cambia el vuelo a la clase seleccionada")
    public void elSistemaPermiteElegirClaseEconomicaPrimeraClaseYOtras() {
        GivenWhenThen.then(user).should(GivenWhenThen.seeThat(
                ValidateClassSelection.classSelected(user.recall("flightClass"), ListedFlightsPage.CATEGORY_BTN)));
    }

    @When("el usuario selecciona la opcion de {string}")
    public void elUsuarioSeleccionaUnaOpcionDeClase(String clase) {
        user.remember("clase", clase);
        user.attemptsTo(
                WaitUntil.the(ClassDetails.btnInside(clase), isVisible()).forNoMoreThan(20).seconds(),
                Click.on(ClassDetails.btnInside(clase)));
    }

    @Then("el sistema muestra los detalles de la clase seleccionada, como restricciones y beneficios")
    public void elSistemaMuestraDetallesDeClaseSeleccionada() {
        GivenWhenThen.then(user).should(GivenWhenThen
                .seeThat(ValidateClassSelection.classSelected(user.recall("clase"), ClassDetails.CATEGORY_TITLE)));
    }
}
