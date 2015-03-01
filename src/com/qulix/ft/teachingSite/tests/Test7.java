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
    @Parameters({"Login", "Password", "HeadlineValue", "TextValue", "LoginJD", "PasswordJD", "UserNameJD", "HeadlineValueJD", "TextValueJD", "UserNameAdmin"})
    public void Test(User user_admin, String headline, String text, User user_jd, String jd_name, String headline_jd, String text_jd, String admin_name) {

        //������� ������� ��������
        MainPage.assertMainPageIsOpened();

        //������� �� ������ qulixteachingsite.UserController
        //������� �������� ������
        MainPage.clickUserController();

        //������ ����� � ������  admin/password, ������ Login
        Login.signIn(user_admin);

        //������ ������ Message list
        MessageList.assertPageIsOpened();

        //������ New Message
        MessageList.goToNewMessage();

        //������� ����� �������� Create message
        CreateMessage.assertPageIsOpened();

        //��������� ���� Headline � Text
        CreateMessage.createMessage(headline, text);

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
        MessageList.clickViewButton(headline, text);

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
        Login.signIn(user_jd);

        //Salut, Johny!
        MessageList.assertGreeting(jd_name);

        //������ ������ Message list
        MessageList.assertPageIsOpened();

        //������ New Message
        MessageList.goToNewMessage();

        //������� ����� �������� Create message
        CreateMessage.assertPageIsOpened();

        //��������� ���� Headline � Text
        CreateMessage.createMessage(headline_jd, text_jd);

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
        MessageList.clickViewButton(headline_jd, text_jd);

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
        Login.signIn(user_admin);

        //Salut, Admin!
        MessageList.assertGreeting(admin_name);

        //������ ������ Message list
        MessageList.assertPageIsOpened();

        //Set the checkbox
        MessageList.checkCheckBox();

        //���������,��� ��������� ���� � ������� �� ������
        MessageList.assertMessageIsInList(headline, text);

        //���������,��� �����  - �����
        MessageList.assertMessageIsInList(headline, text, admin_name);

        //���������,��� ��������� ���� � ������� �� ������
        MessageList.assertMessageIsInList(headline_jd, text_jd);

        //���������,��� �����  - ���� ���
        MessageList.assertMessageIsInList(headline_jd, text_jd, jd_name);

        //Remove checkbox
        MessageList.uncheckCheckBox();

        //���������,��� ��������� ���� � ������� �� ������
        MessageList.assertMessageIsInList(headline, text);

        //���������,��� �����  - �����
        MessageList.assertMessageIsInList(headline, text, admin_name);

        //���������,��� ��������� � ������� �� ������ ���
        MessageList.assertMessageIsNotInList(headline_jd, text_jd);


        /* ------------------------------ Test for the same messages ------------------

        //������� ������� ��������
        MainPage.assertMainPageIsOpened();

        //������� �� ������ qulixteachingsite.UserController
        //������� �������� ������
        MainPage.clickUserController();

        //������ ����� � ������  admin/password, ������ Login
        Login.signIn(login, password);

        //������ ������ Message list
        MessageList.assertPageIsOpened();

        //Set the checkbox
        MessageList.checkCheckBox();

        //���������,��� �����  - �����
        MessageList.assertMessageIsInList("Test","Test",admin_name);

        //���������,��� �����  - ���� ���
        MessageList.assertMessageIsInList("Test","Test",jd_name);   */

    }
}
