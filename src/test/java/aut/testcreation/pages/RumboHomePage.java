package aut.testcreation.pages;

import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static framework.engine.utils.Constants.BASE_URL_AUT;

public class RumboHomePage extends SeleniumWrapper {



    private WebDriver driver;

    public RumboHomePage(WebDriver driver) {
        super(driver);

    }

    By locatorIda = By.xpath("//div[@class='d-1nwmwhy']");
    By locatorIdayVuelta = By.xpath("//div[@class='d-4mhg59']");
    By locatorMultidestino = By.xpath("//a[contains(text(),'Multidestino')]");

    By locatorIrAVuelo = By.xpath("//button[@aria-label='Buscar']");

    //By locatorLimpiaOrigen = By.xpath("//div[@class='d-12g9g33']//div[1]//div[1]//div[1]//button[1]//*[name()='svg']");

    //By locatorLimpiarDestino = By.xpath("//body//div//div[1]//div[1]//div[5]//div[1]//div[1]//div[1]//div[2]//div[1]//form[1]//div[1]//div[4]//fieldset[1]//div[3]//div[1]//div[1]//button[1]//*[name()='svg']//*[name()='path' and contains(@d,'M26 5C14.3')]");

    By locatorOrigen = By.xpath("//input[@aria-label='Origen']");/*//input[@id=':Riqid6lalallbla2mm:']");*/

    By locatorDestino = By.xpath("//input[@aria-label='Destino']");

    By locatorFechaIda = By.xpath("//button[@aria-label='Fecha de ida']");

    By locatorMesIda = By.xpath("//span[contains(text(), 'julio 2023')]");

    By locatorMesSiguiente = By.xpath("//button[@aria-label='Next month']");

    By locatorSeleccionPasajero = By.xpath("//button[@class='d-1k0nsg5']");

    //By locatorSeleccionClase = By.xpath("//body/div/div[@class='e19fnmvl0 d-hpvee9 e161saim2']/div[@class='hub-container mobile e161saim0 d-1pw96xe eg3h3jz0']/div[2]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/button[1]/div[1]//*[name()='svg']//*[name()='path' and contains(@d,'M2.5799 4.')]");

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

    public void irAVuelo(){
        click(esperarPorElemento(locatorIrAVuelo));
    }

    /*public void irSeleccionClase(){

        click(esperarPorElemento(locatorSeleccionClase));
    }*/



    /*public void elegirOrigen(){
        click(esperarPorElemento(locatorOrigen));
    }*/

   /* public void mesIda(){
        click(esperarPorElemento(locatorMesIda));
    }*/

    public void mesSiguiente(){
        click(esperarPorElemento(locatorMesSiguiente));
    }

    public void fechaIda(){
        click(esperarPorElemento(locatorFechaIda));
    }

    public void seleccionPasajero(){
        click(esperarPorElemento(locatorSeleccionPasajero));
    }

  /*  public void irSeleccionClase(){

        WebElement element = driver.findElement(By.tagName("form"));
        WebElement sourchElement = element.findElement(By.xpath("//spa"))
    }*/


    public void irClaseTurista(){
        click(esperarPorElemento(locatorTurista));
    }

    public void noCookies(){
        click(esperarPorElemento(locatorNoCookies));
    }

    public void navegarAlSitio(){
        navigateTo(BASE_URL_AUT);
    }

   public void preferenciasIda(String origen,String destino/*,
                                            String diaIda*/){

        esperarXSegundos(200);
       agregarTexto(esperarPorElemento(locatorOrigen),origen);
        esperarXSegundos(300);
        agregarTexto(esperarPorElemento(locatorDestino),destino);
        esperarXSegundos(300);


    }

   public void elegirFechaIda(String mesIda){

          seleccionarMes(locatorMesIda, mesIda);

   }


    public void preferenciasIdayVuelta(String origen,String destino/*,String mesIda,
                                String diaIda,String mesVuelta,
                                       String diaVuelta*/){

        esperarXSegundos(200);
        agregarTexto(esperarPorElemento(locatorOrigen),origen);
        esperarXSegundos(300);
        agregarTexto(esperarPorElemento(locatorDestino),destino);
        esperarXSegundos(300);
    }

}