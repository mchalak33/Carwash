package com.car.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Waits {
    public static void waitForPageToLoad(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Wait until document.readyState is 'complete'
        for (int i = 0; i < 30; i++) { // max 30 seconds
            String readyState = js.executeScript("return document.readyState").toString();
            if (readyState.equals("complete")) {
                break;
            }
            try {
                Thread.sleep(1000); // wait 1 second before checking again
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
