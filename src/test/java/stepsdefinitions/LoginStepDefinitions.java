package stepsdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertTrue;

public class LoginStepDefinitions {

    WebDriver driver;

    @Given("I open the login page")
    public void i_open_the_login_page() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DaisyLoraineIsip\\Documents\\Sample Automation\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://sandbox.mifos.community/");  // Replace with the actual URL
    }

    @When("I enter valid credentials")
    public void i_enter_valid_credentials() {
        WebElement usernameField = driver.findElement(By.id("mat-input-0"));
        WebElement passwordField = driver.findElement(By.id("mat-input-1"));
        usernameField.sendKeys("mifos");  // Replace with a valid username
        passwordField.sendKeys("password");  // Replace with a valid password
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login-form\"]/button[1]"));
        loginButton.click();
    }

    @Then("I should see the welcome message")
    public void i_should_see_the_welcome_message() {
        WebElement welcomeMessage = driver.findElement(By.id("welcomeMessage"));
        assertTrue(welcomeMessage.isDisplayed());
        driver.quit();
    }
}