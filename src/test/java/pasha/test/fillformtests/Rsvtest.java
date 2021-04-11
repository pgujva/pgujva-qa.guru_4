package pasha.test.fillformtests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.conditions.Text;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Rsvtest {
  @Test
  public void testsearch() {
    String webinar = "Вебинар";
    SelenideLogger.addListener("allure", new AllureSelenide());
    Configuration.startMaximized = true;
    open("https://rsv-test.bizml.ru/");
    $(".search-button").click();
    $(".searching-input").clear();
    $(".searching-input").val(webinar);
    $(".results-item").shouldHave(text(webinar + "ы" + "\n" + "Перейти на страницу вебинаров"));
    $(".results-item").click();
    $(".app-body").$("div h1").shouldHave(text(webinar + "ы"));
  }
}
