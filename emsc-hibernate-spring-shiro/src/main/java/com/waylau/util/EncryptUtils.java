package com.waylau.util;

import org.apache.shiro.crypto.hash.Md5Hash;

public class EncryptUtils {
	public static final String encryptMD5(String source) {
		if (source == null) {
			source = "";
		}
		Md5Hash md5 = new Md5Hash(source);
		return md5.toString();
	}
}
