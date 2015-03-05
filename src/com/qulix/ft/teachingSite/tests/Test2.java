package com.qulix.ft.teachingSite.tests;

import com.qulix.ft.teachingSite.User;
import com.qulix.ft.teachingSite.pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


/***
 * �������� 2
 */
public class Test2  extends AbstractTest{
    @Test(description = "�������� 2. Create and View message")
    @Parameters({"HeadlineValue", "TextValue"})
    public void Test(String headline, String text){

        MainPage mainPage = new MainPage();

       //������� ������� ��������
        mainPage.assertMainPageIsOpened();

        //������� �� ������ qulixteachingsite.UserController
        //������� �������� ������
        LoginPage loginPagePage = mainPage.goToUserController();
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
        ShowMessagePage showMessagePage = createNewMessagePage.createMessage(headline, text);

        //������� �������� Show message
        showMessagePage.assertPageIsOpened();

        //������ ������ Message list
        messageList = showMessagePage.showMessageList();

        //��������� ������.
        messageList.assertPageIsOpened();

        //� ������ ���������� ��������� ������, � �������� Headline �  Text ���������� ��������, ��������� �� ���� 4
        messageList.assertMessageIsInList(headline, text);

        //������ View ��� ���������� ����� ���������
        showMessagePage = messageList.viewMessage(headline, text);

        //������� �������� Show message
        showMessagePage.assertPageIsOpened();

        //��������� ����� �������� ����� �� ���������
        showMessagePage.assertMessageIsCorrect(headline,text);

        //������ ������ Message list
        messageList = showMessagePage.showMessageList();

        //��������� ������.
        messageList.assertPageIsOpened();

        //� ������ ���������� ��������� ������, � �������� Headline �  Text ���������� ��������, ��������� �� ���� 4
        messageList.assertMessageIsInList(headline, text);

    }
}
