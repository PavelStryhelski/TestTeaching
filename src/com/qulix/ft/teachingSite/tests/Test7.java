package com.qulix.ft.teachingSite.tests;

import com.qulix.ft.teachingSite.User;
import com.qulix.ft.teachingSite.pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


/**
 * Сценарий 2
 */
public class Test7 extends AbstractTest {
    @Test(description = "Сценарий 7. Check another user`s messages")
    @Parameters({"HeadlineValue", "TextValue", "HeadlineValueJD", "TextValueJD"})
    public void Test(String headline, String text, String headline_jd, String text_jd) {


        MainPage mainPage = new MainPage();

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
        ShowMessagePage showMessagePage = createNewMessagePage.createMessage(headline, text);

        //Открыта страница Show message
        showMessagePage.assertPageIsOpened();

        //Чекнуть, что сообщение правильное
        showMessagePage.assertMessageIsCorrect(headline, text);

        //перейти на страницу Message List
        messageList = showMessagePage.showMessageList();

        //Открыт список Message list
        messageList.assertPageIsOpened();

        //Убедиться,что сообщение есть в таблице
        messageList.assertMessageIsInList(headline, text);

        //Кликнуть созданное сообщение на View
        showMessagePage = messageList.viewMessage(headline, text);

        //Убедиться,что открылась страница Show Message
        showMessagePage.assertPageIsOpened();

        //Проверить,что сообщение четенькое
        showMessagePage.assertMessageIsCorrect(headline, text);

        //перейти на страницу Message List
        messageList = showMessagePage.showMessageList();

        //Открыт список Message list
        messageList.assertPageIsOpened();

        //Убедиться,что сообщение есть в таблице
        messageList.assertMessageIsInList(headline, text);

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
        showMessagePage = createNewMessagePage.createMessage(headline_jd, text_jd);

        //Открыта страница Show message
        showMessagePage.assertPageIsOpened();

        //Чекнуть, что сообщение правильное
        showMessagePage.assertMessageIsCorrect(headline_jd, text_jd);

        //перейти на страницу Message List
        messageList = showMessagePage.showMessageList();

        //Открыт список Message list
        messageList.assertPageIsOpened();

        //Set the checkbox
        messageList.checkCheckBox();

        //Убедиться,что сообщение есть в таблице
        messageList.assertMessageIsInList(headline_jd, text_jd);

        //Кликнуть созданное сообщение на View
        showMessagePage = messageList.viewMessage(headline_jd, text_jd);

        //Убедиться,что открылась страница Show Message
        showMessagePage.assertPageIsOpened();

        //Проверить,что сообщение четенькое
        showMessagePage.assertMessageIsCorrect(headline_jd, text_jd);

        //перейти на страницу Message List
        messageList = showMessagePage.showMessageList();

        //Открыт список Message list
        messageList.assertPageIsOpened();

        //Убедиться,что сообщение есть в таблице
        messageList.assertMessageIsInList(headline_jd, text_jd);

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
        messageList.assertMessageIsInList(headline, text, User.ADMIN.getName());

        //Убедиться,что автор  - Джон Доу
        messageList.assertMessageIsInList(headline_jd, text_jd, User.J_DOE.getName());

        //Remove checkbox
        messageList.uncheckCheckBox();

        //Убедиться,что автор  - Админ
        messageList.assertMessageIsInList(headline, text, User.ADMIN.getName());

        //Убедиться,что сообщения в таблице от Джонни нет
        messageList.assertMessageIsNotInList(headline_jd, text_jd);


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
