package com.win.xymz.common.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * �ַ��������� update by seven
 */
public class StringUtil {
	/**
	 * ��һ���ַ������ض��ַ���ȫ
	 * 
	 * @author seven
	 * @param str
	 *            ��Ҫ��ȫ���ַ���
	 * @param size
	 *            ��Ҫ�õ������ճ���
	 * @param c
	 *            �油���ַ�
	 * @param before
	 *            �Ƿ��ͷ����
	 * @return ���ز��õ��ַ���
	 */
	public static String completeString(String str, int size, char c, boolean before) {
		StringBuffer sb = new StringBuffer();
		int length = str.length();
		if (length >= size)
			return str;
		if (before) {// ��ͷ����
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
	 * ��һ���ַ������ض��ַ�trim()
	 * 
	 * @author seven
	 * @param str
	 *            ��Ҫ������ַ���
	 * @param c
	 *            trim���ַ�
	 * @param before
	 *            �Ƿ��ͷtrim return ���ش������ַ���
	 */
	public static String trimString(String str, char c, boolean before) {
		int length = str.length();
		int count = 0;
		if (before) {// ��ͷtrim
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
	 * �ж�һ���ַ����Ƿ�Ϊ NULL ��Ϊ��
	 * 
	 * @param inStr
	 * @return Ϊ�ջ�null����true
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
	 * ��String���ͷ��ش����׳��Ķ�ջ��Ϣ
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
