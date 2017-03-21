package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

//import encryption.dec.Encryption;

public class LaunchWebService {

	// private static final String POST_URL =
	// "http://ssotest.rajasthan.gov.in:8888"
	// private static final String POST_URL =
	// "https://10.68.122.64/app/live/webServicesRepositoryA/backtobackTransaction/WithEncryptionA";
//	 private static final String POST_URL = "https://emitraapp.rajasthan.gov.in/webServicesRepository/backtobackTransactionWithEncryptionA";
	 /*For online transaction verification*/
//	 private static final String POST_URL = "https://emitraApp.rajasthan.gov.in/webServicesRepository/newAggrTransVerify";
	 
	// private static final String POST_URL =
	// "http://www.mispltest.com/HtEst/weBSerVice/HRestServerS.php";
	// private static final String POST_URL =
	// "https://emitraapp.rajasthan.gov.in/webServicesRepository/backtobackTransactionWithEncryptionA";
	/*for kiosk transaction verification*/
//	 private static final String POST_URL ="https://emitraapp.rajasthan.gov.in/webServicesRepository/getTokenVerifyNewProcessByRequestIdWithEncryption";
	 private static final String POST_URL ="https://apitest.sewadwaar.rajasthan.gov.in/app/live/webServicesRepository/getFetchDetailsEncryptedBySso/WithEncryption?client_id=96f2ea05-8742-401d-aa42-ec269f8a71c0";
	 //	 private static final String POST_URL = "https://emitraapp.rajasthan.gov.in/webServicesRepository/getTokenVerifyNewProcessByRequestId";
	 //For RPP
//	 private static final String POST_URL = "http://103.203.136.34/payments/v1/services/txnStatus.json";
//	 private static final String POST_URL =	 "https://emitraapp.rajasthan.gov.in/webServicesRepository/getKioskDetailsJSON";
//	private static final String POST_URL =	"http://emitrauat.rajasthan.gov.in/webServicesRepositoryUat/getKioskDetailsJSON";
	// private static final String POST_URL =
	// "http://emitrauat.rajasthan.gov.in/webServicesRepositoryUat/getKioskDetailsJSON";
//	private static final String POST_URL = "http://emitrauat.rajasthan.gov.in/webServicesRepositoryUat/backtobackTransactionWithEncryptionA";
//	 private static final String POST_URL ="http://emitrauat.rajasthan.gov.in/webServicesRepositoryUat/updateTransactionPostingWithEncryption";
	// private static final String POST_URL =
	// "http://emitraapp.rajasthan.gov.in/webServicesRepository/getTokenDetails";
//	 private static final String POST_URL ="https://api.sewadwaar.rajasthan.gov.in/app/live/webServicesRepository/getKioskDetails/JSON?client_id=8d7701cc-bc06-4a90-ab36-4de02974d2bc";
	// private static final String POST_URL =
	// "http://micronicinfo.com/EmiTraWeb/weBSerVice/H2EServerS.php";
	// private static final String POST_URL =
	// "https://emitraapp.rajasthan.gov.in/webServicesRepository/emitraAESEncryption";
	// private static final String POST_URL =
	// "https://emitraapp.rajasthan.gov.in/webServicesRepository/emitraAESDecryption";
	// private static final String POST_URL =
	// "https://emitraapp.rajasthan.gov.in/webServicesRepository/emitraAESEncryption";
	// private static final String POST_URL =
	// "https://emitraapp.rajasthan.gov.in/webServicesRepository/emitraMD5Checksum";
	// private static final String POST_URL =
	// "http://emitrauat.rajasthan.gov.in/webServicesRepositoryUat/updateTransactionPostingWithEncryption";
	// private static final String POST_URL =
	// "https://emitraapp.rajasthan.gov.in/webServicesRepository/getTokenDetailsWithEncryptionNew";
	// private static final String GET_URL =
	// "http://ssotest.rajasthan.gov.in:8888/";
//	private static final String POST_URL =  "https://emitraapp.rajasthan.gov.in/webServicesRepository/getTokenDetailsWithEncryptionNew";
	
//	private static final String POST_URL = "https://emitraapp.rajasthan.gov.in/webServicesRepository/getTokenDetailsWithEncryptionNew";
	
//	private static final String POST_URL = "http://micronicinfo.com/EmiTraWeb/weBSerVice/HRestEServerS.php";
//	private static final String POST_URL = "https://emitraapp.rajasthan.gov.in/webServicesRepository/getTokenDetailsWithEncryptionNew";
	// pnb
//	 private static final String POST_PARAMS ="data=8AB4D5vLgakRctmEpGhpxP1RrScsXwTi7pwJZMs9JB0UPAa5DaDPaj6PoPdrejZi2vEAsCwJ7kfMpIQfz0deqbe6geR13A56gIm1xEWyMHs=";
	// private static final String POST_PARAMS =
	// "toBeDecrypt=jgf6epY1S4XELpLPaqG68Bm3wrK/MF0Y8CzKTXmmyM7guJdFcM+nMq4VVPcbqK0EY/VMMo4CAKyXltuFDAPP7TZ/6q4KS47NSC23x0wIMdAAYPj6vjQwH3PkTyzcy2th4+h4Q+y1weJkpwYrUIv4v1gL/5SFlYr/xQEFYZ82fn5xV5hVIN+6TmOrFXZdHGrESxl6F/XtjX5YrqSeuY83ALRYl4s9hVl9151gYtfAdcux3ZEHexqSu3jCQuMhVfiJ+t//0KabKt1fi1w3R7Tkgg==";
	// private static final String POST_PARAMS =
	// "toBeEncrypt={'MERCHANTCODE':'RSOS1607','REQUESTID':'132465','REQTIMESTAMP':'2017012507010404','SERVICEID':'2124','SUBSERVICEID':'','REVENUEHEAD':'534-20.00|554-30.00','CONSUMERKEY':132465,'CONSUMERNAME':'hsingh','COMMTYPE':1,'SSOID':'HARPEJ2008','OFFICECODE':'RSOSHQ','SSOTOKEN':'795119','CHECKSUM':'57770587f85e761bcb55d4a3e5e72f60'}";
	// private static final String POST_PARAMS =
	// "toBeCheckSumString={\"SSOID\":\"HARPEJ2008\",\"REQUESTID\":\"132465\",\"REQTIMESTAMP\":\"2017012508011313\",\"SSOTOKEN\":\"966499\"}";
	 public static String POST_PARAMS ="encData=//wzeTciCLKFnevjkR+Y+9Av818ZKvBZLA4rU1FTCpA/2aoltEJROkqp79VPthK/hpYH7I9dZQAu0pNqjKPmn9IMUoazesKWqTNkvxnYv3I";
//	 private static final String POST_PARAMS = "MERCHANTCODE=HCJODHPUR&PRN=20173103053104183226&SERVICEID=2315";
	// data value={'TRANSACTIONID':'160011940704,'MERCHENTCODE':'UOR1116'}

//	private static final String POST_PARAMS = "P1=7531966&P2=2287&P3=1&P7=1989-07-10";
//	private static final String POST_PARAMS = "P1=3044249&P2=2252&P3=1&P7=2007-04-02";
	 /*for kiosk transaction verification*/
//	private static final String POST_PARAMS = "encData=e4O9qC2+A2ygddEQQrr25TO7KHIjsXS9JFp+PBydVUwHKg2N7fOAdSTeo4YXdGzWokMSZ0MA3H1h9MISbE0G+CAuJD7xIAUYoNhJZIQ4w9vzcUnlT9rlxgkApr8xSj7I98lC/EFRsymBqZMdJtqay3W7uhUnPAOKDjChqDkdmcF4z4JdjDUB7uGddqt0CSci";
//	 private static final String POST_PARAMS ="TRANSACTIONID=160014344338&MERCHANTCODE=UOR1116&SERVICEID=1968";
	// private static final String POST_PARAMS =
	// "data={'MERCHANTCODE':'POLICE1116','SERVICEID':'1947','REQUESTID':'1781331','SSOTOKEN':'0','CHECKSUM':'164b17ff6f6e6565eb180e8faa41f2dc'}";
	// bob
	// private static final String GET_PARAMS =
	// "/SSOREST/UpdateEmitraData/SURENDRASINGH1751/K10376594/EMITRANEW.DEPTADMIN/Test@1234/KIOSK";
//	 private static final String POST_PARAMS ="data={'MERCHANTCODE':'HCJODHPUR','REQUESTID':'20173103053104183226','SERVICEID':'2315','SSOTOKEN':'0','CHECKSUM':'9882e4086dae5434d535806bd3a9f116'}";
	// private static final String POST_PARAMS =
	// "MERCHANTCODE=RAJSSP1116&SSOID=VISHAL.DEV.GAUR";
//	 private static final String POST_PARAMS = "MERCHANTCODE=AGR1116&SSOID=NAVEENDUA6745";
	// private static final String POST_PARAMS =
	// "districtcode=130&tehsilcode=00688&villagecode=106118&khasra=45";
	// private static final String POST_PARAMS =
	// "client_id=8d7701cc-bc06-4a90-ab36-4de02974d2bc&encData=e4O9qC2+A2ygddEQQrr25XsghNC4c7Ar4JWddBHpyBun+JyfrOkQ8IANyxMPFLYIyEimSME7i6gHukr5gxKBTYBbUJ53YGC9B/SPdmGtIC7uFQz2Bpm/HceCI0sV+Nwa4t5Z4geo2cY5vtzvbAanzyqnUxrh2HmaVSb8g0kr2UF1TgFcFhCB47a6o98DmnOaSy7430i94LXAf/fYtIEMICde6+AkLXfwt+VsdWXXK4GVs0C6hqBV3jO9wg72KR++lfL+QN7+8MvFgWcaBHecazalg8ZV6lJtiygfSDVjJeVUuzrGLaKSKwaDxgwF/+8DZyAbE1DLDGbuCA0ZwcVb5fn1uz8N3ockIJG4dOGV0AnjY42N2MA+5B/GvS6iBXIVj93w6AGSaWH9kYrrhPeQ0He3vwln8Vnd/MUindJra70hbAxLylJoMvDoYWJClYyhLGDjMIjeqSVPpn9XO4hcnA==";

