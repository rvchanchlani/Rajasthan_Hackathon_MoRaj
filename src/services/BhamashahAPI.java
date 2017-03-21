package services;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.DecompressingEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.common.net.HttpHeaders;

public class BhamashahAPI {

	//3390379679,ad7288a4-7764-436d-a727-783a977f1fe1
	//1067-7PVQ-28383
	public static String verifyAccount(String accNo, String clientId) throws ClientProtocolException, IOException, ParseException{
		String result=null;
		String url="https://apitest.sewadwaar.rajasthan.gov.in/app/live/Service/verifyAccount/"+accNo+"?client_id="+clientId;
		URL reqUrl = new URL(url);
		CloseableHttpClient httpClient =  HttpClients.createDefault();
		HttpGet httpget=new HttpGet(url);
		CloseableHttpResponse response = httpClient.execute(httpget);
		try{
			HttpEntity entity = response.getEntity();
			result = IOUtils.toString(entity.getContent());
			//entity.getContent().
		}finally{
			response.close();
		}
		
		JSONParser jsonParser=new JSONParser();
		
		JSONObject jsonObject=(JSONObject)jsonParser.parse(result);
		String accHolderName = ""+jsonObject.get("accountHolder_name");
		JSONArray arr=(JSONArray)jsonObject.get("account_details");
		String scheme = ""+((JSONObject)arr.get(0)).get("SCHEME_NAME");
		
		result="Name = "+accHolderName+", Scheme = "+scheme;
		
		return result;
	}
	
	public static String getAccountDetails(String accNo, String clientId) throws ClientProtocolException, IOException, ParseException{
		String result=null;
		String url="https://apitest.sewadwaar.rajasthan.gov.in/app/live/Service/getAccountDetails/"+accNo+"?client_id="+clientId;
		URL reqUrl = new URL(url);
		CloseableHttpClient httpClient =  HttpClients.createDefault();
		HttpGet httpget=new HttpGet(url);
		CloseableHttpResponse response = httpClient.execute(httpget);
		try{
			HttpEntity entity = response.getEntity();
			result = IOUtils.toString(entity.getContent());
			//entity.getContent().
		}finally{
			response.close();
		}
		
		String parsedResult=null;
		
		JSONParser jsonParser = new JSONParser();
		JSONArray jsonArray=(JSONArray) jsonParser.parse(result);
		
		String name=""+((JSONObject)jsonArray.get(0)).get("name");
		String bhamaId=""+((JSONObject)jsonArray.get(0)).get("bhamashahId");
		String fatherName=""+((JSONObject)jsonArray.get(0)).get("fatherName");
		String mobile=""+((JSONObject)jsonArray.get(0)).get("mobileNo");
		
		result="Name = "+name+", Father's Name = "+fatherName+", Bhamashah Id = "+bhamaId+", Mobile No = "+mobile;
		
		return result;
	}
	
	
	public static String getFamilyDetails(String BId, String clientId) throws ClientProtocolException, IOException{
		String result=null;
		String url="https://apitest.sewadwaar.rajasthan.gov.in/app/live/Service/family/details/"+BId+"?client_id="+clientId;
		URL reqUrl = new URL(url);
		CloseableHttpClient httpClient =  HttpClients.createDefault();
		HttpGet httpget=new HttpGet(url);
		CloseableHttpResponse response = httpClient.execute(httpget);
		try{
			HttpEntity entity = response.getEntity();
			result = IOUtils.toString(entity.getContent());
			//entity.getContent().
		}finally{
			response.close();
		}
		return result;
	}
	
	public static String getHofAndMember(String BId, String clientId) throws ClientProtocolException, IOException{
		String result=null;
		String url="https://apitest.sewadwaar.rajasthan.gov.in/app/live/Service/Bhamashah/hofAndMember/"+BId+"?client_id="+clientId;
		URL reqUrl = new URL(url);
		CloseableHttpClient httpClient =  HttpClients.createDefault();
		HttpGet httpget=new HttpGet(url);
		CloseableHttpResponse response = httpClient.execute(httpget);
		try{
			HttpEntity entity = response.getEntity();
			result = IOUtils.toString(entity.getContent());
			//entity.getContent().
		}finally{
			response.close();
		}
		return result;
	}
	
