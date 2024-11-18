package co.com.udea.certificacion.busqueda_de_vuelos_B.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces.BuscarVuelo.TITLE_ERROR;

public class ValidationBusquedaError implements Question<String>{
    public ValidationBusquedaError() {}

    @Override
    public String answeredBy(Actor actor) {
        String msg = BrowseTheWeb.as(actor).find(TITLE_ERROR).getText();
        return msg;
    }

    public static ValidationBusquedaError titleError() {
        return new ValidationBusquedaError();
    }
}

