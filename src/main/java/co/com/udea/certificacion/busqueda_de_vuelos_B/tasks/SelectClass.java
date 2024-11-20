package co.com.udea.certificacion.busqueda_de_vuelos_B.tasks;

import co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces.ClassDetails;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class SelectClass implements Task {
    private String clase;
    public SelectClass(String clase) {
        this.clase = clase;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(ClassDetails.btnInside(clase)),
                Click.on(ClassDetails.CLASS_SELECTION_BTN));
    }
    public static SelectClass with(String clase) {
        return Tasks.instrumented(SelectClass.class, clase);
    }

}
