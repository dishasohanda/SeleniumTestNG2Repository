package PK1OrangeHRM;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;

public class OrangeHRMusingSeleniumIDECode {
 
  
	WebDriver driver;
	@Test(dataProvider = "excelData",priority = 1)
	  public void orangeHRMLogin(String Browser,String UserName,String PassWord,String FirstName,String MiddleName,String LastName) throws InterruptedException {
		  
		  if (Browser.equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver", "./Browsers/chromedriver.exe"); //where chromedriver exists(path)
				 driver = new ChromeDriver(); //To open Chrome Browser
				
			}
			
			if (Browser.equals("Edge")) {
				System.setProperty("webdriver.edge.driver", "./Browsers/msedgedriver.exe");//where Edge exists(path)
				 driver = new EdgeDriver(); //To open Edge Browser
			} 
		  
		  
		  
		  
		Thread.sleep(5000);
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    driver.manage().window().setSize(new Dimension(1382, 744));
	   // driver.findElement(By.name("username")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.name("username")).sendKeys(UserName);
	    driver.findElement(By.name("password")).sendKeys(PassWord);
	    Thread.sleep(2000);
	    driver.findElement(By.cssSelector(".oxd-button")).click();
	    try {
	      Thread.sleep(5000);
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    }
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//div[@id=\'app\']/div/div/aside/nav/div[2]/ul/li[2]/a/span")).click();
	    try {
	      Thread.sleep(2000);
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    }
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("(//button[@type=\'button\'])[5]")).click();
	    try {
	      Thread.sleep(2000);
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    }
	    driver.findElement(By.name("firstName")).sendKeys(FirstName);
	    driver.findElement(By.name("middleName")).sendKeys(MiddleName);
	    driver.findElement(By.name("lastName")).sendKeys(LastName);
	    driver.findElement(By.xpath("//div[2]/div/div/div[2]/input")).sendKeys(Keys.CONTROL+"A"+ Keys.BACK_SPACE);
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//button[2]")).click();
	  }
	  
	  
	//Below code is to pass the data from Excel
	  @DataProvider(name = "excelData")
	  public Object[][] excelDataProvider() throws IOException {

	      // We are creating an object from the excel sheet data by calling a method that
	      // reads data from the excel stored locally in our system
	      Object[][] arrObj = getExcelData(
	              "D:\\Disha Sohanda-Projects\\SeleniumTestNG2\\TestData\\TestDataSheet.xlsx","OrangeHRM");
	      return arrObj;
	}

	  // This method handles the excel - opens it and reads the data from the
	  // respective cells using a for-loop & returns it in the form of a string array
	  public String[][] getExcelData(String fileName, String sheetName) throws IOException {
	      String[][] data = null;
	      try {

	          FileInputStream fis = new FileInputStream(fileName);
	          XSSFWorkbook workbook = new XSSFWorkbook(fis);
	          XSSFSheet sheet = workbook.getSheet(sheetName);
	          XSSFRow row = sheet.getRow(0);
	          int noOfRows = sheet.getPhysicalNumberOfRows();
	          int noOfCols = row.getLastCellNum();
	          XSSFCell cell;
	          data = new String[noOfRows - 1][noOfCols];

	          for (int i = 1; i < noOfRows; i++) {
	              for (int j = 0; j < noOfCols; j++) {
	                  row = sheet.getRow(i);
	                  cell = row.getCell(j);
	                  data[i - 1][j] = cell.getStringCellValue();
	              }
	          }
	      } catch (Exception e) {
	          System.out.println("The exception is: " + e.getMessage());
	      }
	      return data;
	  }
	  
	  

	  
  

 //@DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  
}
