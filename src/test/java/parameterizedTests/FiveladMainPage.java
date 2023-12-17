package parameterizedTests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FiveladMainPage {
    ElementsCollection elementsWithLevel2Class = $$(".level2");
    SelenideElement authorTitle = $("h1 [itemprop=\"name\"]");

    public FiveladMainPage openUrlToAuthor (String urlToAuthor) {
        open(urlToAuthor);
        return this;

    }

    public FiveladMainPage checkNumberOfRecordsByArtist (int expectedNumberOfRecords) {
        elementsWithLevel2Class.shouldHave(size(expectedNumberOfRecords));
        return this;
    }

    public FiveladMainPage checkSongTitlesByArtist (List<String> expectedSongTitles) {
        elementsWithLevel2Class.shouldHave(texts(expectedSongTitles));
        return this;
    }

    public FiveladMainPage clickOnAuthor (String authorName) {
        $(byText(authorName)).click();
        return this;
    }

    public FiveladMainPage checkTextInAuthorTitle (String authorName) {
        authorTitle.shouldHave(text(authorName + " - аккорды и тексты песен"));
        return this;
    }
}
