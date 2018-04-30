package com.teatime.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.teatime.dao.MyPageDAO;
import com.teatime.dto.MyPageDTO;
import com.teatime.util.PassConUtil;

// マイページ機能
// ログイン状態の判別
// →未ログイン状態ならばログイン
// エラーが出たらマイページにエラーメッセージを飛ばす
//

public class MyPageAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	private ArrayList<MyPageDTO> myPageList = new ArrayList<MyPageDTO>();

	private String userId;
	private String password;
	private String passCon;

	public String execute() throws SQLException{

		String result = ERROR;

		if(!(session.containsKey("loginFlg"))) {

			result = "login";
			return result;
		}

		else {
			userId = session.get("userId").toString();
			MyPageDAO myPageDAO = new MyPageDAO();
			myPageList = myPageDAO.getUserInfo(userId);

			if(myPageList.size() > 0) {

				result = SUCCESS;

				PassConUtil passConUtil = new PassConUtil();
				password = session.get("password").toString();
				passCon = passConUtil.hidePassword(password);

			}
		}

	return result;
	}


	public Map<String,Object> getSession(){
		return session;
	}
	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}

	public String getUserId(){
		return userId;
	}
	public void setSession(String userId){
		this.userId = userId;
	}


	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}


	public String getPassCon() {
		return passCon;
	}
	public void setPassCon(String passCon) {
		this.passCon = passCon;
	}


	public ArrayList<MyPageDTO> getMyPageList(){
		return myPageList;
	}
	public void setMyPageList(ArrayList<MyPageDTO> myPageList){
		this.myPageList = myPageList;
	}
}
