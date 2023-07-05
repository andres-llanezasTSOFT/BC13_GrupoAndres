package aut.testcreation.pages;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.*;

public class BusquedaHotel extends SeleniumWrapper {

    public BusquedaHotel(WebDriver driver) {
        super(driver);
    }

    By locatorCiudad = By.xpath("//input[contains(@placeholder, \"quieres ir\")]");
    By locatorFecha = By.xpath("//button[contains(@aria-label, \"Fecha de entrada\")]");
    By locatorPersonas = By.xpath("//div/label[contains(text(),\"Personas\")]");
    By btnAumentarNroAdultos = By.xpath("//button[@aria-label='Aumentar el número de adultos']//*[name()='svg']");
    By btnAnnadirNinnos = By.xpath("//button[contains(@aria-label, \"Aumentar el número de niños\")] //span[@xpath=\"2\"]");
    By locatorEdadNinnos = By.xpath("//ul//li[contains(.,\"Edad al viajar\")]");
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
        esperarXSegundos(8000);
       buscar();
    }


    private void annadirAdultos(int cantAdultos) {
        if(cantAdultos>2){
            for(int i=2;i<cantAdultos;i++) {
                click(esperarPorElemento(btnAumentarNroAdultos));
                esperarXSegundos(500);
            }
            click(esperarPorElemento(locatorPersonas));

        }
        else{click(esperarPorElemento(locatorPersonas));}
    }

    public void buscar(){
        click(esperarPorElemento(btnAceptar));
    }

    public void annadirNinnosHabitacion(String edadNinnos) {
        click(esperarPorElemento(btnAnnadirNinnos));
        esperarXSegundos(500);
        if (isDisplayed(locatorEdadNinnos)) {
            seleccionarComboBoxPortextoVisible(locatorEdadNinnos, edadNinnos);
            esperarXSegundos(500);
        }else{
            esperarXSegundos(500);
            click(esperarPorElemento(annadirHabitacion));
        }
    }


}
