package aut.testcreation.pages.hoteles;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BusquedaHotel extends SeleniumWrapper {

    public BusquedaHotel(WebDriver driver) {
        super(driver);
    }

    By locatorCiudad = By.xpath("//input[contains(@placeholder, \"quieres ir\")]");
    By locatorFecha = By.xpath("//button[contains(@aria-label, \"Fecha de entrada\")]");
    By locatorPersonas = By.xpath("//div/label[contains(text(),\"Personas\")]");
    By btnAumentarNroAdultos = By.xpath("//button[@aria-label='Aumentar el número de adultos']//*[name()='svg']");
    By btnAnnadirNinnos = By.xpath("//button[@aria-label='Aumentar el número de niños']");
    By locatorEdadNinnos = By.cssSelector(".d-g93eyo");
    By annadirHabitacion = By.xpath("//button[contains(text(), \"Añadir\")]");
    By locatorOpcionDia;
    By btnAceptar = By.xpath("//button[@type=\"submit\"]");
    //By btnAceptar = By.xpath("//button[@aria-label=\"buscar\"]");

    public By crear_locator_dia(String number){
        return locatorOpcionDia = By.xpath("//button[contains(text(),"+ number+")]");
    }

    public void buscarHotel(String ciudad, String diaPartida, String diaVuelta,
                            int cantAdultos, int cantNinnos) {

        agregarTexto(esperarPorElemento(locatorCiudad), ciudad);
        esperarXSegundos(500);
        click(esperarPorElemento(locatorFecha));
        click(crear_locator_dia(diaPartida));
        click(crear_locator_dia(diaVuelta));
        esperarXSegundos(500);
        annadirAdultos(cantAdultos);

        if (cantNinnos != 0) {
            int ninno = 0;
            while (ninno != cantNinnos) {
                annadirNinnosHabitacion("2 años");
                ninno++;
            }
            click(esperarPorElemento(locatorPersonas));
        }
        esperarXSegundos(500);
        this.getDriver().switchTo();
       buscar();
    }


    private void annadirAdultos(int cantAdultos) {
        if(cantAdultos>2){
            for(int i=2;i<cantAdultos;i++) {
                click(esperarPorElemento(btnAumentarNroAdultos));
                esperarXSegundos(500);
            }
        }
    }

    public void buscar(){
        getDriver().switchTo().frame("iframe[height='0']"); //switching the frame by ID
        getDriver().findElement(btnAceptar).click();
        click(esperarPorElemento(btnAceptar));
    }

    public void annadirNinnosHabitacion(String edadNinnos) {
        esperarXSegundos(500);
        if (isEnabled(btnAnnadirNinnos)) {
            click(esperarPorElemento(btnAnnadirNinnos));
            esperarXSegundos(1000);
            List<WebElement> edades = getDriver().findElements(locatorEdadNinnos);
            for(WebElement li: edades){
                if(li.getText().equals(edadNinnos)){
                   li.click();
                }
            }
            esperarXSegundos(1000);
        }else{
            esperarXSegundos(500);
            click(esperarPorElemento(annadirHabitacion));
        }
    }


}
