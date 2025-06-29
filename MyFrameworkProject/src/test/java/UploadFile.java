import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadFile
{
    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice.expandtesting.com/upload");
        driver.manage().window().maximize();
        WebElement uploadField = driver.findElement(By.id("fileInput"));
        uploadField.sendKeys("C:\\Users\\artha\\Desktop\\RAJA.txt");
        driver.findElement(By.id("fileSubmit")).click();



    }
}
