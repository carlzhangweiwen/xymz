package com.win.xymz.common.util;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

/**
 * Ajax统一返回对象
 * @author seven
 */
public class AjaxReturnInfo {
	
	private String errorCode = "1";	// 默认为1
	private String message = "ok";			// 返回信息, 默认为ok
	private Map<String, Object> datas = new HashMap<String, Object>(); // 返回的数据
	
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 取得所有数据
	 * @return 数据集合
	 */
	public Map<String, Object> getDatas() {
		return datas;
	}
	
	/**
	 * 添加数据
	 * @param key  Key值
	 * @param obj  对象
	 */
	public void add(String key, Object obj) {
		if (!StringUtils.hasText(key) || obj == null)
			return;
		this.datas.put(key, obj);
	}
	
	/**
	 * 获取返回到前台的JsonMap
	 */
	public HashMap<String,Object> getReturnMap(){
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("errcode", errorCode);
		map.put("errmsg", message);
		map.put("results",datas);
		return map;
	}
}