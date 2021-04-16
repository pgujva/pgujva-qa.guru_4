package pasha.tests.rsv.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MainPageSearchTests {
  @BeforeEach
  void setUp() {
    SelenideLogger.addListener("allure", new AllureSelenide());
    Configuration.startMaximized = true;
    open("https://rsv-test.bizml.ru/");
  }

  @Test
  public void testSearchWebinar() {
    String webinar = "Вебинар";
    $(".search-button").click();
    $(".searching-input").clear();
    $(".searching-input").val(webinar);
    $(".results-item").shouldHave(text(webinar + "ы" + "\n" + "Перейти на страницу вебинаров"));
    $(".results-item").click();
    $(".app-body").$("div h1").shouldHave(text(webinar + "ы"));
  }

  @Test
  public void testSearchProjects() {
    String project = "Проект";
    $(".search-button").click();
    $(".searching-input").clear();
    $(".searching-input").val(project);
    $(".searching-switcher").click();
    $$(".categories-column").filterBy(text(project + "ы")).first().click();
    $$(".results.SRWrapper.results").first().shouldHave(text(project + "ы"));
    $(".results-item").shouldHave(text(project + "ы" + "\n" + "Перейти на страницу проектов"));
    $(".results-item").click();
    $(".app-body").$("div h1").shouldHave(text(project + "ы"));
  }


}
