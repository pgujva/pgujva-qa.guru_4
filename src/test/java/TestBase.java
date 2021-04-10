import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {

  @BeforeAll
  static void setup() {
    goToPracticeForm();
    Configuration.startMaximized = true;
  }

  public static void goToPracticeForm() {
    open("https://demoqa.com/automation-practice-form");
  }
}
