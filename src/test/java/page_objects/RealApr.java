package page_objects;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RealApr extends NavigationBar{
    private static final Logger LOGGER = LogManager.getLogger(RealApr.class);


    private final By RatesLink = By.linkText("Rates");
    private final By RealAprLink = By.linkText("Real APR");
    private final By CalculatorTab = By.xpath("//label[text()='Calculator']");
    private final By HomePriceInputField = By.name("HomeValue");
    private final By DownPaymentInDollar = By.name("DownPaymentSel");
    private final By DownPaymentInputField = By.name("DownPayment");
    private final By InterestRateInputField = By.name("Interest");
    private final By CalculateRateButton = By.name("calculate");
    private final By ActualAprRate = By.xpath("//*[@id='analysisDiv']/table/tbody/tr/td/strong[text()='Actual APR:']/../../td[2]/strong");

    public RealApr(WebDriver driver){
        super(driver);


    }
    public RealApr waitForPageToLoad(){
        LOGGER.debug("Wait for page to load");
        ActOn.wait(driver,CalculatorTab).waitForElementToBeVisible();
        return this;
    }


    public RealApr typeHomePrice(String value){
        LOGGER.debug("typing the home price: " + value);
        ActOn.element(driver,HomePriceInputField).setValue(value);
        return this;
    }
    public RealApr clickDownPaymentInDollar(){
        LOGGER.debug("click on the dollar button");
        ActOn.element(driver,DownPaymentInDollar).click();
        return this;
    }
    public RealApr typeDownPayment(String value){
        LOGGER.debug("Typing the down payment: " + value);
        ActOn.element(driver,DownPaymentInputField).setValue(value);
        return this;
    }
    public RealApr typeInterestRate(String value){
        LOGGER.debug("typing the interest rate: " + value);
        ActOn.element(driver,InterestRateInputField).setValue(value);
        return this;
    }
    public RealApr clickOnCalculateButton(){
        LOGGER.debug("Clicking on the Calculate Button");
        ActOn.element(driver,CalculateRateButton).click();
        return this;
    }
    public RealApr validateRealApr(String expectedAprRate){
        LOGGER.debug(" Validate the real apr rate is: " + expectedAprRate);
        String actualRealAprRate = driver.findElement(ActualAprRate).getText();
        Assert.assertEquals(expectedAprRate,actualRealAprRate);
        return this;
    }
}

