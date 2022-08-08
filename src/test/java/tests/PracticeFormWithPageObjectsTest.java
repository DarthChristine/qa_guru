package tests;

import org.junit.jupiter.api.Test;

public class PracticeFormWithPageObjectsTest extends TestBase {

    @Test
    void successfulTest() {
        String firstName = "Ivan";
        String lastName = "Ivanov";

        practiceFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail("ivan@tt.tt")
                .setGender("Male")
                .setNumber("1234567890")
                .setDateOfBirth("30", "July", "2008")
                .setSubjects("English")
                .setHobbies("Reading")
                .uploadPicture()
                .setAddress("Address")
                .setState()
                .setCity()
                .clickSubmit();

//        practiceFormPage.setFirstName(firstName); //вместо этих строк сделали все методы с return и под один вызов
//        practiceFormPage.setLastName(lastName);
//        practiceFormPage.setEmail("ivan@tt.tt");
//          practiceFormPage.setGender("Male");
//        $("#userNumber").setValue("1234567890");
//        practiceFormPage.setDateOfBirthWithKeys("30", "July", "2008");  //можно так дату задать
//        $("#subjectsInput").sendKeys("English");
//        $("#subjectsInput").pressEnter();
//        $("#hobbiesWrapper").$(byText("Reading")).click();
//        $("#uploadPicture").uploadFile(new File("src/test/java/resources/img/1.png"));
//        $("#currentAddress").setValue("Address");
//        $("#state").click(); //открыли дропдаун
//        $("#stateCity-wrapper").$(byText("NCR")).click(); //выбрали значение из дропдауна
//        $("#city").click(); //открыли дропдаун
//        $("#stateCity-wrapper").$(byText("Delhi")).click(); //выбрали значение из дропдауна
//        $("#submit").click(); //сабмитнули заполненную форму
//        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form")); //проверка

        practiceFormPage
                .checkHeader()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", "ivan@tt.tt")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "30 July,2008")
                .checkResult("Subjects", "English")
                .checkResult("Hobbies", "Reading")
                .checkResult("Address", "Address")
                .checkResult("State and City", "NCR Delhi");

        }
}

