package test.lesson7qaguru;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class SevenWebStepsIssue {

    private static final String URL = "https://github.com";
    private static final String REPOSITORY = "StanislavDZ/FormDemoQA1";
    private static  final int ISSUE_NUMBER = 1;

    @Step("Open page {url}")
    public void openPage(String URL) {
        open(URL);
    }
    @Step("Search repository {repository}")
    public void searchRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }
    @Step("Open URL {repository}")
    public void openLink(String REPOSITORY) {
        $(By.linkText(REPOSITORY)).click();
    }
    @Step("Click menu ISSUES")
    public void clickTabMenuIssues() {
        $(By.partialLinkText("Issues")).click();
    }
    @Step("Check number #{number}")
    public void checkNumber(int number) {
        $(withText("#"+number)).should(Condition.exist);
    }
    @Attachment(value = "Screenshot", type = "pic/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
    @Test
    public void testAnnotatedSteps() {
        addListener("allure", new AllureSelenide());
        SevenWebStepsIssue steps = new SevenWebStepsIssue();
        steps.openPage(URL);
        steps.searchRepository(REPOSITORY);
        steps.openLink(REPOSITORY);
        steps.clickTabMenuIssues();
        steps.checkNumber(ISSUE_NUMBER);
        steps.takeScreenshot();
    }

}
