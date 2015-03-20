package com.qulix.ft.teachingSite.tests;

import com.qulix.ft.logging.WebDriverFactory;
import com.qulix.ft.teachingSite.Environment;
import com.qulix.ft.teachingSite.User;
import com.qulix.ft.teachingSite.UserMessage;
import com.qulix.ft.teachingSite.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * �������� 1
 */
public class Test1 extends AbstractTest {

    public WebDriver jd_driver;

    @Test(description = "�������� 1. Create message")
    public void Test() {

       /* jd_driver = WebDriverFactory.instance().openNewBrowser();
        jd_driver.get(Environment.URL);*/

        //ADMIN
//        WebDriverFactory.instance().setActiveWebDriver(driver);
        MainPage mainPage = new MainPage(WebDriverFactory.instance().getActiveWebDriver());

        //������� ������� ��������
        mainPage.assertMainPageIsOpened();

        //������� �� ������ qulixteachingsite.UserController
        LoginPage loginPagePage = mainPage.goToUserController();

        //������� �������� ������
        loginPagePage.assertLoginPageIsOpened();

        //������ ����� � ������  admin/password, ������ LoginPage
        MessageList messageList = loginPagePage.signIn(User.ADMIN);

     /*   //JD
        WebDriverFactory.instance().setActiveWebDriver(jd_driver);
        MainPage jdMainPage = new MainPage(WebDriverFactory.instance().getActiveWebDriver());
        jdMainPage.assertMainPageIsOpened();
        LoginPage jdLoginPagePage = jdMainPage.goToUserController();
        jdLoginPagePage.assertLoginPageIsOpened();
        //������ ����� � ������  admin/password, ������ LoginPage
        MessageList jdMessageList = jdLoginPagePage.signIn(User.J_DOE);

        //ADMIN
        //������ ������ Message list
        WebDriverFactory.instance().setActiveWebDriver(driver);
        messageList.assertPageIsOpened();

        //������ New Message
        Message createNewMessagePage = messageList.createNewMessage();

        //������� ����� �������� Create message
        createNewMessagePage.assertCreateMessagePageIsOpened();

        //��������� ���� Headline � Text
        //������ Create
        UserMessage userMessage = new UserMessage();
        ShowMessagePage showMessagePage = createNewMessagePage.createMessage(userMessage);

        //������� �������� Show message
        showMessagePage.assertPageIsOpened();

        //������ ������ Message list
        messageList = showMessagePage.showMessageList();

        //��������� ������.
        messageList.assertPageIsOpened();

        //� ������ ���������� ��������� ������, � �������� Headline �  Text ���������� ��������, ��������� �� ���� 4
        messageList.assertMessageIsInList(userMessage);


        //JD
        WebDriverFactory.instance().setActiveWebDriver(jd_driver);
        jdMessageList.checkCheckBox();
        jdMessageList.assertMessageIsInList(userMessage, User.ADMIN.getName());*/

    }

}
