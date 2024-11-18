package co.com.udea.certificacion.busqueda_de_vuelos_B.userinterfaces;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class GooglePage  extends PageObject {
    public static final Target INPUT_TEXT = Target.the("INPUT TEXT").located(By.name("q"));
    public static final Target INPUT_TEXT1 = Target.the("INPUT TEXT").locatedBy("//*[@name='q']");
    public static final Target LINK_TO_UDEA_HOMEPAGE = Target.the("LINK UDEA HOMEPAGE").locatedBy("//h3[contains(@class, 'LC20lb MBeuO DKV0Md')]");
    public static final Target TITLE_UDEA_HOMEPAGE = Target.the("TITULO UDEA HOMEPAGE").locatedBy("//*[@id='layoutContainers']/div/div[2]/div/div[2]/section/div[2]/section[1]/div[1]/p");



}