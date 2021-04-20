import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class ShoppingCart {

    @Test
    public void addBookToTheCart() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("11111");
        driver.findElement(By.cssSelector("[value = Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Alex");
        driver.findElement(By.name("last_name")).sendKeys("Brown");
        driver.findElement(By.name("email")).sendKeys("mail@mail.com");
        driver.findElement(By.name("password1")).sendKeys("1111");
        driver.findElement(By.name("password2")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value = Register]")).click();
        String email = driver.findElement(By.xpath("//b[contains(text(),'@')]")).getText();
        driver.findElement(By.xpath("//a[contains(text(),'here')]")).click();
        driver.findElement(By.cssSelector("[name = email]")).sendKeys(email);
        driver.findElement(By.cssSelector("[name = password]")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value = Login]")).click();
       driver.findElement(By.name("keyword")).sendKeys("The Adventures of Huckleberry Finn");
        driver.findElement(By.cssSelector("[value = Search]")).click();
//        driver.findElement(By.cssSelector("[src=\"../images/add_to_cart.gif\">]")).click();
        String messageForAddedBook = driver.findElement(By.cssSelector("[class= confirmation message]")).getText();
        Assert.assertEquals(messageForAddedBook,
                "Book was added to the Shopping Cart",
                "Book was not added to the cart");
        driver.quit();
    }

    @Test
    public void checkAddedBookInTheCart() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("11111");
        driver.findElement(By.cssSelector("[value = Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Alex");
        driver.findElement(By.name("last_name")).sendKeys("Brown");
        driver.findElement(By.name("email")).sendKeys("mail@mail.com");
        driver.findElement(By.name("password1")).sendKeys("1111");
        driver.findElement(By.name("password2")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value = Register]")).click();
        String email = driver.findElement(By.xpath("//b[contains(text(),'@')]")).getText();
        driver.findElement(By.xpath("//a[contains(text(),'here')]")).click();
        driver.findElement(By.cssSelector("[name = email]")).sendKeys(email);
        driver.findElement(By.cssSelector("[name = password]")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value = Login]")).click();
//        driver.findElement(By.name("keyword")).sendKeys("The Adventures of Huckleberry Finn");

//        driver.findElement(By.cssSelector("[value = Search]")).click();
//        driver.findElement(By.cssSelector("[src=\"../images/add_to_cart.gif\">]")).click();
//        driver.findElement(By.xpath("//a[contains(text(),'Shopping Cart')]")).click();
        boolean bookAdded1 = driver.findElement(By.xpath("//td[contains(text(),'The Adventures of Huckleberry Finn')]")).isDisplayed();
        assertTrue(bookAdded1, "Book is not in the cart");
        driver.quit();
    }

    @Test
    public void addMultipleBooksToTheCart() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("11111");
        driver.findElement(By.cssSelector("[value = Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Alex");
        driver.findElement(By.name("last_name")).sendKeys("Brown");
        driver.findElement(By.name("email")).sendKeys("mail@mail.com");
        driver.findElement(By.name("password1")).sendKeys("1111");
        driver.findElement(By.name("password2")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value = Register]")).click();
        String email = driver.findElement(By.xpath("//b[contains(text(),'@')]")).getText();
        driver.findElement(By.xpath("//a[contains(text(),'here')]")).click();
        driver.findElement(By.cssSelector("[name = email]")).sendKeys(email);
        driver.findElement(By.cssSelector("[name = password]")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value = Login]")).click();
        driver.findElement(By.name("keyword")).sendKeys("The Adventures of Huckleberry Finn");
        driver.findElement(By.cssSelector("[value = Search]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Shopping Cart')]")).click();
//        driver.findElement(By.name("keyword")).sendKeys("War and Peace");
//        driver.findElement(By.cssSelector("[value = Search]")).click();
//        driver.findElement(By.cssSelector("[src=\"../images/add_to_cart.gif\">]")).click();
//        driver.findElement(By.xpath("//a[contains(text(),'Shopping Cart')]")).click();
//        boolean bookAdded2 = driver.findElement(By.xpath("//td[contains(text(),'War and Peace')]")).isDisplayed();
//        assertTrue(bookAdded2, "Second Book is not added to the cart");
        driver.quit();
    }
}
