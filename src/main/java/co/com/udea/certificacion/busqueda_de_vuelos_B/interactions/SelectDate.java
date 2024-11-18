package co.com.udea.certificacion.busqueda_de_vuelos_B.interactions;

import java.time.LocalDate;

import co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces.FlightSearchPage;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class SelectDate implements Interaction {

    private LocalDate date;

    public SelectDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(FlightSearchPage.DATE_SELECTION_BTN),
                Click.on(By.buttonText(Integer.toString(date.getDayOfMonth()))));
    }

    public static SelectDate departureDate(LocalDate date) {
        return Tasks.instrumented(SelectDate.class, date);
    }
}
