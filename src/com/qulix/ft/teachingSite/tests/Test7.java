package com.qulix.ft.teachingSite.tests;

import com.qulix.ft.teachingSite.User;
import com.qulix.ft.teachingSite.UserMessage;
import com.qulix.ft.teachingSite.pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


/**
 * �������� 2
 */
public class Test7 extends AbstractTest {
    @Test(description = "�������� 7. Check another user`s messages")
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

        //�������, ��� ��������� ����������
        showMessagePage.assertMessageIsCorrect(userMessage);

        //������� �� �������� Message List
        messageList = showMessagePage.showMessageList();

        //������ ������ Message list
        messageList.assertPageIsOpened();

        //���������,��� ��������� ���� � �������
        messageList.assertMessageIsInList(userMessage);

        //�������� ��������� ��������� �� View
        showMessagePage = messageList.viewMessage(userMessage);

        //���������,��� ��������� �������� Show Message
        showMessagePage.assertPageIsOpened();

        //���������,��� ��������� ���������
        showMessagePage.assertMessageIsCorrect(userMessage);

        //������� �� �������� Message List
        messageList = showMessagePage.showMessageList();

        //������ ������ Message list
        messageList.assertPageIsOpened();

        //���������,��� ��������� ���� � �������
        messageList.assertMessageIsInList(userMessage);

        //Log out
        loginPagePage = messageList.logOut();

        //������� ������� ��������
        loginPagePage.assertLoginPageIsOpened();

        /**
         *
         * ACT AS JOHN DOE
         *
         */

        //������ ����� � ������  admin/password, ������ LoginPage
        messageList = loginPagePage.signIn(User.J_DOE);

        //Salut, Johny!
        messageList.assertGreeting(User.J_DOE.getName());

        //������ ������ Message list
        messageList.assertPageIsOpened();

        //������ New Message
        createNewMessagePage = messageList.createNewMessage();

        //������� ����� �������� Create message
        createNewMessagePage.assertCreateMessagePageIsOpened();

        //��������� ���� Headline � Text
        UserMessage userMessageJD = new UserMessage();
        showMessagePage = createNewMessagePage.createMessage(userMessageJD);

        //������� �������� Show message
        showMessagePage.assertPageIsOpened();

        //�������, ��� ��������� ����������
        showMessagePage.assertMessageIsCorrect(userMessageJD);

        //������� �� �������� Message List
        messageList = showMessagePage.showMessageList();

        //������ ������ Message list
        messageList.assertPageIsOpened();

        //Set the checkbox
        messageList.checkCheckBox();

        //���������,��� ��������� ���� � �������
        messageList.assertMessageIsInList(userMessageJD);

        //�������� ��������� ��������� �� View
        showMessagePage = messageList.viewMessage(userMessageJD);

        //���������,��� ��������� �������� Show Message
        showMessagePage.assertPageIsOpened();

        //���������,��� ��������� ���������
        showMessagePage.assertMessageIsCorrect(userMessageJD);

        //������� �� �������� Message List
        messageList = showMessagePage.showMessageList();

        //������ ������ Message list
        messageList.assertPageIsOpened();

        //���������,��� ��������� ���� � �������
        messageList.assertMessageIsInList(userMessageJD);

        //Remove checkbox
        messageList.uncheckCheckBox();

        //Log out
        loginPagePage = messageList.logOut();

        /**
         *
         * ACT AS ADMIN
         *
         */

        //������ ����� � ������  admin/password, ������ LoginPage
        messageList = loginPagePage.signIn(User.ADMIN);

        //������ ������ Message list
        messageList.assertPageIsOpened();

        //Salut, Admin!
        messageList.assertGreeting(User.ADMIN.getName());

        //Set the checkbox
        messageList.checkCheckBox();

        //���������,��� �����  - �����
        messageList.assertMessageIsInList(userMessage, User.ADMIN.getName());

        //���������,��� �����  - ���� ���
        messageList.assertMessageIsInList(userMessageJD, User.J_DOE.getName());

        //Remove checkbox
        messageList.uncheckCheckBox();

        //���������,��� �����  - �����
        messageList.assertMessageIsInList(userMessage, User.ADMIN.getName());

        //���������,��� ��������� � ������� �� ������ ���
        messageList.assertMessageIsNotInList(userMessageJD);


        /* ------------------------------ Test for the same messages ------------------

        MainPage newMainPage = new MainPage();

        //������� ������� ��������
        newMainPage.assertMainPageIsOpened();

        //������� �� ������ qulixteachingsite.UserController
        //������� �������� ������
        MessageList newMessageList = loginPagePage.signIn(User.ADMIN);

        //������ ������ Message list
        newMessageList.assertPageIsOpened();

        //Set the checkbox
        newMessageList.checkCheckBox();

        //���������,��� �����  - �����
        newMessageList.assertMessageIsInList("Test","Test",User.ADMIN.getName());

        //���������,��� �����  - ���� ���
        newMessageList.assertMessageIsInList("Test", "Test", User.J_DOE.getName());    */

    }
}
