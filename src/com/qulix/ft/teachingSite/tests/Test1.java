package com.qulix.ft.teachingSite.tests;

import com.qulix.ft.teachingSite.User;
import com.qulix.ft.teachingSite.pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/***
 * �������� 1
 */
public class Test1 extends AbstractTest{

    //TODO: Create nested classes
    //TODO Create Message and User classes

    @Test(description = "�������� 1. Create message")
    @Parameters({"HeadlineValue", "TextValue"})
    public void Test(String headline, String text){

        /*MainPage mainPage = new MainPage(driver);
        Login loginPage = mainPage.goToUserController();*/

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

    }
}
