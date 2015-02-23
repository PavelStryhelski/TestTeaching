package com.qulix.ft.teachingSite.tests;

import com.qulix.ft.teachingSite.pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


/***
 * Сценарий 2
 */
public class Test7 extends AbstractTest{
    @Test(description = "Сценарий 7. Check another user`s messages")
    @Parameters({"Login", "Password", "HeadlineValue", "TextValue","HeadlineValue_2", "TextValue_2"})
    public void Test(String login, String password, String headline, String text,String headline_2, String text_2){

       //Открыта главная страница
        MainPage.assertMainPageIsOpened();

        //Перейти по ссылке qulixteachingsite.UserController
        //Открыта страница логина
        MainPage.clickUserController();

        //Ввести логин и пароль  admin/password, нажать Login
        Login.signIn(login, password);

        //Открыт список Message list
        MessageList.assertPageIsOpened();

         //Нажать New Message
        MessageList.clickNewMessage();

        //Открыта форма создания Create message
        CreateMessage.assertPageIsOpened();

        //Заполнить поля Headline и Text
        CreateMessage.createMessage(headline, text);

        //Открыта страница Show message
        ShowMessage.assertPageIsOpened();

        //Чекнуть, что сообщение правильное
        ShowMessage.assertMessageIsCorrect(headline,text);

        ShowMessage.clickMessageList();

        MessageList.assertMessageIsInList(headline,text);




    }
}
