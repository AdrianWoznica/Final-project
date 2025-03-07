package com.course.selenium.finalProject.Task1;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;

public class Task1 {

    private WebDriver driver;

    @Given("I am logged in as a user with the email {string} and password {string}")
    public void iAmLoggedInAsAUserWithTheFollowingCredentials(String email, String password) {

        // Skonfigurowanie sterownika przeglądarki
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        // Otworzenie nowego okna Chrome
        driver = new ChromeDriver();

        // Otworzenie strony do logowania i maksymalizacja okna
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");

        // Wypełnienie formularza logowania
        driver.findElement(By.id("field-email")).sendKeys(email);
        driver.findElement(By.id("field-password")).sendKeys(password);
        driver.findElement(By.id("submit-login")).click();

        // Czekaj chwilę, aby zobaczyć efekt na stronie (opcjonalnie)
        try {
            Thread.sleep(3000); // 3 sekundy
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("I click on the {string} link")
    public void iClickOnTheLink(String linkText) {
        // Klikamy na link "Addresses"
        WebElement element = driver.findElement(By.xpath("//*[@id=\"addresses-link\"]/span"));
        element.click();

        // Czekaj chwilę, aby zobaczyć efekt na stronie (opcjonalnie)
        try {
            Thread.sleep(3000); // 3 sekundy
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("I click on the {string} button")
    public void iClickOnTheButton(String buttonText) {
        // Klikamy przycisk "Create new address"
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/a/span")).click();
    }


    @And("I fill in the new address form with the following details")
    public void iFillInTheNewAddressFormWithTheFollowingDetails(DataTable addressDetails) {
        List<Map<String, String>> data = addressDetails.asMaps(String.class, String.class);

        // Wypełniamy formularz
        driver.findElement(By.id("field-alias")).sendKeys(data.get(0).get("alias"));
        driver.findElement(By.id("field-address1")).sendKeys(data.get(0).get("address"));
        driver.findElement(By.id("field-city")).sendKeys(data.get(0).get("city"));
        driver.findElement(By.id("field-postcode")).sendKeys(data.get(0).get("zip"));
        driver.findElement(By.id("field-phone")).sendKeys(data.get(0).get("phone"));

        // Czekaj chwilę, aby zobaczyć efekt na stronie (opcjonalnie)
        try {
            Thread.sleep(3000); // 3 sekundy
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Then("The program checks if the data are correct, create a new address and reload to the addresses page")
    public void checkAndSaveNewAddress() {
        // Sprawdzamy, czy nowy adres pojawił się na liście
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/footer/button")).click();


        // Czekaj chwilę, aby zobaczyć efekt na stronie (opcjonalnie)
        try {
            Thread.sleep(3000); // 3 sekundy
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @After
    public void tearDown() {
        // Zamykamy przeglądarkę
        driver.quit();
    }
}