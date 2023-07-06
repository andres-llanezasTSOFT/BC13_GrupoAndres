package framework.engine.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static framework.engine.utils.Constants.BASE_URL_AUT;

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
    public void navegarAlSitio () {navigateTo(BASE_URL_AUT);}


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
    public void cargarUrl(String url){
        driver.get(url);
    }

    public void maximizarBrowser(){
        this.driver.manage().window().maximize();
    }
    public WebDriver getDriver() {
        return driver;
    }

    public WebElement seleccionarBotonPortextoVisible(By locator,String textoVisible){
        WebElement contenedor = driver.findElement(locator);
        Select selectorElemento = new Select(contenedor);
        selectorElemento.selectByVisibleText(textoVisible);
        return contenedor;
    }

    public void navigateTo(String url){
        driver.navigate().to(url);
    }

    public String getUrlTitle(){
        return driver.getTitle();
    }

    public int extraer_int_de_String(By locator) {
        String resultado = findElement(locator).getText();
        StringBuilder sb = new StringBuilder();
        for (char c : resultado.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        return Integer.parseInt(sb.toString());
    }

    public void drag_and_drop(By locator, int value){
        int y=0;
        WebElement slider = this.getDriver().findElement(locator);
        Actions action = new Actions(this.getDriver());
        action.dragAndDropBy(slider, value, y).perform();
    }




}
