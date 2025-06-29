import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class practice {
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\artha\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.xpath("//select"));
        Select select = new Select(element);
        select.selectByIndex(6);
        List<WebElement> options = select.getOptions();
        for(int i = 0; i< options.size(); i++)
        {
            System.out.println(options.get(i).getText());
        }
    }
}
