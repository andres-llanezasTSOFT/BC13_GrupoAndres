package framework.engine.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SeleniumWrapper {

    private final WebDriver driver;
    protected WebDriverWait espera; //ME PERMITIRA MANEJAR LAS ESPERAS

    protected JavascriptExecutor js; //manipular eventos como el scroll


    //Constructor Base
    public SeleniumWrapper(WebDriver driver){
        this.driver = driver;
    }

    //Wrappers Selenium
    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findElements (By locator){
        return driver.findElements(locator);
    }

    public String getText(By locator){
        return driver.findElement(locator).getText();
    }
    public String getText(WebElement elemento){
        return elemento.getText();
    }
    public void write(String inputText, By locator){
        driver.findElement(locator).sendKeys(inputText);
    }
    public void sendKeys(Keys key, By locator){
        driver.findElement(locator).sendKeys(key);
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public void click(WebElement elemento){
        elemento.click();
    }


    public void agregarTexto(WebElement elemento,String texto){
        elemento.sendKeys(texto);
    }
    public void esperarXSegundos(int milisegs){
        try {
            Thread.sleep(milisegs);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public WebElement esperarPorElemento(By locator){
        espera = new WebDriverWait(this.driver,30);
        return espera.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public Boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
    public Boolean isEnabled(By locator) {
        try {
            return driver.findElement(locator).isEnabled();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public WebElement buscarElementoWeb(By locator){
        return this.driver.findElement(locator);
    }

    public List<WebElement> buscarElementosWeb(By locator){

        return this.driver.findElements(locator);
    }

    public void scrollingDownElement(WebElement elemento){
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", elemento);
    }

    public Boolean isSelected(By locator) {
        try {
            return driver.findElement(locator).isSelected();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void seleccionarComboBoxPortextoVisible(By locator,String textoVisible){
        WebElement ddlMes = driver.findElement(locator);
        Select selectorMes = new Select(ddlMes);
        selectorMes.selectByVisibleText(textoVisible);
    }

    public WebElement seleccionarBotonPortextoVisible(By locator,String textoVisible){
        WebElement ddlMes = driver.findElement(locator);
        Select selectorMes = new Select(ddlMes);
        selectorMes.selectByVisibleText(textoVisible);
        return ddlMes;
    }

    public void navigateTo(String url){
        driver.navigate().to(url);
    }

    public String getUrlTitle(){
        return driver.getTitle();
    }

}
