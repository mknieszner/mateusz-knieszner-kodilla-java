package com.kodilla.testing2.google;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Google Search Testing Class.
 */
public class GoogleTestingApp {
  public static final String SEARCHFIELD = "lst-ib";

  public static void main(final String[] args) {
    final WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
    driver.get("https://www.google.com");

    final WebElement searchfield = driver.findElement(By.id(SEARCHFIELD));
    searchfield.sendKeys("Kodilla");
    searchfield.submit();
  }
}
