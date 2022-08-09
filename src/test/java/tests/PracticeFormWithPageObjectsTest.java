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

