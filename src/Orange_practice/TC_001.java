package Orange_practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TC_001 {
	static String url="http://127.0.0.1/orangehrm-2.6/login.php";
	public static void main(String args[]) throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\webdrivers\\chromedriver\\version-102\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.navigate().to(url);
		driver.manage().window().maximize();
	   if(driver.getTitle().equals("Orange")) {
		   System.out.println("Title matched");
	   }
	   else {
		   System.out.println("Title not matched");
		   System.out.println(driver.getTitle());
	   }
	   
//git	   
//LOGIN 1.USERNAME&PASSWORD
	   driver.findElement(By.name("txtUserName")).sendKeys("admin");
	   driver.findElement(By.name("txtPassword")).sendKeys("admin");
	  //LOGIN 2.LOGIN FUNCTION WITH ENTER BUTTON 
	   Robot r=new Robot();
	   r.keyPress(KeyEvent.VK_TAB);//Virtual_KeyBoard
	   r.keyRelease(KeyEvent.VK_TAB);
	   r.keyPress(KeyEvent.VK_ENTER);
	   r.keyRelease(KeyEvent.VK_ENTER);
		//MOUSE OVER  ON BENEFITS
	   Actions ac=new Actions(driver);
	  ac.moveToElement(driver.findElement(By.xpath("//*[@id=\"benefits\"]/a/span"))).perform();
	  ac.moveToElement(driver.findElement(By.xpath("//*[@id=\"benefits\"]/ul/li[1]/a/span"))).perform();
	  ac.moveToElement(driver.findElement(By.xpath("//*[@id=\"benefits\"]/ul/li[1]/ul/li[5]/a/span"))).perform();
	  driver.findElement(By.xpath("//*[@id=\"benefits\"]/ul/li[1]/ul/li[5]/a/span")).click();
	  System.out.println("Mouse action done");
	  //ENTERING INTO FRAME
	  driver.switchTo().frame("rightMenu");
	  Select st = new Select(driver.findElement(By.id("year")));
	  st.selectByValue("2022");
	  System.out.println("The year was selected");
	  driver.findElement(By.xpath("//*[@id=\"frmSelectEmployee\"]/input[4]")).click();
	 //ENTERING INTO NEW WINDOW
	 ArrayList<String>windsinfo=new ArrayList<String>(driver.getWindowHandles());
	 driver.switchTo().window(windsinfo.get(1));
	 //CLICK FUNCTION IN NEW WINDOW
	  String al=driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/table/tbody/tr/td[2]/a")).getText();
	  System.out.println(al);
	  //driver.switchTo().window(windsinfo.get(0));
	  //driver.findElement(By.xpath("//*[@id=\"btnView\"]")).click();
	  
	  //as VIEW locators not working. So, clicking through ENTER KB
	  /*r.keyPress(KeyEvent.VK_TAB);
	  r.keyRelease(KeyEvent.VK_TAB);
	  Thread.sleep(2000);
	  r.keyPress(KeyEvent.VK_ENTER);
	  r.keyRelease(KeyEvent.VK_ENTER);*/		
	  System.out.println("function over");
	  driver.close();
	  driver.switchTo().window(windsinfo.get(0));
	  
	 /*  for(int i=1;i<=8;i++) {
	  r.keyPress(KeyEvent.VK_TAB);
	  r.keyRelease(KeyEvent.VK_TAB);
	  Thread.sleep(3000);
	  }*/
	   
	driver.findElement(By.linkText("Logout")).click();
	//driver.findElement(By.linkText("Change Password")).click();
	  
	 /* r.keyPress(KeyEvent.VK_TAB);	
	  r.keyRelease(KeyEvent.VK_TAB);
	  Thread.sleep(3000);
	  r.keyPress(KeyEvent.VK_TAB);
	  r.keyRelease(KeyEvent.VK_TAB);
	  Thread.sleep(3000);
	  r.keyPress(KeyEvent.VK_TAB);
	  r.keyRelease(KeyEvent.VK_TAB);
	  Thread.sleep(3000);
	  r.keyPress(KeyEvent.VK_TAB);
	  r.keyRelease(KeyEvent.VK_TAB);
	  Thread.sleep(3000);
	  r.keyPress(KeyEvent.VK_TAB);
	  r.keyRelease(KeyEvent.VK_TAB);
	  Thread.sleep(3000);
	  r.keyPress(KeyEvent.VK_TAB);
	  r.keyRelease(KeyEvent.VK_TAB);
	  Thread.sleep(3000);
	  //driver.switchTo().defaultContent();
	  r.keyPress(KeyEvent.VK_TAB);
	  r.keyRelease(KeyEvent.VK_TAB);
	  Thread.sleep(3000);*/
	 /* r.keyPress(KeyEvent.VK_ENTER);
	  r.keyRelease(KeyEvent.VK_ENTER);*/
	  	  System.out.println("The Logout function over");
	 // driver.findElement(By.xpath("/html/body/div[3]/ul/li[3]/a")).click();
	  //driver.quit();
	  
}}
