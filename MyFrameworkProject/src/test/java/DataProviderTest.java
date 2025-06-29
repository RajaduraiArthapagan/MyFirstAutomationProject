import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest
{
    @DataProvider(parallel = true)
    public static Object[][] getData()
    {
        Object[][] obj = new Object[][]
                {{"Admin","admin123"},{"Admin","admin1234"}};
        return obj;
    }
    @Test(dataProvider = "getData")
    public void loginTest(String username, String password) throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div/input[@name=\"username\"]")).sendKeys(username);
        driver.findElement(By.xpath("//div/input[@name=\"password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//div/button[@type=\"submit\"]")).click();
        Thread.sleep(5000);

    }
}
