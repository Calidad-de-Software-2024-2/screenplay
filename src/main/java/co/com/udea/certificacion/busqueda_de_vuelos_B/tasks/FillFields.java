package co.com.udea.certificacion.busqueda_de_vuelos_B.tasks;

import java.time.LocalDate;

import co.com.udea.certificacion.busqueda_de_vuelos_B.interactions.SelectCity;
import co.com.udea.certificacion.busqueda_de_vuelos_B.interactions.ArrivalDate;
import co.com.udea.certificacion.busqueda_de_vuelos_B.interactions.DepartureDate;
import co.com.udea.certificacion.busqueda_de_vuelos_B.interactions.SelectPassengers;
import co.com.udea.certificacion.busqueda_de_vuelos_B.interactions.SelectTravelType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class FillFields implements Task {

    private String origin;
    private String destiny;
    private LocalDate departureDate;
    private LocalDate arrivalDate;
    private int passengers;

    public FillFields(String origin, String destiny, LocalDate departureDate,LocalDate arrivalDate, int passengers) {
        this.origin = origin;
        this.destiny = destiny;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.passengers = passengers;
        
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectCity.origin(origin),
                SelectCity.destiny(destiny),
                SelectTravelType.roundTrip(),
                DepartureDate.departureDate(departureDate),
                ArrivalDate.arrivalDate(arrivalDate),
                SelectPassengers.of(passengers));
                
    }

    public static FillFields with(String origin, String destiny, LocalDate departureDate,LocalDate arrivalDate, int passengers) {
        return Tasks.instrumented(FillFields.class, origin, destiny, departureDate,arrivalDate, passengers);
    }

}
