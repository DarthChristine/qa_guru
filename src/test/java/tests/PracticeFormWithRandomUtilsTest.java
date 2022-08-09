package tests;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static utils.RandomUtils.getRandomEmail;
import static utils.RandomUtils.getRandomString;

public class PracticeFormWithRandomUtilsTest extends TestBase {

// move to TestData
    String firstName = getRandomString(5);
    String lastName = getRandomString(10);
    String email = getRandomEmail();

    @Test
    void successfulTest() {

        open("/automation-practice-form"); //открыли страницу сайта, указанного в начале
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()"); // убираем футер
        executeJavaScript("$('#fixedban').remove()"); // убираем рекламу внизу

        $("#firstName").setValue(firstName); //ввели значение в поле ввода
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1234567890");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();

        $("#subjectsInput").sendKeys("English");
        $("#subjectsInput").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();

        $("#uploadPicture").uploadFile(new File("src/test/java/resources/img/1.png"));

        $("#currentAddress").setValue("Address");

        $("#state").click(); //открыли дропдаун
        $("#stateCity-wrapper").$(byText("NCR")).click(); //выбрали значение из дропдауна

        $("#city").click(); //открыли дропдаун
        $("#stateCity-wrapper").$(byText("Delhi")).click(); //выбрали значение из дропдауна

        $("#submit").click(); //сабмитнули заполненную форму

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form")); //проверка
        $(".table-responsive").shouldHave(
                text(firstName + " " + lastName), text(email), text("Male"), text("1234567890"),
                text("30 July,2008"), text("English"), text("Reading"), text("Address"), text("NCR Delhi"));

    }
}

