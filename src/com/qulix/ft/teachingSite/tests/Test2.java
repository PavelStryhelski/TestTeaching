package com.qulix.ft.teachingSite.tests;

import com.qulix.ft.teachingSite.pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test2  extends AbstractTest{
    @Test(description = "Сценарий 2. Create message")
    @Parameters({"Login", "Password", "HeadlineValue", "TextValue"})
    public void Test(String login, String password, String headline, String text){

        //Открыта главная страница
        MainPage.assertMainPageIsOpened();

        //Перейти по ссылке qulixteachingsite.UserController
        //Открыта страница логина
        MainPage.clickMessageController();

        //Ввести логин и пароль  admin/password, нажать Login
        Login.signIn(login, password);

        //Открыт список Message list
        MessageList.assertPageIsOpened();

        //Нажать New Message
        MessageList.clickNewMessage();

        //Открыта форма создания Create message
        CreateMessage.assertPageIsOpened();

        //Заполнить поля Headline и Text
        //Нажать Create
        CreateMessage.createMessage(headline, text);

        //Открыта страница Show message
        ShowMessage.assertPageIsOpened();

        //Нажать кнопку Message list
        ShowMessage.clickMessageList();

        //Отображен список.
        MessageList.assertPageIsOpened();

        //В списке содержится созданный объект, в колонках Headline и  Text отображены значения, введенные на шаге 4
        MessageList.assertMessageIsInList(headline, text);

        //Выбрать созданное ранее сообщение


    }
}
