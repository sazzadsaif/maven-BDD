package page_objects;


import command_providers.ActOn;
import command_providers.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home extends NavigationBar {
    private final By HomeValueInputField = By.id("homeval");
    private final By DownPaymentInputField = By.id("downpayment");
    private final By SelectDownPaymentInDollar = By.name("param[downpayment_type]");
    private final By LoanAmountInputField = By.id("loanamt");
    private final By InterestRateInputField = By.id("intrstsrate");
    private final By LoanTermInputField = By.id("loanterm");
    private final By StartMonthDropDown = By.name("param[start_month]");
    private final By StartYearInputField = By.id("start_year");
    private final By PropertyTaxInputField = By.id("pptytax");
    private final By PMIInputField = By.id("pmi");
    private final By HomeInsuranceInputField = By.id("hoi");
    private final By HOAInputField = By.id("hoa");
    private final By LoanTypeDropDown = By.name("param[milserve]");
    private final By RefiOrBuyDropDown = By.name("param[refiorbuy]");
    private final By CalculateButton = By.name("cal");

    private static final Logger LOGGER = LogManager.getLogger(Home.class);



    public Home(WebDriver driver){
        super(driver);

    }

    public Home typeHomePrice(String value){
        LOGGER.debug("Typing the Home value: " + value);
        ActOn.element(driver,HomeValueInputField).setValue(value);
        return this;
    }
    public Home typeDownPayment(String value){
        LOGGER.debug(" Typing the down payment: " + value);
        ActOn.element(driver,DownPaymentInputField).setValue(value);
        return this;
    }
    public Home clickDownPaymentToDollar(){
        LOGGER.debug("Click on the radio button");
        ActOn.element(driver,SelectDownPaymentInDollar).click();
        return this;
    }
    public Home typeLoanAmount(String value){
        LOGGER.debug("Type the loan amount: " + value);
        ActOn.element(driver,LoanAmountInputField).setValue(value);
        return this;
    }
    public Home typeInterestRate(String value){
        LOGGER.debug("Typing the interest rate: " + value);
        ActOn.element(driver,InterestRateInputField).setValue(value);
        return this;
    }
    public Home typeLoanTermYear(String value){
        LOGGER.debug("Typing the loan term: " + value + "years");
        ActOn.element(driver,LoanTermInputField).setValue(value);
        return this;
    }
    public Home selectMonth(String month){
        LOGGER.debug("Select the start month: " + month);
        ActOn.element(driver,StartMonthDropDown).selectValue(month);
        return this;
    }
    public Home typeYear(String year){
        LOGGER.debug("Select the start year: " + year);
        ActOn.element(driver,StartYearInputField).setValue(year);
        return this;
    }
    public Home typePropertyTax(String value){
        LOGGER.debug("Typing the property tax: " + value);
        ActOn.element(driver,PropertyTaxInputField).setValue(value);
        return this;
    }
    public Home typePmi(String value){
        LOGGER.debug("typing the PMI: " + value);
        ActOn.element(driver,PMIInputField).setValue(value);
        return this;
    }
    public Home typeHomeIns(String value){
        LOGGER.debug("Typing the Home ins: " + value);
        ActOn.element(driver,HomeInsuranceInputField).setValue(value);
        return this;
    }
    public Home TypeHoa(String value){
        LOGGER.debug(" typing the HOA: " + value);
        ActOn.element(driver,HOAInputField).setValue(value);
        return this;
    }
    public Home selectLoanType(String value){
        LOGGER.debug("Selecting the loan type: " + value);
        ActOn.element(driver,LoanTypeDropDown).selectValue(value);
        return this;
    }
    public Home selectBuyOrRefi(String value){
        LOGGER.debug("Selecting the option: " + value);
        ActOn.element(driver,RefiOrBuyDropDown).selectValue(value);
        return this;
    }
    public Home clickOnCalculateRateButton(){
        LOGGER.debug("Clicking on Calculator Button");
        ActOn.element(driver,CalculateButton).click();
        return this;
    }
    public Home validateTotalMonthlyPayment(String expectedTotalMonthlyPayment){
        LOGGER.debug("");

        String formattedXpath = String.format("//h3[text()='%s']",expectedTotalMonthlyPayment);
        // String formattedXpath = String.format("//h3[text()='$' + expectedTotalMonthlyPayment +'']");
        By monthlyPayment = By.xpath(formattedXpath);

        // Validate that the monthly payment is $1,611.85
        LOGGER.debug("Validate the monthly payment is: " + expectedTotalMonthlyPayment);

        AssertThat.elementAssertions(driver,monthlyPayment).elementIsDisplayed();

        return this;
    }




}
