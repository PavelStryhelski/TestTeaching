package com.qulix.ft.teachingSite.tests;

import com.qulix.ft.teachingSite.User;
import com.qulix.ft.teachingSite.pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


/***
 * �������� 2
 */
public class Test4 extends AbstractTest{
    @Test(description = "�������� 4. Create and Delete message")
    @Parameters({"Login", "Password", "HeadlineValue", "TextValue"})
    public void Test(User user, String headline, String text){

       //������� ������� ��������
        MainPage.assertMainPageIsOpened();

        //������� �� ������ qulixteachingsite.UserController
        //������� �������� ������
        MainPage.clickUserController();

        //������ ����� � ������  admin/password, ������ Login
        Login.signIn(user);

        //������ ������ Message list
        MessageList.assertPageIsOpened();

         //������ New Message
        MessageList.goToNewMessage();

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

        //������� ����� ��������� ���������
        MessageList.clickDeleteButton(headline, text);

        //�������, ��� ��������� ��������� �� ������������ � ������
        MessageList.assertMessageIsNotInList(headline, text);

    }
}
