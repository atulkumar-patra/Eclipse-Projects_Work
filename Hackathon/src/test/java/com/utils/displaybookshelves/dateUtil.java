package com.utils.displaybookshelves;

import java.util.Date;

public class dateUtil {
	
	public static String getTimeStamp(){
		Date date = new Date();
		return date.toString().replaceAll(":", "_").replaceAll(" ", "_");
	}
}
