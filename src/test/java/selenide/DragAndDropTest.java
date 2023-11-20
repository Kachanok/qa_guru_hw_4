package selenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @AfterEach
    void afterEach() {
        closeWebDriver();
    }

    @Test
    void relocateFigureActions() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        actions().clickAndHold($("#column-a")).moveToElement($("#column-b")).release().perform();
        $("#column-b").shouldHave(text("A"));
    }

    @Test
    void relocateFigureDragAndDrop() {
        $("#column-a").dragAndDropTo("#column-b");
        $("#column-b").shouldHave(text("B"));

    }
}

