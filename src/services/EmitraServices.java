package services;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EmitraServices {

	public static Map<String, String> keyMap= new HashMap();
	
	static{
		keyMap.put("Airtel", "1214");
		keyMap.put("Idea", "1220");
		keyMap.put("MTS Data Card", "1216");
		keyMap.put("Vodafone", "1219");
		keyMap.put("BSNL", "1222");
		keyMap.put("Water Bill", "1807");
	}
	
	public static String getDetails(String serviceProvider, String phNo) throws IOException, ParseException{
		String result=null;
		
		String key=keyMap.get(serviceProvider);
		String json="{\"SRVID\":\""+key+"\",\"searchKey\":\""+phNo+"\",\"SSOID\":\"SSOTESTKIOSK\"}";
		
		String strPssword = "E-m!tr@2016";
        AES.setKey(strPssword);
		
		String encryptedRequest=AES.encrypt(json);
		System.out.println("req- "+encryptedRequest);
		LaunchWebService.POST_PARAMS="encData="+encryptedRequest;
		result=LaunchWebService.getResponse();
		result = AES.decrypt(result);
		String parsedResult=null;
		if(result!=null){
			JSONParser parser = new JSONParser();
		    Object obj = parser.parse(result);
		   
		    JSONObject jsonObject=(JSONObject)obj;
		    JSONObject fetchDetails=(JSONObject)jsonObject.get("FetchDetails");
		   
		    JSONArray tranJsonObject=(JSONArray)fetchDetails.get("TransactionDetails");
		   
		    System.out.println("ServiceName--"+((JSONObject)tranJsonObject.get(0)).get("ServiceName"));
		    
		    parsedResult="Service Name = "+((JSONObject)tranJsonObject.get(0)).get("ServiceName")+", ";
		    parsedResult+="Consumer Name = "+((JSONObject)tranJsonObject.get(0)).get("ConsumerName")+", ";
		    parsedResult+="Bill Amount = "+((JSONObject)tranJsonObject.get(0)).get("BillAmount");
		    System.out.println(parsedResult);
		}
		
	    
	    
		
		return parsedResult;
	}
	
	public static void main(String[] args) throws IOException, ParseException {
		//System.out.println("---"+getDetails("Vodafone", "9982345598"));
		//System.out.println("---"+getDetails("Idea", "8440042182"));
		//System.out.println("---"+getDetails("BSNL", "9530084675"));
	 System.out.println("---"+getDetails("Airtel", "9352423664"));
	//	System.out.println("---"+getDetails("MTS Data Card", "8432926694"));
		//System.out.println("---"+getDetails("Water Bill", "16-14062-04535"));
	}
}
