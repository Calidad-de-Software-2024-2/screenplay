package co.com.udea.certificacion.busqueda_de_vuelos_B.questions;

import java.util.List;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class CheckIfPrice implements Question<Boolean> {
    private final double minPrice;
    private final double maxPrice;
    private final Target priceTarget;

    public CheckIfPrice(Double[] priceRange, Target priceTarget) {
        Double[] rangeParts = priceRange;
        this.minPrice = rangeParts[0];
        this.maxPrice = rangeParts[1];
        this.priceTarget = priceTarget;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        List<WebElementFacade> tarjetasDeVuelos = priceTarget.resolveAllFor(actor);

        for (WebElementFacade priceElement : tarjetasDeVuelos) {
            String precioTexto = priceElement.getText().replace("USD$", "").trim();

            try {
                double precio = Double.parseDouble(precioTexto);
                if (precio < minPrice || precio > maxPrice) {
                    return false; 
                }
            } catch (NumberFormatException e) {
                throw new AssertionError("No se pudo convertir el precio a un número en la tarjeta: " + precioTexto);
            }
        }
        return true; 
    }
    public static CheckIfPrice isWithin(Double[] priceRange, Target priceTarget) {
        return new CheckIfPrice(priceRange, priceTarget);
    }
}
