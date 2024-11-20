package co.com.udea.certificacion.busqueda_de_vuelos_B.interactions;

import java.util.Arrays;

import co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces.ClassDetails;
import net.serenitybdd.screenplay.Tasks;

public class SelectClass extends SequenceOfClicks {

    public SelectClass(String clase) {
        super(Arrays.asList(ClassDetails.btnInside(clase), ClassDetails.CLASS_SELECTION_BTN));
    }

    public static SelectClass with(String clase) {
        return Tasks.instrumented(SelectClass.class, clase);
    }

}
