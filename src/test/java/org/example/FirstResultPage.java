package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FirstResultPage {
    public WebDriver dirver;

    public FirstResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.dirver = driver;
    }

    @FindBy(xpath = "//*[@id='relatedresources_articleview_docs']/div[3]/div/div/div[1]/div[2]/a")
    private WebElement firstRelatedResourceLink;

    public void clickFirstRelatedResourceLink() {
        firstRelatedResourceLink.click();
    }
}
