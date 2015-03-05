package com.qulix.ft.teachingSite.tests;

import com.qulix.ft.teachingSite.User;
import com.qulix.ft.teachingSite.UserMessage;
import com.qulix.ft.teachingSite.pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/***
 * �������� 1
 */
public class Test1 extends AbstractTest{

    @Test(description = "�������� 1. Create message")
    public void Test(){

        MainPage mainPage = new MainPage(driver);

        //������� ������� ��������
        mainPage.assertMainPageIsOpened();

        //������� �� ������ qulixteachingsite.UserController
        LoginPage loginPagePage = mainPage.goToUserController();

        //������� �������� ������
        loginPagePage.assertLoginPageIsOpened();

       //������ ����� � ������  admin/password, ������ LoginPage
        MessageList messageList = loginPagePage.signIn(User.ADMIN);

         //������ ������ Message list
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

    }
}
