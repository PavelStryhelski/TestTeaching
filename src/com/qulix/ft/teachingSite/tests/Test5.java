package com.qulix.ft.teachingSite.tests;

import com.qulix.ft.teachingSite.User;
import com.qulix.ft.teachingSite.pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


/***
 * �������� 2
 */
public class Test5 extends AbstractTest{
    @Test(description = "�������� 5. Create message and exit without saving")
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
        CreateMessage.fulfilMessageFieldsWithValues(headline,text);

        //������ Message List
        MessageList.goToMessageList();

        //��������� ������.
        MessageList.assertPageIsOpened();

        //�������, ��� ��������� ��������� �� ������������ � ������
        MessageList.assertMessageIsNotInList(headline, text);

    }
}
