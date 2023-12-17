package parameterizedTests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.open;

public class FiveladMainPageTests {
    FiveladMainPage fiveladMainPage = new FiveladMainPage();

    @BeforeAll
    static void BeforeAll() {
        Configuration.browserSize = "1920*1080";
        Configuration.baseUrl = "https://www.5lad.ru/";
    }

    @Disabled("not now")
    @CsvSource({
            "akkordy/25-17/, 67",
            "akkordy/4-aprelya/, 53",
            "akkordy/5nizza/, 77"
    })
    @ParameterizedTest(name = "Проверка количества записей по исполнителю {0}")
    @Tags({@Tag("Blocker"), @Tag("UI")})
    void checkNumberOfRecordsByArtist(String url, int expectedNumberOfRecords) {
        fiveladMainPage.
                openUrlToAuthor(url).
                checkNumberOfRecordsByArtist(expectedNumberOfRecords);
    }

    @Disabled("not now")
    @ValueSource(
            strings = {"25/17", "4 апреля"}
    )
    @ParameterizedTest(name = "Проверка тайтла по артисту")
    @Tags({@Tag("Blocker"), @Tag("UI")})
    void chechArtistTitle(String authorName) {
        open("");
        fiveladMainPage.
                clickOnAuthor(authorName).
                checkTextInAuthorTitle(authorName);
    }

    static Stream<Arguments> checkSongTitles() {
        return Stream.of(
                Arguments.of("СтимфониЯ", List.of("Времени у нас нет", "Герда",
                                                            "Летящий", "Отражение", "Сказки")),
                Arguments.of("Грибы", List.of("Интро", "Любовь", "Нига, не гони", "Тает Лёд")));
    }

    @MethodSource
    @ParameterizedTest(name = "check song titles {0}")
    @Tags({@Tag("Blocker"), @Tag("UI")})
    void checkSongTitles(String authorName, List<String> songs) {
        open("");
        fiveladMainPage.
                clickOnAuthor(authorName).
                checkSongTitlesByArtist(songs);
    }

}
