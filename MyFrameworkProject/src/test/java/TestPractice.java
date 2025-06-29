import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestPractice
{
    @DataProvider(parallel = true)
    public Object[][] getData() throws IOException
    {
        File file = new File(System.getProperty("user.dir")+"\\Book1.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        int lasRow = sheet.getLastRowNum();
        int lasCol = sheet.getRow(1).getLastCellNum();

        Object[][] a = new Object[lasRow][lasCol];
        for(int i = 1; i<=lasRow; i++)
        {
            for(int j = 0; j<lasCol; j++)
            {
                a[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
            }
        }
        return a;
    }

    @Test(dataProvider = "getData")
    public void testMethod(String username, String password)
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

}
