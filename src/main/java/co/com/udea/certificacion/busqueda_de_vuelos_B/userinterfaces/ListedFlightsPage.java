package co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class ListedFlightsPage {

    public static final Target APPLY_FILTERS_BTN = Target.the("Aplicar filtros").located(By.buttonText("Apply"));
    public static final Target DATE_RANGE_BTN = Target.the("Seleccionar rango de fechas")
            .located(By.buttonText("Rango de fechas")); // TODO: This btn does not exist atm

}
