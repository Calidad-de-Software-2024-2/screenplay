package co.com.udea.certificacion.busqueda_de_vuelos_B.interactions;

import co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces.BuscarVuelo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

public class BusquedaCorrectaInteraction implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            // Llenar el campo de origen
            SelectFromOptions.byValue("Cartagena").from(BuscarVuelo.ORIGIN_SELECT_BUTTON),
            
            // Llenar el campo de destino
            SelectFromOptions.byValue("Cali").from(BuscarVuelo.DESTINATION_SELECT_BUTTON),
            
            // Seleccionar tipo de vuelo (ida o ida y vuelta)
            Click.on(BuscarVuelo.DEPARTURE_RADIO),
            // O bien, para ida y vuelta:
            // Click.on(BuscarVuelo.ROUNDTRIP_RADIO),
            
            // Seleccionar el número de pasajeros
            SelectFromOptions.byValue("2").from(BuscarVuelo.PASSENGERS_SELECT_BUTTON),
            

            Click.on(BuscarVuelo.DATE_PICKER_DAY.of("30"))
            
        );
    }

    public static BusquedaCorrectaInteraction enCampos() {
        return Tasks.instrumented(BusquedaCorrectaInteraction.class);
    }
}
