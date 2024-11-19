package co.com.udea.certificacion.busqueda_de_vuelos_B.interactions;

import co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces.FlightSearchPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class SelectTravelType implements Interaction{
    private Target button;
    public SelectTravelType(Target button) {
        this.button = button;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(button));
    }
    public static SelectTravelType roundTrip() {
        return Tasks.instrumented(SelectTravelType.class,FlightSearchPage.ROUND_TRIP);
    }
    public static SelectTravelType oneWayTrip() {
        return Tasks.instrumented(SelectTravelType.class,FlightSearchPage.ONE_WAY);
    }
}
