import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class OrangeScreenShot
{
    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div/input[@name=\"username\"]")).sendKeys("Admin");
        driver.findElement(By.xpath("//div/input[@name=\"password\"]")).sendKeys("admin123");
        driver.findElement(By.xpath("//div/button[@type=\"submit\"]")).click();
        Thread.sleep(5000);
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir")+"\\rajad.png");
        FileUtils.copyFile(source,target);

    }
}
