package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;

public class SearchPage {
    public WebDriver driver;

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(className = "magic-box-input")
    private WebElement divSearch;
    private WebElement searchField = divSearch.findElement(By.cssSelector("input"));

    @FindBy(id = "tdx-search")
    private WebElement searchButton;
    // private WebElement divSearch = driver.findElement(By.className("magic-box-input")).findElement(By.cssSelector("input"));

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
