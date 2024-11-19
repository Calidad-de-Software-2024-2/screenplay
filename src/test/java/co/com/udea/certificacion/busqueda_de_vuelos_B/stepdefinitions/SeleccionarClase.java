package co.com.udea.certificacion.busqueda_de_vuelos_B.stepdefinitions;

import java.time.LocalDate;

import org.openqa.selenium.WebDriver;
import co.com.udea.certificacion.busqueda_de_vuelos_B.tasks.FillThe;
import co.com.udea.certificacion.busqueda_de_vuelos_B.tasks.OpenThe;
import co.com.udea.certificacion.busqueda_de_vuelos_B.tasks.SelectClass;
import co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces.ClassDetails;
import co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces.FlightSearchPage;
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
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.junit.Assert.assertEquals;

public class SeleccionarClase {

    Actor user = Actor.named("usuario");

    @Managed
    public WebDriver theDriver;

    @Before
    public void config() {
        user.can(BrowseTheWeb.with(theDriver));
        user.attemptsTo(OpenThe.flightSearchPage());
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        user.attemptsTo(FillThe.departureFields("Medellín", "Cali", tomorrow, 2));
        user.attemptsTo(Click.on(FlightSearchPage.SEARCH_BTN));
    }

    @Given("el usuario abre la lista desplegable de clases")
    public void elUsuarioAbreLaListaDesplegableDeClases() {
        user.attemptsTo(
            WaitUntil.the(ListedFlightsPage.CATEGORY_BTN, isVisible()).forNoMoreThan(20).seconds(),
            Click.on(ListedFlightsPage.CATEGORY_BTN)
        );
        // Código para abrir el menú desplegable de selección de clase en la lista de vuelos
    }

    @When("el usuario selecciona una clase de vuelo {string}")
    public void elUsuarioSeleccionaUnaClaseDeVuelo(String clase) {
        user.remember(clase,"clase");
        user.attemptsTo(SelectClass.with(clase));
    }
    @Then("el sistema cambia el vuelo a la clase seleccionada")
    public void elSistemaPermiteElegirClaseEconomicaPrimeraClaseYOtras() {
        String claseRecordada = user.recall("clase");
        String textoBoton = Text.of(ListedFlightsPage.CATEGORY_BTN).answeredBy(user).toString();
        GivenWhenThen.then(user).should(GivenWhenThen.seeThat("El texto del botón de clase es igual a la clase seleccionada", x -> textoBoton.equals(claseRecordada)));
    }
    @When("el usuario selecciona la opcion de {string}")
    public void elUsuarioSeleccionaUnaOpcionDeClase(String clase) {
        user.attemptsTo(
            WaitUntil.the(ClassDetails.btnInside(clase), isVisible()).forNoMoreThan(20).seconds(),
            Click.on(ClassDetails.btnInside(clase))
        );
    }

    @Then("el sistema muestra los detalles de la clase seleccionada, como restricciones y beneficios")
    public void elSistemaMuestraDetallesDeClaseSeleccionada() {
        user.recall("clase");
        GivenWhenThen.then(user).should(GivenWhenThen.seeThat(Text.of(ClassDetails.CATEGORY_TITLE), org.hamcrest.Matchers.equalTo(user.recall("clase"))));
    }
}
