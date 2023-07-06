package aut.testcreation.pages.Vuelos;

import framework.engine.selenium.FixEncoding;
import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElegirVuelo extends SeleniumWrapper {
    public ElegirVuelo(WebDriver driver) {
        super(driver);
    }

    By locatorMasBarato = By.xpath("//h5[contains(text(), 'barato')]");

    By locatorElegirVuelo = By.xpath("//*[@id=\"app-container\"]/div/div/div/div/div[1]/div[2]/div[3]/div/div[2]/div[5]/div/section[2]/div/div[1]/div/div/div/div/div[2]/div");
    //div[@class='trip-collection-view__trips-container-top']//div[@class='FullTransportPrices__SelectedPriceContainer-sc-1qck0l5-1 knGmgC']
    //*[@id="app-container"]/div/div/div/div/div[1]/div[2]/div[3]/div/div[2]/div[5]/div/section[2]/div/div[1]/div/div/div/div/div[2]/div
    public void masBarato(){
        click(esperarPorElemento(locatorMasBarato));
    }

    public void elegirVuelo(){
        click(esperarPorElemento(locatorElegirVuelo));
    }
}
