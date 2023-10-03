package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Main {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.edge.driver", "C:\\Users\\shola\\IdeaProjects\\SampleProject\\msedgedriver.exe");
        // WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://pnfp.myapexcard.com/info");
    }
    @Test
    public void epexCard() throws InterruptedException {

        Thread.sleep(5000);
        WebElement viewCard = driver.findElement(By.xpath("//*[@class='productSelector_category_business']"));
        Assert.assertTrue(viewCard.isDisplayed());
        viewCard.click();
        WebElement termsConditions = driver.findElement(By.xpath("(//*[@class='productSelector_cardRow_applyTCContainer']//div[@class='productSelector_cardRow_applyTCContainer_tc applyTermsAndConditions'])[6]"));
        Assert.assertTrue(termsConditions.isDisplayed());
        termsConditions.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//*[@class='css-tc-table-td-big'])[3]"))));
        WebElement aprElement = driver.findElement(By.xpath("(//*[@class='css-tc-table-td-big'])[3]"));
        Assert.assertTrue(aprElement.isDisplayed());

    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}