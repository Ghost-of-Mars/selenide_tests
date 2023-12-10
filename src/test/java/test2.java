import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class test2 {

    @BeforeAll
    static void BeforeAll() {
        Configuration.browserSize = "1920*1080";
        Configuration.pageLoadTimeout = 50000;
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void test() {
        open("/automation-practice-form");

        //Locators
        String firstName = "#firstName";
        String lastName = "#lastName";
        String userEmail = "#userEmail";
        String genderMale = "[value=Male]";
        String mobile = "#userNumber";
        String dateOfBirth = "#dateOfBirthInput";
        String selectMonth = "select.react-datepicker__month-select";
        String selectDate = "select.react-datepicker__year-select";
        String monthJan = "option[value='0']";
        String date = "option[value='2000']";
        String curDate = ".react-datepicker__day--weekend.react-datepicker__day--001";
        String subjects = "#subjectsContainer div.subjects-auto-complete__control";
        String subjectInput = "#subjectsInput";
        String hobbiesSports = "#hobbies-checkbox-1";
        String hobbiesReading = "#hobbies-checkbox-2";
        String hobbiesMusic = "#hobbies-checkbox-3";
        String picture = "#uploadPicture";
        String currentAddress = "#currentAddress";
        String state = "#state";
        String city = "#city";
        String submitButton = "#submit";
        String submitHeader = "#example-modal-sizes-title-lg";
        String submitBodyHeaderTwoTH = "div.table-responsive thead th";
        String submitBodyResuls20 = "div.table-responsive tbody td";

        //data
        String antony = "Antony";
        String button = "Button";
        String mail = "Button@mail.ru";
        String phone = "9108963214";
        String moscow = "Moscow";
        String stateNCR = "NCR";
        String cityDelhi = "Delhi";
        String english = "English"; //loc ?? id="react-select-2-option-0"

        //test
        $(firstName).setValue(antony);
        $(lastName).setValue(button);
        $(userEmail).setValue(mail);
        $(genderMale).ancestor("div").click();
        $(mobile).setValue(phone);
        $(dateOfBirth).click();
        $(selectMonth).click();
        $(monthJan).click();
        $(selectDate).click();
        $(date).click();
        $(curDate).click();
        $(subjects).click();
        $(subjectInput).setValue("e");
        $(byText(english)).click();
        $(hobbiesSports).ancestor("div").click();
        $(hobbiesReading).ancestor("div").click();
        $(hobbiesMusic).ancestor("div").click();
        $(picture).uploadFromClasspath("unmarked.txt");
        $(currentAddress).setValue(moscow);
        $(state).click();
        $(byText(stateNCR)).click();
        $(city).click();
        $(byText(cityDelhi)).click();
        //executeJavaScript("$('#fixedban').remove()"); почикать рекламу
        $(submitButton).click();

        //asserts
        $(submitHeader).shouldHave(text("Thanks for submitting the form"));
        $$(submitBodyHeaderTwoTH).get(0).shouldHave(text("Label"));
        $$(submitBodyHeaderTwoTH).get(1).shouldHave(text("Values"));

        $$(submitBodyResuls20).get(0).shouldHave(text("Student Name"));
        $$(submitBodyResuls20).get(1).shouldHave(text("Antony Button"));

        $$(submitBodyResuls20).get(2).shouldHave(text("Student Email"));
        $$(submitBodyResuls20).get(3).shouldHave(text("Button@mail.ru"));

        $$(submitBodyResuls20).get(4).shouldHave(text("Gender"));
        $$(submitBodyResuls20).get(5).shouldHave(text("Male"));

        $$(submitBodyResuls20).get(6).shouldHave(text("Mobile"));
        $$(submitBodyResuls20).get(7).shouldHave(text("9108963214"));

        $$(submitBodyResuls20).get(8).shouldHave(text("Date of Birth"));
        $$(submitBodyResuls20).get(9).shouldHave(text("01 January,2000"));

        $$(submitBodyResuls20).get(10).shouldHave(text("Subjects"));
        $$(submitBodyResuls20).get(11).shouldHave(text("English"));

        $$(submitBodyResuls20).get(12).shouldHave(text("Hobbies"));
        $$(submitBodyResuls20).get(13).shouldHave(text("Sports, Reading, Music"));

        $$(submitBodyResuls20).get(14).shouldHave(text("Picture"));
        $$(submitBodyResuls20).get(15).shouldHave(text("unmarked.txt"));

        $$(submitBodyResuls20).get(16).shouldHave(text("Address"));
        $$(submitBodyResuls20).get(17).shouldHave(text("Moscow"));

        $$(submitBodyResuls20).get(18).shouldHave(text("State and City"));
        $$(submitBodyResuls20).get(19).shouldHave(text("NCR Delhi"));
    }
}
