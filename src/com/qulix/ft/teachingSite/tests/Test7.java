package com.qulix.ft.teachingSite.tests;

import com.qulix.ft.teachingSite.User;
import com.qulix.ft.teachingSite.pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


/**
 * �������� 2
 */
public class Test7 extends AbstractTest {
    @Test(description = "�������� 7. Check another user`s messages")
    @Parameters({"HeadlineValue", "TextValue", "HeadlineValueJD", "TextValueJD"})
    public void Test(String headline, String text, String headline_jd, String text_jd) {


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

        //������� �� �������� Message List
        messageList = showMessagePage.showMessageList();

        //������ ������ Message list
        messageList.assertPageIsOpened();

        //���������,��� ��������� ���� � �������
        messageList.assertMessageIsInList(headline, text);

        //�������� ��������� ��������� �� View
        showMessagePage = messageList.viewMessage(headline, text);

        //���������,��� ��������� �������� Show Message
        showMessagePage.assertPageIsOpened();

        //���������,��� ��������� ���������
        showMessagePage.assertMessageIsCorrect(headline, text);

        //������� �� �������� Message List
        messageList = showMessagePage.showMessageList();

        //������ ������ Message list
        messageList.assertPageIsOpened();

        //���������,��� ��������� ���� � �������
        messageList.assertMessageIsInList(headline, text);

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
        showMessagePage = createNewMessagePage.createMessage(headline_jd, text_jd);

        //������� �������� Show message
        showMessagePage.assertPageIsOpened();

        //�������, ��� ��������� ����������
        showMessagePage.assertMessageIsCorrect(headline_jd, text_jd);

        //������� �� �������� Message List
        messageList = showMessagePage.showMessageList();

        //������ ������ Message list
        messageList.assertPageIsOpened();

        //Set the checkbox
        messageList.checkCheckBox();

        //���������,��� ��������� ���� � �������
        messageList.assertMessageIsInList(headline_jd, text_jd);

        //�������� ��������� ��������� �� View
        showMessagePage = messageList.viewMessage(headline_jd, text_jd);

        //���������,��� ��������� �������� Show Message
        showMessagePage.assertPageIsOpened();

        //���������,��� ��������� ���������
        showMessagePage.assertMessageIsCorrect(headline_jd, text_jd);

        //������� �� �������� Message List
        messageList = showMessagePage.showMessageList();

        //������ ������ Message list
        messageList.assertPageIsOpened();

        //���������,��� ��������� ���� � �������
        messageList.assertMessageIsInList(headline_jd, text_jd);

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
        messageList.assertMessageIsInList(headline, text, User.ADMIN.getName());

        //���������,��� �����  - ���� ���
        messageList.assertMessageIsInList(headline_jd, text_jd, User.J_DOE.getName());

        //Remove checkbox
        messageList.uncheckCheckBox();

        //���������,��� �����  - �����
        messageList.assertMessageIsInList(headline, text, User.ADMIN.getName());

        //���������,��� ��������� � ������� �� ������ ���
        messageList.assertMessageIsNotInList(headline_jd, text_jd);


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
