package co.com.udea.certificacion.busqueda_de_vuelos_B.tasks;

import co.com.udea.certificacion.busqueda_de_vuelos_B.interactions.SelectPrice;
import co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces.ListedFlightsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class FilterBy implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ListedFlightsPage.FILTERS_BTN),
                SelectPrice.priceSelect(),
                Click.on(ListedFlightsPage.APPLY_FILTERS_BTN)
        );
    }

    public static FilterBy price() {
        return Tasks.instrumented(FilterBy.class);
    }

}
