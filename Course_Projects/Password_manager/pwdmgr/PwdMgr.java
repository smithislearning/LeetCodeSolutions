package pwdmgr;

import java.io.*;
import java.util.*;
import java.security.*;
import javax.crypto.*;
import java.security.spec.KeySpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.util.Base64;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.spec.SecretKeySpec;

public class PwdMgr{
	private static final String pr = "username:password";
	private static final String ivPr = "username:iv";
	private Properties usr;
	private Properties usrIv;
	private File pwdFile;
	private File pwdIvFile;
	private static char[] pass;
	private String strIv;
	private	byte[] iv;

	
	//Constructor with specified password file.
	PwdMgr(String filename, String ivFilename) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException, FileNotFoundException{	
		usr = new Properties();
		pwdFile = new File(filename);
		usrIv = new Properties();
		pwdIvFile = new File(ivFilename);
		
		if(pwdFile.exists() && pwdFile.isFile() && pwdFile.canRead()){
			FileInputStream fd = new FileInputStream(pwdFile); 
			usr.load(fd);
			fd.close(); 
		}
		
		if(pwdIvFile.exists() && pwdIvFile.isFile() && pwdIvFile.canRead()){
			FileInputStream fv = new FileInputStream(pwdIvFile);
			usrIv.load(fv);
			fv.close();
		}
		
		masterKeyGenerator();
	}

	//Generate master key.
	private static void masterKeyGenerator() throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException, FileNotFoundException{
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(128);
		Key masterKey = keyGenerator.generateKey();
		
		setKeyPass();		
		KeyStore ks = KeyStore.getInstance("JCEKS");
		ks.load(null, pass);
		KeyStore.ProtectionParameter protParam = new KeyStore.PasswordProtection(pass);
		ks.setKeyEntry("masterKey", masterKey, pass, null);
		OutputStream writeStream = new FileOutputStream("pwdmgr.key");
		ks.store(writeStream, pass);
		writeStream.close();
	}
	
	private static void setKeyPass() throws IOException{
		System.out.println("Please give me a password to protect you keys.");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String passw = in.readLine();
		pass = passw.toCharArray();
	}
	
	//Create username, password pair. Encrypt password.
	public boolean create(String username, String password) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchPaddingException, UnrecoverableKeyException, InvalidKeySpecException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException{
		if(usr.getProperty(username) != null){
			return false;
		}
		usr.setProperty(username, pwdEnc(username, password));
		
		FileOutputStream fd = new FileOutputStream(pwdFile);
		usr.store(fd, pr);
		fd.close();
		System.out.println("User created!");
		return true;
	}
	
	//Create username with algorithm, iv pair.
	private boolean createIvPr(String username, String strIv) throws IOException, FileNotFoundException{
		if(usrIv.getProperty(username) != null){
			return false;
		}
		usrIv.setProperty(username, strIv);
		
		FileOutputStream fv = new FileOutputStream(pwdIvFile);
		usrIv.store(fv, ivPr);
		fv.close();
		return true;
	}
	
	//To encrypt password.
	private String pwdEnc(String username, String password) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchPaddingException, UnrecoverableKeyException, InvalidKeySpecException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException{
		setEncKey(username);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		return pwdtoEnc(username, password, in);
	}
	
	private void setEncKey(String username) throws UnrecoverableKeyException, InvalidKeySpecException, IOException, CertificateException, FileNotFoundException, KeyStoreException, NoSuchAlgorithmException{
		
		SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
	    byte[] salt = new byte[128];
	    secureRandom.nextBytes(salt);
	    
		KeyStore ks = KeyStore.getInstance("JCEKS");
		FileInputStream fIn = new FileInputStream("pwdmgr.key");
		ks.load(fIn, pass);
		Key masterKey = ks.getKey("masterKey", pass);
		SecretKeyFactory kf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		String strMasterKey = masterKey.toString();
		KeySpec specs = new PBEKeySpec(strMasterKey.toCharArray(), salt, 1024, 128);
		Key key = kf.generateSecret(specs);
		ks.setKeyEntry(username, key, pass, null);
		OutputStream writeStream = new FileOutputStream("pwdmgr.key");
		ks.store(writeStream, pass);
		writeStream.close();
	}

