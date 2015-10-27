package pwdmgr;
import pwdmgr.PwdMgr;

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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import java.security.KeyStoreException;

public class PasswordManager{
	private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException, CertificateException, UnrecoverableKeyException, IOException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, FileNotFoundException, KeyStoreException, BadPaddingException, KeyStoreException, FileNotFoundException, NoSuchAlgorithmException, IOException{
		System.out.println("Inform me what name do you want to give to the file storing username and encrypted password?");
		String filename = in.readLine();
		System.out.println("What about the file storing username and IV?");
		String ivFileName = in.readLine();
		PwdMgr manager = new PwdMgr(filename, ivFileName);
		
		while(true){
			System.out.println("\n\n\nWell, what do you want to do?");
			System.out.println("\n\n[C]reate account. | [L]ogin.");
			String action = in.readLine();
			String username;
			String password;
			switch(action.toUpperCase()){
			case "C":
				System.out.println("\n\nTell me what you wanna call yourself.");
				username = in.readLine();
				System.out.println("\n\nAnd what bout your password?");
				password = in.readLine();
				manager.create(username, password);
				break;
			case "L":
				System.out.println("\n\nWho are you?");
				username = in.readLine();
				System.out.println("\n\nPassword?");
				password = in.readLine();
				manager.match(username, password);
				break;
			}
		}
	}
}