import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Recall
{
    public static void main(String[] args) throws InterruptedException
    {
       System.setProperty("webdriver.chrome.driver","C:\\Users\\artha\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
       WebDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
       Thread.sleep(5000);
       driver.findElement(By.xpath("//div/input[@name=\"username\"]")).sendKeys("Admin");
       driver.findElement(By.xpath("//div/input[@name=\"password\"]")).sendKeys("admin123");
       driver.findElement(By.xpath("//div/button[@type=\"submit\"]")).click();
       //driver.close();

       driver.get("https://practice.expandtesting.com/dropdown#google_vignette");
       driver.manage().window().maximize();
       Thread.sleep(5000);
       WebElement element = driver.findElement(By.id("country"));
       Select select = new Select(element);
       select.selectByValue("AL");
       Thread.sleep(5000);
       select.selectByVisibleText("Bermuda");

       List<WebElement> options = select.getOptions();
       for(int i = 0; i<options.size(); i++)
       {
           System.out.println(options.get(i).getText());
       }
    }
}
