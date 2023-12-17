package demoQA.tests;

import com.codeborne.selenide.Configuration;
import demoQA.pages.RegistrationPage;
import demoQA.pages.SubmittingForm;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    SubmittingForm submittingForm = new SubmittingForm();

    @BeforeAll
    static void BeforeAll() {
        Configuration.browserSize = "1920*1080";
        Configuration.pageLoadTimeout = 50000;
        Configuration.baseUrl = "https://demoqa.com";
    }

}
