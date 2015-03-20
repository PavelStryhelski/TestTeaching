package com.qulix.ft.implementation;

import com.qulix.ft.logging.SuiteLogger;
import com.qulix.ft.model.IButton;
import com.qulix.ft.model.IElement;
import com.qulix.ft.model.IPage;
import com.qulix.ft.teachingSite.Conditions.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * Кнопка
 */
public class Button implements IButton {

    private static final int DEFAULT_TIME = 2;

    private By locator;
    private WebDriver driver;

    public Button(WebDriver driver, By locator){
        this.driver = driver;
        this.locator = locator;
    }

    @Override
    public boolean clickable(int timeout) {

        WebDriverWait wait = new WebDriverWait(driver, timeout);

        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            return true;
        } catch (TimeoutException e){
            return false;
        }

    }

    @Override
    public boolean enabled(int timeout) {


        WebDriverWait wait = new WebDriverWait(driver, timeout);

        try {
            wait.until(ExpectedConditions.elementToBeEnabled(locator));
            return true;
        } catch (TimeoutException e){
            return false;
        }
    }

    @Override
    public boolean disabled(int timeout) {

        WebDriverWait wait = new WebDriverWait(driver, timeout);

        try {
            wait.until(ExpectedConditions.elementToBeEnabled(locator));
            return false;
        } catch (TimeoutException e){
            return true;
        }
    }

    @Override
    public void click() {
       if (clickable(DEFAULT_TIME)){
           getElement(locator).click();
       } else {
           SuiteLogger.logError("Button is not clickable!");
       }
    }

    @Override
    public void sendKeys(CharSequence... sequence) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getText() {
        return getElement(locator).getText();
    }

    @Override
    public IPage getOwnerPage() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public By getLocator() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getName() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getProperty(String propertyName) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean visible(int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException e){
            return false;
        }
    }

    @Override
    public boolean invisible(int timeout) {

        WebDriverWait wait = new WebDriverWait(driver, timeout);

        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException e){
            return false;
        }
    }

    @Override
    public boolean exists(int timeout) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean doesntExist(int timeout) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public IElement getParentElement() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    private WebElement getElement(By locator){
        return driver.findElement(locator);
    }

}