	//Method to encrypt password with selection.
	private String pwdtoEnc(String username, String password, BufferedReader in) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchPaddingException, UnrecoverableKeyException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException{
		KeyStore ks = KeyStore.getInstance("JCEKS");
		FileInputStream fIn = new FileInputStream("pwdmgr.key");
		ks.load(fIn, pass);
		Key key = ks.getKey(username, pass);				
		String action;
		String plainText = password;
		String cipherText;
		byte[] byteToEnc = password.getBytes();
		byte[] byteCipherText;
		Cipher cipherForEnc;
				
		System.out.println("How you want to encryt your password?");
		System.out.println("\n\n[ECB] | [CTR] | [CBC]");
		action = in.readLine();
		SecretKeySpec k = new SecretKeySpec(key.getEncoded(), "AES");
		switch (action.toUpperCase()){
		case "ECB":
			cipherForEnc = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipherForEnc.init(Cipher.ENCRYPT_MODE, k);
			byteCipherText = cipherForEnc.doFinal(byteToEnc);
			cipherText = Base64.getEncoder().encodeToString(byteCipherText);
			break;
		case "CTR":
			cipherForEnc = Cipher.getInstance("AES/CTR/PKCS5Padding");
			cipherForEnc.init(Cipher.ENCRYPT_MODE, k);
			iv = cipherForEnc.getIV();
			strIv = Base64.getEncoder().encodeToString(iv);
			createIvPr(username += "ctr", strIv);
			byteCipherText = cipherForEnc.doFinal(byteToEnc);
			cipherText = Base64.getEncoder().encodeToString(byteCipherText);
			break;
		case "CBC":
			cipherForEnc = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipherForEnc.init(Cipher.ENCRYPT_MODE, k);
			iv = cipherForEnc.getIV();
			strIv = Base64.getEncoder().encodeToString(iv);
			createIvPr(username += "cbc", strIv);
			byteCipherText = cipherForEnc.doFinal(byteToEnc);
			cipherText = Base64.getEncoder().encodeToString(byteCipherText);
			break;
		default:
			cipherText = null;
		}
		return cipherText;
	}
	
	//Search if there is a matched entry. If there is, call matchPass() to see if password matches.
	public boolean match(String username, String password) throws BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException, CertificateException, UnrecoverableKeyException, IOException, KeyStoreException, InvalidKeyException, IllegalBlockSizeException, NoSuchAlgorithmException, IOException{
		String user = usr.getProperty(username);
		if(user == null){
			System.out.println("Sorry, no such user exists.");
			return false;
		} else {
			return matchPass(username, password, user);
		}
	}
	
	//Decrypted stored ciphertext with all three algorithms. Then see if any of them matches with inputed password.
	private boolean matchPass(String username, String password, String cipherText) throws BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException, CertificateException, UnrecoverableKeyException, IOException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, FileNotFoundException, KeyStoreException{
		KeyStore ks = KeyStore.getInstance("JCEKS");
		FileInputStream fIn = new FileInputStream("pwdmgr.key");
		ks.load(fIn, pass);
		Key key = ks.getKey(username, pass);
		byte[] byteDecryptedText;
		byte[] byteCipherText = Base64.getDecoder().decode(cipherText);
		Cipher cipherForDec;
		String decryptedCipher;
		String ctrUserName = username + "ctr";
		String cbcUserName = username + "cbc";
		
		if(usrIv.getProperty(ctrUserName) != null){
			cipherForDec = Cipher.getInstance("AES/CTR/PKCS5Padding");
			iv = Base64.getDecoder().decode(usrIv.getProperty(ctrUserName));
			SecretKeySpec k1 = new SecretKeySpec(key.getEncoded(), "AES");
			cipherForDec.init(Cipher.DECRYPT_MODE, k1, new IvParameterSpec(iv));
			byteDecryptedText = cipherForDec.doFinal(byteCipherText);
			decryptedCipher = new String(byteDecryptedText);
		} else if (usrIv.getProperty(cbcUserName) != null){
			cipherForDec = Cipher.getInstance("AES/CBC/PKCS5Padding");
			iv = Base64.getDecoder().decode(usrIv.getProperty(cbcUserName));
			SecretKeySpec k2 = new SecretKeySpec(key.getEncoded(), "AES");
			cipherForDec.init(Cipher.DECRYPT_MODE, k2, new IvParameterSpec(iv));
			byteDecryptedText = cipherForDec.doFinal(byteCipherText);
			decryptedCipher = new String(byteDecryptedText);
		} else {
			cipherForDec = Cipher.getInstance("AES/ECB/PKCS5Padding");
			SecretKeySpec k = new SecretKeySpec(key.getEncoded(), "AES");
			cipherForDec.init(Cipher.DECRYPT_MODE, k);
			byteDecryptedText = cipherForDec.doFinal(byteCipherText);
			decryptedCipher = new String(byteDecryptedText);
		}

		if(password.equals(decryptedCipher)){
				System.out.println("Welcom! Though I got nothing here for anybody~~~ lol ~~~");
				return true;
		} else {
			System.out.println("Wrong password! Hope you are this poor guy. And you just forgot you password... ;_;");
			return false;
		}		
	}
	
		
}