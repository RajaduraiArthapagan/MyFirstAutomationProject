import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionDemo
{
    public static void main(String[] args) throws InterruptedException
    {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div/input[@name=\"username\"]")).sendKeys("Admin");
        driver.findElement(By.xpath("//div/input[@name=\"password\"]")).sendKeys("admin123");
        driver.findElement(By.xpath("//div/button[@type=\"submit\"]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//li/a/span[text()='Admin']")).click();
        Thread.sleep(5000);
        Actions action = new Actions(driver);
        WebElement job = driver.findElement(By.xpath("//li/span[text()='Job ']"));
        action.click(job).build().perform();
        Thread.sleep(5000);
        WebElement empStatus = driver.findElement(By.xpath("//li/a[text()='Employment Status']"));
        action.click(empStatus).build().perform();

    }
}
