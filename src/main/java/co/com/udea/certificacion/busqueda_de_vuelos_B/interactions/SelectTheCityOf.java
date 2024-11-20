package co.com.udea.certificacion.busqueda_de_vuelos_B.interactions;

import java.util.Arrays;

import co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces.FlightSearchPage;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

public class SelectTheCityOf extends SequenceOfClicks {

    public SelectTheCityOf(Target button, String city) {
        super(Arrays.asList(button, Target.the(city).located(By.buttonText(city))));
    }

    public static SelectTheCityOf origin(String city) {
        return Tasks.instrumented(SelectTheCityOf.class, FlightSearchPage.ORIGIN_CITY_BTN, city);
    }

    public static SelectTheCityOf destination(String city) {
        return Tasks.instrumented(SelectTheCityOf.class, FlightSearchPage.DESTINY_CITY_BTN, city);
    }

}
