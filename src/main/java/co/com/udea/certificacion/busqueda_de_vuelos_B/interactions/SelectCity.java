package co.com.udea.certificacion.busqueda_de_vuelos_B.interactions;

import co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces.FlightSearchPage;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class SelectCity implements Task {

    private Target button;
    private String city;

    public SelectCity(Target button, String city) {
        this.button = button;
        this.city = city;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(button),
                Click.on(By.buttonText(city)));
    }

    public static SelectCity origin(String city) {
        return Tasks.instrumented(SelectCity.class, FlightSearchPage.ORIGIN_CITY_BTN, city);
    }

    public static SelectCity destination(String city) {
        return Tasks.instrumented(SelectCity.class, FlightSearchPage.DESTINY_CITY_BTN, city);
    }

}
