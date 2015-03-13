package com.qulix.ft.teachingSite.tests;

import com.qulix.ft.logging.WebDriverFactory;
import com.qulix.ft.teachingSite.User;
import com.qulix.ft.teachingSite.UserMessage;
import com.qulix.ft.teachingSite.pages.*;
import org.testng.annotations.Test;

/**
 * �������� 1
 */
public class Test1 extends AbstractTest {

    @Test(description = "�������� 1. Create message")
    public void Test() {

//        ADMIN
        MainPage mainPage = new MainPage(WebDriverFactory.instance().get());

        //������� ������� ��������
        mainPage.assertMainPageIsOpened();

        //������� �� ������ qulixteachingsite.UserController
        LoginPage loginPagePage = mainPage.goToUserController();

        //������� �������� ������
        loginPagePage.assertLoginPageIsOpened();

        //������ ����� � ������  admin/password, ������ LoginPage
        MessageList messageList = loginPagePage.signIn(User.ADMIN);

//      JD
        WebDriverFactory.instance().setWebDriverForAllPages(jd_driver);
        MainPage jdMainPage = new MainPage(WebDriverFactory.instance().get());
        jdMainPage.assertMainPageIsOpened();
        LoginPage jdLoginPagePage = jdMainPage.goToUserController();
        jdLoginPagePage.assertLoginPageIsOpened();
        //������ ����� � ������  admin/password, ������ LoginPage
        MessageList jdMessageList = jdLoginPagePage.signIn(User.J_DOE);

//        ADMIN
        //������ ������ Message list
        WebDriverFactory.instance().setWebDriverForAllPages(driver);
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


//      JD
        WebDriverFactory.instance().setWebDriverForAllPages(jd_driver);
        jdMessageList.checkCheckBox();
        jdMessageList.assertMessageIsInList(userMessage, User.ADMIN.getName());

    }

}
