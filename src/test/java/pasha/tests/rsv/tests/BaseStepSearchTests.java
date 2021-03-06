package pasha.tests.rsv.tests;

import Steps.BaseSteps;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URI;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class BaseStepSearchTests extends BaseSteps {
  private final static String PROJECT = "Проект";
  //private final static String BASE_URL = "https://rsv-test.bizml.ru";

  @Test
  public void PageSearchTest() {
    openMainPage();
    openSearchWindow();
    choseFilter(PROJECT);
    shouldHaveTestProject(PROJECT);
    shouldHaveTestLinkProject(PROJECT);
    shouldHaveTestLinkTextProject(PROJECT);

  }

}
