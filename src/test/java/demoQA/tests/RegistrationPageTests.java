package demoQA.tests;

import org.junit.jupiter.api.*;


public class RegistrationPageTests extends TestBase {

    @BeforeEach
    void beforeEach() {
        System.out.println("Start");
    }
    @AfterEach
    void afterEach() {
        System.out.println("End");
    }

    @Tag("Blocker")
    @DisplayName("Проверка регистрации нового юзера с заполнением всех полей")
    @Test
    void test() {

        //test data
        String firstName = "Antony";
        String lastName = "Button";
        String mail = "Button@mail.ru";
        String phone = "9108963214";
        String moscow = "Moscow";
        String stateNCR = "NCR";
        String cityDelhi = "Delhi";
        String english = "English";
        String maleGender = "Male";
        String sportsHobbies = "Sports";


        //test

        registrationPage.openRegistrationPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(mail)
                .setGender(maleGender)
                .setMobile(phone)
                .setBirthDate("2000", "December", "15")
                .setSubjects(english)
                .setHobbies(sportsHobbies)
                .uploadPicture("unmarked.txt")
                .setAddress(moscow)
                .setState(stateNCR)
                .setCity(cityDelhi)
                .clickSubmit();

        submittingForm.verifyModalAppears()
                .verifyResult("Label", "Values")
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", mail)
                .verifyResult("Gender", maleGender)
                .verifyResult("Mobile", phone)
                .verifyResult("Date of Birth", "15 December,2000")
                .verifyResult("Subjects", english)
                .verifyResult("Hobbies", sportsHobbies)
                .verifyResult("Picture", "unmarked.txt")
                .verifyResult("Address", moscow)
                .verifyResult("State and City", stateNCR + " " + cityDelhi);
    }
}
