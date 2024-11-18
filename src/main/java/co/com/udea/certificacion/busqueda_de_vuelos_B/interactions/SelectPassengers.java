package co.com.udea.certificacion.busqueda_de_vuelos_B.interactions;

import org.openqa.selenium.Keys;

import co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces.FlightSearchPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.targets.Target;

public class SelectPassengers implements Task {

    private Target button;
    private int numberOfPassengers;

    public SelectPassengers(Target button, int numberOfPassengers) {
        this.button = button;
        this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // actor.attemptsTo(Click.on(button),
        // Click.on(By.buttonText(Integer.toString(numberOfPassengers))));
        actor.attemptsTo(Click.on(button),
                Hit.the(Keys.NUMPAD4, Keys.ENTER).into("/html/body/div/div/div/div/form/div[3]/div[2]/div/select"));
    }

    public static SelectPassengers of(int passengers) {
        return Tasks.instrumented(SelectPassengers.class, FlightSearchPage.PASSENGERS_SELECTION_BTN, passengers);
    }

}
