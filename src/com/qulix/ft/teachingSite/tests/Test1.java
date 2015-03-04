package com.qulix.ft.teachingSite.tests;

import com.qulix.ft.teachingSite.User;
import com.qulix.ft.teachingSite.pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/***
 * �������� 1
 */
public class Test1 extends AbstractTest{

    @Test(description = "�������� 1. Create message")
    @Parameters({"HeadlineValue", "TextValue"})
    public void Test(String headline, String text){

        MainPage mainPage = new MainPage(driver);

        //������� ������� ��������
        mainPage.assertMainPageIsOpened();

        //������� �� ������ qulixteachingsite.UserController
        Login loginPage = mainPage.goToUserController();

        //������� �������� ������
        loginPage.assertLoginPageIsOpened();

       //������ ����� � ������  admin/password, ������ Login
        MessageList messageList = loginPage.signIn(User.ADMIN);

         //������ ������ Message list
        messageList.assertPageIsOpened();

       //������ New Message
        Message createNewMessagePage = messageList.createNewMessage();

        //������� ����� �������� Create message
        createNewMessagePage.assertCreateMessagePageIsOpened();

        //��������� ���� Headline � Text
        //������ Create
        ShowMessage showMessage = createNewMessagePage.createMessage(headline, text);

        //������� �������� Show message
        showMessage.assertPageIsOpened();

         //������ ������ Message list
        messageList = showMessage.showMessageList();

        //��������� ������.
        messageList.assertPageIsOpened();

        //� ������ ���������� ��������� ������, � �������� Headline �  Text ���������� ��������, ��������� �� ���� 4
        messageList.assertMessageIsInList(headline, text);

    }
}
