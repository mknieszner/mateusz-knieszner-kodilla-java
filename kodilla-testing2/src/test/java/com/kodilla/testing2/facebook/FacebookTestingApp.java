package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Facebook Registration Testing App
 */
public class FacebookTestingApp {
  public static final String XPATH_NAME = "//div[contains(@id,\"registration_container\")]//*[contains(@id,\"u_0_i\")]";
  public static final String XPATH_LASTNAME = "//div[contains(@id,\"registration_container\")]//*[contains(@id,\"u_0_k\")]";
  public static final String XPATH_EMAIL = "//div[contains(@id,\"registration_container\")]//*[contains(@id,\"u_0_n\")]";
  public static final String XPATH_CONFIRM_EMAIL = "//div[contains(@id,\"registration_container\")]//*[contains(@id,\"u_0_q\")]";
  public static final String XPATH_PASSWORD = "//div[contains(@id,\"registration_container\")]//*[contains(@id,\"u_0_u\")]";
  public static final String XPATH_BIRTHDAY_DAY = "//div[contains(@id,\"registration_container\")]//*[contains(@id,\"day\")]";
  public static final String XPATH_BIRTHDAY_MONTH = "//div[contains(@id,\"registration_container\")]//*[contains(@id,\"month\")]";
  public static final String XPATH_BIRTHDAY_YEAR = "//div[contains(@id,\"registration_container\")]//*[contains(@id,\"year\")]";
  public static final String XPATH_MALE_SEX = "//div[contains(@id,\"registration_container\")]//span[contains(@class,\"_5k_2\")][2]";

  public static void main(final String[] args) {
    final WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
    driver.get("https://www.facebook.com/");

    final WebElement firstNameField = driver.findElement(By.xpath(XPATH_NAME));
    firstNameField.sendKeys("TestFirstName");

    final WebElement lastNameField = driver.findElement(By.xpath(XPATH_LASTNAME));
    lastNameField.sendKeys("TestLastName");

    final WebElement emailField = driver.findElement(By.xpath(XPATH_EMAIL));
    emailField.sendKeys("Test@Email.com");

    while (!driver.findElement(By.xpath(XPATH_CONFIRM_EMAIL)).isDisplayed()) ;

    final WebElement confirmEmailField = driver.findElement(By.xpath(XPATH_CONFIRM_EMAIL));
    confirmEmailField.sendKeys("Test@Email.com");

    final WebElement passwordField = driver.findElement(By.xpath(XPATH_PASSWORD));
    passwordField.sendKeys("TestPassword");

    final WebElement birthdayDayCombo = driver.findElement(By.xpath(XPATH_BIRTHDAY_DAY));
    final Select birthdayDaySelect = new Select(birthdayDayCombo);
    birthdayDaySelect.selectByValue("2");

    final WebElement birthdayMonthCombo = driver.findElement(By.xpath(XPATH_BIRTHDAY_MONTH));
    final Select birthdayMonthSelect = new Select(birthdayMonthCombo);
    birthdayMonthSelect.selectByValue("3");

    final WebElement birthdayYearCombo = driver.findElement(By.xpath(XPATH_BIRTHDAY_YEAR));
    final Select birthdayYearSelect = new Select(birthdayYearCombo);
    birthdayYearSelect.selectByValue("1990");

    final WebElement maleSexCombo = driver.findElement(By.xpath(XPATH_MALE_SEX));
    maleSexCombo.click();
  }
}
