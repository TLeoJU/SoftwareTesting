package org.example.lab5;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginFormTest {
    private static ChromeDriver driver;
    private static WebDriverWait wait;
    WebElement usernameInput;
    WebElement passwordInput;
    WebElement loginButton;

    @BeforeClass
    public static void initTest() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options); //创建驱动对象（启动浏览器）
        driver.manage().window().maximize();    //窗口最大化
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //使用WebDriverWait来处理加载所需的等待
        driver.get("https://the-internet.herokuapp.com/login");   //访问这什么网页
//        Thread.sleep(3000); //等待网页加载
    }

    @AfterClass
    public static void endTest() {
        //关闭浏览器窗口
        driver.quit();
    }

    @Before
    public void getInputBoxes() {
        //获取用户名输入框、密码输入框、登录按钮
        usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
    }

    @After
    public void cleanInputBoxes() {
        //如果网页发生跳转，保存的WebElement可能失效，此处重新获取元素，并清空输入
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).clear();
    }

    @Test
    public void testCorrectInputs() {
        //输入正确的账户密码并登录
        usernameInput.sendKeys("tomsmith");
        passwordInput.sendKeys("SuperSecretPassword!");
        loginButton.click();
        //获取顶部提示成功的横条
        WebElement topMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".flash.success")));
        //确认横条已展示
        assertTrue("check if the top green message is displayed", topMessage.isDisplayed());
        //获取跳转后的url
        String currentUrl = driver.getCurrentUrl();
        //确认当前url指向首页
        assertEquals("check current Url is the home page",
                "https://the-internet.herokuapp.com/secure", currentUrl);
        //回退网页
        driver.navigate().back();
    }

    @Test
    public void testIncorrectInputs1() {
        //输入正确账户、错误密码并尝试登录
        usernameInput.sendKeys("tomsmith");
        passwordInput.sendKeys("youGotAWrongPassword");
        loginButton.click();
        //获取顶部提示失败的横条
        WebElement topMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".flash.error")));
        //确认横条已展示
        assertTrue("check if the top red message is displayed", topMessage.isDisplayed());
    }

    @Test
    public void testIncorrectInputs2() {
        //输入错误账户、正确密码并尝试登录
        usernameInput.sendKeys("youGotAWrongUsername");
        passwordInput.sendKeys("SuperSecretPassword!");
        loginButton.click();
        //获取顶部提示失败的横条
        WebElement topMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".flash.error")));
        //确认横条已展示
        assertTrue("check if the top red message is displayed", topMessage.isDisplayed());
    }

    @Test
    public void testIncorrectInputs3() {
        //输入错误账户密码并尝试登录
        usernameInput.sendKeys("(0v0)wokeUP!");
        passwordInput.sendKeys("(-v-)sleeping");
        loginButton.click();
        //获取顶部提示失败的横条
        WebElement topMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".flash.error")));
        //确认横条已展示
        assertTrue("check if the top red message is displayed", topMessage.isDisplayed());
    }
}
