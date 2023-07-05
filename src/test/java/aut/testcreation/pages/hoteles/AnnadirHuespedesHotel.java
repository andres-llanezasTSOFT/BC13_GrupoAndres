package aut.testcreation.pages.hoteles;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AnnadirHuespedesHotel extends SeleniumWrapper {


    public AnnadirHuespedesHotel(WebDriver driver) {
        super(driver);
    }

    By locatorInputNombre = By.xpath("//input[@name=\"name\"]");
    By locatorInputApellido = By.xpath("//input[@name=\"surname\"]");
    By locatorInputMail = By.xpath("//input[@name=\"email\"]");
    By btnPrefijo = By.xpath("//button[@aria-haspopup]");
    //By locatorPrefijo = By.xpath("");
    By locatorInputTelefono = By.xpath("//input[@name=\"phone\"]");

    By locatorFormGreenCheck = By.xpath("//form[@class]//span[contains(@data-testid,\"input-end-valid\")]");


public void llenar_datos_personales(String nombre, String apellido, String mail, String pais, String telefono) {
    agregarTexto(esperarPorElemento(locatorInputNombre), nombre);
    esperarXSegundos(500);
    agregarTexto(esperarPorElemento(locatorInputApellido), apellido);
    esperarXSegundos(500);
    agregarTexto(esperarPorElemento(locatorInputMail), mail);
    esperarXSegundos(500);
    //click(esperarPorElemento(btnPrefijo));
   // esperarXSegundos(500);
    seleccionarComboBoxPortextoVisible(btnPrefijo, pais);
    esperarXSegundos(500);
    agregarTexto(esperarPorElemento(locatorInputTelefono), telefono);
}

public int cantidad_inputs_validos(){
    List<WebElement> validos = getDriver().findElements(locatorFormGreenCheck);
    int cantidad= validos.size();
    return cantidad;
}

}
