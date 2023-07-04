package aut.testcreation.pages;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static framework.engine.utils.Constants.BASE_URL_AUT;

public class RumboHomePage extends SeleniumWrapper {

    public RumboHomePage(WebDriver driver) {
        super(driver);
    }

    By locatorIda = By.xpath("//div[@class='d-1nwmwhy']");
    By locatorIdayVuelta = By.xpath("//div[@class='d-4mhg59']");
    By locatorMultidestino = By.xpath("//a[contains(text(),'Multidestino')]");

    By locatorIrAVuelo = By.xpath("//button[@aria-label='Buscar']");

    By locatorIrAHotel = By.xpath("//button[@aria-label='Hoteles']");

    By locatorOrigen = By.id(":Riqid6lalallbla2mm:");


    By locatorSeleccionPasajero = By.xpath("//button[@class='d-1k0nsg5']");

    By locatorSeleccionClase = By.xpath("//body/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/button[1]");

    By locatorTurista = By.xpath("//body/div[2]/div[3]/div[1]/section[1]/ul[1]/li[2]");
    By locatorNoCookies = By.xpath("//button[@class='iubenda-cs-reject-btn iubenda-cs-btn-primary']");
    //acciones del sitio
    public void irASoloIda(){
        click(esperarPorElemento(locatorIda));
    }

    public void irIdayVuelta(){
        click(esperarPorElemento(locatorIdayVuelta));
    }
    public void irSeleccionPasajero(){
        click(esperarPorElemento(locatorSeleccionPasajero));
    }

    public void irMultidestino(){
        click(esperarPorElemento(locatorMultidestino));
    }

    public void irAVuelo(){ click((esperarPorElemento(locatorIrAVuelo))); }

    public void irABusquedaHotel(){ click((esperarPorElemento(locatorIrAHotel))); }
    public void irSeleccionClase(){
        click(esperarPorElemento(locatorSeleccionClase));
    }
    public void irClaseTurista(){
        click(esperarPorElemento(locatorTurista));
    }

    public void noCookies(){
        click(esperarPorElemento(locatorNoCookies));
    }

    public void navegarAlSitio(){
        navigateTo(BASE_URL_AUT);
    }

   /* public void completarFormularioRegistro(String correo,String contrasena,String username,
                                            String dia,String mes,String annio,int genero){

        if(isDisplayed(locatorCerrarCookies)){
            click(esperarPorElemento(locatorCerrarCookies));
        }
        esperarXSegundos(500);
        agregarTexto(esperarPorElemento(locatorCorreo),correo);
        esperarXSegundos(500);
        agregarTexto(esperarPorElemento(locatorPassword),contrasena);
        esperarXSegundos(500);

        agregarTexto(esperarPorElemento(locatorUsername),username);
        esperarXSegundos(500);

        agregarTexto(esperarPorElemento(locatorDia),dia);
        esperarXSegundos(500);

        seleccionarComboBoxPortextoVisible(locatorMes,mes);
        esperarXSegundos(500);

        agregarTexto(esperarPorElemento(locatorAnnio),annio);
        esperarXSegundos(500);

        click(buscarElementosWeb(locatorGeneros).get(genero));
        esperarXSegundos(500);

        click(buscarElementosWeb(locatorPreferencias).get(0));
        esperarXSegundos(500);

        click(buscarElementosWeb(locatorPreferencias).get(1));
        esperarXSegundos(500);

        click(esperarPorElemento(btnRegistrate));
        scrollingDownElement(esperarPorElemento(locatorCorreo));
        esperarXSegundos(1500);

    }*/

}
