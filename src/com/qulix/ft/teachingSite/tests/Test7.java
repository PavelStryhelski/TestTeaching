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

       //������� ������� ��������
        MainPage.assertMainPageIsOpened();

        //������� �� ������ qulixteachingsite.UserController
        //������� �������� ������
        MainPage.goToUserController();

        //������ ����� � ������  admin/password, ������ Login
        Login.signIn(User.ADMIN);

        //������ ������ Message list
        MessageList.assertPageIsOpened();

        //������ New Message
        MessageList.createNewMessage();

        //������� ����� �������� Create message
        Message.assertCreateMessagePageIsOpened();

        //��������� ���� Headline � Text
        Message.createMessage(headline, text);

        //������� �������� Show message
        ShowMessage.assertPageIsOpened();

        //�������, ��� ��������� ����������
        ShowMessage.assertMessageIsCorrect(headline, text);

        //������� �� �������� Message List
        ShowMessage.showMessageList();

        //������ ������ Message list
        MessageList.assertPageIsOpened();

        //���������,��� ��������� ���� � �������
        MessageList.assertMessageIsInList(headline, text);

        //�������� ��������� ��������� �� View
        MessageList.viewMessage(headline, text);

        //���������,��� ��������� �������� Show Message
        ShowMessage.assertPageIsOpened();

        //���������,��� ��������� ���������
        ShowMessage.assertMessageIsCorrect(headline, text);

        //������� �� �������� Message List
        ShowMessage.showMessageList();

        //������ ������ Message list
        MessageList.assertPageIsOpened();

        //���������,��� ��������� ���� � �������
        MessageList.assertMessageIsInList(headline, text);

        //Log out
        MessageList.logOut();

        //������� ������� ��������
        Login.assertLoginPageIsOpened();

        /**
         *
         * ACT AS JOHN DOE
         *
         */

        //������ ����� � ������  admin/password, ������ Login
        Login.signIn(User.J_DOE);

        //Salut, Johny!
        MessageList.assertGreeting(User.J_DOE.getName());

        //������ ������ Message list
        MessageList.assertPageIsOpened();

        //������ New Message
        MessageList.createNewMessage();

        //������� ����� �������� Create message
        Message.assertCreateMessagePageIsOpened();

        //��������� ���� Headline � Text
        Message.createMessage(headline_jd, text_jd);

        //������� �������� Show message
        ShowMessage.assertPageIsOpened();

        //�������, ��� ��������� ����������
        ShowMessage.assertMessageIsCorrect(headline_jd, text_jd);

        //������� �� �������� Message List
        ShowMessage.showMessageList();

        //������ ������ Message list
        MessageList.assertPageIsOpened();

        //Set the checkbox
        MessageList.checkCheckBox();

        //���������,��� ��������� ���� � �������
        MessageList.assertMessageIsInList(headline_jd, text_jd);

        //�������� ��������� ��������� �� View
        MessageList.viewMessage(headline_jd, text_jd);

        //���������,��� ��������� �������� Show Message
        ShowMessage.assertPageIsOpened();

        //���������,��� ��������� ���������
        ShowMessage.assertMessageIsCorrect(headline_jd, text_jd);

        //������� �� �������� Message List
        ShowMessage.showMessageList();

        //������ ������ Message list
        MessageList.assertPageIsOpened();

        //���������,��� ��������� ���� � �������
        MessageList.assertMessageIsInList(headline_jd, text_jd);

        //Remove checkbox
        MessageList.uncheckCheckBox();

        //Log out
        MessageList.logOut();

        /**
         *
         * ACT AS ADMIN
         *
         */

        //������ ����� � ������  admin/password, ������ Login
        Login.signIn(User.ADMIN);

        //Salut, Admin!
        MessageList.assertGreeting(User.ADMIN.getName());

        //������ ������ Message list
        MessageList.assertPageIsOpened();

        //Set the checkbox
        MessageList.checkCheckBox();

        //���������,��� �����  - �����
        MessageList.assertMessageIsInList(headline, text, User.ADMIN.getName());

        //���������,��� �����  - ���� ���
        MessageList.assertMessageIsInList(headline_jd, text_jd, User.J_DOE.getName());

        //Remove checkbox
        MessageList.uncheckCheckBox();

        //���������,��� �����  - �����
        MessageList.assertMessageIsInList(headline, text, User.ADMIN.getName());

        //���������,��� ��������� � ������� �� ������ ���
        MessageList.assertMessageIsNotInList(headline_jd, text_jd);


        /* ------------------------------ Test for the same messages ------------------  */

        //������� ������� ��������
        MainPage.assertMainPageIsOpened();

        //������� �� ������ qulixteachingsite.UserController
        //������� �������� ������
        MainPage.goToUserController();

        //������ ����� � ������  admin/password, ������ Login
        Login.signIn(User.ADMIN);

        //������ ������ Message list
        MessageList.assertPageIsOpened();

        //Set the checkbox
        MessageList.checkCheckBox();

        //���������,��� �����  - �����
        MessageList.assertMessageIsInList("Test","Test",User.ADMIN.getName());

        //���������,��� �����  - ���� ���
        MessageList.assertMessageIsInList("Test", "Test", User.J_DOE.getName());

    }
}
