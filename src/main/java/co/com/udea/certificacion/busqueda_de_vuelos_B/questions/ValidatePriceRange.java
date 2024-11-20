package co.com.udea.certificacion.busqueda_de_vuelos_B.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public class ValidatePriceRange implements Question<Boolean> {
    private final double minPrice;
    private final double maxPrice;
    private final Target priceTarget;

    public ValidatePriceRange(String priceRange, Target priceTarget) {
        // Convertir el rango de precios de cadena a números
        String[] rangeParts = priceRange.split(",");
        this.minPrice = Double.parseDouble(rangeParts[0].trim());
        this.maxPrice = Double.parseDouble(rangeParts[1].trim());
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
    public static ValidatePriceRange isWithin(String priceRange, Target priceTarget) {
        return new ValidatePriceRange(priceRange, priceTarget);
    }
}
