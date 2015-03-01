package com.qulix.ft.teachingSite.tests;

import com.qulix.ft.teachingSite.User;
import com.qulix.ft.teachingSite.pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


/***
 * Сценарий 2
 */
public class Test6 extends AbstractTest{
    @Test(description = "Сценарий 6. Create 2 messages")
    @Parameters({"Login", "Password", "HeadlineValue", "TextValue","HeadlineValue_2", "TextValue_2"})
    public void Test(User user, String headline, String text,String headline_2, String text_2){

       //Открыта главная страница
        MainPage.assertMainPageIsOpened();

        //Перейти по ссылке qulixteachingsite.UserController
        //Открыта страница логина
        MainPage.clickUserController();

        //Ввести логин и пароль  admin/password, нажать Login
        Login.signIn(user);

        //Открыт список Message list
        MessageList.assertPageIsOpened();

         //Нажать New Message
        MessageList.goToNewMessage();

        //Открыта форма создания Create message
        CreateMessage.assertPageIsOpened();

        //Заполнить поля Headline и Text
        CreateMessage.createMessage(headline, text);

        //Открыта страница Show message
        ShowMessage.assertPageIsOpened();

        //Чекнуть, что сообщение правильное
        ShowMessage.assertMessageIsCorrect(headline,text);

        //Нажать New Message
        ShowMessage.createNewMessage();

        //Открыта форма создания Create message
        CreateMessage.assertPageIsOpened();

        //Заполнить поля Headline и Text
        CreateMessage.createMessage(headline_2, text_2);

        //Открыта страница Show message
        ShowMessage.assertPageIsOpened();

        //Чекнуть, что сообщение правильное
        ShowMessage.assertMessageIsCorrect(headline_2,text_2);

        //Нажать Message List
        ShowMessage.showMessageList();

        //Отображен список.
        MessageList.assertPageIsOpened();

        //В списке содержится созданный объект, в колонках Headline и  Text отображены значения, введенные на шаге 4
        MessageList.assertMessageIsInList(headline, text);

        //В списке содержится созданный объект, в колонках Headline и  Text отображены значения, введенные на шаге 8
        MessageList.assertMessageIsInList(headline_2, text_2);
    }
}
