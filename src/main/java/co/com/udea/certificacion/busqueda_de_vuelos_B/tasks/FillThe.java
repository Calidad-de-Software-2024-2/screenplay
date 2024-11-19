package co.com.udea.certificacion.busqueda_de_vuelos_B.tasks;

import java.time.LocalDate;

import co.com.udea.certificacion.busqueda_de_vuelos_B.interactions.SelectCity;
import co.com.udea.certificacion.busqueda_de_vuelos_B.interactions.SelectDate;
import co.com.udea.certificacion.busqueda_de_vuelos_B.interactions.SelectPassengers;
import co.com.udea.certificacion.busqueda_de_vuelos_B.interactions.SelectTravelType;
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
                SelectCity.origin(origin),
                SelectCity.destiny(destiny),
                SelectTravelType.roundTrip());

        actor.attemptsTo(Click.on(FlightSearchPage.DATE_SELECTION_BTN)); // abre la selección de fechas
        if (returnDate != null) { // ida y vuelta
            actor.attemptsTo(SelectDate.departureDate(departureDate, true),
                    SelectDate.returnDate(returnDate));
        } else { // solo ida
            actor.attemptsTo(SelectDate.departureDate(departureDate, false));
        }

        actor.attemptsTo(
                SelectPassengers.of(passengers));
    }

    public static FillThe rountTripFields(String origin, String destiny, LocalDate departureDate, LocalDate arrivalDate,
            int passengers) {
        return Tasks.instrumented(FillThe.class, origin, destiny, departureDate, arrivalDate, passengers);
    }

    public static FillThe departureFields(String origin, String destiny, LocalDate departureDate, int passengers) {
        return Tasks.instrumented(FillThe.class, origin, destiny, departureDate, passengers);
    }

}
