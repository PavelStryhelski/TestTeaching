package com.qulix.ft.teachingSite.tests;

import com.qulix.ft.teachingSite.User;
import com.qulix.ft.teachingSite.UserMessage;
import com.qulix.ft.teachingSite.pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


/**
 * �������� 2
 */
public class Test3 extends AbstractTest {
    @Test(description = "�������� 3. Create and Edit message")
    public void Test() {


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

        //��������������� ������ ���������
        Message editMessagePage = messageList.editMessage(userMessage);

        //������� �������� Edit message
        editMessagePage.assertEditPageIsOpened();

        //��������� ��� ���������� ������ ���������
        editMessagePage.assertMessageIsCorrect(userMessage);

        //���������� ����� �������� � ���� Headline � Text
        UserMessage userMessageNew = new UserMessage();
        editMessagePage.setNewValuesForHeadlineAndText(userMessageNew);

        //��������� ������
        showMessagePage = editMessagePage.saveMessage();

        //������� �������� Show message
        showMessagePage.assertPageIsOpened();

        //��������� ����� �������� ����� �� ���������
        showMessagePage.assertMessageIsCorrect(userMessageNew);

        //������ ������ Message list
        messageList = showMessagePage.showMessageList();

        //��������� ������.
        messageList.assertPageIsOpened();

        //� ������ ���������� ��������� ������, � �������� Headline �  Text ���������� ����� ��������
        messageList.assertMessageIsInList(userMessageNew);
    }
}
