package co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

import net.serenitybdd.core.pages.PageObject;

public class ClassDetails extends PageObject {
    
    public static final Target btnInside(String text) {
        return Target.the("Button %s".formatted(text))
                .locatedBy("/html/body/div[3]/div/div/div[1]/button[text()='{0}']").of(text);
    }     
    public static final Target CATEGORY_TITLE = Target.the("Categoría")
            .locatedBy("/html/body/div[3]/div/div/div/div/div[1]/h3");
    public static final Target CLASS_SELECTION_BTN = Target.the("Clase")
            .locatedBy("/html/body/div[3]/div//button[contains(text(), \"Select\")]");
}
