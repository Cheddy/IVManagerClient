package com.csoftware.ivmanager.net;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1 {

	public static String hash(Serializable record) {
		try {
			MessageDigest algo = MessageDigest.getInstance("SHA-256");
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(out);
			oos.writeObject(record);
			oos.close();
			byte[] bytes = algo.digest(out.toByteArray());
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < bytes.length; i++) {
				hexString.append(Integer.toHexString(0xFF & bytes[i]));
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException | IOException e) {
			e.printStackTrace();
		}
		return "";
	}

}
