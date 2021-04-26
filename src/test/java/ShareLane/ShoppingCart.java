package ShareLane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class ShoppingCart {


    @Test
    public void addBookToTheCart() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
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
        driver.findElement(By.name("keyword")).sendKeys("White Fang");
        driver.findElement(By.cssSelector("[value = Search]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'add_to_cart')]")).click();
        String messageForAddedBook = driver.findElement(By.cssSelector("[class= confirmation_message]")).getText();
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
        driver.findElement(By.name("keyword")).sendKeys("White Fang");
        driver.findElement(By.cssSelector("[value = Search]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'add_to_cart')]")).click();
        driver.findElement(By.xpath("//a[contains(@href,'shopping_cart')]")).click();
        boolean bookAdded1 = driver.findElement(By.xpath("//td[contains(text(),'White Fang')]")).isDisplayed();
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
        driver.findElement(By.name("keyword")).sendKeys("White Fang");
        driver.findElement(By.cssSelector("[value = Search]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'add_to_cart')]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'main.py')]")).click();
        driver.findElement(By.name("keyword")).sendKeys("War and Peace");
        driver.findElement(By.cssSelector("[value = Search]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'add_to_cart')]")).click();
        driver.findElement(By.xpath("//a[contains(@href,'shopping_cart')]")).click();
        boolean bookAdded2 = driver.findElement(By.xpath("//td[contains(text(),'War and Peace')]")).isDisplayed();
        boolean bookAdded1 = driver.findElement(By.xpath("//td[contains(text(),'White Fang')]")).isDisplayed();
        assertTrue(bookAdded2, "Second Book is not added to the cart");
        assertTrue(bookAdded1, "First Book is not in to the cart");
        driver.quit();
    }

    @Test
    public void discountAndTotalPriceForRangeUnder20Books() {
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
        driver.findElement(By.name("keyword")).sendKeys("White Fang");
        driver.findElement(By.cssSelector("[value = Search]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'add_to_cart')]")).click();
        driver.findElement(By.xpath("//a[contains(@href,'shopping_cart')]")).click();
        driver.findElement(By.xpath("//input[contains(@value, '1')]")).clear();
        driver.findElement(By.name("q")).sendKeys("19");
        driver.findElement(By.cssSelector("[value = Update]")).click();
        String discountFor19Books = driver.findElement(By.xpath("((//tr)[9]//td)[5]")).getText();
        Assert.assertEquals(discountFor19Books,
                "0",
                "Discount for range<20 is incorrect");
        String priceFor19Books = driver.findElement(By.xpath("((//tr)[9]//td)[7]")).getText();
        Assert.assertEquals(priceFor19Books,
                "190",
                "Total price for range<20 is incorrect");
        driver.quit();
    }

    @Test
    public void discountAndTotalPriceForRangeFrom20To49Books() {
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
        driver.findElement(By.name("keyword")).sendKeys("White Fang");
        driver.findElement(By.cssSelector("[value = Search]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'add_to_cart')]")).click();
        driver.findElement(By.xpath("//a[contains(@href,'shopping_cart')]")).click();
        driver.findElement(By.xpath("//input[contains(@value, '1')]")).clear();
        driver.findElement(By.xpath("//input[2]")).isSelected();
        driver.findElement(By.name("q")).sendKeys("20");
        driver.findElement(By.cssSelector("[value = Update]")).click();
        String discountFor19Books = driver.findElement(By.xpath("((//tr)[9]//td)[5]")).getText();
        Assert.assertEquals(discountFor19Books,
                "2",
                "Discount for range 20-49 is incorrect");
        String priceFor19Books = driver.findElement(By.xpath("((//tr)[9]//td)[7]")).getText();
        Assert.assertEquals(priceFor19Books,
                "196",
                "Total price for range 20-49  is incorrect");
        driver.quit();
    }

    @Test
    public void discountAndTotalPriceForRangeFrom50To99Books() {
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
        driver.findElement(By.name("keyword")).sendKeys("White Fang");
        driver.findElement(By.cssSelector("[value = Search]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'add_to_cart')]")).click();
        driver.findElement(By.xpath("//a[contains(@href,'shopping_cart')]")).click();
        driver.findElement(By.xpath("//input[contains(@value, '1')]")).clear();
        driver.findElement(By.xpath("//input[2]")).isSelected();
        driver.findElement(By.name("q")).sendKeys("50");
        driver.findElement(By.cssSelector("[value = Update]")).click();
        String discountFor19Books = driver.findElement(By.xpath("((//tr)[9]//td)[5]")).getText();
        Assert.assertEquals(discountFor19Books,
                "3",
                "Discount for range 50-99 is incorrect");
        String priceFor19Books = driver.findElement(By.xpath("((//tr)[9]//td)[7]")).getText();
        Assert.assertEquals(priceFor19Books,
                "485",
                "Total price for range 50-99 is incorrect");
        driver.quit();
    }

    @Test
    public void discountAndTotalPriceForRangeFrom100To499Books() {
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
        driver.findElement(By.name("keyword")).sendKeys("White Fang");
        driver.findElement(By.cssSelector("[value = Search]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'add_to_cart')]")).click();
        driver.findElement(By.xpath("//a[contains(@href,'shopping_cart')]")).click();
        driver.findElement(By.xpath("//input[contains(@value, '1')]")).clear();
        driver.findElement(By.xpath("//input[2]")).isSelected();
        driver.findElement(By.name("q")).sendKeys("100");
        driver.findElement(By.cssSelector("[value = Update]")).click();
        String discountFor19Books = driver.findElement(By.xpath("((//tr)[9]//td)[5]")).getText();
        Assert.assertEquals(discountFor19Books,
                "4",
                "Discount for range 100-499 is incorrect");
        String priceFor19Books = driver.findElement(By.xpath("((//tr)[9]//td)[7]")).getText();
        Assert.assertEquals(priceFor19Books,
                "960",
                "Total price for range 100-499 is incorrect");
        driver.quit();
    }

    @Test
    public void discountAndTotalPriceForRangeFrom500To999Books() {
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
        driver.findElement(By.name("keyword")).sendKeys("White Fang");
        driver.findElement(By.cssSelector("[value = Search]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'add_to_cart')]")).click();
        driver.findElement(By.xpath("//a[contains(@href,'shopping_cart')]")).click();
        driver.findElement(By.xpath("//input[contains(@value, '1')]")).clear();
        driver.findElement(By.xpath("//input[2]")).isSelected();
        driver.findElement(By.name("q")).sendKeys("500");
        driver.findElement(By.cssSelector("[value = Update]")).click();
        String discountFor19Books = driver.findElement(By.xpath("((//tr)[9]//td)[5]")).getText();
        Assert.assertEquals(discountFor19Books,
                "5",
                "Discount for range 500-999 is incorrect");
        String priceFor19Books = driver.findElement(By.xpath("((//tr)[9]//td)[7]")).getText();
        Assert.assertEquals(priceFor19Books,
                "4750",
                "Total price for range 500-999 is incorrect");
        driver.quit();
    }

    @Test
    public void discountAndTotalPriceForRangeFrom1000To4999Books() {
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
        driver.findElement(By.name("keyword")).sendKeys("White Fang");
        driver.findElement(By.cssSelector("[value = Search]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'add_to_cart')]")).click();
        driver.findElement(By.xpath("//a[contains(@href,'shopping_cart')]")).click();
        driver.findElement(By.xpath("//input[contains(@value, '1')]")).clear();
        driver.findElement(By.xpath("//input[2]")).isSelected();
        driver.findElement(By.name("q")).sendKeys("1000");
        driver.findElement(By.cssSelector("[value = Update]")).click();
        String discountFor19Books = driver.findElement(By.xpath("((//tr)[9]//td)[5]")).getText();
        Assert.assertEquals(discountFor19Books,
                "6",
                "Discount for range 1000-4999 is incorrect");
        String priceFor19Books = driver.findElement(By.xpath("((//tr)[9]//td)[7]")).getText();
        Assert.assertEquals(priceFor19Books,
                "9400",
                "Total price for range 1000-4999 is incorrect");
        driver.quit();
    }

    @Test
    public void discountAndTotalPriceForRangeFrom5000To9999Books() {
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
        driver.findElement(By.name("keyword")).sendKeys("White Fang");
        driver.findElement(By.cssSelector("[value = Search]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'add_to_cart')]")).click();
        driver.findElement(By.xpath("//a[contains(@href,'shopping_cart')]")).click();
        driver.findElement(By.xpath("//input[contains(@value, '1')]")).clear();
        driver.findElement(By.xpath("//input[2]")).isSelected();
        driver.findElement(By.name("q")).sendKeys("5000");
        driver.findElement(By.cssSelector("[value = Update]")).click();
        String discountFor19Books = driver.findElement(By.xpath("((//tr)[9]//td)[5]")).getText();
        Assert.assertEquals(discountFor19Books,
                "7",
                "Discount for range 5000-9999 is incorrect");
        String priceFor19Books = driver.findElement(By.xpath("((//tr)[9]//td)[7]")).getText();
        Assert.assertEquals(priceFor19Books,
                "46500",
                "Total price for range 5000-9999 is incorrect");
        driver.quit();
    }

    @Test
    public void discountAndTotalPriceForRangeFrom10000Books() {
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
        driver.findElement(By.name("keyword")).sendKeys("White Fang");
        driver.findElement(By.cssSelector("[value = Search]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'add_to_cart')]")).click();
        driver.findElement(By.xpath("//a[contains(@href,'shopping_cart')]")).click();
        driver.findElement(By.xpath("//input[contains(@value, '1')]")).clear();
        driver.findElement(By.xpath("//input[2]")).isSelected();
        driver.findElement(By.name("q")).sendKeys("10000");
        driver.findElement(By.cssSelector("[value = Update]")).click();
        String discountFor19Books = driver.findElement(By.xpath("((//tr)[9]//td)[5]")).getText();
        Assert.assertEquals(discountFor19Books,
                "8",
                "Discount for range 10000> is incorrect");
        String priceFor19Books = driver.findElement(By.xpath("((//tr)[9]//td)[7]")).getText();
        Assert.assertEquals(priceFor19Books,
                "92000",
                "Total price for range 10000> is incorrect");
        driver.quit();
    }
}
