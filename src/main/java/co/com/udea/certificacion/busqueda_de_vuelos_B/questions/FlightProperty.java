package co.com.udea.certificacion.busqueda_de_vuelos_B.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class FlightProperty implements Question<String> {

    WebElementFacade container;
    String propertyName;

    public FlightProperty(WebElementFacade container, String expected) {
        this.container = container;
        this.propertyName = expected;
    }

    @Override
    public String answeredBy(Actor actor) {
        WebElementFacade propertyElement = container.findBy("//p[contains(text(),'%s')]".formatted(propertyName));
        if (propertyElement == null)
            return null;
        return propertyElement.getText().replace(propertyName, "").replaceAll(":", "").trim();
    }

    public static FlightProperty origin(WebElementFacade card) {
        return new FlightProperty(card, "Origin");
    }

    public static FlightProperty destination(WebElementFacade card) {
        return new FlightProperty(card, "Destination");
    }

}
