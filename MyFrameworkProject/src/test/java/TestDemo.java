import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestDemo extends BaseTest
{
    @Test
    public void testDemo() throws InterruptedException
    {
        driver.findElement(By.xpath("//div/input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//div/input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//div/button[@type='submit']")).click();
        Thread.sleep(5000);
    }
}
