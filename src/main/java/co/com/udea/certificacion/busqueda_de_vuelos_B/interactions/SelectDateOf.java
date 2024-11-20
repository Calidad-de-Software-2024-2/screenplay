package co.com.udea.certificacion.busqueda_de_vuelos_B.interactions;

import java.time.Duration;
import java.time.LocalDate;

import org.openqa.selenium.By;

import co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces.FlightSearchPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class SelectDateOf implements Interaction {

    private LocalDate date;
    private Target calendarContainer;

    public SelectDateOf(LocalDate date, Target calendarContainer) {
        this.date = date;
        this.calendarContainer = calendarContainer;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        boolean dateSelectionOpened = BrowseTheWeb.as(actor).isElementVisible(
                By.xpath(calendarContainer.waitingForNoMoreThan(Duration.ofSeconds(2)).getCssOrXPathSelector()));

        // if calendar container is no open
        if (!dateSelectionOpened) {
            // open it to select a date
            actor.attemptsTo(Click.on(FlightSearchPage.DATE_SELECTION_BTN));
        }

        Target dayButton = FlightSearchPage.btnInside(calendarContainer, Integer.toString(date.getDayOfMonth()));
        actor.attemptsTo(Click.on(dayButton));
    }

    public static SelectDateOf departureDate(LocalDate date, boolean isRoundTrip) {
        if (isRoundTrip) {
            return Tasks.instrumented(SelectDateOf.class, date, FlightSearchPage.DEPARTURE_CALENDAR_DIV);
        } else {
            return Tasks.instrumented(SelectDateOf.class, date, FlightSearchPage.DEPARTURE_ONLY_CALENDAR_DIV);
        }
    }

    public static SelectDateOf returnDate(LocalDate date) {
        return Tasks.instrumented(SelectDateOf.class, date, FlightSearchPage.RETURN_CALENDAR_DIV);
    }
}
