package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTest {

    @BeforeAll
    static void beforeAll() {

        Configuration.baseUrl = "https://demoqa.com"; //один раз прописали сайт, который будет повторяться
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successfulTest() {
        String name = "Ivan Ivanov";
        open("/text-box"); //открыли страницу сайта, указанного в начале
        executeJavaScript("$('footer').remove()"); // убираем футер
        executeJavaScript("$('fixedban').remove()"); // убираем рекламу внизу

        $("[id=userName]").setValue(name); //ввеоли значение в поле ввода
        $("[id=userEmail]").setValue("ivan@uv.yy");
        $("[id=currentAddress]").setValue("Ivanovo");
        $("[id=permanentAddress]").setValue("Saratov");

        $("[id=submit]").click(); //сабмитнули заполненную форму

        $("[id=output]").shouldHave(text(name), text("ivan@uv.yy"), text("Ivanovo"), text("Saratov"));



    }
}
