package aut.testcreation.pages.hoteles;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DetalleHotel extends SeleniumWrapper {
    public DetalleHotel(WebDriver driver) {
        super(driver);
    }

    By btnSoloAlojamiento = By.xpath("//button/span[@xpath=\"3\"]");


    public void elegir_solo_alojamiento(){
        click(esperarPorElemento(btnSoloAlojamiento));
    }
}
