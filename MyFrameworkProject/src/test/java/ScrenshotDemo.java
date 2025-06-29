import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class ScrenshotDemo
{
    public static void main(String[] args) throws IOException, InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice.expandtesting.com/upload");
        driver.manage().window().maximize();
        WebElement uploadField = driver.findElement(By.id("fileInput"));
        uploadField.sendKeys("C:\\Users\\artha\\Desktop\\RAJA.txt");
       Thread.sleep(5000);
       driver.findElement(By.id("fileSubmit")).click();

        Thread.sleep(5000);
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir")+"\\sample1.png");
        FileUtils.copyFile(source,target);
    }
}
