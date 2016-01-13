package com.win.xymz.common.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * @author 作者 Carl Zhang. E-mail: carlzhangweiwen@sina.com
 * @version 创建时间：2015年12月24日 下午11:47:31 
 * 类说明 
 */
public class TokenGenerator {
	private static final Logger logger = LoggerFactory.getLogger("TokenGenerator");
    public static final String  SECRET = "cde5ghi663AbcZd2u2191dDs"; //密钥
    
    /**
     * 产生全局唯一票据
     * 有效期目前为7*24个小时
     * @param appid
     * @return
     * @throws InvalidKeyException 
     * @throws NoSuchAlgorithmException 
     * @throws InvalidKeySpecException 
     * @throws NoSuchPaddingException 
     * @throws UnsupportedEncodingException 
     * @throws BadPaddingException 
     * @throws IllegalBlockSizeException 
     */
    public static String createToken(String appid) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
    	Calendar calendar = Calendar.getInstance();
		calendar.set(2015, 11, 11);
		Date now = calendar.getTime();
	
        SimpleDateFormat d1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String orgToken = "company=xymz;appType=SINGER;appid=" + appid
					+ ";currentTime=" + d1.format(now);
		
		//DESede 24bit
		DESedeKeySpec keySpec = new DESedeKeySpec(SECRET.getBytes());
		
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
		SecretKey key = keyFactory.generateSecret(keySpec);
		
		Cipher c = Cipher.getInstance("DESede");
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] result = c.doFinal(orgToken.getBytes("utf-8"));
		return 	Base64.encodeBase64String(result);
    }
    /**
     * 验证全局唯一票据有效性
     * @param authentication
     * @param appid
     * @throws InvalidKeyException 
     * @throws NoSuchAlgorithmException 
     * @throws InvalidKeySpecException 
     * @throws NoSuchPaddingException 
     * @throws BadPaddingException 
     * @throws IllegalBlockSizeException 
     * @throws ParseException 
     */
    public static AjaxReturnInfo authToken(String token, String appid) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, ParseException{
    	DESedeKeySpec keySpec = new DESedeKeySpec(SECRET.getBytes());
		
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
		SecretKey key = keyFactory.generateSecret(keySpec);
		
		Cipher c = Cipher.getInstance("DESede");
		c.init(Cipher.DECRYPT_MODE, key);
		
		String text = new String(c.doFinal(Base64.decodeBase64(token)));//company=carl;appType=SINGER;appid=car;currentTime=2016-01-04 15:24:08
		
		logger.info(text);
		
		String[] textsVals = text.split(";");
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < textsVals.length; i++) {
			String[] t = textsVals[i].split("=");
			map.put(t[0], t[1]);
		}
		System.out.println(map);
		
		String currTime = map.get("currentTime");
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = format.parse(currTime);
		
		Date now = new Date();
		AjaxReturnInfo returnInfo = new AjaxReturnInfo(); 		
		
		if((now.getTime()-date.getTime()) > 7*24*60*60*1000){//检测是否登录时间超过7天
			logger.info("no, the time is to long...");
			returnInfo.setErrorCode("111");
			returnInfo.setMessage("很抱歉，登录已过期");
		}
		if(!appid.equals(map.get("appid"))){//检测是否相同
			logger.info("no, the appid cannot matched...");
			returnInfo.setErrorCode("112");
			returnInfo.setMessage("很抱歉，验证失败");
		}
		//严格意义上，要和数据库或者缓存里存储的token进行比对
		System.out.println(now.getTime()-date.getTime());
		return returnInfo;
    }
}

