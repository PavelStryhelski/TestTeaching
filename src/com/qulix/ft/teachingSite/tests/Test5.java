package com.qulix.ft.teachingSite.tests;

import com.qulix.ft.teachingSite.User;
import com.qulix.ft.teachingSite.UserMessage;
import com.qulix.ft.teachingSite.pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


/***
 * �������� 2
 */
public class Test5 extends AbstractTest{
    @Test(description = "�������� 5. Create message and exit without saving")
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
        UserMessage userMessage = new UserMessage();
        createNewMessagePage.fulfilMessageFieldsWithValues(userMessage);

        //������ Message List
        messageList = createNewMessagePage.goToMessageList();

        //��������� ������.
        messageList.assertPageIsOpened();

        //�������, ��� ��������� ��������� �� ������������ � ������
        messageList.assertMessageIsNotInList(userMessage);

    }
}
