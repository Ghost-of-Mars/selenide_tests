package demoQA.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SubmittingForm {
    SelenideElement
            modalDialog = $(".modal-dialog"),
            submitHeader = $("#example-modal-sizes-title-lg"),
            table = $(".table-responsive");

    public SubmittingForm verifyModalAppears() {
        modalDialog.should(appear);
        submitHeader.shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    public SubmittingForm verifyResult(String key, String value) {
        $(table).$(byText(key)).parent()
                .shouldHave(text(value));
        return this;
    }
}
