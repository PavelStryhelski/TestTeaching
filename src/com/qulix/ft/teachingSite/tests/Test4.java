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
    @Parameters({"HeadlineValue", "TextValue"})
    public void Test(String headline, String text){

      /* //������� ������� ��������
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
        Message.assertCreateMessagePageIsOpened();

        //��������� ���� Headline � Text
        //������ Create
        Message.createMessage(headline, text);

        //������� �������� Show message
        ShowMessage.assertPageIsOpened();

        //������ ������ Message list
        ShowMessage.showMessageList();

        //��������� ������.
        MessageList.assertPageIsOpened();

        //� ������ ���������� ��������� ������, � �������� Headline �  Text ���������� ��������, ��������� �� ���� 4
        MessageList.assertMessageIsInList(headline, text);

        //������� ����� ��������� ���������
        MessageList.deleteMessage(headline, text);

        //�������, ��� ��������� ��������� �� ������������ � ������
        MessageList.assertMessageIsNotInList(headline, text);*/

    }
}
