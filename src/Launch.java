import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import nlp.NLP;

public class Launch {

	public static void main(String args[]) {
	
		try {
			Configure con = new Configure();
			con.initiateDriver();
			//con.launchFirstChat();
			String reciviedMsg = "ntg";
			while(true)
			{
				if(con.isNewMsg())
				{
				
					reciviedMsg = con.getLastMessage();
					NLP nlp = new NLP();
					String outputMsg = nlp.getOutput(reciviedMsg);
					if(!(outputMsg.equals("done")))
					{
						con.sendMessage(outputMsg);	
					}
					else
					{
						if(Configure.mode.equals("whatsapp"))
						{
							con.switchToHangout();	
						}
						else
						{
							con.switchToWhatsapp();
							
							
						}
					}
				}
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
