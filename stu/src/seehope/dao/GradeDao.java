package seehope.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import seehope.db.DBUtil;
import seehope.model.GradeModel;

public class GradeDao {
	public static GradeModel getSubjectByGrade(int grade){
		String sql = "select subject1,subject2,subject3,subject4,subject5,subject6 from sec_sub_grade where grade=?"+
				" GROUP BY grade ;";
		Connection conn = DBUtil.getInstance().getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		GradeModel gM = new GradeModel();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, grade);
			rs = stmt.executeQuery();
			while(rs.next()){
				String subject1 = rs.getString("subject1");
				String subject2 = rs.getString("subject2");
				String subject3 = rs.getString("subject3");
				String subject4 = rs.getString("subject4");
				String subject5 = rs.getString("subject5");
				String subject6 = rs.getString("subject6");
				gM.setGrade(grade);
				gM.setSubject1(subject1);
				gM.setSubject2(subject2);
				gM.setSubject3(subject3);
				gM.setSubject4(subject4);
				gM.setSubject5(subject5);
				gM.setSubject6(subject6);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gM;
	}
}
