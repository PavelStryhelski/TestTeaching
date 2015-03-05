package com.qulix.ft.teachingSite.tests;

import com.qulix.ft.teachingSite.User;
import com.qulix.ft.teachingSite.UserMessage;
import com.qulix.ft.teachingSite.pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


/**
 * Сценарий 2
 */
public class Test7 extends AbstractTest {
    @Test(description = "Сценарий 7. Check another user`s messages")
    public void Test() {

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
        //Нажать Create
        UserMessage userMessage = new UserMessage();
        ShowMessagePage showMessagePage = createNewMessagePage.createMessage(userMessage);

        //Открыта страница Show message
        showMessagePage.assertPageIsOpened();

        //Чекнуть, что сообщение правильное
        showMessagePage.assertMessageIsCorrect(userMessage);

        //перейти на страницу Message List
        messageList = showMessagePage.showMessageList();

        //Открыт список Message list
        messageList.assertPageIsOpened();

        //Убедиться,что сообщение есть в таблице
        messageList.assertMessageIsInList(userMessage);

        //Кликнуть созданное сообщение на View
        showMessagePage = messageList.viewMessage(userMessage);

        //Убедиться,что открылась страница Show Message
        showMessagePage.assertPageIsOpened();

        //Проверить,что сообщение четенькое
        showMessagePage.assertMessageIsCorrect(userMessage);

        //перейти на страницу Message List
        messageList = showMessagePage.showMessageList();

        //Открыт список Message list
        messageList.assertPageIsOpened();

        //Убедиться,что сообщение есть в таблице
        messageList.assertMessageIsInList(userMessage);

        //Log out
        loginPagePage = messageList.logOut();

        //Открыта главная страница
        loginPagePage.assertLoginPageIsOpened();

        /**
         *
         * ACT AS JOHN DOE
         *
         */

        //Ввести логин и пароль  admin/password, нажать LoginPage
        messageList = loginPagePage.signIn(User.J_DOE);

        //Salut, Johny!
        messageList.assertGreeting(User.J_DOE.getName());

        //Открыт список Message list
        messageList.assertPageIsOpened();

        //Нажать New Message
        createNewMessagePage = messageList.createNewMessage();

        //Открыта форма создания Create message
        createNewMessagePage.assertCreateMessagePageIsOpened();

        //Заполнить поля Headline и Text
        UserMessage userMessageJD = new UserMessage();
        showMessagePage = createNewMessagePage.createMessage(userMessageJD);

        //Открыта страница Show message
        showMessagePage.assertPageIsOpened();

        //Чекнуть, что сообщение правильное
        showMessagePage.assertMessageIsCorrect(userMessageJD);

        //перейти на страницу Message List
        messageList = showMessagePage.showMessageList();

        //Открыт список Message list
        messageList.assertPageIsOpened();

        //Set the checkbox
        messageList.checkCheckBox();

        //Убедиться,что сообщение есть в таблице
        messageList.assertMessageIsInList(userMessageJD);

        //Кликнуть созданное сообщение на View
        showMessagePage = messageList.viewMessage(userMessageJD);

        //Убедиться,что открылась страница Show Message
        showMessagePage.assertPageIsOpened();

        //Проверить,что сообщение четенькое
        showMessagePage.assertMessageIsCorrect(userMessageJD);

        //перейти на страницу Message List
        messageList = showMessagePage.showMessageList();

        //Открыт список Message list
        messageList.assertPageIsOpened();

        //Убедиться,что сообщение есть в таблице
        messageList.assertMessageIsInList(userMessageJD);

        //Remove checkbox
        messageList.uncheckCheckBox();

        //Log out
        loginPagePage = messageList.logOut();

        /**
         *
         * ACT AS ADMIN
         *
         */

        //Ввести логин и пароль  admin/password, нажать LoginPage
        messageList = loginPagePage.signIn(User.ADMIN);

        //Открыт список Message list
        messageList.assertPageIsOpened();

        //Salut, Admin!
        messageList.assertGreeting(User.ADMIN.getName());

        //Set the checkbox
        messageList.checkCheckBox();

        //Убедиться,что автор  - Админ
        messageList.assertMessageIsInList(userMessage, User.ADMIN.getName());

        //Убедиться,что автор  - Джон Доу
        messageList.assertMessageIsInList(userMessageJD, User.J_DOE.getName());

        //Remove checkbox
        messageList.uncheckCheckBox();

        //Убедиться,что автор  - Админ
        messageList.assertMessageIsInList(userMessage, User.ADMIN.getName());

        //Убедиться,что сообщения в таблице от Джонни нет
        messageList.assertMessageIsNotInList(userMessageJD);


        /* ------------------------------ Test for the same messages ------------------

        MainPage newMainPage = new MainPage();

        //Открыта главная страница
        newMainPage.assertMainPageIsOpened();

        //Перейти по ссылке qulixteachingsite.UserController
        //Открыта страница логина
        MessageList newMessageList = loginPagePage.signIn(User.ADMIN);

        //Открыт список Message list
        newMessageList.assertPageIsOpened();

        //Set the checkbox
        newMessageList.checkCheckBox();

        //Убедиться,что автор  - Админ
        newMessageList.assertMessageIsInList("Test","Test",User.ADMIN.getName());

        //Убедиться,что автор  - Джон Доу
        newMessageList.assertMessageIsInList("Test", "Test", User.J_DOE.getName());    */

    }
}
