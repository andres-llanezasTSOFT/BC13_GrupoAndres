package aut.testcreation.pages.hoteles;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.*;
import javax.swing.plaf.basic.BasicSliderUI;

public class DetalleHotel extends SeleniumWrapper {
    public DetalleHotel(WebDriver driver) {
        super(driver);
    }

    By btnSoloAlojamiento = By.xpath("//div/span[contains(@class,\"RoomPanelMealPlan\")]//descendant-or-self::span[@xpath=\"1\"]");
By testScroll = By.xpath("//h2[contains(text(),'También te podrían interesar')]");

    public void elegir_solo_alojamiento(){
        esperarXSegundos(6000);
        WebElement busqueda= getDriver().findElement(testScroll);
        scrollingDownElement(busqueda);
        seleccionar_primer_resultado();



        //click(esperarPorElemento(btnSoloAlojamiento));
    }

    public void seleccionar_primer_resultado() {
        super.seleccionar_primer_resultado(btnSoloAlojamiento);
    }
}
