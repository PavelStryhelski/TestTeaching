package com.qulix.ft.teachingSite.pages;

import com.qulix.ft.teachingSite.Environment;
import com.qulix.ft.logging.SuiteLogger;
import com.qulix.ft.utils.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Страница CreateMessage
 */
public class CreateMessage extends AbstractPage{

    /**
     * Локатор наименования страницы
    */
    private static final By _labelCreateMessage = Locators.get(Environment.MAPS.CREATE_MESSAGE, "labelCreateMessage");
    /**
     * Локатор кнопки Create
    */
    private static final By _buttonCreate = Locators.get(Environment.MAPS.CREATE_MESSAGE, "buttonCreate");
    /**
     * Локатор поля HeadLine
    */
    private static final By _editHeadline = Locators.get(Environment.MAPS.CREATE_MESSAGE, "editHeadline");
    /**
     * Локатор поля Text
    */
    private static final By _editText = Locators.get(Environment.MAPS.CREATE_MESSAGE, "editText");

    /**
     * Поле HeadLine
     *
     * @return поле логина
     */
    private static WebElement editHeadline() {
        return driver.findElement(_editHeadline);
    }

    /**
     * Поле Text
     *
     * @return поле Text
     */
    private static WebElement editText() {
        return driver.findElement(_editText);
    }

    /**
     * Кнопка Create
     *
     * @return кнопка Create
     */
    private static WebElement buttonCreate() {
        return driver.findElement(_buttonCreate);
    }

    /**
     * Убедиться, что открыта страница Create Message
     */
    public static void assertPageIsOpened(){
        assertPageIsOpened(_labelCreateMessage, "Create Message");
    }

    /**
     * Нажать Create
     */
    public static void clickCreate(){
        SuiteLogger.logMessage("Click button Create");
        buttonCreate().click();
    }

    /**
     * Заполнить форму Create message: ввести headline и text, нажать Create
     * @param headline значение headline
     * @param text значение text
     */
    public static void createMessage(String headline, String text){

        SuiteLogger.logMessage("Fill in form Create message with values Headline: " + headline + ", Text: " + text);
        editHeadline().sendKeys(headline);
        editText().sendKeys(text);
        clickCreate();

    }
}
