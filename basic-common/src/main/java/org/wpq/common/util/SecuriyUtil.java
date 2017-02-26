package org.wpq.common.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecuriyUtil {
	private SecuriyUtil() {
	}
	
	public static String md5(String str) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(str.getBytes());
		return new BigInteger(1,md.digest()).toString();
	}
}
