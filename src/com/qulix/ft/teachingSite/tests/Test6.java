package com.qulix.ft.teachingSite.tests;

import com.qulix.ft.teachingSite.User;
import com.qulix.ft.teachingSite.pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


/***
 * �������� 2
 */
public class Test6 extends AbstractTest{
    @Test(description = "�������� 6. Create 2 messages")
    @Parameters({"Login", "Password", "HeadlineValue", "TextValue","HeadlineValue_2", "TextValue_2"})
    public void Test(User user, String headline, String text,String headline_2, String text_2){

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
        CreateMessage.createMessage(headline, text);

        //������� �������� Show message
        ShowMessage.assertPageIsOpened();

        //�������, ��� ��������� ����������
        ShowMessage.assertMessageIsCorrect(headline,text);

        //������ New Message
        ShowMessage.createNewMessage();

        //������� ����� �������� Create message
        CreateMessage.assertPageIsOpened();

        //��������� ���� Headline � Text
        CreateMessage.createMessage(headline_2, text_2);

        //������� �������� Show message
        ShowMessage.assertPageIsOpened();

        //�������, ��� ��������� ����������
        ShowMessage.assertMessageIsCorrect(headline_2,text_2);

        //������ Message List
        ShowMessage.showMessageList();

        //��������� ������.
        MessageList.assertPageIsOpened();

        //� ������ ���������� ��������� ������, � �������� Headline �  Text ���������� ��������, ��������� �� ���� 4
        MessageList.assertMessageIsInList(headline, text);

        //� ������ ���������� ��������� ������, � �������� Headline �  Text ���������� ��������, ��������� �� ���� 8
        MessageList.assertMessageIsInList(headline_2, text_2);
    }
}
