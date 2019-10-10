package mavanPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HMSReg 
{
	private	WebDriver driver;

	@Test(description="Test to check HMS Registration funcationality")
	public void f() throws Exception 
	{
		//Login
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();

		//Navigate to Registration
		driver.findElement(By.linkText("Registration")).click();

		//Registration
		new Select(driver.findElement(By.name("PATIENT_CAT"))).selectByVisibleText("Insurance");
		new Select(driver.findElement(By.name("TITLE"))).selectByVisibleText("Mr.");
		driver.findElement(By.name("PNT_NAME")).sendKeys("Sara");
		driver.findElement(By.name("MIDDLE_NAME")).sendKeys("Murali");
		driver.findElement(By.name("LAST_NAME")).sendKeys("Krishna");
		driver.findElement(By.name("DOB")).click();
		driver.findElement(By.className("tcalSelected")).click();
		driver.findElement(By.name("AGE")).sendKeys("25");
		new Select(driver.findElement(By.name("SEX"))).selectByVisibleText("Male");
		new Select(driver.findElement(By.name("MTRL_STATUS"))).selectByVisibleText("Single");
		new Select(driver.findElement(By.name("RELIGION"))).selectByVisibleText("Hindu");
		new Select(driver.findElement(By.name("PLANGUAGE"))).selectByVisibleText("Telugu");
		driver.findElement(By.name("ADDRESS1")).sendKeys("Secunderabad");
		driver.findElement(By.name("MOBILE_NO")).sendKeys("9999999999");
		driver.findElement(By.name("EMAIL_ID")).sendKeys("SMK@gmail.com");
		new Select(driver.findElement(By.name("COUNTRY_CODE"))).selectByVisibleText("India");


		new Select(driver.findElement(By.name("RELATION"))).selectByVisibleText("Father");
		driver.findElement(By.name("MOTHER_NAME")).sendKeys("Padma");
		new Select(driver.findElement(By.name("PAT_IDENTITY"))).selectByVisibleText("PAN Card");
		driver.findElement(By.name("PAT_IDENTITY_PROOF")).sendKeys("XXXXXXXXXX");
		new Select(driver.findElement(By.name("NATIONALITY"))).selectByVisibleText("Indian");
		new Select(driver.findElement(By.name("IS_MLC"))).selectByVisibleText("Yes");
		new Select(driver.findElement(By.name("EDUCATION"))).selectByVisibleText("B.Tech");
		new Select(driver.findElement(By.name("OCCUPATION"))).selectByVisibleText("Employee");
		new Select(driver.findElement(By.name("BLOOD_GRP_CODE"))).selectByVisibleText("B+");
		new Select(driver.findElement(By.name("CITIZENSHIP"))).selectByVisibleText("Indian");
		new Select(driver.findElement(By.name("SC_PROOF"))).selectByVisibleText("Yes");
		driver.findElement(By.name("ADDRESS2")).sendKeys("Secundrabad");
		driver.findElement(By.name("ZIP")).sendKeys("500010");

		//Upload image
		driver.findElement(By.name("image")).sendKeys("D:\\img007.jpg");

		driver.findElement(By.name("submit")).click();
		//Alert
		String str=driver.switchTo().alert().getText();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		System.out.println(str);

	}

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browsername) 
	{
		if (browsername.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "D:\\\\Murali_Selenium\\\\Library\\\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\Murali_Selenium\\Library\\geckodriver.exe");
			driver=new FirefoxDriver();	 
		}
		else if(browsername.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "D:\\Murali_Selenium\\Library\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://selenium4testing.com/hms/");

	}

	@AfterTest
	public void afterTest() throws Exception 
	{
		//Thread.sleep(2000);
		//driver.quit();
	}

}
