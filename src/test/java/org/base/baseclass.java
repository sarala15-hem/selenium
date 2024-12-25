package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseclass {
	public static WebDriver driver;
	
	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
	}
	public static void WindowMaximize() {
		driver.manage().window().maximize();
	}
	public static void launchUrl(String url) {
		driver.get(url);
	}
	public static void PageTitle() {
		String title=driver.getTitle();
		System.out.println(title);
	}
	public static void PageUrl() {
		String Url = driver.getCurrentUrl();
		System.out.println(Url);
	}
	public static void PassText(String Txt,WebElement ele) {
		ele.sendKeys(Txt);
	}
	public static void closeEntireBrowse() {
		driver.quit();
	}
	public static void clickBtn(WebElement ele) {
		ele.click();
	}
	public static void Screenshot(String imgName) throws IOException{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File image=ts.getScreenshotAs(OutputType.FILE);
		File f=new File("location+imgNme.png");
		FileUtils.copyFile(image, f);
		
	}
	public static Actions a;
	
	public static void moveTheCursor(WebElement target ) {
		a=new Actions(driver);
		a.moveToElement( target).perform();
		
	}
	public static void dragDrop(WebElement dragWebElement,WebElement dropElement) {
		a=new Actions(driver);
		a.dragAndDrop(dragWebElement, dropElement).perform();
		
	}
	public static JavascriptExecutor js;
	public static void scrollThePage(WebElement tarwebele) {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false),");
	}
	public static void excelRead(String sheetName,int rowNum, int cellNum, String value) throws IOException {
		File f=new File("excelLocations.xlsx");
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet mySheet=wb.getSheet("Datas");
		XSSFRow r = mySheet.getRow(rowNum);
		XSSFCell c = r.getCell(cellNum);
		int cellType = c.getCellType();
		String Type=" ";
		if(cellType==1) {
			String Value2=c.getStringCellValue();
		}
		else if(DateUtil.isCellDateFormatted(null)){
			Date dd = c.getDateCellValue();
			SimpleDateFormat s=new SimpleDateFormat(value);
			String value1 = s.format(dd);
		}
		else {
			double d = c.getNumericCellValue();
			long l=(long)d;
			String valueOf = String.valueOf(l);
		}
		}
	
	public static void createNexwExcelFile(int rowNum,int cellNum,String writeData)throws IOException {
		File f=new File("Exce Location.xlsx");
		XSSFWorkbook w=new XSSFWorkbook();
		XSSFSheet newsheet = w.createSheet("Datas");
		XSSFRow newrow = newsheet.createRow(rowNum);
		XSSFCell newcell = newrow.createCell(cellNum);
		newcell.setCellValue(writeData);
		FileOutputStream fos=new FileOutputStream(f);
		w.write(fos);
		}
	public static void createCell(int getRow,int creCell,String newData) throws IOException{
		File f=new File("ExcelLocations.xlsx");
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet s = wb.getSheet("Datas");
		XSSFRow r = s.getRow(getRow);
		XSSFCell c = r.createCell(creCell);
		c.setCellValue(newData);
		FileOutputStream fos=new FileOutputStream(f);
		wb.write(fos);
		}
	public static void createRow(int creRow,int creCell,String newData) throws IOException {
		
		File f=new File("ExcelLocation.xlsx");
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet s = wb.getSheet("Datas");
		XSSFRow r = s.createRow(creRow);
		XSSFCell c = r.createCell(creCell);
		c.setCellValue(newData);
		FileOutputStream fos=new FileOutputStream(f);
		wb.write(fos);
		}
	public static void updateDataToParticularCell(int getTheRow,int getTheCell,String exixtingData,String wrtieNewData) throws IOException {
		File f=new File("ExcelLocation.xlsx");
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet s = wb.getSheet("Datas");
		XSSFRow r = s.getRow(getTheRow);
		XSSFCell c = r.getCell(getTheCell);
		String str = c.getStringCellValue();
		if(str.equals(exixtingData)) {
			c.setCellValue(wrtieNewData);
		}
		FileOutputStream fos=new FileOutputStream(f);
		wb.write(fos);
		}
	
	
	

	
	

}
