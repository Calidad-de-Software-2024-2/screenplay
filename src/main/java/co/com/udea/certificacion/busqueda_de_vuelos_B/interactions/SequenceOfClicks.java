package co.com.udea.certificacion.busqueda_de_vuelos_B.interactions;

import java.util.List;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class SequenceOfClicks implements Interaction {

    List<Target> targets;

    public SequenceOfClicks(List<Target> targets) {
        this.targets = targets;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (Target target : targets) {
            actor.attemptsTo(Click.on(target));
        }
    }
}
