package com.qulix.ft.teachingSite.tests;

import com.qulix.ft.teachingSite.pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


/***
 * Сценарий 2
 */
public class Test5 extends AbstractTest{
    @Test(description = "Сценарий 5. Create message and exit without saving")
    @Parameters({"Login", "Password", "HeadlineValue", "TextValue"})
    public void Test(String login, String password, String headline, String text){

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
        CreateMessage.fulfilMessageFieldsWithValues(headline,text);

        //Нажать Message List
        MessageList.clickMessageListButton();

        //Отображен список.
        MessageList.assertPageIsOpened();

        //Чекнуть, что удаленное сообщение не присутствует в списке
        MessageList.assertMessageIsNotInList(headline, text);

    }
}
