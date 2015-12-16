package com.win.xymz.common.config;

import org.springframework.beans.factory.FactoryBean;

import com.win.xymz.common.util.SecurityHelper;

import java.util.Properties;

/**
 * @author seven --decrypt the secret info
 */
public class PropertiesEncryptFactoryBean implements FactoryBean {

	private Properties properties;

	public Object getObject() throws Exception {
		return getProperties();
	}

	public Class getObjectType() {
		return java.util.Properties.class;
	}

	public boolean isSingleton() {
		return true;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties inProperties) {
		this.properties = inProperties;
		String originalUsername = properties.getProperty("user");
		String originalPassword = properties.getProperty("password");
		if (originalUsername != null) {
			String newUsername = SecurityHelper.DESDecrypt(originalUsername);
			properties.put("user", newUsername);
		}
		if (originalPassword != null) {
			String newPassword = SecurityHelper.DESDecrypt(originalPassword);
			properties.put("password", newPassword);
		}
	}
}