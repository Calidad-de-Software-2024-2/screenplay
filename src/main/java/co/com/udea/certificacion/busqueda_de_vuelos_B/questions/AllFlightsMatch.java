package co.com.udea.certificacion.busqueda_de_vuelos_B.questions;

import co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces.ListedFlightsPage;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class AllFlightsMatch implements Question<Boolean> {

    String origin;
    String destination;

    public AllFlightsMatch(String origin, String destination) {
        this.origin = origin;
        this.destination = destination;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        ListOfWebElementFacades flightCards = ListedFlightsPage.A_FLIGHT_CARD.resolveAllFor(actor);
        return flightCards.stream().allMatch(card -> {
            return ValueOf.originOf(card).answeredBy(actor).equalsIgnoreCase(origin) &&
                    ValueOf.destinationOf(card).answeredBy(actor).equalsIgnoreCase(destination);
        });
    }

    public static AllFlightsMatch theOriginAndDestination(String origin, String destination) {
        return new AllFlightsMatch(origin, destination);
    }
}
