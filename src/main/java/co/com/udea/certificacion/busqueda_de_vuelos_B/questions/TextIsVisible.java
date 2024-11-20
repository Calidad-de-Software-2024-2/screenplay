package co.com.udea.certificacion.busqueda_de_vuelos_B.questions;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class TextIsVisible implements Question<Boolean> {

    String text;

    public TextIsVisible(String text) {
        this.text = text;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor)
                .isElementVisible(By.xpath("/html/body//p[contains(text(),'%s')]".formatted(text)));
    }

    public static TextIsVisible originCityRequired() {
        return new TextIsVisible("Origin city is required");
    }

    public static TextIsVisible destinationCityRequired() {
        return new TextIsVisible("Origin city is required");
    }

}