	public static String getHofMembPhoto(String BId, String MId, String clientId) throws ClientProtocolException, IOException{
		String result=null;
		String url="https://apitest.sewadwaar.rajasthan.gov.in/app/live/Service/hofMembphoto/"+BId+"/"+MId+"?client_id="+clientId;
		URL reqUrl = new URL(url);
		CloseableHttpClient httpClient =  HttpClients.createDefault();
		HttpGet httpget=new HttpGet(url);
		CloseableHttpResponse response = httpClient.execute(httpget);
		try{
			HttpEntity entity = response.getEntity();
			result = IOUtils.toString(entity.getContent());
			//entity.getContent().
		}finally{
			response.close();
		}
		return result;
	}
	
	
	public static String verifyBCAccount(String accNo, String clientId) throws ClientProtocolException, IOException{
		String result=null;
		String url="https://apitest.sewadwaar.rajasthan.gov.in/app/live/Service/verify/BCAccount/"+accNo+"?client_id="+clientId;
		URL reqUrl = new URL(url);
		CloseableHttpClient httpClient =  HttpClients.createDefault();
		HttpGet httpget=new HttpGet(url);
		CloseableHttpResponse response = httpClient.execute(httpget);
		try{
			HttpEntity entity = response.getEntity();
			result = IOUtils.toString(entity.getContent());
			//entity.getContent().
		}finally{
			response.close();
		}
		return result;
	}
	
	public static String verifyMobileUser(String UserId, String clientId) throws ClientProtocolException, IOException{
		String result=null;
		String url="https://apitest.sewadwaar.rajasthan.gov.in/app/live/Service/gptestuser/verifyMobileUser/"+UserId+"?client_id="+clientId;
		URL reqUrl = new URL(url);
		CloseableHttpClient httpClient =  HttpClients.createDefault();
		HttpGet httpget=new HttpGet(url);
		CloseableHttpResponse response = httpClient.execute(httpget);
		try{
			HttpEntity entity = response.getEntity();
			result = IOUtils.toString(entity.getContent());
			//entity.getContent().
		}finally{
			response.close();
		}
		return result;
	}
	
	public static String getNregaDetails(String Date, String Id, String clientId) throws ClientProtocolException, IOException{
		String result=null;
		String url="https://apitest.sewadwaar.rajasthan.gov.in/app/live/Service/BhamashahgetNregaDetails/"+Date+"/"+Id+"?client_id="+clientId;
		URL reqUrl = new URL(url);
		CloseableHttpClient httpClient =  HttpClients.createDefault();
		HttpGet httpget=new HttpGet(url);
		CloseableHttpResponse response = httpClient.execute(httpget);
		try{
			HttpEntity entity = response.getEntity();
			result = IOUtils.toString(entity.getContent());
			//entity.getContent().
		}finally{
			response.close();
		}
		return result;
	}
	
	//96f2ea05-8742-401d-aa42-ec269f8a71c0
	public static String getEmitraDetails(String encryptedRequest, String clientId) throws ClientProtocolException, IOException{
		String result=null;
		String url="https://apitest.sewadwaar.rajasthan.gov.in/app/live/webServicesRepository/getFetchDetailsEncryptedBySso/WithEncryption?client_id="+clientId;
		CloseableHttpClient httpClient =  HttpClients.createDefault();
		HttpPost httpPost=new HttpPost(url);
		
		List<NameValuePair> params = new ArrayList();
		params.add(new BasicNameValuePair("encData", encryptedRequest));
		httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
		
		//httpPost.addHeader(HttpHeaders.ACCEPT_ENCODING, "musixmatch");
		
		CloseableHttpResponse response = httpClient.execute(httpPost);
		try{
			HttpEntity entity = response.getEntity();
			//ByteArrayOutputStream os = new ByteArrayOutputStream();
			//entity.writeTo(os);
			//System.out.println(new String(os.toByteArray(),"UTF-8"));
			System.out.println(response.getStatusLine().getStatusCode());
			
			Header contentEncodingHeader = entity.getContentEncoding();
			
			if (contentEncodingHeader != null) {
			    HeaderElement[] encodings =contentEncodingHeader.getElements();
			    for (int i = 0; i < encodings.length; i++) {
			    	System.out.println("*_"+encodings[i].getName());
			        /*if (encodings[i].getName().equalsIgnoreCase("gzip")) {
			            entity = new GzipDecompressingEntity(entity);
			            break;
			        }*/
			    }
			}
			
			 BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent(),"iso-8859-1"),8);
		        StringBuilder out = new StringBuilder();
		        String line;
		        while ((line = reader.readLine()) != null) {
		            out.append(line);
		        }
			result = out.toString();
			//entity.getContent().
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			response.close();
		}
		return result;
	}
	
	
	public static void main(String[] args) throws ClientProtocolException, IOException, ParseException {
		//System.out.println(getNregaDetails("01012016","2711", "ad7288a4-7764-436d-a727-783a977f1fe1"));
		/*System.out.println("---"+getEmitraDetails("//wzeTciCLKFnevjkR+Y+9Av818ZKvBZLA4rU1FTCpA/2aoltEJROkqp79VPthK/hpYH7I9dZQAu0pNqjKPmn9IMUoazesKWqTNkvxnYv3I=",
				"96f2ea05-8742-401d-aa42-ec269f8a71c0"));*/
		System.out.println(getAccountDetails("3390379679", "ad7288a4-7764-436d-a727-783a977f1fe1"));
	}
}
