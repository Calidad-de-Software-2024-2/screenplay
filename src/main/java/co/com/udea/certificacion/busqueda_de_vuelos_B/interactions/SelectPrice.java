package co.com.udea.certificacion.busqueda_de_vuelos_B.interactions;


import co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces.ListedFlightsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class SelectPrice implements Interaction {

    private Target priceFilterButton;
    private Target valueButton;

    public SelectPrice(Target priceFilterButton, Target valueButton) {
        this.priceFilterButton = priceFilterButton;
        this.valueButton = valueButton;
    }

   @Override
    public <T extends Actor> void performAs(T actor) {
       actor.attemptsTo(Click.on(priceFilterButton),
                Click.on(valueButton));
    }

    public static SelectPrice priceSelect() {
        return Tasks.instrumented(SelectPrice.class, ListedFlightsPage.PRICE_FILTER_BTN, ListedFlightsPage.PRICE_RANGE_BTN);
    }
    
}
