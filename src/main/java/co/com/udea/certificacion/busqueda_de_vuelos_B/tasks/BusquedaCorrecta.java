package co.com.udea.certificacion.busqueda_de_vuelos_B.tasks;

import co.com.udea.certificacion.busqueda_de_vuelos_B.interactions.BusquedaCorrectaInteraction;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class BusquedaCorrecta implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(BusquedaCorrectaInteraction.enCampos());
    }

    public static BusquedaCorrecta enCampos(){
        return Tasks.instrumented(BusquedaCorrecta.class);
    }
}