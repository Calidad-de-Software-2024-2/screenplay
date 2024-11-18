package co.com.udea.certificacion.busqueda_de_vuelos_B.tasks;

import java.time.LocalDate;

import co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces.ListedFlightsPage;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class FilterBy implements Task {

    private LocalDate from;
    private LocalDate to;

    public FilterBy(LocalDate from, LocalDate to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(ListedFlightsPage.DATE_RANGE_BTN),
                Click.on(By.buttonText(Integer.toString(from.getDayOfMonth()))),
                Click.on(By.buttonText(Integer.toString(to.getDayOfMonth()))),
                Click.on(ListedFlightsPage.APPLY_FILTERS_BTN));
    }

    public static FilterBy dateRange(LocalDate from, LocalDate to) {
        return Tasks.instrumented(FilterBy.class, from, to);
    }

}
