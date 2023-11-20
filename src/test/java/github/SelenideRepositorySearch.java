package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SelenideRepositorySearch {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com/"; // открыть главную страницу
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
        Configuration.timeout = 5000; // default 4000
    }


    @Test
    void shouldFindSelenideRepository() {

        open("selenide/selenide");
        //перейти в раздел wiki проекта

        $("#wiki-tab").click();

        //убедиться, что в списке страниц (Pages) есть страница SoftAssertions

        $("#wiki-pages-filter").setValue("SoftAssertions").pressEnter();

        //открыть страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5

        $("[href='/selenide/selenide/wiki/SoftAssertions']").click();
        $("#js-repo-pjax-container").shouldHave(text("""
                @ExtendWith({SoftAssertsExtension.class})
                class Tests {
                  @Test
                  void test() {
                    Configuration.assertionMode = SOFT;
                    open("page.html");

                    $("#first").should(visible).click();
                    $("#second").should(visible).click();
                  }
                }"""));



        


    }
}
