package co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class FlightSearchPage extends PageObject {
    public static final Target ORIGIN_CITY_BTN = Target.the("Ciudad de origen")
            .locatedBy("//*[@id=\"__next\"]/div/div/div/form/div[1]/div[1]/div/button");

    public static final Target DESTINY_CITY_BTN = Target.the("Ciudad de destino")
            .locatedBy("//*[@id=\"__next\"]/div/div/div/form/div[1]/div[2]/div/button");

    public static final Target DATE_SELECTION_BTN = Target.the("Fecha de salida")
            .locatedBy("//*[@id=\"__next\"]/div/div/div/form/div[3]/div[1]/div/div/button");

    public static final Target PASSENGERS_SELECTION_BTN = Target.the("Número de pasajeros")
            .locatedBy("//*[@id=\"__next\"]/div/div/div/form/div[3]/div[2]/div/button");

    public static final Target SEARCH_BTN = Target.the("Buscar").located(By.buttonText("Search"));
}
