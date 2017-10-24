package seehope.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import seehope.db.DBUtil;
import seehope.model.UserModel;
import seehope.security.SecurityContext;

public class UserRoleMapDao {

	public static String getRole(String id) {
		String sql = "SELECT ROLE FROM SEC_URMAP WHERE USERID=?";
		Connection conn = DBUtil.getInstance().getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String role=null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				role = rs.getString("ROLE");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.getInstance().close(rs, stmt);
		}
		return role;
	}

	

	public static boolean updateRole(String id, String role) {
		boolean result = false;
		

		String sql = "UPDATE SEC_URMAP SET ROLE=?,LAST_UPDATE_TIME=SYSDATE WHERE USERID=?";
		Connection conn = DBUtil.getInstance().getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, role);
			stmt.setString(2, id);
			int c = stmt.executeUpdate();
			if (c > 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static boolean addMap(String id) {
		boolean result = false;
		

		String sql = "INSERT INTO SEC_URMAP (USERID,ROLE,LAST_UPDATE_TIME)"
				+ "VALUES(?,'primary',SYSDATE)";
		Connection conn = DBUtil.getInstance().getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			int c = stmt.executeUpdate();
			if (c > 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}


