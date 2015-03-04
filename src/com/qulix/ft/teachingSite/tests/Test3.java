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

        //��������������� ������ ���������
        Message editMessagePage = messageList.editMessage(headline, text);

        //������� �������� Edit message
        editMessagePage.assertEditPageIsOpened();

        //��������� ��� ���������� ������ ���������
        editMessagePage.assertMessageIsCorrect(headline, text);

        //���������� ����� �������� � ���� Headline � Text
        editMessagePage.setNewValuesForHeadlineAndText(headlineNew, textNew);

        //��������� ������
        showMessage = editMessagePage.saveMessage();

        //������� �������� Show message
        showMessage.assertPageIsOpened();

        //��������� ����� �������� ����� �� ���������
        showMessage.assertMessageIsCorrect(headlineNew, textNew);

        //������ ������ Message list
        messageList = showMessage.showMessageList();

        //��������� ������.
        messageList.assertPageIsOpened();

        //� ������ ���������� ��������� ������, � �������� Headline �  Text ���������� ����� ��������
        messageList.assertMessageIsInList(headlineNew, textNew);
    }
}
