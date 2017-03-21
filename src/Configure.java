import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Configure {
	
	static String mode = "whatsapp";
	AppiumDriver driver;	
	
	public void initiateDriver() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec("cmd /c start D:\\AppiumStart.bat");		
		DesiredCapabilities capabilities = new DesiredCapabilities();                 // library method available. . .
    	capabilities.setCapability("appPackage", "com.whatsapp");
    	capabilities.setCapability("appActivity", "com.whatsapp.Main");
    	capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
    	capabilities.setCapability("deviceName", "Android Mobile");
    	capabilities.setCapability("platformName", "Android");
    	capabilities.setCapability("platformVersion", "5.0.2");
    	driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    	Thread.sleep(2000);
	}
	
	public void initiateDriver1() throws IOException, InterruptedException
	{
		 driver.quit();
		DesiredCapabilities capabilities = new DesiredCapabilities();                 // library method available. . .
    	capabilities.setCapability("appPackage", "com.whatsapp");
    	capabilities.setCapability("appActivity", "com.whatsapp.Main");
    	capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
    	capabilities.setCapability("deviceName", "Android Mobile");
    	capabilities.setCapability("platformName", "Android");
    	capabilities.setCapability("platformVersion", "5.0.2");
    	driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    	Thread.sleep(2000);
	}
	
	public void launchFirstChat()
	{
		driver.findElement(By.className("android.widget.TextView")).click();
	}
	public void launchFirstChat1(WebElement ele)
	{
		ele.click();
	}
	
	public String getLastMessage(){
		String s="";
		if(mode.equals("whatsapp"))
		{
			List<WebElement> ele = driver.findElements(By.className("android.view.ViewGroup"));
			WebElement lastMsg = ele.get(ele.size()-1);
			List<WebElement> textView=lastMsg.findElements(By.className("android.widget.TextView"));
			s = textView.get(textView.size()-2).getText();
		}
		else
		{
			List<WebElement> ele1 = driver.findElements(By.className("android.widget.TextView"));
			s=ele1.get(ele1.size()-2).getText();
			System.out.println(s);
		}
		return s;
	}
	
	public void sendMessage(String message) throws InterruptedException
	{
		if(mode.equals("whatsapp"))
		{
			driver.findElement(By.className("android.widget.EditText")).click();
			driver.findElement(By.className("android.widget.EditText")).sendKeys(message);
    		List<WebElement> buttonList=driver.findElements(By.className("android.widget.ImageButton"));
    		WebElement sendButton = buttonList.get(buttonList.size()-1);
    		sendButton.click();
    		Thread.sleep(200);
    		driver.findElement(By.id("com.whatsapp:id/back")).click();
    		Thread.sleep(500);
		}
		else
		{
			driver.findElement(By.className("android.widget.EditText")).click();
			driver.findElement(By.className("android.widget.EditText")).sendKeys(message);
			driver.findElement(By.id("com.google.android.apps.hangouts:id/floating_send_button")).click();
		}
	}
	
	public boolean isNewMsg()
	{
		List<WebElement>ele=driver.findElements(By.id("com.whatsapp:id/conversations_row_message_count"));
		if(ele.size()>0)
		{
			launchFirstChat1(ele.get(0));
			return true;
		}
		else
		{
			return false;
		}
		
		
	}
	
	public boolean isLastRecievedMsg()
	{
		boolean flag;
		if(mode.equals("whatsapp"))
		{
			
			List<WebElement> ele = driver.findElements(By.className("android.view.ViewGroup"));
			WebElement lastMsg = ele.get(ele.size()-1);
			List<WebElement> textView=lastMsg.findElements(By.className("android.widget.TextView"));
			int x=textView.get(textView.size()-2).getLocation().getX();
			if(x==52)
			{
				flag = true;
			}
			else
			{
				flag = false;
			}
		}
		else
		{
			
			
			
			List<WebElement> ele1 = driver.findElements(By.className("android.widget.TextView"));
			int x=ele1.get(ele1.size()-2).getLocation().getX();
			if(x==204)
			{
				flag = true;
			}
			else
			{
				flag = false;
			}
		}
		
		return flag;
	}
	
	public void switchToHangout() throws InterruptedException
	{
		driver.findElement(By.id("com.whatsapp:id/back")).click();
		Thread.sleep(500);
		driver.navigate().back(); 
		Thread.sleep(500);
		driver.navigate().back(); 
		Thread.sleep(500);
		driver.navigate().back(); 
		driver.findElement(By.id("com.google.android.googlequicksearchbox:id/hotseat")).findElements(By.className("android.widget.TextView")).get(1).click();
		Thread.sleep(2000);
		driver.findElements(By.className("android.widget.TextView")).get(1).click();
		mode = "hangout";
	}

	
	public void switchToWhatsapp() throws InterruptedException, IOException
	{
		initiateDriver1();
		mode = "whatsapp";
		launchFirstChat();
	}

}
