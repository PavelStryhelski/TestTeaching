package com.qulix.ft.teachingSite.tests;

import com.qulix.ft.teachingSite.pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


/***
 * �������� 2
 */
public class Test7 extends AbstractTest{
    @Test(description = "�������� 7. Check another user`s messages")
    @Parameters({"Login", "Password", "HeadlineValue", "TextValue","HeadlineValue_2", "TextValue_2"})
    public void Test(String login, String password, String headline, String text,String headline_2, String text_2){

       //������� ������� ��������
        MainPage.assertMainPageIsOpened();

        //������� �� ������ qulixteachingsite.UserController
        //������� �������� ������
        MainPage.clickUserController();

        //������ ����� � ������  admin/password, ������ Login
        Login.signIn(login, password);

        //������ ������ Message list
        MessageList.assertPageIsOpened();

         //������ New Message
        MessageList.clickNewMessage();

        //������� ����� �������� Create message
        CreateMessage.assertPageIsOpened();

        //��������� ���� Headline � Text
        CreateMessage.createMessage(headline, text);

        //������� �������� Show message
        ShowMessage.assertPageIsOpened();

        //�������, ��� ��������� ����������
        ShowMessage.assertMessageIsCorrect(headline,text);

        ShowMessage.clickMessageList();

        MessageList.assertMessageIsInList(headline,text);




    }
}
