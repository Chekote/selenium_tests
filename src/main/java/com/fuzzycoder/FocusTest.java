package com.fuzzycoder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Keys;

public class FocusTest  {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("http://localhost/focustest.html");

        driver.findElement(By.id("focusbtn")).click();

        WebElement input = driver.findElement(By.id("field"));

        int length = input.getAttribute("value").length();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; ++i) {
            sb.append(Keys.DELETE);
            sb.append(Keys.BACK_SPACE);
        }

        sb.append("Chekote");

        input.sendKeys(sb.toString());

        String value = input.getAttribute("value");
        if (value.equals("Chekote")) {
            System.out.println("Passed!");
        } else {
            System.out.println("Failed!");
            System.out.println("Value was: " + value);
        }

        driver.quit();
    }
}
