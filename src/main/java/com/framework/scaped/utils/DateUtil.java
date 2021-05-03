package com.framework.scaped.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DateUtil {

	private static final SimpleDateFormat cdf = new SimpleDateFormat("MM/dd/yyyy");
	private static final SimpleDateFormat sdf = new SimpleDateFormat("MMddyyHHmmss");

	public static String getCurrentDate() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return cdf.format(timestamp).toString();
	}

	public static String getTimeStamp() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return sdf.format(timestamp);
	}

	public static void main(String[] args) {
		String value = "home.auto@test.com";
		String s1 = value.substring(0, value.indexOf("@"));
		System.out.println(value);
		System.out.println(s1);
//		value = value.replace(value.substring(0, value.indexOf("@")), "test" + getTimeStamp());
		value = value.replace(s1, s1 + DateUtil.getTimeStamp());
//		System.out.println(value.indexOf("@"));
//		System.out.println(value.substring(0, value.indexOf("@")));
		System.out.println(value);



	}

}
