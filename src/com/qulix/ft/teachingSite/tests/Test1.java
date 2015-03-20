package com.qulix.ft.teachingSite.tests;

import com.qulix.ft.logging.WebDriverFactory;
import com.qulix.ft.teachingSite.Environment;
import com.qulix.ft.teachingSite.User;
import com.qulix.ft.teachingSite.UserMessage;
import com.qulix.ft.teachingSite.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * Сценарий 1
 */
public class Test1 extends AbstractTest {

    public WebDriver jd_driver;

    @Test(description = "Сценарий 1. Create message")
    public void Test() {

       /* jd_driver = WebDriverFactory.instance().openNewBrowser();
        jd_driver.get(Environment.URL);*/

        //ADMIN
//        WebDriverFactory.instance().setActiveWebDriver(driver);
        MainPage mainPage = new MainPage(WebDriverFactory.instance().getActiveWebDriver());

        //Открыта главная страница
        mainPage.assertMainPageIsOpened();

        //Перейти по ссылке qulixteachingsite.UserController
        LoginPage loginPagePage = mainPage.goToUserController();

        //Открыта страница логина
        loginPagePage.assertLoginPageIsOpened();

        //Ввести логин и пароль  admin/password, нажать LoginPage
        MessageList messageList = loginPagePage.signIn(User.ADMIN);

     /*   //JD
        WebDriverFactory.instance().setActiveWebDriver(jd_driver);
        MainPage jdMainPage = new MainPage(WebDriverFactory.instance().getActiveWebDriver());
        jdMainPage.assertMainPageIsOpened();
        LoginPage jdLoginPagePage = jdMainPage.goToUserController();
        jdLoginPagePage.assertLoginPageIsOpened();
        //Ввести логин и пароль  admin/password, нажать LoginPage
        MessageList jdMessageList = jdLoginPagePage.signIn(User.J_DOE);

        //ADMIN
        //Открыт список Message list
        WebDriverFactory.instance().setActiveWebDriver(driver);
        messageList.assertPageIsOpened();

        //Нажать New Message
        Message createNewMessagePage = messageList.createNewMessage();

        //Открыта форма создания Create message
        createNewMessagePage.assertCreateMessagePageIsOpened();

        //Заполнить поля Headline и Text
        //Нажать Create
        UserMessage userMessage = new UserMessage();
        ShowMessagePage showMessagePage = createNewMessagePage.createMessage(userMessage);

        //Открыта страница Show message
        showMessagePage.assertPageIsOpened();

        //Нажать кнопку Message list
        messageList = showMessagePage.showMessageList();

        //Отображен список.
        messageList.assertPageIsOpened();

        //В списке содержится созданный объект, в колонках Headline и  Text отображены значения, введенные на шаге 4
        messageList.assertMessageIsInList(userMessage);


        //JD
        WebDriverFactory.instance().setActiveWebDriver(jd_driver);
        jdMessageList.checkCheckBox();
        jdMessageList.assertMessageIsInList(userMessage, User.ADMIN.getName());*/

    }

}
