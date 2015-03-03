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
        Message.createMessage(headline, text);

        //Открыта страница Show message
        ShowMessage.assertPageIsOpened();

        //Чекнуть, что сообщение правильное
        ShowMessage.assertMessageIsCorrect(headline, text);

        //перейти на страницу Message List
        ShowMessage.showMessageList();

        //Открыт список Message list
        MessageList.assertPageIsOpened();

        //Убедиться,что сообщение есть в таблице
        MessageList.assertMessageIsInList(headline, text);

        //Кликнуть созданное сообщение на View
        MessageList.viewMessage(headline, text);

        //Убедиться,что открылась страница Show Message
        ShowMessage.assertPageIsOpened();

        //Проверить,что сообщение четенькое
        ShowMessage.assertMessageIsCorrect(headline, text);

        //перейти на страницу Message List
        ShowMessage.showMessageList();

        //Открыт список Message list
        MessageList.assertPageIsOpened();

        //Убедиться,что сообщение есть в таблице
        MessageList.assertMessageIsInList(headline, text);

        //Log out
        MessageList.logOut();

        //Открыта главная страница
        Login.assertLoginPageIsOpened();

        /**
         *
         * ACT AS JOHN DOE
         *
         */

        //Ввести логин и пароль  admin/password, нажать Login
        Login.signIn(User.J_DOE);

        //Salut, Johny!
        MessageList.assertGreeting(User.J_DOE.getName());

        //Открыт список Message list
        MessageList.assertPageIsOpened();

        //Нажать New Message
        MessageList.createNewMessage();

        //Открыта форма создания Create message
        Message.assertCreateMessagePageIsOpened();

        //Заполнить поля Headline и Text
        Message.createMessage(headline_jd, text_jd);

        //Открыта страница Show message
        ShowMessage.assertPageIsOpened();

        //Чекнуть, что сообщение правильное
        ShowMessage.assertMessageIsCorrect(headline_jd, text_jd);

        //перейти на страницу Message List
        ShowMessage.showMessageList();

        //Открыт список Message list
        MessageList.assertPageIsOpened();

        //Set the checkbox
        MessageList.checkCheckBox();

        //Убедиться,что сообщение есть в таблице
        MessageList.assertMessageIsInList(headline_jd, text_jd);

        //Кликнуть созданное сообщение на View
        MessageList.viewMessage(headline_jd, text_jd);

        //Убедиться,что открылась страница Show Message
        ShowMessage.assertPageIsOpened();

        //Проверить,что сообщение четенькое
        ShowMessage.assertMessageIsCorrect(headline_jd, text_jd);

        //перейти на страницу Message List
        ShowMessage.showMessageList();

        //Открыт список Message list
        MessageList.assertPageIsOpened();

        //Убедиться,что сообщение есть в таблице
        MessageList.assertMessageIsInList(headline_jd, text_jd);

        //Remove checkbox
        MessageList.uncheckCheckBox();

        //Log out
        MessageList.logOut();

        /**
         *
         * ACT AS ADMIN
         *
         */

        //Ввести логин и пароль  admin/password, нажать Login
        Login.signIn(User.ADMIN);

        //Salut, Admin!
        MessageList.assertGreeting(User.ADMIN.getName());

        //Открыт список Message list
        MessageList.assertPageIsOpened();

        //Set the checkbox
        MessageList.checkCheckBox();

        //Убедиться,что автор  - Админ
        MessageList.assertMessageIsInList(headline, text, User.ADMIN.getName());

        //Убедиться,что автор  - Джон Доу
        MessageList.assertMessageIsInList(headline_jd, text_jd, User.J_DOE.getName());

        //Remove checkbox
        MessageList.uncheckCheckBox();

        //Убедиться,что автор  - Админ
        MessageList.assertMessageIsInList(headline, text, User.ADMIN.getName());

        //Убедиться,что сообщения в таблице от Джонни нет
        MessageList.assertMessageIsNotInList(headline_jd, text_jd);


        /* ------------------------------ Test for the same messages ------------------  */

        //Открыта главная страница
        MainPage.assertMainPageIsOpened();

        //Перейти по ссылке qulixteachingsite.UserController
        //Открыта страница логина
        MainPage.goToUserController();

        //Ввести логин и пароль  admin/password, нажать Login
        Login.signIn(User.ADMIN);

        //Открыт список Message list
        MessageList.assertPageIsOpened();

        //Set the checkbox
        MessageList.checkCheckBox();

        //Убедиться,что автор  - Админ
        MessageList.assertMessageIsInList("Test","Test",User.ADMIN.getName());

        //Убедиться,что автор  - Джон Доу
        MessageList.assertMessageIsInList("Test", "Test", User.J_DOE.getName());

    }
}
