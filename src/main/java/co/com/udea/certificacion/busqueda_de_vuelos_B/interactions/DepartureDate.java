package co.com.udea.certificacion.busqueda_de_vuelos_B.interactions;

import java.time.LocalDate;

import co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces.FlightSearchPage;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class DepartureDate implements Interaction {

    private LocalDate departureDate;

    public DepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(FlightSearchPage.DATE_SELECTION_BTN),
                Click.on(By.buttonText(Integer.toString(departureDate.getDayOfMonth()))));
    }

    public static DepartureDate departureDate(LocalDate date) {
        return Tasks.instrumented(DepartureDate.class, date);
    }
}
