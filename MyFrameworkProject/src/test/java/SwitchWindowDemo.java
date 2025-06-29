import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SwitchWindowDemo
{
    public static void main(String[] args) throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();
        Thread.sleep(5000);
        String handle = driver.getWindowHandle();
        System.out.println(handle);

        Set<String> handles = driver.getWindowHandles();
        System.out.println(handles);
        List<String> myList = new ArrayList<>(handles);
        driver.switchTo().window(myList.get(0));
        driver.findElement(By.xpath("//div/input[@name=\"username\"]")).sendKeys("Admin");
        driver.findElement(By.xpath("//div/input[@name=\"password\"]")).sendKeys("admin123");
        driver.findElement(By.xpath("//div/button[@type=\"submit\"]")).click();
        Thread.sleep(5000);

        driver.switchTo().window(myList.get(1));
        driver.findElement(By.linkText("Contact Sales")).click();
        driver.close();
        driver.switchTo().window(myList.getFirst());
        driver.close();
    }
}
