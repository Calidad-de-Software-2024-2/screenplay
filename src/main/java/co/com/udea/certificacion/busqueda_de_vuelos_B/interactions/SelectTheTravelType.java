package co.com.udea.certificacion.busqueda_de_vuelos_B.interactions;

import java.util.Arrays;

import co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces.FlightSearchPage;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

public class SelectTheTravelType extends SequenceOfClicks {

    public SelectTheTravelType(Target button) {
        super(Arrays.asList(button));
    }

    public static SelectTheTravelType asRoundTrip() {
        return Tasks.instrumented(SelectTheTravelType.class, FlightSearchPage.ROUND_TRIP);
    }

    public static SelectTheTravelType asOneWayTrip() {
        return Tasks.instrumented(SelectTheTravelType.class, FlightSearchPage.ONE_WAY);
    }
}
