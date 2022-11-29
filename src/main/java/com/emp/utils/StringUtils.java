package com.emp.utils;

public class StringUtils {

	public static boolean isNotNullAndBlank(String value) {
		return (value != null && !value.isEmpty());
	}

	public static boolean isGreaterThanZero(int value) {
		return value > 0;
	}
}
  