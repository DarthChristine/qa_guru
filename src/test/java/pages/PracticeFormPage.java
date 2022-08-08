package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalenderComponent;
import pages.components.ResultsTableComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PracticeFormPage {

    public CalenderComponent calenderComponent = new CalenderComponent();
    public ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    SelenideElement firstNameInput = $("#firstName"), //выносим локаторы отдельно
                    lastNameInput = $("#lastName");

    public PracticeFormPage openPage() { //вызвали метод с типом PracticeFormPage
        open("/automation-practice-form"); //открыли страницу сайта, указанного в начале
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()"); // убираем футер
        executeJavaScript("$('#fixedban').remove()"); // убираем рекламу внизу

        return this; //метод возвращает сам себя, теперь после него можем в тесте ставить точку и вызывать другие команды
    }

    //метод позволит вместо команды с вставкой имени в автотесте использовать его
//    public void setFirstName(String value) {
//        $("#firstName").setValue(value);
//    }

    public PracticeFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    public PracticeFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public PracticeFormPage setEmail(String value) {
        $("#userEmail").setValue(value);
        return this;
    }

    public PracticeFormPage setGender(String value) {
        $("#genterWrapper").$(byText("Male")).click();
        return this;
    }

    public PracticeFormPage setNumber(String value) {
        $("#userNumber").setValue("1234567890");
        return this;
    }

    public PracticeFormPage setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calenderComponent.setDate(day, month, year);
        return this;
    }

    public PracticeFormPage setDateOfBirthWithKeys(String day, String month, String year) {
        $("#dateOfBirthInput").sendKeys(day + " " + month + " " + year);

        return this;
    }

    public PracticeFormPage checkResult(String key, String value) {
        resultsTableComponent.checkResult(key, value);
        return this;
    }

    public PracticeFormPage clearFirstName() { //если нужно очистить поле
        firstNameInput.clear();
        return this;
    }

    public PracticeFormPage setFullName(String firstName, String lastName) { //сразу вводим значения в два поля
        firstNameInput.setValue(firstName);
        lastNameInput.setValue(lastName);
        return this;
    }

    public PracticeFormPage setSubjects(String value) {
        $("#subjectsInput").sendKeys(value);
        $("#subjectsInput").pressEnter();
        return this;
    }

    public PracticeFormPage setHobbies(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();
        return this;
    }

    public PracticeFormPage uploadPicture() {
        $("#uploadPicture").uploadFile(new File("src/test/java/resources/img/1.png"));
        return this;
    }

    public PracticeFormPage setAddress(String value) {
        $("#currentAddress").setValue(value);
        return this;
    }

    public PracticeFormPage setState() {
        $("#state").click(); //открыли дропдаун
        $("#stateCity-wrapper").$(byText("NCR")).click(); //выбрали значение из дропдауна
        return this;
    }

    public PracticeFormPage setCity() {
        $("#city").click(); //открыли дропдаун
        $("#stateCity-wrapper").$(byText("Delhi")).click(); //выбрали значение из дропдауна
        return this;
    }

    public PracticeFormPage clickSubmit() {
        $("#submit").click(); //сабмитнули заполненную форму
        return this;
    }

    public PracticeFormPage checkHeader() {
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form")); //проверка
        return this;
    }

}
