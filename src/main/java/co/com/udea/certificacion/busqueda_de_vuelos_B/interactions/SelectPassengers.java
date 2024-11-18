package co.com.udea.certificacion.busqueda_de_vuelos_B.interactions;

import co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces.FlightSearchPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class SelectPassengers implements Task {

    private Target button;
    private int numberOfPassengers;

    public SelectPassengers(Target button, int numberOfPassengers) {
        this.button = button;
        this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(button),
                Click.on(FlightSearchPage.getPassengersOption(numberOfPassengers)));
    }

    public static SelectPassengers of(int passengers) {
        return Tasks.instrumented(SelectPassengers.class, FlightSearchPage.PASSENGERS_SELECTION_BTN, passengers);
    }

}
