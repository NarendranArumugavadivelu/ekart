package com.cooper.farming.utils;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import com.cooper.farming.constants.Constants;


public class CommonUtils {

	private CommonUtils() {
		
	}
	
	private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(Constants.DATE_TIME_FORMAT);
	
	/**Method to parse the string to a valid local date time*/
	public static LocalDateTime parseStringToDate(String input) {
		LocalDateTime localDateTime;
		try {
			localDateTime = LocalDateTime.parse(input, dateTimeFormatter);
		} catch(Exception exception) {
			localDateTime = null;
		}
		return localDateTime;
	}
	
	/**Method to convert the valid local date time to string*/
	public static String formatDateToString(LocalDateTime localDateTime) {
		return localDateTime.format(dateTimeFormatter);
	}
	
	/**Method to load the properties*/
	public static Properties loadProperties(String propertyFilename) {
		Properties properties = null;
		try(InputStream inputStream = CommonUtils.class.getClassLoader().getResourceAsStream(propertyFilename)) {
			properties = new Properties();
			properties.load(inputStream);
		} catch(Exception exception) {
			properties = new Properties();
		}
		return properties;
	}
}
