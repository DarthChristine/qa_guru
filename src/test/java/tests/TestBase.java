package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.PracticeFormPage;

public class TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage(); //чтобы не писать перед каждой командой new PracticeFormPage().openPage


    @BeforeAll
    static void beforeAll() {

        Configuration.baseUrl = "https://demoqa.com"; //один раз прописали сайт, который будет повторяться
        Configuration.browserSize = "1920x1080";
    }
}
