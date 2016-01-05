package com.win.xymz.bean;
/** 
 * @author 作者 Carl Zhang. E-mail: carlzhangweiwen@sina.com
 * @version 创建时间：2015年12月23日 下午8:35:33 
 * 类说明 
 */
public class User {
	private int id;//主键id 
	private String username;//用户名
	private String password;//密码
	private String mobilephone;//手机号
	private String realname	;//'用户真实姓名'
	private int gender;	//'用户性别0:女,1:男'
	private String birthday;	//'出生年月1989-12-19'
	private String email;	//'邮箱地址'
	private String photourl;	//'头像'
	private int resumeId;	//'简历'
	private String registerip;	//'注册时ip地址'
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobilephone() {
		return mobilephone;
	}
	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhotourl() {
		return photourl;
	}
	public void setPhotourl(String photourl) {
		this.photourl = photourl;
	}
	public int getResumeId() {
		return resumeId;
	}
	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}
	public String getRegisterip() {
		return registerip;
	}
	public void setRegisterip(String registerip) {
		this.registerip = registerip;
	}
	
}

