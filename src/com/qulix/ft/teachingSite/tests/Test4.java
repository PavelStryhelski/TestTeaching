package com.qulix.ft.teachingSite.tests;

import com.qulix.ft.teachingSite.User;
import com.qulix.ft.teachingSite.pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


/***
 * Сценарий 2
 */
public class Test4 extends AbstractTest{
    @Test(description = "Сценарий 4. Create and Delete message")
    @Parameters({"HeadlineValue", "TextValue"})
    public void Test(String headline, String text){

      /* //Открыта главная страница
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

        //Удалить ранее созданное сообщение
        MessageList.deleteMessage(headline, text);

        //Чекнуть, что удаленное сообщение не присутствует в списке
        MessageList.assertMessageIsNotInList(headline, text);*/

    }
}
