package com.qulix.ft.teachingSite.tests;

import com.qulix.ft.teachingSite.User;
import com.qulix.ft.teachingSite.pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


/**
 * Сценарий 2
 */
public class Test3 extends AbstractTest {
    @Test(description = "Сценарий 3. Create and Edit message")
    @Parameters({"HeadlineValue", "TextValue", "NewHeadlineValue", "NewTextValue"})
    public void Test(String headline, String text, String headlineNew, String textNew) {


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

        //Нажать кнопку Message list
        messageList = showMessagePage.showMessageList();

        //Отображен список.
        messageList.assertPageIsOpened();

        //В списке содержится созданный объект, в колонках Headline и  Text отображены значения, введенные на шаге 4
        messageList.assertMessageIsInList(headline, text);

        //Отредактировать данное сообщение
        Message editMessagePage = messageList.editMessage(headline, text);

        //Открыта страница Edit message
        editMessagePage.assertEditPageIsOpened();

        //Проверить что содержится данное сообщение
        editMessagePage.assertMessageIsCorrect(headline, text);

        //Установить новые значения в поля Headline и Text
        editMessagePage.setNewValuesForHeadlineAndText(headlineNew, textNew);

        //Сохранить данные
        showMessagePage = editMessagePage.saveMessage();

        //Открыта страница Show message
        showMessagePage.assertPageIsOpened();

        //Проверить форма содержит такое же сообщение
        showMessagePage.assertMessageIsCorrect(headlineNew, textNew);

        //Нажать кнопку Message list
        messageList = showMessagePage.showMessageList();

        //Отображен список.
        messageList.assertPageIsOpened();

        //В списке содержится созданный объект, в колонках Headline и  Text отображены новые значения
        messageList.assertMessageIsInList(headlineNew, textNew);
    }
}
