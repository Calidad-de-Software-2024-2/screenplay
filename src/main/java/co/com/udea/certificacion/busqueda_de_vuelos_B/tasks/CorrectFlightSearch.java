package co.com.udea.certificacion.busqueda_de_vuelos_B.tasks;

import java.time.LocalDate;

import co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces.FlightSearchPage;
import co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces.ListedFlightsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
public class CorrectFlightSearch implements Task {
    @Override
    public <T extends Actor> void performAs(T user) {
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        user.attemptsTo(FillThe.departureFields("Barranquilla", "Cali", tomorrow, 2));
        user.attemptsTo(Click.on(FlightSearchPage.SEARCH_BTN), WaitUntil.the(ListedFlightsPage.PRICE,
        WebElementStateMatchers.isVisible())
        .forNoMoreThan(60).seconds());
    }
    public static CorrectFlightSearch with() {
        return Tasks.instrumented(CorrectFlightSearch.class);
    }
}
