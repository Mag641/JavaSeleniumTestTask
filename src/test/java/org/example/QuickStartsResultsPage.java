package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuickStartsResultsPage {
    public WebDriver driver;

    public QuickStartsResultsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(className = "CoveoResultLink")
    private WebElement firstResult;

    public void clickFirstResult() {
        firstResult.click();
    }
}