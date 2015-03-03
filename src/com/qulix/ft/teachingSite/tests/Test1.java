package com.qulix.ft.teachingSite.tests;

import com.qulix.ft.teachingSite.User;
import com.qulix.ft.teachingSite.pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/***
 * Сценарий 1
 */
public class Test1 extends AbstractTest{

    //TODO: CreateMessagePage & EditMessagePage - common
    //TODO Create Message and User classes

    @Test(description = "Сценарий 1. Create message")
    @Parameters({"HeadlineValue", "TextValue"})
    public void Test(String headline, String text){

        //Открыта главная страница
        MainPage.assertMainPageIsOpened();

        //Перейти по ссылке qulixteachingsite.UserController
        //Открыта страница логина
        MainPage.goToUserController();

        //Ввести логин и пароль  admin/password, нажать Login
        Login.signIn(User.ADMIN);

        //Открыт список Message list
        MessageList.assertPageIsOpened();

        //Нажать New Message
        MessageList.createNewMessage();

        //Открыта форма создания Create message
        Message.assertCreateMessagePageIsOpened();

        //Заполнить поля Headline и Text
        //Нажать Create
        Message.createMessage(headline, text);

        //Открыта страница Show message
        ShowMessage.assertPageIsOpened();

        //Нажать кнопку Message list
        ShowMessage.showMessageList();

        //Отображен список.
        MessageList.assertPageIsOpened();

        //В списке содержится созданный объект, в колонках Headline и  Text отображены значения, введенные на шаге 4
        MessageList.assertMessageIsInList(headline, text);

    }
}
