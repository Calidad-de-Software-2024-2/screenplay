package co.com.udea.certificacion.busqueda_de_vuelos_B.stepdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

import java.time.LocalDate;

import org.openqa.selenium.WebDriver;

import co.com.udea.certificacion.busqueda_de_vuelos_B.questions.SelectedDate;
import co.com.udea.certificacion.busqueda_de_vuelos_B.tasks.FilterBy;
import co.com.udea.certificacion.busqueda_de_vuelos_B.tasks.OpenThe;
import co.com.udea.certificacion.busqueda_de_vuelos_B.tasks.SearchFlight;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import kotlin.NotImplementedError;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class FiltrarPorFechas {

    Actor user = Actor.named("usuario");

    @Managed
    public WebDriver theDriver;

    @Before
    public void config() {
        user.can(BrowseTheWeb.with(theDriver));
    }

    @Given("que el usuario esta en la pagina de busqueda de vuelos")
    public void userInTheWebsite() {
        user.attemptsTo(OpenThe.flightSearchPage());
    }

    @And("el usuario ha realizado una búsqueda previa")
    public void userHasEnteredOriginAndDestiny() {
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        user.attemptsTo(SearchFlight.by("Barranquilla", "Cartagena", tomorrow, 4));
    }

    @When("el usuario intenta filtrar por rango de fechas")
    public void userFiltersByDateRange() {
        // LocalDate from = LocalDate.now().minusDays(1);
        // LocalDate to = LocalDate.now().plusDays(30);
        // user.attemptsTo(FilterBy.dateRange(from, to));
    }

    @Then("el sistema permite seleccionar un rango de fechas")
    public void systemAllowsDateSelection() {
        throw new NotImplementedError("El botón de fecha no existe por tanto no se puede comprobar que valor contiene");
    }
    
    @But("si el usuario ha seleccionado fechas específicas en la búsqueda")
    public void ifUserHasSelectedThat() {
        throw new NotImplementedError("El botón de fecha no existe por tanto no se puede comprobar que valor contiene");
    }

    @Then("el sistema no permite filtrar por rango de fechas")
    public void systemsDisallowsDateFiltering() {
        throw new NotImplementedError("Noc");
    }

}
