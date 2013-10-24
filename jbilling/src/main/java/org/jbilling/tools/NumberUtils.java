package org.jbilling.tools;

public class NumberUtils {

	public static int tryParseInt(String str) {
		return tryParseInt(str, 0);
	}

	public static int tryParseInt(String str, int defaultValue) {
		try {
			return Integer.parseInt(str);
		} catch (Exception ex) {
			return defaultValue;
		}
	}

}
