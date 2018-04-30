package com.teatime.util;

public class PassConUtil {
	private String passCon;

/**
 * hidePassword 受け取ったパスワードを伏字にするメソッド。<br>
 * -パスワードが1文字→"*"<br>
 * -パスワードが2文字→"**"<br>
 * -パスワードが3文字以上→頭2文字以外"*"<br>
 *
 * @param password
 * @return passCon(String)
 */

	public String hidePassword(String password) {

		if(password.length() == 1){
			passCon = "*";
		}
		else if(password.length() == 2){
			passCon = "**";
		}
		else if(password.length() > 2){
			StringBuilder sb = new StringBuilder(password);
			for(int i=2; i<password.length(); i++){
				sb.setCharAt(i, '*');
			}
			passCon = sb.toString();
		}
	return passCon;
	}

	public String GetPassCon() {
		return passCon;
	}
	public void setPassCon(String passCon) {
		this.passCon = passCon;
	}
}
