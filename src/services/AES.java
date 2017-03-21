package services;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.print.DocFlavor.STRING;

import org.apache.commons.codec.binary.Base64;



public class AES
{

	
    private static SecretKeySpec secretKey ;
    private static byte[] key ;
    
	private static String decryptedString;
	private static String encryptedString;
 
    
    public static void setKey(String myKey){
    	
   
    	MessageDigest sha = null;
		try {
			key = myKey.getBytes("UTF-8");
			System.out.println(key.length);
			sha = MessageDigest.getInstance("SHA-256");
			key = sha.digest(key);
	    	key = Arrays.copyOf(key, 16); // use only first 128 bit
	    	System.out.println(key.length);
	    	System.out.println(new String(key,"UTF-8"));
		    secretKey = new SecretKeySpec(key, "AES");
		    
		    
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    
    public static String getDecryptedString() {
		return decryptedString;
	}

	public static void setDecryptedString(String decryptedString) {
		AES.decryptedString = decryptedString;
	}

    public static String getEncryptedString() {
		return encryptedString;
	}

	public static void setEncryptedString(String encryptedString) {
		AES.encryptedString = encryptedString;
	}

	public static String encrypt(String strToEncrypt)
    {
        try
        {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(key));
        
         
            setEncryptedString(Base64.encodeBase64String(cipher.doFinal(strToEncrypt.getBytes("UTF-8"))));
        
        }
        catch (Exception e)
        {
           
            System.out.println("Error while encrypting: "+e.toString());
        }
        return AES.getEncryptedString();

    }

    public static String decrypt(String strToDecrypt)
    {
        try
        {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(key));
            setDecryptedString(new String(cipher.doFinal(Base64.decodeBase64(strToDecrypt))));
            
        }
        catch (Exception e)
        {
         
            System.out.println("Error while decrypting: "+e.toString()+"---"+secretKey);

        }
        return AES.getDecryptedString();
    }


    public static void main(String args[])
    {
 
                final String strToEncrypt = "My text to encrypt";
                final String strPssword = "E-m!tr@2016";
                AES.setKey(strPssword);
               
                //AES.encrypt(strToEncrypt.trim());
                
                //System.out.println("String to Encrypt: " + strToEncrypt); 
                //System.out.println("Encrypted: " + AES.getEncryptedString());
           
                final String strToDecrypt =  "w2tZwKucTyOLM+cq+H1aRXckVuADGrE2GJb35btosuI3GNY3vViM/43tiBvinkRNyo49DlVm3hr9FWe062eaKH+OE0UEMmnFL+1ci0f7P+VS0356eFk1WFwYoayFv+mG7Pmih4kCa7FekDZZFwFvdA6VqEvq/SCcz7QgvWNr0/8udMJwUKeHIDHvbSvGdu/zeN2FTaipB43iuyUOAizQsH1s1lpx/aGXcmr4u6fPiyCFaC540x6clNuYNoVktCPSPTNQ76KSg3CcqlUWyRJ3C/8+e6y3Z1ImJvXZ/Z7y4QWZZWJRZKrGnYta/6DvMmUJFXto14D1VSdt+IsWfiLpV2CCIa3mF9LeoT5pdF0zxOA++kNGD2w1QamVNfqWoolF/Fm25aCzImlXbJbHRFJlVNljCl9905NWoRo4c42Urg0l90pA9rPXy1H23z7TaT6Omx7szWz0ZguS+R/4jdrR9fPKJOFel1GFNxz2xsQuUgFqtz0CKXL1vHHBXgSnaaj/ehvzvnl42T9TVpg93q0LG1ei/lXR6VK29UPmau3O6p0NB6kcg2lpvcS3N+WS+H3i30IYRBkRhAQJsMkDA2tuitJolBBC8p1xSkp7OpFrs1Y077MUppJag8JpEPwG4jpk0CqK9iU8V+Shw0mrzsq4mqKRs8JqFjd9MocKqkPfpkwmUTqPg8Ug3eaSSErVIBn4/BRsO5pOvEb21ySKpLG3YYji+8rP2GF1u43CUyfpQ8v7Zu5DuD47FxTAcOoqGgvFvNbpIuFC53PH57htbxTRU4ruGplUKwpOAcvNXZrwe2blb7rKw3fNTBhkvOn+JfrkhQq9Dq6fn3rUna5+2iWMp5XH0eH3kZZbIQq2kVqRjWN2f5TST+hAIkruvrHgf2C5a5c8xVDfR4C5JlngAEmsXp0zMdfQwt7dcSWwQ+S0rxXn1sIJZ+YBN/m7k+k08nFEtaK+6l/j0W0sP6F245FePUkkx/vZOWRFr/TlquY7XvQBZbLmFsfszkYDkWMnF0F5";
                AES.decrypt(strToDecrypt.trim());
               
                System.out.println("String To Decrypt : " + strToDecrypt);
                System.out.println("Decrypted : " + AES.getDecryptedString());
        
    }
     
}