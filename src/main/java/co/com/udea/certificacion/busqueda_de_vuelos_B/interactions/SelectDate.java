package co.com.udea.certificacion.busqueda_de_vuelos_B.interactions;

import java.time.LocalDate;

import org.openqa.selenium.By;

import co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces.FlightSearchPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class SelectDate implements Interaction {

    private LocalDate date;
    private boolean isRoundTrip;
    private boolean isReturnDate;

    public SelectDate(LocalDate date, boolean isReturnDate, boolean isRoundTrip) {
        this.date = date;
        this.isRoundTrip = isRoundTrip;
        this.isReturnDate = isReturnDate;
    }

    public SelectDate(LocalDate date, boolean isReturnDate) {
        this.date = date;
        this.isRoundTrip = false;
        this.isReturnDate = isReturnDate;
    }

    public SelectDate(LocalDate date) {
        this.date = date;
        this.isRoundTrip = false;
        this.isReturnDate = false;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Target container = FlightSearchPage.DEPARTURE_ONLY_DIV;
        boolean dateSelectionOpened = false;
        if (isRoundTrip) {
            if (isReturnDate) {
                container = FlightSearchPage.RETURN_DIV;
            } else {
                container = FlightSearchPage.DEPARTURE_DIV;
            }
        }
        Target dayButton = FlightSearchPage.btnInside(container, Integer.toString(date.getDayOfMonth()));
        

        dateSelectionOpened = BrowseTheWeb.as(actor)
                .isElementVisible(By.xpath(container.getCssOrXPathSelector()));

        if (!dateSelectionOpened) {
            // open it
            actor.attemptsTo(Click.on(FlightSearchPage.DATE_SELECTION_BTN));
        }
        actor.attemptsTo(Click.on(dayButton));
    }

    public static SelectDate departureDate(LocalDate date, boolean isRoundTrip) {
        return Tasks.instrumented(SelectDate.class, date, false, isRoundTrip);
    }

    public static SelectDate returnDate(LocalDate date) {
        return Tasks.instrumented(SelectDate.class, date, true, true);
    }
}
