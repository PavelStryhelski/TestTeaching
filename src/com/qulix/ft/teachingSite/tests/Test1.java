package com.qulix.ft.teachingSite.tests;

import com.qulix.ft.teachingSite.User;
import com.qulix.ft.teachingSite.pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/***
 * �������� 1
 */
public class Test1 extends AbstractTest{

    //TODO: CreateMessagePage & EditMessagePage - common
    //TODO Create Message and User classes

    @Test(description = "�������� 1. Create message")
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

    }
}
