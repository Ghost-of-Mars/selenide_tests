package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.Calendar;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private Calendar calendar = new Calendar();
    private SelenideElement
            firstName = $("#firstName"),
            lastName = $("#lastName"),
            userEmail = $("#userEmail"),
            gender = $("#genterWrapper"),
            mobile = $("#userNumber"),
            dateOfBirth = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbies = $("#hobbiesWrapper"),
            hobbiesSports = $("#hobbies-checkbox-1"),
            hobbiesReading = $("#hobbies-checkbox-2"),
            hobbiesMusic = $("#hobbies-checkbox-3"),
            picture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            state = $("#state"),
            city = $("#city"),
            submitButton = $("#submit");


    public RegistrationPage openRegistrationPage () {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstName.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastName.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmail.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        gender.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setMobile(String value) {
        mobile.setValue(value);
        return this;
    }

    public RegistrationPage setBirthDate(String year, String month, String day) {
        dateOfBirth.click();
        calendar.setDate(year, month, day);
        return this;
    }

    public RegistrationPage setSubjects(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbies.$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        picture.uploadFromClasspath(value);//unmarked.txt
        return this;
    }

    public RegistrationPage setAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        state.click();
        $(byText(value)).click();
        return this;
    }

    public RegistrationPage setCity(String value) {
        city.click();
        $(byText(value)).click();
        return this;
    }

    public RegistrationPage clickSubmit() {
        submitButton.click();
        return this;
    }

    //executeJavaScript("$('#fixedban').remove()"); почикать рекламу

}
