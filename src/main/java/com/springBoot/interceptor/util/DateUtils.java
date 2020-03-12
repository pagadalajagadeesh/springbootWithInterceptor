package com.springBoot.interceptor.util;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateUtils {
	public static Object convertToDate(Date date) {
		try {
			if (date == null) {
				return null;
			} else {
				DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
//    	   String s=df.format(date);
//    	   System.out.println(s);
				return df.format(date);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
