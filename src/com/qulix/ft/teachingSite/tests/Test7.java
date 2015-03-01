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
    @Parameters({"Login", "Password", "HeadlineValue", "TextValue", "LoginJD", "PasswordJD", "UserNameJD", "HeadlineValueJD", "TextValueJD", "UserNameAdmin"})
    public void Test(User user_admin, String headline, String text, User user_jd, String jd_name, String headline_jd, String text_jd, String admin_name) {

        //Открыта главная страница
        MainPage.assertMainPageIsOpened();

        //Перейти по ссылке qulixteachingsite.UserController
        //Открыта страница логина
        MainPage.clickUserController();

        //Ввести логин и пароль  admin/password, нажать Login
        Login.signIn(user_admin);

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
        ShowMessage.assertMessageIsCorrect(headline, text);

        //перейти на страницу Message List
        ShowMessage.showMessageList();

        //Открыт список Message list
        MessageList.assertPageIsOpened();

        //Убедиться,что сообщение есть в таблице
        MessageList.assertMessageIsInList(headline, text);

        //Кликнуть созданное сообщение на View
        MessageList.clickViewButton(headline, text);

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
        Login.signIn(user_jd);

        //Salut, Johny!
        MessageList.assertGreeting(jd_name);

        //Открыт список Message list
        MessageList.assertPageIsOpened();

        //Нажать New Message
        MessageList.goToNewMessage();

        //Открыта форма создания Create message
        CreateMessage.assertPageIsOpened();

        //Заполнить поля Headline и Text
        CreateMessage.createMessage(headline_jd, text_jd);

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
        MessageList.clickViewButton(headline_jd, text_jd);

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
        Login.signIn(user_admin);

        //Salut, Admin!
        MessageList.assertGreeting(admin_name);

        //Открыт список Message list
        MessageList.assertPageIsOpened();

        //Set the checkbox
        MessageList.checkCheckBox();

        //Убедиться,что сообщение есть в таблице от Админа
        MessageList.assertMessageIsInList(headline, text);

        //Убедиться,что автор  - Админ
        MessageList.assertMessageIsInList(headline, text, admin_name);

        //Убедиться,что сообщение есть в таблице от Джонни
        MessageList.assertMessageIsInList(headline_jd, text_jd);

        //Убедиться,что автор  - Джон Доу
        MessageList.assertMessageIsInList(headline_jd, text_jd, jd_name);

        //Remove checkbox
        MessageList.uncheckCheckBox();

        //Убедиться,что сообщение есть в таблице от Админа
        MessageList.assertMessageIsInList(headline, text);

        //Убедиться,что автор  - Админ
        MessageList.assertMessageIsInList(headline, text, admin_name);

        //Убедиться,что сообщения в таблице от Джонни нет
        MessageList.assertMessageIsNotInList(headline_jd, text_jd);


        /* ------------------------------ Test for the same messages ------------------

        //Открыта главная страница
        MainPage.assertMainPageIsOpened();

        //Перейти по ссылке qulixteachingsite.UserController
        //Открыта страница логина
        MainPage.clickUserController();

        //Ввести логин и пароль  admin/password, нажать Login
        Login.signIn(login, password);

        //Открыт список Message list
        MessageList.assertPageIsOpened();

        //Set the checkbox
        MessageList.checkCheckBox();

        //Убедиться,что автор  - Админ
        MessageList.assertMessageIsInList("Test","Test",admin_name);

        //Убедиться,что автор  - Джон Доу
        MessageList.assertMessageIsInList("Test","Test",jd_name);   */

    }
}
