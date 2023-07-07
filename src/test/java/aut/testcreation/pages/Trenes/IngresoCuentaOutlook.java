package aut.testcreation.pages.Trenes;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IngresoCuentaOutlook extends SeleniumWrapper {

    By locatorOrigen = By.xpath("//input[@aria-label='Origen'and@value='Barcelona']");
    By locatorDestino = By.xpath("//input[@aria-label='Destino'and@value='Madrid']");
    By opcionFechas;
    By locatorBtnFechaIda = By.xpath("//span[text()='sáb, 8 jul']");
    By locatorBtnFechaVuelta = By.xpath("//span[text()='sáb, 15 jul']");
    By locatorBtnPasajero = By.xpath("//label[normalize-space()='Pasajero']");
    By locatorBtnBusqueda = By.xpath("//button[contains(@aria-label,'Buscar')]");



    public void ingresoMail(){

    }
    public By fechasIndices(String numero){
        return opcionFechas = By.xpath("//button[contains(text(),"+numero+")]");
    }

    public IngresoCuentaOutlook(WebDriver driver) {
        super(driver);
    }


}
