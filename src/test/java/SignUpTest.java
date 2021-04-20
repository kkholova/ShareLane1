import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class SignUpTest {

    @Test
    public void zipCodeShouldBe5Digits() {
//        установка переменной среды стр 14
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//          Open the page      https://sharelane.com/cgi-bin/register.py
        driver.get("https://sharelane.com/cgi-bin/register.py");
//          Insert any 5 digits (11111)
        driver.findElement(By.name("zip_code")).sendKeys("11111");
//                Click on  Continue
//        driver.findElement(By.name("zip_code")).submit();
//        или
        driver.findElement(By.cssSelector("[value = Continue]")).click();
//           Get sure we are on Sign Up page
        boolean isOpened = driver.findElement(By.cssSelector("[value = Register]")).isDisplayed();
        assertTrue(isOpened, "Sign Up page wasn't opened");
//        Close browser
        driver.quit();
    }
    @Test
    public void zipCodeShouldNotBe6Digits() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("111111");
        driver.findElement(By.cssSelector("[value = Continue]")).click();
        String error = driver.findElement(By.cssSelector("[class= error_message]")).getText();
        Assert.assertEquals(error, "Oops, error on page. ZIP code should have 5 digits",
                "zip_code Error message is incorrect");
//        Close browser
        driver.quit();
    }

    @Test
    public void zipCodeShouldNotBe4Digits() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value = Continue]")).click();
        String error = driver.findElement(By.cssSelector("[class= error_message]")).getText();
        Assert.assertEquals(error, "Oops, error on page. ZIP code should have 5 digits",
                "zip_code Error message is incorrect");
//        Close browser
        driver.quit();
    }

    @Test
    public void successfulSignUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("11111");
        driver.findElement(By.cssSelector("[value = Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Alex");
        driver.findElement(By.name("last_name")).sendKeys("Brown");
        driver.findElement(By.name("email")).sendKeys("mail@mail.com");
        driver.findElement(By.name("password1")).sendKeys("1111");
        driver.findElement(By.name("password2")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value = Register]")).click();
        boolean isSignedUp = driver.findElement(By.cssSelector("[class = confirmation_message]")).isDisplayed();
        assertTrue(isSignedUp, "SignUp is failed");
        driver.quit();
    }

    @Test
    public void signUpFailureWithEmptyFirstName() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("11111");
        driver.findElement(By.cssSelector("[value = Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("");
        driver.findElement(By.name("last_name")).sendKeys("Brown");
        driver.findElement(By.name("email")).sendKeys("mail@mail.com");
        driver.findElement(By.name("password1")).sendKeys("1111");
        driver.findElement(By.name("password2")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value = Register]")).click();
        String errorForSignUp1 = driver.findElement(By.cssSelector("[class= error_message]")).getText();
        Assert.assertEquals(errorForSignUp1,
                "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Sign Up with empty first name has failed");
        driver.quit();
    }

    @Test
    public void signUpFailureWithEmptyEmail() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("11111");
        driver.findElement(By.cssSelector("[value = Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Alex");
        driver.findElement(By.name("last_name")).sendKeys("Brown");
        driver.findElement(By.name("email")).sendKeys("");
        driver.findElement(By.name("password1")).sendKeys("1111");
        driver.findElement(By.name("password2")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value = Register]")).click();
        String errorForSignUp1 = driver.findElement(By.cssSelector("[class= error_message]")).getText();
        Assert.assertEquals(errorForSignUp1,
                "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Sign Up with empty email has failed");
        driver.quit();
    }

    @Test
    public void signUpFailureWithWrongStructureOfEmail() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("11111");
        driver.findElement(By.cssSelector("[value = Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Alex");
        driver.findElement(By.name("last_name")).sendKeys("Brown");
        driver.findElement(By.name("email")).sendKeys("mail_gmail");
        driver.findElement(By.name("password1")).sendKeys("1111");
        driver.findElement(By.name("password2")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value = Register]")).click();
        String errorForSignUp1 = driver.findElement(By.cssSelector("[class= error_message]")).getText();
        Assert.assertEquals(errorForSignUp1,
                "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Sign Up with wrong email structure has failed");
        driver.quit();
    }

    @Test
    public void signUpFailureWithNoFullStructureOfEmail() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("11111");
        driver.findElement(By.cssSelector("[value = Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Alex");
        driver.findElement(By.name("last_name")).sendKeys("Brown");
        driver.findElement(By.name("email")).sendKeys("mail@gmail.");
        driver.findElement(By.name("password1")).sendKeys("1111");
        driver.findElement(By.name("password2")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value = Register]")).click();
        String errorForSignUp1 = driver.findElement(By.cssSelector("[class= error_message]")).getText();
        Assert.assertEquals(errorForSignUp1,
                "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Sign Up with not full email structure has failed");
        driver.quit();
    }

    @Test
    public void signUpFailureWithNotEqualPasswordFields() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("11111");
        driver.findElement(By.cssSelector("[value = Continue]")).click();
        driver.findElement(By.name("first_name")).sendKeys("Alex");
        driver.findElement(By.name("last_name")).sendKeys("Brown");
        driver.findElement(By.name("email")).sendKeys("mail@gmail.ru");
        driver.findElement(By.name("password1")).sendKeys("11111");
        driver.findElement(By.name("password2")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value = Register]")).click();
        String errorForSignUp1 = driver.findElement(By.cssSelector("[class= error_message]")).getText();
        Assert.assertEquals(errorForSignUp1,
                "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Sign Up with Not equal Passwords has failed");
        driver.quit();
    }

    @Test
    public void checkOfTypeOfPasswordField() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("11111");
        driver.findElement(By.cssSelector("[value = Continue]")).click();
        String typeOfPassword1Field = driver.findElement(By.cssSelector("[name = password1]")).getAttribute("type");
        Assert.assertEquals(typeOfPassword1Field,
                "password",
                "Field Password is not of password type");
        driver.quit();
    }

    @Test
    public void successfulLogIn() {
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
//        String userPassword = driver.findElement(By.xpath("//td[contains(text(),'Password')]/following-sibling::")).toString();
        driver.findElement(By.xpath("//a[contains(text(),'here')]")).click();
        driver.findElement(By.cssSelector("[name = email]")).sendKeys(email);
        driver.findElement(By.cssSelector("[name = password]")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value = Login]")).click();
       boolean isLoggedIn = driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).isDisplayed();
        assertTrue(isLoggedIn, "Log in has failed");
        driver.quit();
    }

}
