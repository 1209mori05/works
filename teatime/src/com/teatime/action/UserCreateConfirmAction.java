package com.teatime.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.teatime.util.PassConUtil;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware{
	private String userId;
	private String password;
	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private int sex;
	private String email;

	private PassConUtil passConUtil = new PassConUtil();

//--------エラーメッセージ--------
	private String errorUserId;
	private String errorPassword;
	private String errorName;
	private String errorNameKana;
	private String errorEmail;

	private String passCon;			//パスワードを伏字にする

	private Map<String,Object> session;


	public String execute() {
		String result = SUCCESS;

	//---------------入力エラ---------------
		if(userId.equals("")) {
			errorUserId = "ユーザーIDを入力してください。";
			result = ERROR;
		}
		else if(!(userId.length() >=1 && userId.length() <= 12)) {
			errorUserId = "ユーザーIDは12文字以内で入力してください。";
			result = ERROR;
		}


		if(password.equals("")) {
			errorPassword = "パスワードを入力してください。";
			result = ERROR;
		}
		else if(!(password.length() >=1 && password.length() <= 12)) {
			errorPassword = "ユーザーIDは12文字以内で入力してください。";
			result = ERROR;
		}


		if(familyName.equals("") || firstName.equals("")) {
			errorName = "お名前を入力してください。";
			result = ERROR;
		}
		else if(!(familyName.length() >=1 && familyName.length() <= 20)
					|| !(firstName.length() >=1 && firstName.length() <= 20)) {
			errorName = "お名前は20文字以内で入力してください。";
			result = ERROR;
		}


		if(familyNameKana.equals("") || firstNameKana.equals("")) {
			errorNameKana = "ふりがなを入力してください。";
			result = ERROR;
		}
		else if(!(familyNameKana.length() >=1 && familyNameKana.length() <= 20)
					|| !(firstNameKana.length() >=1 && firstNameKana.length() <= 20)) {
			errorNameKana = "ふりがなは20文字以内で入力してください。";
			result = ERROR;
		}

		if(email.equals("")) {
			errorEmail = "メールアドレスを入力してください。";
			result = ERROR;
		}
		else if(!(email.length() >=1 && email.length() <= 50)) {
			errorEmail = "メールアドレスが長すぎます。";
			result = ERROR;
		}

		else{
		//---------------パスワード伏字機能---------------

			passCon = passConUtil.hidePassword(password);
			session.put("passCon", passCon);
		}
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


	public String getPassCon() {
		return passCon;
	}
	public void setPassCon(String passCon) {
		this.passCon = passCon;
	}


	public String getErrorUserId() {
		return errorUserId;
	}
	public void setErrorUserId(String errorUserId) {
		this.errorUserId = errorUserId;
	}


	public String getErrorPassword() {
		return errorPassword;
	}
	public void setErrorPassword(String errorPassword) {
		this.errorPassword = errorPassword;
	}


	public String getErrorName() {
		return errorName;
	}
	public void setErrorName(String errorName) {
		this.errorName = errorName;
	}


	public String getErrorNameKana() {
		return errorNameKana;
	}
	public void setErrorNameKana(String errorNameKana) {
		this.errorNameKana = errorNameKana;
	}


	public String getErrorEmail() {
		return errorEmail;
	}
	public void setErrorEmail(String errorEmail) {
		this.errorEmail = errorEmail;
	}


	public Map<String,Object> getSession(){
		return session;
	}
	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}
}
