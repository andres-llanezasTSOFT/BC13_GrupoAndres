package aut.testcreation.pages.Vuelos;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElegirServicio extends SeleniumWrapper {
    public ElegirServicio(WebDriver driver) {
        super(driver);
    }

    By locatorClassic = By.xpath("//button[contains(text(), 'Elegir Classic')]");


    public void servicioClassic(){
        click(esperarPorElemento(locatorClassic));
    }
}
