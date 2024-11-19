package co.com.udea.certificacion.busqueda_de_vuelos_B.interactions;

import java.time.LocalDate;

import co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces.FlightSearchPage;
import net.bytebuddy.asm.Advice.Local;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class ArrivalDate implements Interaction {
    private LocalDate arrivalDate;
    public ArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
        Click.on(Target.the("botón con el número 5")
        .located(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/table/tbody//button[normalize-space(text())='25']")))

                
                );
    }

    public static ArrivalDate arrivalDate(LocalDate arrivalDate) {
        return Tasks.instrumented(ArrivalDate.class,arrivalDate);
    }
}
