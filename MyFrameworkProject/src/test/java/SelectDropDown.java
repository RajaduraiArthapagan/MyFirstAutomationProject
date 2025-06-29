import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectDropDown
{
    public static void main(String[] args) throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\artha\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.id("course"));
        Select select = new Select(element);
        select.selectByIndex(1);
        Thread.sleep(5000);
        select.selectByValue("net");
        List<WebElement> options = select.getOptions();

        for(int i = 0; i< options.size(); i++)
        {
            String s = options.get(i).getText();
            System.out.println(s);
        }
    }
}
