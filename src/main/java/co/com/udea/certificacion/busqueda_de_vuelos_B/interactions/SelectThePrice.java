package co.com.udea.certificacion.busqueda_de_vuelos_B.interactions;

import java.util.Arrays;

import co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces.ListedFlightsPage;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

public class SelectThePrice extends SequenceOfClicks {

    public SelectThePrice(Target priceFilterButton, Target valueButton) {
        super(Arrays.asList(priceFilterButton, valueButton));
    }

    public static SelectThePrice of100to200() {
        return Tasks.instrumented(SelectThePrice.class, ListedFlightsPage.PRICE_FILTER_BTN,
                ListedFlightsPage.PRICE_RANGE_BTN);
    }

}
