import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.DemoQaRegistrationPage;

public class TestBase {


    DemoQaRegistrationPage demoQaRegistrationPage = new DemoQaRegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }
}
