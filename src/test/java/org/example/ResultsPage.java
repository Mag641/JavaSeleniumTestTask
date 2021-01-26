package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ResultsPage {
    public WebDriver driver;

    public ResultsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "#ArticleTypeFacet > div.coveo-facet-footer > div.coveo-facet-more.coveo-accessible-button.coveo-active")
    private WebElement showMoreButton;

    @FindBy(xpath = "//*[@id=\"ArticleTypeFacet\"]/ul/li[12]/label/div")
    private WebElement quickStarts;

    public void clickShowMore() {
        showMoreButton.click();
    }

    public void clickQuickStarts() {
        quickStarts.click();
    }
}