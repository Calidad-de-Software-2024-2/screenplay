package co.com.udea.certificacion.busqueda_de_vuelos_B.interactions;

import java.util.Arrays;

import co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces.FlightSearchPage;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

public class SelectPassengers extends SequenceOfClicks {

    public SelectPassengers(Target button, int numberOfPassengers) {
        super(Arrays.asList(button, FlightSearchPage.getPassengersOption(numberOfPassengers)));
    }

    public static SelectPassengers of(int passengers) {
        return Tasks.instrumented(SelectPassengers.class, FlightSearchPage.PASSENGERS_SELECTION_BTN, passengers);
    }

}
