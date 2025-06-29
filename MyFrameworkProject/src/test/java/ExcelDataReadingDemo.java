import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelDataReadingDemo
{
    @DataProvider
    public static Object[][] getData() throws IOException, InterruptedException
    {
        File file = new File(System.getProperty("user.dir") + "\\Book1.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        XSSFSheet sheet = workbook.getSheet("Sheet1");
        int lastRowNum = sheet.getLastRowNum();
        int lastColNum = sheet.getRow(0).getLastCellNum();

        Object[][] obj = new Object[lastRowNum][lastColNum];

        for (int i = 1; i <= lastRowNum; i++) {
            for (int j = 0; j < lastColNum; j++) {
                obj[i - 1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
            }
        }
        return obj;
    }

    @Test(dataProvider = "getData")
    public void loginTest(String username, String password) throws InterruptedException, IOException
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();Thread.sleep(5000);


        driver.findElement(By.xpath("//div/input[@name=\"username\"]")).sendKeys(username);
        driver.findElement(By.xpath("//div/input[@name=\"password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//div/button[@type=\"submit\"]")).click();
        Thread.sleep(5000);


        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir")+"\\ts1.png");
        FileHandler.copy(source,target);
    }
}



