package com.qulix.ft.teachingSite.tests;

import com.qulix.ft.teachingSite.User;
import com.qulix.ft.teachingSite.pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


/***
 * Сценарий 2
 */
public class Test2  extends AbstractTest{
    @Test(description = "Сценарий 2. Create and View message")
    @Parameters({"HeadlineValue", "TextValue"})
    public void Test(String headline, String text){

        MainPage mainPage = new MainPage(driver);

       //Открыта главная страница
        mainPage.assertMainPageIsOpened();

        //Перейти по ссылке qulixteachingsite.UserController
        //Открыта страница логина
        Login loginPage = mainPage.goToUserController();
        loginPage.assertLoginPageIsOpened();

        //Ввести логин и пароль  admin/password, нажать Login
        MessageList messageList = loginPage.signIn(User.ADMIN);

        //Открыт список Message list
        messageList.assertPageIsOpened();

         //Нажать New Message
        Message createNewMessagePage = messageList.createNewMessage();

        //Открыта форма создания Create message
        createNewMessagePage.assertCreateMessagePageIsOpened();

        //Заполнить поля Headline и Text
        //Нажать Create
        ShowMessage showMessage = createNewMessagePage.createMessage(headline, text);

        //Открыта страница Show message
        showMessage.assertPageIsOpened();

        //Нажать кнопку Message list
        messageList = showMessage.showMessageList();

        //Отображен список.
        messageList.assertPageIsOpened();

        //В списке содержится созданный объект, в колонках Headline и  Text отображены значения, введенные на шаге 4
        messageList.assertMessageIsInList(headline, text);

        //Нажать View для созданного ранее сообщения
        showMessage = messageList.viewMessage(headline, text);

        //Открыта страница Show message
        showMessage.assertPageIsOpened();

        //Проверить форма содержит такое же сообщение
        showMessage.assertMessageIsCorrect(headline,text);

        //Нажать кнопку Message list
        messageList = showMessage.showMessageList();

        //Отображен список.
        messageList.assertPageIsOpened();

        //В списке содержится созданный объект, в колонках Headline и  Text отображены значения, введенные на шаге 4
        messageList.assertMessageIsInList(headline, text);

    }
}
