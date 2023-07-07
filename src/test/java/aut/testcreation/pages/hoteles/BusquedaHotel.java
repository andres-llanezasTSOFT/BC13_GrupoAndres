package aut.testcreation.pages.hoteles;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.*;



public class BusquedaHotel extends SeleniumWrapper {

    public BusquedaHotel(WebDriver driver) {
        super(driver);
    }

    By locatorCiudad = By.xpath("//input[contains(@placeholder, \"quieres ir\")]");
    By locatorFecha = By.xpath("//button[contains(@aria-label, \"Fecha de entrada\")]");
    By locatorPersonas = By.xpath("//label[contains(text(),\"Personas\")]");
    By btnAumentarNroAdultos = By.xpath("//button[@aria-label='Aumentar el número de adultos']//*[name()='svg']");
    By btnAnnadirNinnos = By.xpath("//button[@aria-label='Aumentar el número de niños']");
    By locatorEdadNinnos;
    By annadirHabitacion = By.xpath("//button[contains(text(), \"Añadir\")]");
    By locatorOpcionDia;
    By btnAceptar = By.xpath("//button[@type=\"submit\"]");

    public By crear_locator_dia(String number){
        return locatorOpcionDia = By.xpath("//button[contains(text(),"+ number+")]");
    }

    public void buscarHotel(String ciudad, String diaPartida, String diaVuelta,
                            int cantAdultos, int cantNinnos) {
        esperarXSegundos(500);
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
        }

        ir_a_personas();
        esperarXSegundos(500);
        buscar();
        esperarXSegundos(2000);
    }


    public void ir_a_personas(){
        click(esperarPorElemento(locatorPersonas));
    }
    public void annadirAdultos(int cantAdultos) {
        if(cantAdultos>2){
            for(int i=2;i<cantAdultos;i++) {
                click(esperarPorElemento(btnAumentarNroAdultos));
                esperarXSegundos(500);
            }
        }
    }
    public void buscar(){
        click(esperarPorElemento(btnAceptar));
        esperarXSegundos(1000);

    }

    public void annadirNinnosHabitacion(String edadNinnos) {
        esperarXSegundos(500);
        if (isEnabled(btnAnnadirNinnos)) {
            esperarXSegundos(500);
            click(esperarPorElemento(btnAnnadirNinnos));
            esperarXSegundos(1000);
            click(crear_locator_ninnos(edadNinnos));
            esperarXSegundos(1000);
        }else{
            esperarXSegundos(500);
            click(esperarPorElemento(annadirHabitacion));
        }
    }

    public By crear_locator_ninnos(String edad){
       return locatorEdadNinnos= By.xpath("//div/ul/li[contains(text(),'"+edad+"')]");
    }


}
