package Steps;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.AttachmentHelper.*;

public class BaseSteps {
  private final static String BASE_URL = "https://rsv-test.bizml.ru/";

  @BeforeAll
  static void setUp() {
    addListener("AllureSelenide", new AllureSelenide());
   /* DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("browserName", "chrome");
    capabilities.setCapability("browserVersion", "89.0");
    capabilities.setCapability("enableVNC", true);
    Configuration.browserCapabilities = capabilities;
    Configuration.remote = "http://localhost:4444/wd/hub";*/
  }

  @AfterEach
  void afterEach() {
    attachScreenshot("Last screenshot");
    attachPageSource();
    attachAsText("Browser console logs",getConsoleLogs());
  }

  @Step("Открываем главную странцу")
  public void openMainPage() {
    open(BASE_URL);
  }

  @Step("открываем окно поиска")
  public void openSearchWindow() {
    $(".search-button").click();
    $(".searching-input").clear();
  }

  @Step("выбираем фильтр")
  public void choseFilter(final String PROJECT) {
    $(".searching-input").val(PROJECT);
    $(".searching-switcher").click();
    $$(".categories-column").filterBy(text(PROJECT + "ы")).first().click();
  }

  @Step("Проверка фильтрации по проектам")
  public void shouldHaveTestProject(final String PROJECT) {
    $$(".results.SRWrapper.results").first().shouldHave(text(PROJECT + "ы"));
  }

  @Step("Проверка,что есть ссылка на раздел Проекты")
  public void shouldHaveTestLinkProject(final String PROJECT) {
    $(".results-item").shouldHave(text(PROJECT + "ы" + "\n" + "Перейти на страницу проектов"));
  }

  @Step("Проверка,что работает переход на страницу проектов")
  public void shouldHaveTestLinkTextProject(final String PROJECT) {
    $(".results-item").shouldHave(text(PROJECT + "ы" + "\n" + "Перейти на страницу проектов"));
  }
}
