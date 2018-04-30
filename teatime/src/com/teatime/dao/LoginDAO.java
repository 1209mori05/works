package com.teatime.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.teatime.dto.LoginDTO;
import com.teatime.util.DBConnector;

public class LoginDAO {
	private LoginDTO loginDTO = new LoginDTO();
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();


	/**
	 * ユーザー情報をDBから取得
	 *
	 * @param loginUserId
	 * @param loginPassword
	 * @return LoginDTO
	 */
	public LoginDTO getLoginUserInfo(String loginUserId, String loginPassword) {
		String sql = "SELECT * FROM user_info WHERE user_id=? AND password=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ps.setString(2, loginPassword);


			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				loginDTO.setLoginUserId(rs.getString("user_id"));
				loginDTO.setLoginPassword(rs.getString("password"));
				}

		}catch(SQLException e) {
			e.printStackTrace();
		}
	return loginDTO;
			}
}
