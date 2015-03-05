package com.qulix.ft.teachingSite.tests;

import com.qulix.ft.teachingSite.User;
import com.qulix.ft.teachingSite.pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


/**
 * �������� 2
 */
public class Test3 extends AbstractTest {
    @Test(description = "�������� 3. Create and Edit message")
    @Parameters({"HeadlineValue", "TextValue", "NewHeadlineValue", "NewTextValue"})
    public void Test(String headline, String text, String headlineNew, String textNew) {


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

        //������ ������ Message list
        messageList = showMessagePage.showMessageList();

        //��������� ������.
        messageList.assertPageIsOpened();

        //� ������ ���������� ��������� ������, � �������� Headline �  Text ���������� ��������, ��������� �� ���� 4
        messageList.assertMessageIsInList(headline, text);

        //��������������� ������ ���������
        Message editMessagePage = messageList.editMessage(headline, text);

        //������� �������� Edit message
        editMessagePage.assertEditPageIsOpened();

        //��������� ��� ���������� ������ ���������
        editMessagePage.assertMessageIsCorrect(headline, text);

        //���������� ����� �������� � ���� Headline � Text
        editMessagePage.setNewValuesForHeadlineAndText(headlineNew, textNew);

        //��������� ������
        showMessagePage = editMessagePage.saveMessage();

        //������� �������� Show message
        showMessagePage.assertPageIsOpened();

        //��������� ����� �������� ����� �� ���������
        showMessagePage.assertMessageIsCorrect(headlineNew, textNew);

        //������ ������ Message list
        messageList = showMessagePage.showMessageList();

        //��������� ������.
        messageList.assertPageIsOpened();

        //� ������ ���������� ��������� ������, � �������� Headline �  Text ���������� ����� ��������
        messageList.assertMessageIsInList(headlineNew, textNew);
    }
}
