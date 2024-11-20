package co.com.udea.certificacion.busqueda_de_vuelos_B.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValueOf implements Question<String> {

    WebElementFacade container;
    String propertyName;

    public ValueOf(WebElementFacade container, String expected) {
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

    public static ValueOf originOf(WebElementFacade card) {
        return new ValueOf(card, "Origin");
    }

    public static ValueOf destinationOf(WebElementFacade card) {
        return new ValueOf(card, "Destination");
    }

}
