package co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class BuscarVuelo extends PageObject {
    // Título de la página
    public static final Target PAGE_TITLE = Target.the("Page title")
            .locatedBy("h2.text-center");


    public static final Target ORIGIN_SELECT_BUTTON = Target.the("Origin select button")
            .locatedBy("//*[@id=\"__next\"]/div/div/div/form/div[1]/div[1]/div/button");
    public static final Target ORIGIN_SELECT = Target.the("Origin select")
            .locatedBy("/html/body/div[2]");
    public static final Target DESTINATION_SELECT_BUTTON = Target.the("Destination select button")
            .locatedBy("//*[@id=\"__next\"]/div/div/div/form/div[1]/div[2]/div/button");
        public static final Target DESTINATION_SELECT = Target.the("Destination select")
            .locatedBy("/html/body/div[2]");
    // Radio button para el tipo de vuelo
    public static final Target DEPARTURE_RADIO = Target.the("Departure radio button")
            .locatedBy("//*[@id=\"r1\"]");
    public static final Target ROUNDTRIP_RADIO = Target.the("Roundtrip radio button")
            .locatedBy("//*[@id=\"r2\"]");
            public static final Target TITLE_ERROR = Target.the("Mensaje de error").locatedBy("//*[@id=\"__next\"]/div/div/div/div[2]/p");


    public static final Target DATE_PICKER_DAY = Target.the("Date input field")
            .locatedBy("//*[@id=\"__next\"]/div/div/div/form/div[3]/div[1]/div/div/button");


    public static final Target PASSENGERS_SELECT_BUTTON = Target.the("Passengers select button")
            .locatedBy("//*[@id=\"__next\"]/div/div/div/form/div[3]/div[2]/div/select");

    // Botón de búsqueda
    public static final Target SEARCH_BUTTON = Target.the("Search button")
    .locatedBy("//button[text()='Search']");

}

