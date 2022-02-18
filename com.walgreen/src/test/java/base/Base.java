package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Base {
	public static WebDriver driver;
	public static Properties locatorProp;
	public static Properties configProp;
	static FileInputStream fis;

@BeforeSuite
	
	public void setupWebDriver() throws IOException {
		String projectPath;
		projectPath=System.getProperty("user.dir");
		System.out.println(projectPath);
		fis=new FileInputStream(projectPath+"\\src\\test\\resources\\properties\\locator.properties");
		locatorProp=new Properties();
		locatorProp.load(fis);
		
		fis=new FileInputStream(projectPath+"\\src\\test\\resources\\properties\\config.properties");
		configProp=new Properties();
		configProp.load(fis);
		if(configProp.getProperty("browser").contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath+"\\src\\test\\resources\\executable\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(configProp.getProperty("browser").contains("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath+"\\src\\test\\resources\\executable\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
			
	}// setUpWebDriver()

	public void navigateURL(String url) {
		driver.get(url);

	}// navigateURL()

	public void click(By by) {
		driver.findElement(by).click();

	}

	public void sendKeys(By by, String keyvalue) {
		driver.findElement(by).sendKeys(keyvalue);

	}
	public void getText(By by) {
		driver.findElement(by).getText();
	
	}
//	@AfterSuite
//	public void close() {
//		driver.close();
//	}
}
