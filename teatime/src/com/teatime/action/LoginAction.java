package com.teatime.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.teatime.dao.LoginDAO;
import com.teatime.dto.LoginDTO;

public class LoginAction extends ActionSupport implements SessionAware{
	private String loginUserId;
	private  String loginPassword;
	public Map<String,Object> session;
	private String errorMessage;

	public String execute() {
		String result = ERROR;

		LoginDAO loginDAO = new LoginDAO();
		LoginDTO loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword);

		if(loginDTO.getLoginUserId() != null) {
			session.put("userId", loginUserId);
			session.put("password", loginPassword);
			session.put("loginFlg", true);
			result = SUCCESS;
		}

		else {
			errorMessage = "ログインに失敗しました。もう一度お試しください。";
		}
	return result;

	}


	//---------------getter/setter---------------


	public String getLoginUseId() {
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}


	public String getLoginUserId() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}


	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Map<String, Object> getSession() {
		return session;
	}

}
