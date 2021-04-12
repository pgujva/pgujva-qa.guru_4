package pasha.tests.rsv.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class StepMainPageSearchTests {
  @BeforeEach
  void setUp() {
    SelenideLogger.addListener("allure", new AllureSelenide());
    Configuration.startMaximized = true;
    step("Открываем главную страницу", () -> {
      open("https://rsv-test.bizml.ru/");
    });
  }

  @Test
  public void testSearchProjects() {
    String project = "Проект";
    step("Открываем окно поиска", () -> {
      $(".search-button").click();
      $(".searching-input").clear();
    });
    step("Выбор фильтра проекты", () -> {
      $(".searching-input").val(project);
      $(".searching-switcher").click();
      $$(".categories-column").filterBy(text(project + "ы")).first().click();
    });
    step("Проверка фильтрации по проектам", () -> {
      $$(".results.SRWrapper.results").first().shouldHave(text(project + "ы"));
    });
    step("Проверка,что есть ссылка на раздел Проекты", () -> {
      $(".results-item").shouldHave(text(project + "ы" + "\n" + "Перейти на страницу проектов"));
    });
    step("Проверка,что работает переход на страницу проектов", () -> {
      $(".results-item").click();
      $(".app-body").$("div h1").shouldHave(text(project + "ы1"));
    });

  }
}
