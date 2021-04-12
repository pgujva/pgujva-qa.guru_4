package pasha.tests.rsv.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;

public class StepMainPageSearchTests {
  private final static String PROJECT = "Проект";
  private final static String BASE_URL = "https://rsv-test.bizml.ru/";
  @BeforeEach
  void setUp() {
    SelenideLogger.addListener("allure", new AllureSelenide());
    Configuration.startMaximized = true;
    step("Открываем главную страницу", () -> {
      open(BASE_URL);
    });
  }

  @Test
  @Link(BASE_URL)
  @Owner("gujvapv")
  @Feature("Посик на главное")
  @Story("RSV-341")
  @Tags({@Tag("web"), @Tag("major")})
  @DisplayName("Поиск по проектам на главной странице")
  public void testSearchProjects() {
    parameter("Проект", PROJECT);

    step("Открываем окно поиска", () -> {
      $(".search-button").click();
      $(".searching-input").clear();
    });
    step("Выбор фильтра проекты", () -> {
      $(".searching-input").val(PROJECT);
      $(".searching-switcher").click();
      $$(".categories-column").filterBy(text(PROJECT + "ы")).first().click();
    });
    step("Проверка фильтрации по проектам", () -> {
      $$(".results.SRWrapper.results").first().shouldHave(text(PROJECT + "ы"));
    });
    step("Проверка,что есть ссылка на раздел Проекты", () -> {
      $(".results-item").shouldHave(text(PROJECT + "ы" + "\n" + "Перейти на страницу проектов"));
    });
    step("Проверка,что работает переход на страницу проектов", () -> {
      $(".results-item").click();
      $(".app-body").$("div h1").shouldHave(text(PROJECT + "ы"));
    });

  }
}
