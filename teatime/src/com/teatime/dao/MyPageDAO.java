package com.teatime.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.teatime.dto.MyPageDTO;
import com.teatime.util.DBConnector;

public class MyPageDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();

	/**
	 * SQL文でDBからユーザー情報を取得する。
	 *
	 * @param userId
	 * @return myPageList
	 * @throws SQLException
	 */

	public ArrayList<MyPageDTO> getUserInfo(String userId)throws SQLException{
		ArrayList<MyPageDTO> myPageList = new ArrayList<MyPageDTO>();

		String sql = "SELECT user_id, password, family_name, first_name, family_name_kana, first_name_kana, sex, email FROM user_info WHERE user_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){

				MyPageDTO dto = new MyPageDTO();
				dto.setUserId(rs.getString("user_id"));
				dto.setPassword(rs.getString("password"));
				dto.setFamilyName(rs.getString("family_name"));
				dto.setFirstName(rs.getString("first_name"));
				dto.setFamilyNameKana(rs.getString("family_name_kana"));
				dto.setFirstNameKana(rs.getString("first_name_kana"));
				dto.setSex(rs.getInt("sex"));
				dto.setEmail(rs.getString("email"));

				myPageList.add(dto);
			}

		} catch(Exception e) {
			e.printStackTrace();

		} finally{
			con.close();
		}

	return myPageList;

	}
}
