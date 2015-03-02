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
        CreateMessage.assertPageIsOpened();

        //��������� ���� Headline � Text
        //������ Create
        CreateMessage.createMessage(headline, text);

        //������� �������� Show message
        ShowMessage.assertPageIsOpened();

        //������ ������ Message list
        ShowMessage.showMessageList();

        //��������� ������.
        MessageList.assertPageIsOpened();

        //� ������ ���������� ��������� ������, � �������� Headline �  Text ���������� ��������, ��������� �� ���� 4
        MessageList.assertMessageIsInList(headline, text);

        //��������������� ������ ���������
        MessageList.clickEditButton(headline, text);

        //������� �������� Edit message
        EditPage.assertPageIsOpened();

        //��������� ��� ���������� ������ ���������
        EditPage.assertMessageIsCorrect(headline, text);

        //���������� ����� �������� � ���� Headline � Text
        EditPage.setNewValuesForHeadlineAndText(headlineNew, textNew);

        //��������� ������
        EditPage.saveMessage();

        //������� �������� Show message
        ShowMessage.assertPageIsOpened();

        //��������� ����� �������� ����� �� ���������
        ShowMessage.assertMessageIsCorrect(headlineNew, textNew);

        //������ ������ Message list
        ShowMessage.showMessageList();

        //��������� ������.
        MessageList.assertPageIsOpened();

        //� ������ ���������� ��������� ������, � �������� Headline �  Text ���������� ����� ��������
        MessageList.assertMessageIsInList(headlineNew, textNew);
    }
}
