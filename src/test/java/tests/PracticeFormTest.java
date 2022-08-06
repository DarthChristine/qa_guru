package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class PracticeFormTest {
    @BeforeAll
    static void beforeAll() {

        Configuration.baseUrl = "https://demoqa.com"; //один раз прописали сайт, который будет повторяться
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successfulTest() {
        open("/automation-practice-form"); //открыли страницу сайта, указанного в начале
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()"); // убираем футер
        executeJavaScript("$('#fixedban').remove()"); // убираем рекламу внизу

        $("[id=firstName]").setValue("Ivan"); //ввели значение в поле ввода
        $("[id=lastName]").setValue("Ivanov");
        $("[id=userEmail]").setValue("ivan@tt.tt");
        $("#genterWrapper").$(byText("Other")).click();
        $("[id=userNumber]").setValue("1234567890");

        //$("[class=react-datepicker-wrapper]").click(); //открыли календарь
        //Thread.sleep(1000); //ждем пока загрузится
        //$("[class=react-datepicker__year-select]").click(); //открыли поле с годами
        //$("[class=react-datepicker__year-select]").selectOptionByValue("2004"); //выбрали 2004
        //$("[class=react-datepicker__year-select]").click(); //закрыли поле с годами
        //$("[class=react-datepicker__month-select]").click(); //открыли поле с месяцами
        //$("[class=react-datepicker__month-select]").selectOptionByValue("4"); //выбрали май
        //$("[class=react-datepicker__month-select]").click(); //закрыли поле с месяцами
        //$(byText("11")).click(); //выбрала дату

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();

        //$("[id=subjectsContainer]").click(); //кликнули по полю для его активации
        //$("[id=subjectsInput]").setValue("e"); //ввели букву
        //$(byText("English")).click(); //выбрали значение из открывшегося списка

        $("#subjectsInput").sendKeys("Maths");
        $("#subjectsInput").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();

        //$(byText("Reading")).click(); //выбрали чекбокс

        $("[id=uploadPicture]").sendKeys("C:\\Users\\Christina\\IdeaProjects\\qa_guru\\src\\test\\java\\resources\\neoncat.png"); //загрузка файла

        $("[id=currentAddress]").setValue("Address");

        $("[id=state]").click(); //открыли дропдаун
        $("#stateCity-wrapper").$(byText("NCR")).click(); //выбрали значение из дропдауна

        $("[id=city]").click(); //открыли дропдаун
        $("#stateCity-wrapper").$(byText("Delhi")).click(); //выбрали значение из дропдауна


        $("[id=submit]").click(); //сабмитнули заполненную форму

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $("[class=table-responsive]").shouldHave(
            text("Ivan Ivanov"), text("ivan@tt.tt"), text("Male"), text("1234567890"),
            text("11 May,2004"), text("English"), text("Reading"), text("Address"), text("NCR Delhi")); //проверка



    }
}

