package com.kodilla.testing2.ebay;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * EBay Search Testing Class.
 */
public class EBayTestingApp {
  public static final String SEARCHFIELD = "gh-ac";

  public static void main(final String[] args) {
    final WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
    driver.get("https://www.ebay.com/");

    final WebElement searchfield = driver.findElement(By.id(SEARCHFIELD));
    searchfield.sendKeys("Laptop");
    searchfield.submit();
  }
}
