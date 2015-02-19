package com.qulix.ft.teachingSite.tests;

import com.qulix.ft.teachingSite.pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


/**
 * Сценарий 2
 */
public class Test3 extends AbstractTest {
    @Test(description = "Сценарий 3. Create and Edit message")
    @Parameters({"Login", "Password", "HeadlineValue", "TextValue", "NewHeadlineValue", "NewTextValue"})
    public void Test(String login, String password, String headline, String text, String headlineNew, String textNew) {

        //Открыта главная страница
        MainPage.assertMainPageIsOpened();

        //Перейти по ссылке qulixteachingsite.UserController
        //Открыта страница логина
        MainPage.clickMessageController();

        //Ввести логин и пароль  admin/password, нажать Login
        Login.signIn(login, password);

        //Открыт список Message list
        MessageList.assertPageIsOpened();

      /*   //Нажать New Message
        MessageList.clickNewMessage();

        //Открыта форма создания Create message
        CreateMessage.assertPageIsOpened();

        //Заполнить поля Headline и Text
        //Нажать Create
        CreateMessage.createMessage(headline, text);

        //Открыта страница Show message
        ShowMessage.assertPageIsOpened();

        //Нажать кнопку Message list
        ShowMessage.clickMessageList();

        //Отображен список.
        MessageList.assertPageIsOpened();  */

        //В списке содержится созданный объект, в колонках Headline и  Text отображены значения, введенные на шаге 4
        MessageList.assertMessageIsInList(headline, text);

        //Отредактировать данное сообщение
        MessageList.clickEditButton(headline, text);

        //Открыта страница Edit message
        EditPage.assertPageIsOpened();

        //Проверить что содержится данное сообщение
        EditPage.assertMessageIsCorrect(headline, text);

        //Установить новые значения в поля Headline и Text
        EditPage.setNewValuesForHeadlineAndText(headlineNew, textNew);

        //Сохранить данные
        EditPage.save();

        //Открыта страница Show message
        ShowMessage.assertPageIsOpened();

        //Проверить форма содержит такое же сообщение
        ShowMessage.assertMessageIsCorrect(headlineNew, textNew);

        //Нажать кнопку Message list
        ShowMessage.clickMessageList();

        //Отображен список.
        MessageList.assertPageIsOpened();

        //В списке содержится созданный объект, в колонках Headline и  Text отображены новые значения
        MessageList.assertMessageIsInList(headlineNew, textNew);
    }
}
