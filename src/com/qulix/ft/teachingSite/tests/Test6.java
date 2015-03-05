package com.qulix.ft.teachingSite.tests;

import com.qulix.ft.teachingSite.User;
import com.qulix.ft.teachingSite.pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


/**
 * �������� 2
 */
public class Test6 extends AbstractTest {
    @Test(description = "�������� 6. Create 2 messages")
    @Parameters({"HeadlineValue", "TextValue", "HeadlineValue_2", "TextValue_2"})
    public void Test(String headline, String text, String headline_2, String text_2) {

        MainPage mainPage = new MainPage();

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
        ShowMessagePage showMessagePage = createNewMessagePage.createMessage(headline, text);

        //������� �������� Show message
        showMessagePage.assertPageIsOpened();

        //�������, ��� ��������� ����������
        showMessagePage.assertMessageIsCorrect(headline, text);

        //������ New Message
        Message createNewMessage = showMessagePage.createNewMessage();

        //������� ����� �������� Create message
        createNewMessage.assertCreateMessagePageIsOpened();

        //��������� ���� Headline � Text
        showMessagePage = createNewMessage.createMessage(headline_2, text_2);

        //������� �������� Show message
        showMessagePage.assertPageIsOpened();

        //�������, ��� ��������� ����������
        showMessagePage.assertMessageIsCorrect(headline_2, text_2);

        //������ Message List
        messageList = showMessagePage.showMessageList();

        //��������� ������.
        messageList.assertPageIsOpened();

        //� ������ ���������� ��������� ������, � �������� Headline �  Text ���������� ��������, ��������� �� ���� 4
        messageList.assertMessageIsInList(headline, text);

        //� ������ ���������� ��������� ������, � �������� Headline �  Text ���������� ��������, ��������� �� ���� 8
        messageList.assertMessageIsInList(headline_2, text_2);
    }
}
