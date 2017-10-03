package com.cyber.crypt.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.StringTokenizer;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

public class DecryptFileUtil {

	private static String filename;
	private static String password;
	private static FileInputStream inFile;
	private static FileOutputStream outFile;
	String token = null;
	File file1 = null;

	public File fileDecrypt(File file,String string1) {
		try {
			String password = string1;
			System.out.println("password is------->" + password);
			inFile = new FileInputStream(file);
			System.out.println(file);
			System.out.println("Token = " + token);
			PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
			SecretKeyFactory keyFactory = SecretKeyFactory
					.getInstance("PBEWithMD5AndDES");
			SecretKey passwordKey = keyFactory.generateSecret(keySpec);
			byte[] salt = new byte[8];
			inFile.read(salt);
			int iterations = 100;
			PBEParameterSpec parameterSpec = new PBEParameterSpec(salt,
					iterations);
			Cipher cipher = Cipher.getInstance("PBEWithMD5AndDES");
			cipher.init(Cipher.DECRYPT_MODE, passwordKey, parameterSpec);
			outFile = new FileOutputStream(file1);
			byte[] input = new byte[64];
			int bytesRead;
			while ((bytesRead = inFile.read(input)) != -1) {
				byte[] output = cipher.update(input, 0, bytesRead);
				System.out.println(output.length);
				if (output != null)
					outFile.write(output);
			}
			byte[] output = cipher.doFinal();
			if (output != null)
				outFile.write(output);
			outFile.flush();
			inFile.close();
			outFile.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return file1;

	}

}
