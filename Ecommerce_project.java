package com.ecommerce.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Ecommerce_project {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://tutorialsninja.com/demo/"); //Navigate to Ecommerce application
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[@title='My Account']")).click();   //Click on MyAccount -> Login link
        driver.findElement(By.xpath("//a[text()='Login']")).click();

        driver.findElement(By.id("input-email")).sendKeys("aribumar2328@gmail.com");  //Enter Email Address, Password and click on the Login button
        driver.findElement(By.id("input-password")).sendKeys("Aribumar");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

       WebElement laptopandnotebook = driver.findElement(By.xpath("//a[text()='Laptops & Notebooks']")); //Go to Laptops & Notebooks -> Show All Laptops & Notebooks
        WebElement alllaptopandnotebook = driver.findElement(By.xpath("//a[text()='Show AllLaptops & Notebooks']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(laptopandnotebook).click(alllaptopandnotebook).build().perform();

        driver.findElement(By.xpath("(//span[text()='Add to Cart'])[3]")).click();
        driver.findElement(By.xpath("(//span[text()='Add to Cart'])[4]")).click();

        driver.findElement(By.xpath("//span[text()='Shopping Cart']")).click();

       String product1_text = driver.findElement(By.xpath("(//a[contains(@href,'product_id=44')])[4]")).getText();
        String product2_text = driver.findElement(By.xpath("(//a[contains(@href,'product_id=45')])[4]")).getText();

        if (product1_text.equals("MacBook Air")){
            System.out.println("First Product Verification Successfully");
        }else {
            System.out.println("First Product Verification Failed");
        }

        if (product2_text.equals("MacBook Pro")){
            System.out.println("Second Product Verification Successfully");
        }else {
            System.out.println("Second Product Verification Failed");
        }

        String total_amount = driver.findElement(By.xpath("(//table[@class='table table-bordered'])[3]//tr[4]/td[2]")).getText();
        if (total_amount.equals("$3,202.00")){
            System.out.println("Total Amount Verification Successfully");
        }else {
            System.out.println("Total Amount Verification Failed");
        }
        System.out.println(total_amount);

        driver.findElement(By.xpath("//a[text()='Checkout']")).click();


        driver.quit();




    }
}
