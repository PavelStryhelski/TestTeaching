package com.qulix.ft.teachingSite.tests;

import com.qulix.ft.teachingSite.pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


/***
 * �������� 2
 */
public class Test6 extends AbstractTest{
    @Test(description = "�������� 6. Create 2 messages")
    @Parameters({"Login", "Password", "HeadlineValue", "TextValue","HeadlineValue_2", "TextValue_2"})
    public void Test(String login, String password, String headline, String text,String headline_2, String text_2){

       //������� ������� ��������
        MainPage.assertMainPageIsOpened();

        //������� �� ������ qulixteachingsite.UserController
        //������� �������� ������
        MainPage.clickMessageController();

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

        //�������, ��� ��������� ��������� ����������
        ShowMessage.assertMessageIsCorrect(headline,text);

        //������ New Message
        ShowMessage.clickCreateNewMessageButton();

        //������� ����� �������� Create message
        CreateMessage.assertPageIsOpened();

        //��������� ���� Headline � Text
        CreateMessage.createMessage(headline_2, text_2);

        //������� �������� Show message
        ShowMessage.assertPageIsOpened();

        //������ Message List
        ShowMessage.clickMessageList();

        //��������� ������.
        MessageList.assertPageIsOpened();

        //� ������ ���������� ��������� ������, � �������� Headline �  Text ���������� ��������, ��������� �� ���� 4
        MessageList.assertMessageIsInList(headline, text);

        //� ������ ���������� ��������� ������, � �������� Headline �  Text ���������� ��������, ��������� �� ���� 8
        MessageList.assertMessageIsInList(headline_2, text_2);
    }
}
