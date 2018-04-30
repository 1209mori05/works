package com.teatime.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.teatime.dao.UserCreateCompleteDAO;


public class UserCreateCompleteAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	private UserCreateCompleteDAO dao = new UserCreateCompleteDAO();
	private String userId;
	private String password;
	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private int sex;
	private String email;

	public String execute() throws SQLException{

		String result = ERROR;

		int count = dao.insertUserInfo(
						userId,
						password,
						familyName,
						firstName,
						familyNameKana,
						firstNameKana,
						sex,
						email);

		if(count > 0) {
			result = SUCCESS;
		}

		//ログインフラグを立ててログイン状態にする
		session.put("userId", userId);
		session.put("loginFlg", true);

		return result;
	}


	//---------------getter/setter---------------
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}


	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getFamilyNameKana() {
		return familyNameKana;
	}
	public void setFamilyNameKana(String familyNameKana) {
		this.familyNameKana = familyNameKana;
	}


	public String getFirstNameKana() {
		return firstNameKana;
	}
	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}


	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	public Map<String,Object> getSession(){
		return session;
	}
	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}
}
