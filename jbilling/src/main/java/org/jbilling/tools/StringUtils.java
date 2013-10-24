package org.jbilling.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtils {

	public static boolean isNullOrEmpty(String str) {
		return (str == null || "".equals(str));
	}

	public static String removeLines(String str) {
		if (isNullOrEmpty(str))
			return null;
		return str.replaceAll("\r?\n|\t", " ");
	}

	public static String formatDate(Date val, String patern) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmSS");
		return format.format(val);
	}
	
	public static String formatDate(Date val) {
		return formatDate(val, "yyyyMMddHHmmSS");
	}
}
