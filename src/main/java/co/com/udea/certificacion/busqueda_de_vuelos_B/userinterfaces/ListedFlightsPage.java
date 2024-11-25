package co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class ListedFlightsPage {

    public static final Target FILTERS_BTN = Target.the("Abrir filtros")
            .locatedBy("/html/body/div/div/div//button[contains(.,'Filters')]");

    public static final Target PRICE_FILTER_BTN = Target.the("Filtro de precios")
            .locatedBy("/html/body/div[3]/div/button[2]");

    public static final Target PRICE_RANGE_BTN = Target.the("Rango de precios")
            .locatedBy("/html/body/div[4]/div/div/div/div[3]");
        public static final Target PRICE_RANGE_200_300 = Target.the("Rango de precios")
            .locatedBy("/html/body/div[4]/div/div/div/div[4]");        
    public static final Target A_PRICE_TAG = Target.the("Etiqueta de precio")
            .locatedBy("//p[contains(text(),'USD')]");
    public static final Target APPLY_FILTERS_BTN = Target.the("Aplicar filtros").located(By.buttonText("Apply"));
    public static final Target DATE_RANGE_BTN = Target.the("Seleccionar rango de fechas")
            .located(By.buttonText("Rango de fechas"));

    public static final Target A_FLIGHT_CARD = Target.the("Vuelo")
            .locatedBy("/html/body/div/div/div/div/div[2]/div");

    public static final Target FLIGHT_CARD_CHILD_CONTAINS = Target.the("Vuelo")
            .locatedBy("/html/body/div/div/div/div/div[2]/div//p[contains(text(),'{0}')]");

    public static final Target ERROR_MESSAGE = Target.the("Mensaje errororo")
            .locatedBy("//*[@id=\"__next\"]/div/div/div/div[2]/p");
    public static final Target CATEGORY_BTN = Target.the("Seleccionar categoría")
            .locatedBy("/html/body/div/div/div/div/div[2]/div[1]/div[1]/div[6]/button");
}
