package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='magic-box-input']//input")
    private WebElement searchField;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div/help-home/tds-portal-header/div/div/div/div/div[2]/div/tds-header-search/div/div/div/a")
    private WebElement searchButton;

    public void inputSearchString(String searchString) {
        searchField.sendKeys(searchString);
        searchField.sendKeys("\n");
    }

    public void clickSearchButton() {
        searchButton.click();
    }
}
