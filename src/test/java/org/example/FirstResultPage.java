package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class  FirstResultPage{
    public WebDriver driver;

    public FirstResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id='relatedresources_articleview_docs']/div[3]/div/div/div[1]/div[2]/a")
    private WebElement firstRelatedResourceLink;
    private String linkUrl;

    public boolean clickFirstRelatedResourceLink() throws IOException {
        this.linkUrl = firstRelatedResourceLink.getAttribute("href");
        URL obj = new URL(this.linkUrl);
        HttpURLConnection con;
        con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            firstRelatedResourceLink.click();
            return true;
        } // success
        return false;
    }
}
