package co.com.udea.certificacion.busqueda_de_vuelos_B.questions;

import co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces.FlightSearchPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class GetTextOf implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor).find(FlightSearchPage.DATE_SELECTION_BTN).getText();
    }

    public static GetTextOf departureBtn() {
        return new GetTextOf();
    }

}
