package aut.testcreation.pages.hoteles;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


public class BusquedaHotel extends SeleniumWrapper {

    public BusquedaHotel(WebDriver driver) {
        super(driver);
    }

    By locatorCiudad = By.xpath("//input[contains(@placeholder, \"quieres ir\")]");
    By locatorFecha = By.xpath("//button[contains(@aria-label, \"Fecha de entrada\")]");
    By locatorPersonas = By.xpath("//label[contains(text(),\"Personas\")]");
    By btnAumentarNroAdultos = By.xpath("//button[@aria-label='Aumentar el número de adultos']//*[name()='svg']");
    By btnAnnadirNinnos = By.xpath("//button[@aria-label='Aumentar el número de niños']");
    By locatorEdadNinnos = By.cssSelector(".d-g93eyo");
    By annadirHabitacion = By.xpath("//button[contains(text(), \"Añadir\")]");
    By locatorOpcionDia;
   // By btnAceptar = By.xpath("//div[@role=\"search\"]//descendant-or-self::button[@type=\"submit\"]");
    By btnAceptar = By.xpath("//button[@type=\"submit\"]");
   //By btnAceptar = By.xpath("//button[@aria-label='Buscar']");
    //By btnAceptar =By.cssSelector("div.e19fnmvl0.d-iu97wz.e161saim2:nth-child(2) div.mobile.e161saim0.d-mxg74v.eg3h3jz0 div.hub-row.e5okb9y0.hub-no-gutters.d-1cqpkfa.e1sskiuc0 div.hub-col-md-12.hub-col-12.hub-col.d-1fur9sr.e1i8mjyc0 div.e19fnmvl0.content-wrapper.d-bmfhe3.e1151aq91 div.notranslate.e19fnmvl0.d-1mur2we.e1k86xxr1:nth-child(3) div.d-qp626b.e1k86xxr0 div.d-1ytebqy.e10w470p3 div.d-bz45c1.e10w470p2 ul.d-109g97g.e10w470p1 li.d-129j898.e10w470p0:nth-child(2) div.d-1ehhqoq.evvzyi81 > a.evvzyi82.d-134lsl7.e89md6u0");

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
    Actions action = new Actions(this.getDriver());
    public void buscar(){
        //this.getDriver().switchTo().frame("//iframe[@title]");
        click(esperarPorElemento(btnAceptar));
        esperarXSegundos(1000);

    }

    public void annadirNinnosHabitacion(String edadNinnos) {
        esperarXSegundos(500);
        if (isEnabled(btnAnnadirNinnos)) {
            esperarXSegundos(500);
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
