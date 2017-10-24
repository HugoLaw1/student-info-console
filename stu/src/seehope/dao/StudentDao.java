package seehope.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

import seehope.db.DBUtil;
import seehope.model.GradeModel;
import seehope.model.StudentModel;
import seehope.model.UserModel;

public class StudentDao {
	/**
	 * 更新学生数据
	 */
	public static boolean editStudent(StudentModel student) {
		boolean result = false;
		String sql = null;
		StudentModel oldS = StudentDao.getStudentById(student.getId());
		Connection conn = DBUtil.getInstance().getConnection();
		PreparedStatement stmt = null;
		if (oldS.getGrade() != student.getGrade()) {
			sql = "update sec_grade set grade=?,subject1=?,subject2=?,subject3=?,subject4=?,subject5=?,subject6=?,"
					+ "subject1_mark=0,subject2_mark=0,subject3_mark=0,subject4_mark=0,subject5_mark=0,subject6_mark=0 where student_id = ?";
			GradeModel gradeModel = GradeDao.getSubjectByGrade(student.getGrade());
			try {
				conn.setAutoCommit(false);
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, student.getGrade());
				stmt.setString(2, gradeModel.getSubject1());
				stmt.setString(3, gradeModel.getSubject2());
				stmt.setString(4, gradeModel.getSubject3());
				stmt.setString(5, gradeModel.getSubject4());
				stmt.setString(6, gradeModel.getSubject5());
				stmt.setString(7, gradeModel.getSubject6());
				stmt.setString(8, student.getId());

				int c = stmt.executeUpdate();
				if (c < 0) {
					conn.rollback();
					conn.commit();
					return false;
				}
				result = true;
				conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		sql = "UPDATE sec_student set name=?,sex=?,born=?,grade=?,class=?,remark=?,last_update_time=SYSDATE()  where id=?; ";
		try {
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, student.getName());
			stmt.setString(2, student.getSex());
			stmt.setString(3, student.getBorn());
			stmt.setInt(4, student.getGrade());
			stmt.setInt(5, student.getClasss());
			stmt.setString(6, student.getRemark());
			stmt.setString(7, student.getId());
			int c = stmt.executeUpdate();
			if (c < 0) {
				conn.rollback();
				conn.commit();
				return false;
			}
			result = true;
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 获取学生
	 */
	public static StudentModel getStudentById(String id) {
		String sql = "SELECT * FROM SEC_STUDENT WHERE ID=?";
		Connection conn = DBUtil.getInstance().getConnection();
		StudentModel student = new StudentModel();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("NAME");
				String sex = rs.getString("sex");
				String born = rs.getString("born");
				int grade = rs.getInt("grade");
				int classs = rs.getInt("class");
				String remark = rs.getString("remark");
				student.setId(id);
				student.setName(name);
				student.setBorn(born);
				student.setSex(sex);
				student.setRemark(remark);
				student.setGrade(grade);
				student.setClasss(classs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

	/**
	 * 删除学生
	 */
	public static boolean deleteStudent(String[] ids) {
		boolean result = false;
		String sql = "DELETE FROM SEC_STUDENT WHERE ID = ?";
		Connection conn = DBUtil.getInstance().getConnection();
		PreparedStatement stmt = null;
		try {
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(sql);
			for (String id : ids) {
				stmt.setString(1, id);
				stmt.addBatch();
			}
			int[] c = stmt.executeBatch();
			for (int cc : c) {
				if (cc < 0) {
					conn.rollback();
					conn.commit();
					return false;
				}
			}
			if (!MarkDao.deleteMark(ids)) {
				conn.rollback();
				conn.commit();
				return false;
			}
			result = true;
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 增添学生
	 */
	public static String addStudent(StudentModel student) {
		String result = "002";
		if (UserDao.hasUser(student.getId())) {
			return result = "003";
		}
		if(!(student.getSex().equals("男") || student.getSex().equals("女"))) {
			//sex字段校验
			return result = "003";
		}
		String sql = "INSERT INTO SEC_student (ID,NAME,SEX,born,grade,class,remark,created_time,last_update_time) VALUES(?,?,?,?,?,?,?,SYSDATE(),SYSDATE())";
		Connection conn = DBUtil.getInstance().getConnection();
		PreparedStatement stmt = null;
		try {
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, student.getId());
			stmt.setString(2, student.getName());
			stmt.setString(3, student.getSex());
			stmt.setString(4, student.getBorn());
			stmt.setInt(5, student.getGrade());
			stmt.setInt(6, student.getClasss());
			stmt.setString(7, student.getRemark());
			int c = stmt.executeUpdate();
			if (c > 0) {
				sql = "INSERT INTO sec_grade (student_id,grade,subject1,subject1_mark,subject2,subject2_mark,subject3,subject3_mark,subject4,subject4_mark,subject5,subject5_mark,subject6,subject6_mark)"
						+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
				GradeModel grade = GradeDao.getSubjectByGrade(student.getGrade());
				try {
					stmt = conn.prepareStatement(sql);
					stmt.setString(1, student.getId());
					stmt.setInt(2, student.getGrade());
					stmt.setString(3, grade.getSubject1());
					stmt.setString(5, grade.getSubject2());
					stmt.setString(7, grade.getSubject3());
					stmt.setString(9, grade.getSubject4());
					stmt.setString(11, grade.getSubject5());
					stmt.setString(13, grade.getSubject6());
					stmt.setFloat(4, 0);
					stmt.setFloat(6, 0);
					stmt.setFloat(8, 0);
					stmt.setFloat(10, 0);
					stmt.setFloat(12, 0);
					stmt.setFloat(14, 0);

					int b = stmt.executeUpdate();
					if (b > 0) {
						result = "001";
						conn.commit();
					} else {
						conn.rollback();
						conn.commit();
						result = "002";
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn.commit();
			} else {
				conn.rollback();
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}

	/**
	 * 查询学生是否存在
	 */
	public static boolean hasStudent(String id) {
		Connection conn = DBUtil.getInstance().getConnection();
		String sql = "SELECT * FROM SEC_student U WHERE U.id = ?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			if (rs.next())
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.getInstance().close(rs, stmt);
		}
		return false;
	}

	/**
	 * 获取所有的用户数据总量
	 * 
	 * @return
	 */
	public static int getStudentMapCount(Map param) {
		int count = 0;
		Connection conn = DBUtil.getInstance().getConnection();
		String sql = "SELECT COUNT(1) FROM sec_student U";
		String sSearch = (String) param.get("sSearch");
		PreparedStatement stmt = null;
		ResultSet rs = null;

		/**
		 * 分离key
		 */
		String kc = (String) param.get("key");
		String[] two = null;
		String key = null;
		String content = null;
		if (kc != null) {
			two = kc.split(",");
			key = two[0];
			content = two[1];
		}

		try {
			stmt = conn.prepareStatement(sql);
			if (key != null && !key.trim().equals("") && content != null && !content.trim().equals("")
					&& content.trim().equals("name")) {
				sql = "select count(1) from sec_student where name=?;";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, key.trim());
			} else if (key != null && !key.trim().equals("") && content != null && !content.trim().equals("")
					&& content.trim().equals("id")) {
				sql = "SELECT COUNT(1) FROM sec_student WHERE id=?";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, key.trim());
			}
			rs = stmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.getInstance().close(rs, stmt);
		}
		return count;
	}

	/**
	 * 获取所有的用户数据
	 * 
	 * @return
	 */
	public static List<Map> getStudentMap(Map param) {

		System.out.println("getStudentMap:"+param);

		List<Map> list = new LinkedList<Map>();
		Connection conn = DBUtil.getInstance().getConnection();
		String sql = "SELECT * from (SELECT *,@rownum:=@rownum+1 as rownum2 FROM (SELECT U.* FROM SEC_STUDENT U) A,(select @rownum:=0) R) A where A.rownum2>? and A.rownum2<?;";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Integer start = (Integer) param.get("start");
		Integer pageSize = (Integer) param.get("pageSize");
		String sSearch = (String) param.get("sSearch");
		/**
		 * 分离key
		 */
		String kc = (String) param.get("key");
		String[] two = null;
		String key = null;
		String content = null;
		if (kc != null) {
			two = kc.split(",");
			key = two[0];
			content = two[1];
		}
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, start);
			stmt.setInt(2, start + pageSize + 1);
			if (key != null && !key.trim().equals("") && content != null && !content.trim().equals("")
					&& content.trim().equals("name")) {
				sql = "SELECT * from (SELECT *,@rownum:=@rownum+1 as rownum2 FROM(SELECT U.* FROM SEC_STUDENT U where name=?) A,(select @rownum:=0) R) A where A.rownum2>? and A.rownum2<?;";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, key.trim());
				stmt.setInt(2, start);
				stmt.setInt(3, start + pageSize + 1);
			} else if (key != null && !key.trim().equals("") && content != null && !content.trim().equals("")
					&& content.trim().equals("id")) {
				sql = "SELECT * from (SELECT *,@rownum:=@rownum+1 as rownum2 FROM (SELECT U.* FROM SEC_STUDENT U where id = ?) A,(select @rownum:=0) R) A where A.rownum2>? and A.rownum2<?;";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, key.trim());
				stmt.setInt(2, start);
				stmt.setInt(3, start + pageSize + 1);
			}
			rs = stmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				String born = rs.getString("born");
				int grade = rs.getInt("grade");
				int classs = rs.getInt("class");
				String remark = rs.getString("remark");
				Date createdTime = rs.getDate("CREATED_TIME");
				Date lastUpdateTime = rs.getDate("LAST_UPDATE_TIME");
				Map m = new HashedMap();
				m.put("id", id);
				m.put("name", name);
				m.put("born", born);
				m.put("sex", sex);
				m.put("grade", grade);
				m.put("class", classs);
				m.put("remark", remark);
				m.put("createdTime", createdTime);
				m.put("lastUpdateTime", lastUpdateTime);
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.getInstance().close(rs, stmt);
		}
		return list;
	}

}
