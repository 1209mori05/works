package com.teatime.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.teatime.util.DBConnector;
import com.teatime.util.DateUtil;
/**
 * 新規ユーザー情報をDBのuser_infoテーブルに格納するDAOです。
 */
public class UserCreateCompleteDAO {
	private DBConnector db = new DBConnector();
	private Connection con  = db.getConnection();
	private DateUtil dateUtil = new DateUtil();
	int i;



	/**
	 *user_infoへのINSERTメソッドです。
	 *格納件数であるint iを返します。
	 */
	public int insertUserInfo(String userId, String password, String familyName, String firstName,
		String familyNameKana, String firstNameKana, int sex, String email) throws SQLException{

		String sql = "INSERT INTO user_info (user_id, password, family_name, first_name, family_name_kana, first_name_kana, sex, email, insert_date) VALUES (?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, password);
			ps.setString(3, familyName);
			ps.setString(4, firstName);
			ps.setString(5, familyNameKana);
			ps.setString(6, firstNameKana);
			ps.setInt(7, sex);
			ps.setString(8, email);
			ps.setString(9, dateUtil.getDate());

			i = ps.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
	return i;
	}
}