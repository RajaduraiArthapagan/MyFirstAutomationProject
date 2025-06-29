
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDataReading
{
    public static void main(String[] args) throws IOException {
        File file = new File(System.getProperty("user.dir")+"\\Book1.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        XSSFSheet sheet = workbook.getSheet("Sheet1");

        int lastRowNum = sheet.getLastRowNum();
        int lastColNum = sheet.getRow(0).getLastCellNum();

        System.out.println(lastColNum);
        System.out.println(lastRowNum);

        for(int i = 0; i<=lastRowNum; i++)
        {
            for(int j = 0; j<lastColNum; j++)
            {
                System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
            }
        }

    }
}
