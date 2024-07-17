package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
//        ChromeDriver driver = new ChromeDriver();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        String actualTitl = driver.getTitle();
        String expectedTitl = "nopCommerce demo store";
        if (actualTitl.equals(expectedTitl)){
            System.out.println("passed");
            System.out.println("hellohi");
        }
        else {
            System.out.println("failed");
        }

        driver.quit();
    }
}