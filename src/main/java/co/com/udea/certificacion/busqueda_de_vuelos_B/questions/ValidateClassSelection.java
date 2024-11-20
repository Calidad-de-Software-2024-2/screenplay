package co.com.udea.certificacion.busqueda_de_vuelos_B.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;

public class ValidateClassSelection implements Question<Boolean> {
    private String clase;
    private Target labelToCompare;
        public ValidateClassSelection(String clase,Target labelToCompare) {
            this.clase = clase;
            this.labelToCompare=labelToCompare;
        }

    @Override
    public Boolean answeredBy(Actor actor) {
        String msg = BrowseTheWeb.as(actor).find(labelToCompare).getText();
        return msg.contains(clase);
    }

    public static ValidateClassSelection classSelected(String clase,Target labelToCompare) {
        return new ValidateClassSelection(clase,labelToCompare);
    }
    
}
