package aut.testcreation.pages;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BusquedaHotel extends SeleniumWrapper {

    public BusquedaHotel(WebDriver driver) {
        super(driver);
    }


    By locatorCiudad = By.xpath("//input[@id=':r0:']");
    By locatorFecha = By.xpath("//label[contains(text(),'Fecha de entrada')]");
    By locatorMesAnnoActual = By.xpath("//div[@aria-labelledby]//descendant-or-self::span");
    By btnMesPrevio = By.xpath("//button[contains(@aria-label, \"Previous\")]");
    By btnMesSiguiente = By.xpath("//button[contains(@aria-label, \"Next\")]");
    By locatorOpcionDia = By.xpath("//div[@aria-labelledby]//descendant-or-self::button");
    By locatorPersonas = By.xpath("//label[contains(text(),'Personas')]");
    By btnAumentarNroAdultos = By.xpath("//button[contains(@aria-label, \"Aumentar el número de adultos\") and @xpath =\"2\"]");
    By btnAnnadirNinnos = By.xpath("//button[contains(@aria-label, \"Aumentar el número de niños\")] //span[@xpath=\"2\"]");
    By btnBuscar = By.xpath("//button[@type='submit']");
    By locatorEdadNinnos = By.xpath("//ul//li[contains(.,\"Edad al viajar\")]");

    public void buscarHotel(String ciudad, String mesAnno, String diaPartida, String diaVuelta,
                            String cantPersonas, String edadNinnos) {

        agregarTexto(esperarPorElemento(locatorCiudad), ciudad);
        esperarXSegundos(500);
        if (isDisplayed(locatorMesAnnoActual)) {
            seleccionarFechas(mesAnno, diaPartida, diaVuelta);
        }
        esperarXSegundos(500);
        seleccionarComboBoxPortextoVisible(locatorPersonas, cantPersonas);
        esperarXSegundos(500);
        click(esperarPorElemento(btnAumentarNroAdultos));
        esperarXSegundos(500);
        click(esperarPorElemento(btnAnnadirNinnos));
        esperarXSegundos(500);
        if (isDisplayed(locatorEdadNinnos)) {
            seleccionarComboBoxPortextoVisible(locatorEdadNinnos, edadNinnos);
        }
        esperarXSegundos(500);
        click(esperarPorElemento(btnBuscar));
    }


    public void seleccionarFechas(String fecha, String checkInDate, String checkOutDate) {

        click(esperarPorElemento(locatorFecha));

        while (true) {
            if (getText(locatorMesAnnoActual).equals(fecha)) {
                break;
            } else if (getText(locatorMesAnnoActual).compareTo(fecha) > 0) {
                click(btnMesPrevio);
            } else {
                click(btnMesSiguiente);
            }
        }

        if(isEnabled(locatorOpcionDia)) {
            click(seleccionarBotonPortextoVisible(locatorOpcionDia, checkInDate));
            click(seleccionarBotonPortextoVisible(locatorOpcionDia, checkOutDate));
        }

}


}
