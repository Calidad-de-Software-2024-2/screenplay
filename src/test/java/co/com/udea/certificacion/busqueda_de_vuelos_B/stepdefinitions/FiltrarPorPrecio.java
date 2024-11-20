package co.com.udea.certificacion.busqueda_de_vuelos_B.stepdefinitions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        // Esperar hasta que las tarjetas de vuelos estén presentes
        // Localizar las tarjetas de vuelos después de la espera
        List<WebElement> tarjetasDeVuelos = theDriver
                .findElements(By.xpath("/html/body/div/div/div/div/div[2]/div//p[contains(text(),'USD')]"));

        // Iterar sobre cada elemento encontrado y validar los precios
        tarjetasDeVuelos.forEach(price -> {
            String precioTexto = price.getText().replace("USD$", "").trim();

            try {
                double precio = Double.parseDouble(precioTexto);

                // Validar que el precio está dentro del rango permitido
                if (precio < 100 || precio > 200) {
                    throw new AssertionError("El vuelo con precio " + precio + " está fuera del rango [100, 200]");
                }
            } catch (NumberFormatException e) {
                throw new AssertionError("No se pudo convertir el precio a un número en la tarjeta: " + precioTexto);
            }
        });
    }

}