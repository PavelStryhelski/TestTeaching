package com.qulix.ft.teachingSite.tests;

import com.qulix.ft.teachingSite.pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


/***
 * Сценарий 2
 */
public class Test6 extends AbstractTest{
    @Test(description = "Сценарий 6. Create 2 messages")
    @Parameters({"Login", "Password", "HeadlineValue", "TextValue","HeadlineValue_2", "TextValue_2"})
    public void Test(String login, String password, String headline, String text,String headline_2, String text_2){

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
        CreateMessage.createMessage(headline, text);

        //Открыта страница Show message
        ShowMessage.assertPageIsOpened();

        //Чекнуть, что удаленное сообщение правильное
        ShowMessage.assertMessageIsCorrect(headline,text);

        //Нажать New Message
        ShowMessage.clickCreateNewMessageButton();

        //Открыта форма создания Create message
        CreateMessage.assertPageIsOpened();

        //Заполнить поля Headline и Text
        CreateMessage.createMessage(headline_2, text_2);

        //Открыта страница Show message
        ShowMessage.assertPageIsOpened();

        //Нажать Message List
        ShowMessage.clickMessageList();

        //Отображен список.
        MessageList.assertPageIsOpened();

        //В списке содержится созданный объект, в колонках Headline и  Text отображены значения, введенные на шаге 4
        MessageList.assertMessageIsInList(headline, text);

        //В списке содержится созданный объект, в колонках Headline и  Text отображены значения, введенные на шаге 8
        MessageList.assertMessageIsInList(headline_2, text_2);
    }
}
