package com.win.xymz.common.util;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

/**
 * Ajaxͳһ���ض���
 * @author seven
 */
public class AjaxReturnInfo {
	
	private boolean success=true;	// true or false��Ĭ��Ϊtrue
	private String message;			// ������Ϣ
	private Exception exception;
	private Map<String, Object> datas = new HashMap<String, Object>(); // ���ص�����

	/**
	 * ȡ�óɹ�״̬�ķ��ض���
	 * @return success
	 * @param message
	 */
	public static AjaxReturnInfo success(String message) {
	    AjaxReturnInfo ret =  new AjaxReturnInfo(true);
	    ret.message = StringUtils.hasText(message) ? message : "success";
	    return ret;
	}

	/**
	 * ȡ��ʧ��״̬�ķ��ض���
	 * 
	 * @return failed����
	 * @param message
	 */
	public static AjaxReturnInfo failed(String message) {
		AjaxReturnInfo ret = new AjaxReturnInfo(false);
		ret.message = StringUtils.hasText(message) ? message : "failed";
		return ret;
	}

	/**
	 * ˽�еĹ��캯��
	 * @param result
	 *            'true' or 'false'
	 */
	private AjaxReturnInfo(boolean result) {
		this.success = result;
	}
	
	/**
	 * ���캯��
	 * successĬ���ǳɹ���
	 */
	public AjaxReturnInfo(){
	}
	
	/**
	 * ȡ�óɹ���־
	 * 
	 * @return 'true' or 'false'
	 */
	public boolean getSuccess() {
		return success;
	}
	
	/**
	 * ���óɹ���־
	 * 
	 * @param result 'true' or 'false'
	 */
	public void setSuccess(boolean result) {
		this.success=result;
	}
	
	/**
	 * ��÷�����Ϣ
	 * @return ������Ϣ
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * ���÷�����Ϣ
	 * @return ������Ϣ
	 */
	public void setMessage(String mess) {
		this.message=mess;
	}

	/**
	 * ȡ����������
	 * @return ���ݼ���
	 */
	public Map<String, Object> getDatas() {
		return datas;
	}
	
	/**
	 * �������
	 * @param key  Keyֵ
	 * @param obj  ����
	 */
	public void add(String key, Object obj) {
		if (!StringUtils.hasText(key) || obj == null)
			return;
		this.datas.put(key, obj);
	}

	/**
	 * ���ú�̨�������쳣
	 * @param exp  �쳣
	 */
	public void setException(Exception exp) {
		exception = exp;
	}

	/**
	 * ��ȡ��̨�������쳣
	 * @return �쳣����
	 */
	public Exception getException() {
		return exception;
	}
	
	/**
	 * ��ȡ���ص�ǰ̨��JsonMap
	 */
	public HashMap<String,Object> getReturnMap(){
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("success", success?"true":"false");
		map.put("message", message);
		map.put("exception", StringUtil.getStackTrace(exception));
		map.put("datas",datas);
		return map;
	}
}