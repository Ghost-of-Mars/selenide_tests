package uploadOrDownloadTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class UploadTests {

    @DisplayName("first test")
    @Tag("Blocker")
    @Test
    void uploadTest () {
        open("https://the-internet.herokuapp.com/upload");
        $("#file-upload").uploadFromClasspath("unmarked.txt");
        $("#uploaded-files").shouldHave(text("unmarked.txt"));
    }

}
