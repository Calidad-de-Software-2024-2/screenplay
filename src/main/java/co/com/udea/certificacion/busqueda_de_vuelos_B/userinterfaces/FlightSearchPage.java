package co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class FlightSearchPage extends PageObject {
    public static final Target ORIGIN_CITY_BTN = Target.the("Ciudad de origen")
            .locatedBy("//*[@id=\"__next\"]/div/div/div/form/div[1]/div[1]/div/button");

    public static final Target DESTINY_CITY_BTN = Target.the("Ciudad de destino")
            .locatedBy("//*[@id=\"__next\"]/div/div/div/form/div[1]/div[2]/div/button");
    
    public static final Target DATE_SELECTION_BTN = Target.the("Fecha de salida")
            .locatedBy("/html/body/div/div/div/div/form/div[3]/div[1]//button");
    public static final Target ROUND_TRIP = Target.the("Viaje redondo")
            .locatedBy("/html/body/div/div/div/div/form/div[2]/div/div[2]/button");
    public static final Target ONE_WAY = Target.the("Viaje solo ida")
            .locatedBy("/html/body/div/div/div/div/form/div[2]/div/div[1]/button");
    public static final Target PASSENGERS_SELECTION_BTN = Target.the("Número de pasajeros")
            .locatedBy("//*[@id=\"__next\"]/div/div/div/form/div[3]/div[2]/div/button");

    public static final Target DEPARTURE_ONLY_CALENDAR_DIV = Target.the("Fecha de salida")
            .locatedBy("/html/body/div[2]/div/div");
    public static final Target DEPARTURE_CALENDAR_DIV = Target.the("Fecha de salida")
            .locatedBy("/html/body/div[2]/div/div/div[1]");
    public static final Target RETURN_CALENDAR_DIV = Target.the("Fecha de retorno")
            .locatedBy("/html/body/div[2]/div/div/div[2]");

    public static final Target A_TEXT_CONTAINING = Target.the("text")
            .locatedBy("/html/body//p[contains(text(),'{0}')]");

    public static final Target getPassengersOption(int passengers) {
        return Target.the("Option %d".formatted(passengers)).locatedBy(
                "//*[@id=\"radix-:R576:\"]/div/div/div[%d]".formatted(passengers + 2));
    }

    public static final Target btnInside(Target container, String text) {
        return Target.the("Button %s".formatted(text))
                .locatedBy(container.getCssOrXPathSelector() + "//button[text()='{0}']").of(text);
    }

    public static final Target SEARCH_BTN = Target.the("Buscar")
            .locatedBy("//*[@id=\"__next\"]/div/div/div/form/div[4]/button");
}
