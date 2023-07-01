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
    By locatorPersonas = By.xpath("//label[contains(text(),'Personas')]");

    By btnAumentarNroAdultos = By.xpath("//button[contains(@aria-label, \"Aumentar el número de adultos\") and @xpath =\"2\"]");

    By btnAnnadirNinnos = By.xpath("//button[contains(@aria-label, \"Aumentar el número de niños\")] //span[@xpath=\"2\"]")
    By btnBuscar = By.xpath("//button[@type='submit']");

    By locatorEdadNinnos = By.xpath("//ul//li[contains(.,\"Edad al viajar\")]");

    public void buscarHotel(String ciudad,int diaPartida, int diaVuelta,
                                            int cantPersonas){

        if(isDisplayed(locatorEdadNinnos)){
           click(esperarPorElemento(locatorCerrarCookies));}

        esperarXSegundos(500);
        agregarTexto(esperarPorElemento(locatorCiudad),ciudad);
        esperarXSegundos(500);

        //ver metodo para fechas
        //seleccionarComboBoxPortextoVisible(locatorFecha,diaPartida,diaVuelta);
        esperarXSegundos(500);
        agregarTexto(esperarPorElemento(locatorPersonas),cantPersonas);
        esperarXSegundos(500);

        click(esperarPorElemento(btnBuscar));
    }

}
