package com.qulix.ft.teachingSite.tests;

import com.qulix.ft.teachingSite.User;
import com.qulix.ft.teachingSite.UserMessage;
import com.qulix.ft.teachingSite.pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


/**
 * Сценарий 2
 */
public class Test3 extends AbstractTest {
    @Test(description = "Сценарий 3. Create and Edit message")
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

        //Нажать кнопку Message list
        messageList = showMessagePage.showMessageList();

        //Отображен список.
        messageList.assertPageIsOpened();

        //В списке содержится созданный объект, в колонках Headline и  Text отображены значения, введенные на шаге 4
        messageList.assertMessageIsInList(userMessage);

        //Отредактировать данное сообщение
        Message editMessagePage = messageList.editMessage(userMessage);

        //Открыта страница Edit message
        editMessagePage.assertEditPageIsOpened();

        //Проверить что содержится данное сообщение
        editMessagePage.assertMessageIsCorrect(userMessage);

        //Установить новые значения в поля Headline и Text
        UserMessage userMessageNew = new UserMessage();
        editMessagePage.setNewValuesForHeadlineAndText(userMessageNew);

        //Сохранить данные
        showMessagePage = editMessagePage.saveMessage();

        //Открыта страница Show message
        showMessagePage.assertPageIsOpened();

        //Проверить форма содержит такое же сообщение
        showMessagePage.assertMessageIsCorrect(userMessageNew);

        //Нажать кнопку Message list
        messageList = showMessagePage.showMessageList();

        //Отображен список.
        messageList.assertPageIsOpened();

        //В списке содержится созданный объект, в колонках Headline и  Text отображены новые значения
        messageList.assertMessageIsInList(userMessageNew);
    }
}
