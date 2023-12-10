import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class Tests {


//    @Test
//    void openPage() {
//        open("https://github.com/");
//        // - Откройте страницу Selenide в GitHub
//        // - Перейдите в раздел Wiki проекта
//        $("button[data-target=\"qbsearch-input.inputButton\"]").click();
//        $("[name=\"query-builder-test\"]").setValue("selenide").pressEnter();
//        $$("div[data-testid=\"results-list\"] a").first().click();
//        $("a[id=\"wiki-tab\"]").click();
//        // - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
//        // - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
//        $("div[class=\"markdown-body\"] a[href=\"/selenide/selenide/wiki/SoftAssertions\"]").click();
//        $("div#wiki-body a[id=\"user-content-3-using-junit5-extend-test-class\"]")
//                .ancestor("h4")
//                .shouldHave(text("3. Using JUnit5 extend test class:"));
//        sleep(5000);
//    }

//    @Test
//    void openEnterprise() {
//        open("https://github.com/");
//        $(byText("Solutions")).hover();
//        $("ul[aria-labelledby=\"solutions-for-heading\"] a[href=\"/enterprise\"]").click();
//        $("#hero-section-brand-heading").shouldHave(exactTextCaseSensitive("The AI-powered developer platform."));
//    }

//    @Test
//    void dragAndDrop() {
//        open("https://the-internet.herokuapp.com/drag_and_drop");
//        actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(215, 0).release().perform();
//        $("#column-a header").shouldHave(text("B"));
//        $("#column-b header").shouldHave(text("A"));
//        sleep(2000);
//    }

    @Test
    void dragAndDropN2() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDrop(to($("#column-b")));
        $("#column-a header").shouldHave(text("B"));
        $("#column-b header").shouldHave(text("A"));
        //sleep(5000);
    }

    //some1111
    //   Запрограммируйте Drag&Drop с помощью Selenide.actions()
    // - Откройте https://the-internet.herokuapp.com/drag_and_drop
    // - Перенесите прямоугольник А на место В
    // - Проверьте, что прямоугольники действительно поменялись
    // - В Selenide есть команда $(element).dragAndDrop($(to-element)), проверьте работает ли тест, если использовать её вместо actions()

}