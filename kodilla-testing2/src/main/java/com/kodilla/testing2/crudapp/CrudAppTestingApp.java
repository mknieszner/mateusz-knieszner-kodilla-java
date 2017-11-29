package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 *
 */
public class CrudAppTestingApp {
  public static final String XPATH_INPUT = "/html/body/main/section/form/fieldset/input";
  public static final String XPATH_TEXTAREA = "/html/body/main/section/form/fieldset[2]/textarea";
  public static final String XPATH_WAIT_FOR = "//select[1]";
  public static final String XPATH_SELECT = "//div[contains(@class, \"tasks-container\")]/form/div/fieldset/select[1]";


  public static void main(final String[] args) {
    final WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
    driver.get("https://mknieszner.github.io/");

    final WebElement searchField = driver.findElement(By.xpath(XPATH_INPUT));
    searchField.sendKeys("New robotic task");

    final WebElement textareaField = driver.findElement(By.xpath(XPATH_TEXTAREA));
    textareaField.sendKeys("The robotic content");

    while (!driver.findElement(By.xpath(XPATH_WAIT_FOR)).isDisplayed());

    final WebElement selectCombo = driver.findElement(By.xpath(XPATH_SELECT));
    final Select selectBoard = new Select(selectCombo);
    selectBoard.selectByIndex(1);
  }
}
