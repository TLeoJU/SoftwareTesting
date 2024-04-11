package org.example.lab5;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class BaiduTest {
    private static ChromeDriver driver;
    private static WebDriverWait wait;

    @BeforeClass
    public static void initTest() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options); //创建驱动对象（启动浏览器）
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //使用WebDriverWait来处理加载所需的等待
        driver.manage().window().maximize();    //窗口最大化
        driver.get("https://www.baidu.com/");   //访问百度
//        Thread.sleep(3000); //等待网页加载
        wait.until(ExpectedConditions.visibilityOfElementLocated(   //显式等待，当页面出现id为kw的元素（即搜索框）时，返回这个元素
                By.cssSelector("#kw"))).sendKeys("selenium"); //通过id为kw找到搜索框元素，输入selenium

        wait.until(ExpectedConditions.visibilityOfElementLocated(   //同理显式等待
                By.cssSelector("#su"))).click();  //通过id为su找到“百度一下”元素，模拟点击以启动搜索
    }

    @AfterClass
    public static void endTest() {
        //测试结束后退出浏览器
//        driver.quit();
    }

    @Test
    public void baiduTest1() {
        //等待搜索结果加载完毕后获取搜索结果元素
        List<WebElement> searchResults = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                //通过css选择器找到所有搜索结果，其中由于搜索结果类名不一，采用匹配方式选择
                By.cssSelector("div[class*=result][class*=c-container]")));
        assertTrue("Test number of results", searchResults.size() >= 10);
    }

    @Test
    public void baiduTest2() {
        //判断输入框内是否有"selenium"
        String searchText = driver.findElement(By.id("kw")).getAttribute("value");
        assertTrue("Test search box containing \"selenium\" or not", searchText.contains("selenium"));
    }

}
