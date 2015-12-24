package com.win.xymz.common.util;
/** 
 * @author 作者 Carl Zhang. E-mail: carlzhangweiwen@sina.com
 * @version 创建时间：2015年12月24日 下午11:47:31 
 * 类说明 
 */
public class TokenGenerator {
	
    public static final String  SECRET = "cde5ghi663AbcZd2u2191dDs"; //密钥
    
    /**
     * 产生全局唯一票据
     * 有效期目前为7*24个小时
     * @param appid
     * @return
     */
    public static String createToken(String appid) {
    	return "";
    }
    /**
     * 验证全局唯一票据有效性
     * @param authentication
     * @param appid
     */
    public static void authToken(String authentication, String appid){
    	
    }
}