	static StringBuffer data = new StringBuffer();

	public static String getResponse() throws IOException{
		data=new StringBuffer();
		data.append(POST_PARAMS);
		// data.append(GET_PARAMS);
		return sendPOST();
	}
	public static void main(String[] args) throws Exception {

		data.append(POST_PARAMS);
		// data.append(GET_PARAMS);
		sendPOST();
	}

	private static String sendPOST() throws IOException {

		 byPassSSL();
		 String result=null;
		/*
		 * MultivaluedMap formData = new MultivaluedMapImpl();
		 * formData.add("P1", "1500005"); // formData.add("P2", "2218"); //
		 * formData.add("P3", "1"); // String challan="1500002"; Client client =
		 * Client.create(); WebResource resource = client.resource(
		 * "http://jnvuemitra.azurewebsites.net/api/Products/GetProduct/");
		 * ClientResponse responseY =
		 * resource.post(ClientResponse.class,formData); String response =
		 * responseY.getEntity(String.class);
		 * System.out.println("Response in xml: "+response); String
		 * TEST_XML_STRING =response;
		 */
		// JSONObject xmlJSONObj = XML.toJSONObject(TEST_XML_STRING);
		// String jsonPrettyPrintString = xmlJSONObj.toString(4);
		URL obj = new URL(POST_URL);

		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		// con.setRequestProperty("Content-Type",
		// "application/x-www-form-urlencoded");
		// con.setRequestProperty("User-Agent", USER_AGENT);

		// For POST only - START
		con.setDoOutput(true);
		OutputStream os = con.getOutputStream();
		os.write(data.toString().getBytes());
		os.flush();
		os.close();
		// For POST only - END

		int responseCode = con.getResponseCode();
		System.out.println("POST Response Code :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			result=response.toString();
			System.out.println("response of Emitra " + response.toString());
		} else {
			System.out.println("POST request not worked");
		}
		return result;
	}

	public static void byPassSSL() {
		HttpURLConnection connection = null;
		StringBuffer responseReader = new StringBuffer();
		try {
			TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				public void checkClientTrusted(X509Certificate[] certs,
						String authType) {
				}

				public void checkServerTrusted(X509Certificate[] certs,
						String authType) {
				}
			} };
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection
					.setDefaultSSLSocketFactory(sc.getSocketFactory());
			// Create all-trusting host name verifier
			HostnameVerifier allHostsValid = new HostnameVerifier() {
				public boolean verify(String hostname, SSLSession session) {
					return true;
				}
			};
			// Install the all-trusting host verifier
			HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
			/*
			 * end of the fix
			 */
			// logger.info("Response  from oxigen ---"+responseReader);
		} catch (Exception e) {
			// logger.error("Error in oxigen call---"+e.getMessage());
			e.printStackTrace();
		} finally {
			// connection.disconnect();
		}
	}

}