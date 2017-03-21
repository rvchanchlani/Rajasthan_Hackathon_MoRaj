package nlp;
import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.simple.parser.ParseException;

import services.BhamashahAPI;
import services.EmitraServices;

public class NLP {
	
		static String emitraType="xyz";
		static String accountStatus="xyz";

		public String getOutput(String input) throws ClientProtocolException, IOException, InterruptedException, ParseException
		{
			String outputMsg = "";
			
			
			if(input.equalsIgnoreCase("hi")||input.equalsIgnoreCase("hello"))
			{
				outputMsg = "Hello, How can I help you";
			}
			else if(input.contains("scheme")||input.contains("Scheme")){
				outputMsg = "Please provide Account no.";
				accountStatus="yes";
				
			}
			else if(accountStatus.equals("yes"))
			{
				outputMsg = BhamashahAPI.verifyAccount(input, "ad7288a4-7764-436d-a727-783a977f1fe1");
				accountStatus="xyz";
			}
			else if(input.contains("account")||input.contains("Account")){
				outputMsg = "Please provide Account no.";
				accountStatus="no";
				
			}
			else if(accountStatus.equals("no"))
			{
				outputMsg = BhamashahAPI.getAccountDetails(input, "ad7288a4-7764-436d-a727-783a977f1fe1");
				accountStatus="xyz";
			}
			else if(input.equalsIgnoreCase("hhh"))
			{
				outputMsg = "done";
				
			}
			else if(input.equalsIgnoreCase("thanks")||input.equalsIgnoreCase("thank you"))
			{
				outputMsg = "Welcome!!!";
			}
			else if(input.contains("bill") || emitraType.equals("bill"))
			{
				if(input.contains("Airtel")||input.contains("airtel"))
				{
					emitraType = "Airtel";
					outputMsg = "please enter 10 digit mobile no.";
				}
				else if(input.contains("Bsnl")||input.contains("bsnl")||input.contains("BSNL"))
				{
					emitraType = "BSNL";
					outputMsg = "please enter 10 digit mobile no.";
				}
				else if(input.contains("Idea")||input.contains("idea"))
				{
					emitraType = "Idea";
					outputMsg = "please enter 10 digit mobile no.";
				}
				else if(input.contains("Water")||input.contains("water"))
				{
					emitraType = "Water Bill";
					outputMsg = "please enter your water bill id";
				}
				else if(input.contains("vodafone")||input.contains("Vodafone"))
				{
					emitraType = "Vodafone";
					outputMsg = "please enter 10 digit mobile no.";
				}
				else if(input.contains("MTS")||input.contains("mts")||input.contains("data card"))
				{
					emitraType = "MTS Data Card";
					outputMsg = "please enter 10 digit mobile no.";
				}
				else
				{
					emitraType = "bill";
					outputMsg = "Which bill or provider";
				}
			}
			else if((emitraType.equals("Airtel")||emitraType.equals("Idea")||emitraType.equals("Water Bill")||emitraType.equals("Vodafone")||emitraType.equals("BSNL")||emitraType.equals("MTS Data Card")))
			{
					outputMsg = EmitraServices.getDetails(emitraType, input);
			}
			else {
				outputMsg = "Sorry!!! I didn't get you";
			}
			
			return outputMsg;
			
		}
}
