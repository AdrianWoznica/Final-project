package com.course.selenium.finalProject.Task2;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Task2 {

    private WebDriver driver;

    @Given("I am logged in as a user with the email {string} and password {string}")
    public void iAmLoggedInAsAUserWithTheFollowingCredentials(String email, String password) {

        // Skonfigurowanie sterownika przeglądarki
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
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

    // Kliknięcie paska wyszukiwania, wprowadzenie nazwy przedmiotu i kliknięcie enter
    @When("I click on the search bar and look for {string}")
    public void iClickOnTheSearchBarAndSearchForAnItem(String item) {
        WebElement searchbar = driver.findElement(By.xpath("//*[@id=\"search_widget\"]/form/input[2]"));
        searchbar.click();
        searchbar.sendKeys(item);
        searchbar.submit();

    }

    @And("I click on the Hummingbird Printed Sweater' item")
    public void iSelectedAnItem() {
        driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div[3]/div[1]/div[1]/article/div/div[1]/a/img")).click();

    }

    @And("I select a M size")
    public void iSelectMSize() {
        driver.findElement(By.xpath("//*[@id=\"group_1\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"group_1\"]/option[2]")).click();
    }

    @And("I select quantity value of 5")
    public void iSelectQuantityValueOf5() {
        // Znajdź przycisk zwiększania
        WebElement button = driver.findElement(By.cssSelector(".btn.btn-touchspin.js-touchspin.bootstrap-touchspin-up"));

        // Kliknij przycisk zwiększania 4 razy, aby zmienić ilość na 5
        for (int i = 0; i < 5; i++) {
            button.click();
        }

        // Czekaj chwilę, aby zobaczyć efekt na stronie (opcjonalnie)
        try {
            Thread.sleep(3000); // 3 sekundy
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("I add the selected item to cart")
    public void iAddedTheItemToCart() {

        // Tworzymy obiekt WebDriverWait, aby poczekać na element
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Czekamy, aż przycisk będzie dostępny i klikamy go
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-primary.add-to-cart")));
        addToCartButton.click();

        // Czekaj chwilę, aby zobaczyć efekt na stronie (opcjonalnie)
        try {
            Thread.sleep(3000); // 3 sekundy
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("Proceed to checkout")
    public void selectProceedToCheckOut() {

        // Tworzymy obiekt WebDriverWait, aby poczekać na element
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Czekamy, aż element stanie się klikalny
        WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Proceed to checkout']")));
        checkoutButton.click();

        // Czekaj chwilę, aby zobaczyć efekt na stronie (opcjonalnie)
        try {
            Thread.sleep(3000); // 3 sekundy
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("I click proceed to checkout on the next page")
    public void clickProceedTheCheckOutOnTheNextPage() {
        // Kliknięcie "proceed to checkout na kolejnej stronie
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='https://mystore-testlab.coderslab.pl/index.php?controller=order' and @class='btn btn-primary']")));
        checkoutButton.click();
    }

    @And("I click continue")
    public void iClickContinue() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='confirm-addresses' and @class='btn btn-primary continue float-xs-right']")));
        continueButton.click();
    }

    @And("I click continue to payment")
    public void iClickContinueToPayment() {
        // kliknięcie continue
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='confirmDeliveryOption' and @class='continue btn btn-primary float-xs-right']")));
        continueButton.click();
    }

    @And("I select a payment method")
    public void iSelectPaymentMethod() {
        // wybranie metody płatności
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement payByCheckButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"payment-option-1-container\"]/label")));
        payByCheckButton.click();

        // Czekaj chwilę, aby zobaczyć efekt na stronie (opcjonalnie)
        try {
            Thread.sleep(3000); // 3 sekundy
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("I agree to terms")
    public void iAgreeToTerms() {
//        // zatwierdzenie regulaminu
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement agreeCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"conditions-to-approve\"]/ul/li/div[2]/label")));
        agreeCheckbox.click();

        // Czekaj chwilę, aby zobaczyć efekt na stronie (opcjonalnie)
        try {
            Thread.sleep(3000); // 3 sekundy
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("Place an order")
    public void iPlaceAnOrder() {
        driver.findElement(By.xpath("//*[@id=\"payment-confirmation\"]/div[1]/button")).click();

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
