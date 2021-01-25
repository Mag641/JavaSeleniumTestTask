package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;

public class HomePage {
    public WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='magic-box-input']//input")
    private WebElement searchField;

    @FindBy(id = "tdx-search")
    private WebElement searchButton;

    public void inputSearchString(String searchString) {
        searchField.sendKeys(searchString);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    /*
    {
        assert driver != null;
        searchField = driver.findElement(By.className("magic-box-input")).findElement(By.cssSelector("input"));
    }
     */
}
