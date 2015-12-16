package com.win.xymz.common.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 字符串工具类 update by seven
 */
public class StringUtil {
	/**
	 * 给一个字符串以特定字符补全
	 * 
	 * @author seven
	 * @param str
	 *            需要补全的字符串
	 * @param size
	 *            需要得到的最终长度
	 * @param c
	 *            替补的字符
	 * @param before
	 *            是否从头补齐
	 * @return 返回补好的字符串
	 */
	public static String completeString(String str, int size, char c, boolean before) {
		StringBuffer sb = new StringBuffer();
		int length = str.length();
		if (length >= size)
			return str;
		if (before) {// 从头补齐
			for (int i = 0; i < size - length; i++) {
				sb.append(c);
			}
			sb.append(str);
		} else {
			sb.append(str);
			for (int i = length; i < size; i++) {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	/**
	 * 给一个字符串以特定字符trim()
	 * 
	 * @author seven
	 * @param str
	 *            需要处理的字符串
	 * @param c
	 *            trim的字符
	 * @param before
	 *            是否从头trim return 返回处理后的字符串
	 */
	public static String trimString(String str, char c, boolean before) {
		int length = str.length();
		int count = 0;
		if (before) {// 从头trim
			for (int i = 0; i < length; i++) {
				if (str.charAt(i) == c) {
					count++;
				} else {
					break;
				}
			}
			if (count == length) {
				return String.valueOf(c);
			} else {
				return str.substring(count);
			}
		} else {
			for (int i = length - 1; i >= 0; i--) {
				if (str.charAt(i) == c) {
					count++;
				} else {
					break;
				}
			}
			if (count == length) {
				return String.valueOf(c);
			} else {
				return str.substring(0, length - count);
			}
		}
	}

	/**
	 * 判断一个字符串是否为 NULL 或为空
	 * 
	 * @param inStr
	 * @return 为空或null返回true
	 */
	public static boolean isValid(String inStr) {
		if (inStr == null) {
			return true;
		} else if (inStr.equals("")) {
			return true;
		} else if (inStr.equalsIgnoreCase("null")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 以String类型返回错误抛出的堆栈信息
	 * 
	 * @param t
	 *            Throwable
	 * @return String
	 */
	public static String getStackTrace(Throwable t) {
		if (t == null)
			return "";
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		t.printStackTrace(pw);
		return sw.toString();
	}
}
