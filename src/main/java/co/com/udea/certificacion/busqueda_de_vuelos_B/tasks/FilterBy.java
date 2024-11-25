package co.com.udea.certificacion.busqueda_de_vuelos_B.tasks;

import co.com.udea.certificacion.busqueda_de_vuelos_B.interactions.SelectThePrice;
import co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces.ListedFlightsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class FilterBy implements Interaction {

    private String priceRange;

    // Constructor que recibe el rango de precio
    public FilterBy(String priceRange) {
        this.priceRange = priceRange;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ListedFlightsPage.FILTERS_BTN)
        );

        if ("100to200".equals(priceRange)) {
            actor.attemptsTo(SelectThePrice.of100to200());
        } else if ("200to300".equals(priceRange)) {
            actor.attemptsTo(SelectThePrice.of200to300());
        } else {
            throw new IllegalArgumentException("Unexpected value: " + priceRange);
        }

        actor.attemptsTo(
                Click.on(ListedFlightsPage.APPLY_FILTERS_BTN)
        );
    }

    public static FilterBy priceRange(String priceRange) {
        return Tasks.instrumented(FilterBy.class, priceRange);
    }
}