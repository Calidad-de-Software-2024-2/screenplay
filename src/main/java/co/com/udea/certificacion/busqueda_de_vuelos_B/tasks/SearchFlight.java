package co.com.udea.certificacion.busqueda_de_vuelos_B.tasks;

import java.time.LocalDate;

import co.com.udea.certificacion.busqueda_de_vuelos_B.interactions.SelectCity;
import co.com.udea.certificacion.busqueda_de_vuelos_B.interactions.SelectDate;
import co.com.udea.certificacion.busqueda_de_vuelos_B.interactions.SelectPassengers;
import co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces.FlightSearchPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class SearchFlight implements Task {

    private String origin;
    private String destiny;
    private LocalDate departureDate;
    private int passengers;

    public SearchFlight(String origin, String destiny, LocalDate departureDate, int passengers) {
        this.origin = origin;
        this.destiny = destiny;
        this.departureDate = departureDate;
        this.passengers = passengers;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectCity.origin(origin),
                SelectCity.destiny(destiny),
                SelectDate.departureDate(departureDate),
                SelectPassengers.of(passengers),
                Click.on(FlightSearchPage.SEARCH_BTN));
    }

    public static SearchFlight by(String origin, String destiny, LocalDate departureDate, int passengers) {
        return Tasks.instrumented(SearchFlight.class, origin, destiny, departureDate, passengers);
    }

}
