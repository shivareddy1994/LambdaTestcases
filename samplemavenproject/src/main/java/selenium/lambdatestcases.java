package selenium;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class lambdatestcases {
	
	public WebDriver driver;
	@BeforeMethod
	public void startbrowser() throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shiva\\OneDrive\\Desktop\\chromedriver.exe");
		driver=  new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.lambdatest.com/selenium-playground/");
		driver.manage().window().maximize();
		File s = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(s, new File("C:\\Users\\shiva\\eclipse-workspace\\samplemavenproject\\screenshots\\snap.png"));
	}
	@Test()
	public void testcase1() throws InterruptedException, IOException {
		
		System.out.println(driver.getTitle());
		WebElement ele=driver.findElement(By.xpath("//a[text()='Simple Form Demo']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",ele);
		String url= driver.getCurrentUrl();
		if(url.contains("simple-form-demo")) {
			System.out.println("url contains the simple-form-demo and url is.."+url);
		}
		else {
			System.out.println("url does not contains the simple-form-demo.."+url);
		}
		File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(f, new File("C:\\Users\\shiva\\eclipse-workspace\\samplemavenproject\\screenshots\\snap1.png"));
		String s= "Welcome to LambdaTest12";
		driver.findElement(By.id("user-message")).sendKeys(s);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Get Checked value']")).click();
		Thread.sleep(1000);
		String s1=driver.findElement(By.xpath("//*[@id=\"user-message\"]/p[@id='message']")).getText();
		if(s.equals(s1)) {
			System.out.println("validation success.."+s1);
		}
		else {
			System.out.println("validation not success.."+s1);	
		}
		Thread.sleep(1000);
		File f1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(f1, new File("C:\\Users\\shiva\\eclipse-workspace\\samplemavenproject\\screenshots\\snap2.png"));
		driver.close();
	}
	@Test()
	public void testcase2() throws InterruptedException, IOException {
		driver.findElement(By.xpath("//a[text()='Drag & Drop Sliders']")).click();
		Thread.sleep(3000);
		File f2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(f2, new File("C:\\Users\\shiva\\eclipse-workspace\\samplemavenproject\\screenshots\\snap3.png"));
		WebElement scrollele=driver.findElement(By.xpath("//*[text()='Range Sliders']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()",scrollele);
		Thread.sleep(3000);
		WebElement trg= driver.findElement(By.xpath("//input[@class='sp__range' and @value=15]"));
		Thread.sleep(4000);
		Actions ac= new Actions(driver);
		ac.dragAndDropBy(trg, 120, 0).perform();
		Thread.sleep(4000);
		String value= driver.findElement(By.xpath("//output[@id='rangeSuccess']")).getText();
		if(Integer.parseInt(value)==95) {
			System.out.println("range slider moved to value 95.."+value);
		}
		else {
			System.out.println("range slider not moved to value 95.."+value);	
		}
		File f3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(f3, new File("C:\\Users\\shiva\\eclipse-workspace\\samplemavenproject\\screenshots\\snap4.png"));
		driver.close();
	}
	@Test()
	public void testcase3() throws InterruptedException, IOException {
		WebElement scrollele=driver.findElement(By.xpath("//*[text()='Radio Buttons Demo']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()",scrollele);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[text()='Input Form Submit']")).click();
		Thread.sleep(4000);
		File f4 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(f4, new File("C:\\Users\\shiva\\eclipse-workspace\\samplemavenproject\\screenshots\\snap5.png"));
		WebElement submt=driver.findElement(By.xpath("//input[@id='inputCity']"));
		WebElement Name=driver.findElement(By.xpath("//input[@id='name']"));
		WebElement email=driver.findElement(By.xpath("//input[contains(@id,'inputEmail')]"));
		WebElement password=driver.findElement(By.xpath("//input[contains(@id,'inputPassword')]"));
		WebElement company=driver.findElement(By.id("company"));
		WebElement website=driver.findElement(By.xpath("//input[@id='websitename']"));
		WebElement country=driver.findElement(By.xpath("//select[@name='country']"));
		WebElement city=driver.findElement(By.xpath("//input[@id='inputCity']"));
		WebElement address1=driver.findElement(By.xpath("//input[@id='inputAddress1']"));
		WebElement address2=driver.findElement(By.xpath("//input[@id='inputAddress2']"));
		WebElement state=driver.findElement(By.xpath("//input[@id='inputState']"));
		WebElement Zipcode=driver.findElement(By.xpath("//input[@id='inputZip']"));
		
		js.executeScript("arguments[0].scrollIntoView()",submt);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		File f5 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(f5, new File("C:\\Users\\shiva\\eclipse-workspace\\samplemavenproject\\screenshots\\snap6.png"));
		js.executeScript("arguments[0].value='shiva'",Name);
		js.executeScript("arguments[0].value='shiva.pla@email.com'",email);
		js.executeScript("arguments[0].value='shiva444'",password);
		js.executeScript("arguments[0].value='shivaada'",company);
		js.executeScript("arguments[0].value='shiva.opp.com'",website);
		Select se= new Select(country);
		se.selectByVisibleText("United States");
		js.executeScript("arguments[0].value='Hyderabad'",city);
		js.executeScript("arguments[0].value='shiva,100'",address1);
		js.executeScript("arguments[0].value='shiva,900'",address2);
		js.executeScript("arguments[0].value='Tealangana'",state);
		js.executeScript("arguments[0].value='500034'",Zipcode);
		Thread.sleep(4000);
		File f6 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(f6, new File("C:\\Users\\shiva\\eclipse-workspace\\samplemavenproject\\screenshots\\snap7.png"));
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(4000);
		WebElement temp=driver.findElement(By.xpath("//h1[text()='Dropdown Demo']"));
		WebElement successmsg=driver.findElement(By.xpath("//p[contains(text(),'Thanks for contacting us') and @style='display: block;']"));
		js.executeScript("arguments[0].scrollIntoView()",temp);
		Thread.sleep(4000);
		String finaltext=successmsg.getText();
		if(!finaltext.equals(" ")) {
			System.out.println("form submitted successfully..."+finaltext);
		}
		else {
			System.out.println("form failed to submit..."+finaltext);
		}
		File f7 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(f7, new File("C:\\Users\\shiva\\eclipse-workspace\\samplemavenproject\\screenshots\\snap8.png"));
		driver.close();
	}

}
