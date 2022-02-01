package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass1 {
	public static WebDriver driver;

	public static WebDriver launchBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
		}
		if (browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.chromedriver().setup();
			driver = new EdgeDriver();
		}

		return driver;
	}

	public static void maximize() {
		driver.manage().window().maximize();
	}

	public static void implicitWait(long sec) {

		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}

	public static void launchurl(String url) {
		driver.get(url);
	}

	public static void sendkeys(WebElement e, String value) {
	 e.sendKeys(value);
	}

	public static void btnclick(WebElement e) {
		e.click();
	}

	public static void quit() {
		driver.quit();
	}
	public static void close() {
		driver.close();
	}

	public static String getcurrenturl() {
		String url = driver.getCurrentUrl();
		return url;
	}
public static void nextscreen() {
	nextscreen();

}
	public static String getTitle() {
		return driver.getTitle();
	}

	public static String getAttribute(WebElement e) {
		String a = e.getAttribute("value");
		return a;
	}

	public static String getText(WebElement e) {
		String at = e.getText();
		return at;
	}

	public static void click(WebElement e) {

		e.click();
	}
public static void dragAndDrop(WebElement src,WebElement target) {
	Actions a = new Actions(driver);
	a.dragAndDrop(src, target).perform();
}
public static void moveToElement(WebElement e) {
	Actions a = new Actions(driver);
}
public static void actionClick() {
	Actions a = new Actions(driver);
	a.click().perform();
}
public static void doubleClick(WebElement e) {
	Actions a = new Actions(driver);
	a.doubleClick(e).perform();
}
public static void contextClick(WebElement e) {
	Actions a = new Actions(driver);
	a.contextClick().perform();
}
public static void simpleAlert() {
	Alert alert = driver.switchTo().alert();
	alert.accept();
}
public static void confirmAlert() {
	Alert alert = driver.switchTo().alert();
	alert.dismiss();
}
public static void promptAlert(String value) {
	Alert alert = driver.switchTo().alert();
	alert.sendKeys(value);
	alert.accept();
}
public static void selectByIndex(WebElement e,int index) {
	Select s = new Select(e);
    s.selectByIndex(index);
}
public static void selectByValue(WebElement e,String value) {
	Select s = new Select(e);
    s.selectByValue(value);
}
public static void selectByVisibleText(WebElement e, String Text) {
    Select s = new Select(e);
    s.selectByVisibleText(Text);
}
public static boolean isMultiple(WebElement e) {
	Select s = new Select(e);
	return s.isMultiple();
}
public static String getFirstSelectedOption(WebElement e) {
	Select s = new Select(e);
    WebElement firstoption=s.getFirstSelectedOption();
    return firstoption.getText();
}
public static void deSelectByIndex(WebElement e,int index) {
	Select s = new Select(e);
	s.deselectByIndex(index);
}
public static void deSelectByValue(WebElement e,String value) {
	Select s= new Select(e);
    s.deselectByValue(value);
}
public static void deSelectByVisibleText(WebElement e,String text) {
	Select s= new Select(e);
    s.deselectByVisibleText(text);
}
public static void deSelectAll(WebElement e) {
	Select s= new Select(e);
    s.deselectAll();
}

	public static void screenShot(String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        File des=new File("C:\\Users\\Tamil\\eclipse-workspace\\MavenDay1\\Screenshot\\"+name+".png");
        FileUtils.copyFile(src, des);
	}
	public static void setAttribute(String text,WebElement e) {
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value',"+text+")", e);
	}
	public static String getAttribute1(WebElement e) {
		JavascriptExecutor js =(JavascriptExecutor)driver;
		Object at = js.executeScript("return arguments[0].getAttribute('value')", e);
		return at.toString();
	}
	public static void javaClick(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("argument[0].click()", e);
	}
	public static void scrolldown(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("argument[0].scrollIntoView(true)", e);
	}
	public static void scrollup(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("argument[0].scrollIntoView(false)", e);
	}
	public static void frameIndex(int index) {
		driver.switchTo().frame(index);
	}
	public static void frameName(String name) {
		driver.switchTo().frame(name);
	}
	public static void frameWebElement(WebElement e) {
		driver.switchTo().frame(e);
	}
	public static void defaultContent() {
		driver.switchTo().defaultContent();
	}
	public static void parentFrame() {
		driver.switchTo().parentFrame();
	}
	public static String gethandle() {
		return driver.getWindowHandle();
	}
	public static void gethandles(int index) {
		Set<String> s=driver.getWindowHandles();
		List<String> li = new ArrayList<String>();
		li.addAll(s);
		driver.switchTo().window(li.get(index));
	}
	public static void navigateurl(String url) {
		driver.navigate().to(url);
	}
	public static void back() {
		driver.navigate().back();
	}
	public static void forward() {
		driver.navigate().forward();
	}
	public static void refresh() {
		driver.navigate().refresh();
	}
	public static boolean isDisplayed(WebElement e) {
		return e.isDisplayed();
	}
	public static boolean isEnabled(WebElement e) {
		return e.isEnabled();
	}
	public static boolean isSelected(WebElement e) { 
		return e.isSelected();
	}
//	public static String excel(String name,String sheetname,int rono,int ceno) throws IOException {
//		File f = new File("C:\\Users\\Tamil\\eclipse-workspace\\MavenDay1\\src\\test\\resources\\"+name+".xlsx");
//		FileInputStream fi = new FileInputStream(f);
//		Workbook w = new XSSFWorkbook(fi);
//		Sheet s = w.getSheet(sheetname);
//		Row r = s.getRow(rono);
//		Cell c = r.getCell(ceno);
//		
//		int type = c.getCellType();
//		
//		String value=null;
//		if(type==1) {
//			 value = c.getStringCellValue();
//		}
//		else {
//			if(DateUtil.isCellDateFormatted(c)) {
//				Date date = c.getDateCellValue();
//				SimpleDateFormat s1 = new SimpleDateFormat("dd-MM-yyyy");
//				 value  = s1.format(date);
//			}
//			else {
//				double  db= c.getNumericCellValue();
//				long ln=(long)db;
//				 value = String.valueOf(ln);
//		}
//		
//		}
//		return value;
//
//	}
	public static WebElement findElement(String locatorname, String loc) {
		WebElement e = null;
		if (locatorname.equals("id")) {
			e = driver.findElement(By.id(loc));
		} else if (locatorname.equals("name")) {
			e = driver.findElement(By.name(loc));
		} else if (locatorname.equals("xpath")) {
			e = driver.findElement(By.xpath(loc));
		}
		return e;

	}
}
