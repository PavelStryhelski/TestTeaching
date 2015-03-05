package com.qulix.ft.teachingSite.tests;

import com.qulix.ft.teachingSite.User;
import com.qulix.ft.teachingSite.UserMessage;
import com.qulix.ft.teachingSite.pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


/***
 * Сценарий 2
 */
public class Test5 extends AbstractTest{
    @Test(description = "Сценарий 5. Create message and exit without saving")
    public void Test(){

        MainPage mainPage = new MainPage(driver);

        //Открыта главная страница
        mainPage.assertMainPageIsOpened();

        //Перейти по ссылке qulixteachingsite.UserController
        LoginPage loginPagePage = mainPage.goToUserController();

        //Открыта страница логина
        loginPagePage.assertLoginPageIsOpened();

        //Ввести логин и пароль  admin/password, нажать LoginPage
        MessageList messageList = loginPagePage.signIn(User.ADMIN);

        //Открыт список Message list
        messageList.assertPageIsOpened();

        //Нажать New Message
        Message createNewMessagePage = messageList.createNewMessage();

        //Открыта форма создания Create message
        createNewMessagePage.assertCreateMessagePageIsOpened();

        //Заполнить поля Headline и Text
        UserMessage userMessage = new UserMessage();
        createNewMessagePage.fulfilMessageFieldsWithValues(userMessage);

        //Нажать Message List
        messageList = createNewMessagePage.goToMessageList();

        //Отображен список.
        messageList.assertPageIsOpened();

        //Чекнуть, что удаленное сообщение не присутствует в списке
        messageList.assertMessageIsNotInList(userMessage);

    }
}
