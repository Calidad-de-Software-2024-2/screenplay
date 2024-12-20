package co.com.udea.certificacion.busqueda_de_vuelos_B.tasks;

import java.time.LocalDate;

import co.com.udea.certificacion.busqueda_de_vuelos_B.interactions.SelectDateOf;
import co.com.udea.certificacion.busqueda_de_vuelos_B.interactions.SelectPassengers;
import co.com.udea.certificacion.busqueda_de_vuelos_B.interactions.SelectTheCityOf;
import co.com.udea.certificacion.busqueda_de_vuelos_B.interactions.SelectTheTravelType;
import co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces.FlightSearchPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class FillThe implements Task {

    private String origin;
    private String destiny;
    private LocalDate departureDate;
    private LocalDate returnDate;
    private int passengers;

    public FillThe(String origin, String destiny, LocalDate departureDate, LocalDate returnDate, int passengers) {
        this.origin = origin;
        this.destiny = destiny;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.passengers = passengers;

    }

    public FillThe(String origin, String destiny, LocalDate departureDate, int passengers) {
        this.origin = origin;
        this.destiny = destiny;
        this.departureDate = departureDate;
        this.returnDate = null;
        this.passengers = passengers;

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectTheCityOf.origin(origin),
                SelectTheCityOf.destination(destiny));

        if (returnDate != null) { // ida y vuelta
            actor.attemptsTo(SelectTheTravelType.asRoundTrip(), SelectDateOf.returnDate(returnDate),
                    SelectDateOf.departureDate(departureDate, true));
        } else { // solo ida
            actor.attemptsTo(
                    Click.on(FlightSearchPage.DATE_SELECTION_BTN),
                    SelectDateOf.departureDate(departureDate, false));
        }

        actor.attemptsTo(
                SelectPassengers.of(passengers));
    }

    public static FillThe roundTripFields(String origin, String destiny, LocalDate departureDate, LocalDate arrivalDate,
            int passengers) {
        return Tasks.instrumented(FillThe.class, origin, destiny, departureDate, arrivalDate, passengers);
    }

    public static FillThe departureFields(String origin, String destiny, LocalDate departureDate, int passengers) {
        return Tasks.instrumented(FillThe.class, origin, destiny, departureDate, passengers);
    }

}
