package com.qulix.ft.teachingSite.tests;

import com.qulix.ft.teachingSite.User;
import com.qulix.ft.teachingSite.pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


/**
 * Сценарий 2
 */
public class Test6 extends AbstractTest {
    @Test(description = "Сценарий 6. Create 2 messages")
    @Parameters({"HeadlineValue", "TextValue", "HeadlineValue_2", "TextValue_2"})
    public void Test(String headline, String text, String headline_2, String text_2) {

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

        //Нажать New Message
        Message createNewMessage = showMessagePage.createNewMessage();

        //Открыта форма создания Create message
        createNewMessage.assertCreateMessagePageIsOpened();

        //Заполнить поля Headline и Text
        showMessagePage = createNewMessage.createMessage(headline_2, text_2);

        //Открыта страница Show message
        showMessagePage.assertPageIsOpened();

        //Чекнуть, что сообщение правильное
        showMessagePage.assertMessageIsCorrect(headline_2, text_2);

        //Нажать Message List
        messageList = showMessagePage.showMessageList();

        //Отображен список.
        messageList.assertPageIsOpened();

        //В списке содержится созданный объект, в колонках Headline и  Text отображены значения, введенные на шаге 4
        messageList.assertMessageIsInList(headline, text);

        //В списке содержится созданный объект, в колонках Headline и  Text отображены значения, введенные на шаге 8
        messageList.assertMessageIsInList(headline_2, text_2);
    }
}
