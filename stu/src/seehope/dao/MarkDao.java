package seehope.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

import seehope.db.DBUtil;

public class MarkDao {

	private static String[] columnName = { "id", "id", "name", "grade", "class", "subject1_mark", "subject2_mark",
			"subject3_mark", "subject4_mark", "subject5_mark", "subject6_mark", "sum", "average" };
	private static String[] columnName2 ={"grade","class","sum_1","sum_2","sum_3","sum_4","sum_5","sum_6","sum_sum","sum_avg"};

	
	public static boolean deleteMark(String[] ids) {
		boolean result = false;
		String sql = "delete from sec_grade where student_id=?;";
		Connection conn = DBUtil.getInstance().getConnection();
		PreparedStatement stmt = null;
		try {
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(sql);

			for (int i = 0; i < ids.length; i++) {
				stmt.setString(1, ids[i]);
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
			conn.commit();
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

	}

	public static boolean updateMark(Map map) {
		boolean result = false;
		String sql = "update sec_grade G set subject1_mark=?,subject2_mark=?,subject3_mark=?,subject4_mark=?,subject5_mark=?,subject6_mark=?"
				+ " where G.student_id=?;";
		Connection conn = DBUtil.getInstance().getConnection();
		PreparedStatement stmt = null;
		try {
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(sql);
			stmt.setFloat(1, fix2(Float.parseFloat((String) map.get("subject1_mark"))));
			stmt.setFloat(2, fix2(Float.parseFloat((String) map.get("subject2_mark"))));
			stmt.setFloat(3, fix2(Float.parseFloat((String) map.get("subject3_mark"))));
			stmt.setFloat(4, fix2(Float.parseFloat((String) map.get("subject4_mark"))));
			stmt.setFloat(5, fix2(Float.parseFloat((String) map.get("subject5_mark"))));
			stmt.setFloat(6, fix2(Float.parseFloat((String) map.get("subject6_mark"))));
			stmt.setString(7, (String) map.get("id"));

			int c = stmt.executeUpdate();
			if (c < 0) {
				conn.rollback();
				conn.commit();
			}
			result = true;
			conn.commit();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return result;
	}

	public static float fix2(float f) {
		BigDecimal b = new BigDecimal(f);
		f = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
		return f;

	}

	public static Map getMarkById(String id) {
		Map map = new HashMap();
		String sql = "select S.id,S.`name`,S.grade,S.class,G.subject1,G.subject1_mark,G.subject2,G.subject2_mark,G.subject3,G.subject3_mark,G.subject4,G.subject4_mark,G.subject5,G.subject5_mark,G.subject6,G.subject6_mark "
				+ "from sec_grade G LEFT JOIN sec_student S on G.student_id = S.id having S.ID=?;";
		Connection conn = DBUtil.getInstance().getConnection();
		ResultSet rs = null;
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				int grade = rs.getInt("grade");
				int classs = rs.getInt("class");
				String subject1_mark = rs.getString("subject1_mark");
				String subject2_mark = rs.getString("subject2_mark");
				String subject3_mark = rs.getString("subject3_mark");
				String subject4_mark = rs.getString("subject4_mark");
				String subject5_mark = rs.getString("subject5_mark");
				String subject6_mark = rs.getString("subject6_mark");
				String subject1 = rs.getString("subject1");
				String subject2 = rs.getString("subject2");
				String subject3 = rs.getString("subject3");
				String subject4 = rs.getString("subject4");
				String subject5 = rs.getString("subject5");
				String subject6 = rs.getString("subject6");

				map.put("id", id);
				map.put("name", name);
				map.put("grade", grade);
				map.put("classs", classs);
				map.put("subject1_mark", subject1_mark);
				map.put("subject2_mark", subject2_mark);
				map.put("subject3_mark", subject3_mark);
				map.put("subject4_mark", subject4_mark);
				map.put("subject5_mark", subject5_mark);
				map.put("subject6_mark", subject6_mark);
				map.put("subject1", subject1);
				map.put("subject2", subject2);
				map.put("subject3", subject3);
				map.put("subject4", subject4);
				map.put("subject5", subject5);
				map.put("subject6", subject6);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 获取所有的用户数据总量
	 * 
	 * @return
	 */
	public static int getMarkMapCount(Map param) {
		int count = 0;
		Connection conn = DBUtil.getInstance().getConnection();
		String sql = "select count(*) from (SELECT G.student_id as id,S.grade as grade,S.class AS class FROM sec_grade G LEFT JOIN sec_student S ON G.student_id=S.id HAVING (grade=? AND class=?)) AA";
		String sSearch = (String) param.get("sSearch");
		PreparedStatement stmt = null;
		ResultSet rs = null;

		/**
		 * 分离key
		 */
		String kc = (String) param.get("key");
		String[] two = null;
		int grade = 1;
		int classs = 1;
		String searchName = null;
		if (kc != null) {
			two = kc.split(",");
			if (two.length == 2) {
				grade = Integer.parseInt(two[0]);
				classs = Integer.parseInt(two[1]);
			} else if (two.length == 3) {
				grade = Integer.parseInt(two[0]);
				classs = Integer.parseInt(two[1]);
				searchName = two[2];
			} else {
				return 0;
			}
		}

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, grade);
			stmt.setInt(2, classs);
			if (searchName != null && !searchName.trim().equals("")) {
				sql = "select count(*) from (SELECT G.student_id as id,S.`name` AS name,S.grade as grade,S.class AS class FROM sec_grade G LEFT JOIN sec_student S ON G.student_id=S.id HAVING (grade=? AND class=? AND name=?)) AA";
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, grade);
				stmt.setInt(2, classs);
				stmt.setString(3, searchName);
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

	public static String makeSql(String sql, String cn, String order) {
		sql = sql.replace("column", cn);

		sql = sql.replace("asc", order);
		return sql;
	}

	/**
	 * 获取所有的用户数据
	 * 
	 * @return
	 */
	public static List<Map> getMarkMap(Map param) {

		System.out.println("markdao getmarkmap" + param);

		List<Map> list = new LinkedList<Map>();
		Connection conn = DBUtil.getInstance().getConnection();
		String sql = "select *,(subject1_mark+subject2_mark+subject3_mark+subject4_mark+subject5_mark+subject6_mark) as sum,(subject1_mark+subject2_mark+subject3_mark+subject4_mark+subject5_mark+subject6_mark)/6 as average from (select *,(@rownum:=@rownum+1) as rownum from (select S.id,S.`name`,S.grade as gg,S.class as cc,G.subject1,G.subject1_mark,G.subject2,G.subject2_mark,G.subject3,G.subject3_mark,G.subject4,G.subject4_mark,G.subject5,G.subject5_mark,G.subject6,G.subject6_mark from sec_grade G LEFT JOIN sec_student S on G.student_id=S.id HAVING gg = ? && cc = ?) AA,(select (@rownum:=0)) BB) CC where CC.rownum<? && CC.rownum>? order by (column+0) asc;";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Integer start = (Integer) param.get("start");
		Integer pageSize = (Integer) param.get("pageSize");
		String sSearch = (String) param.get("sSearch");

		/**
		 * 分离排序参数
		 */
		String order = (String) param.get("order");
		int column = (int) param.get("column");
		String cn = columnName[column];
		System.out.println("选了列:" + cn);
		sql = makeSql(sql, cn, order);

		/**
		 * 分离key
		 */
		String kc = (String) param.get("key");
		System.out.println("kc:" + kc);
		String[] two = null;
		String searchName = null;
		int grade = 1;
		int classs = 1;
		if (kc != null) {
			two = kc.split(",");
			if (two.length == 2) {
				grade = Integer.parseInt(two[0]);
				classs = Integer.parseInt(two[1]);
			} else if (two.length == 3) {
				grade = Integer.parseInt(two[0]);
				classs = Integer.parseInt(two[1]);
				searchName = two[2];
			} else {
				return list;
			}
		}

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, grade);
			stmt.setInt(2, classs);
			stmt.setInt(3, start + pageSize + 1);
			stmt.setInt(4, start);
			System.out.println("sql：" + stmt.toString());
			if (searchName != null && !searchName.trim().equals("")) {
				System.out.println("searchname");
				sql = "select * from (select *,(@rownum:=@rownum+1) as rownum from (select S.id,S.`name` as name,S.grade as gg,S.class as cc,G.subject1,G.subject1_mark,G.subject2,G.subject2_mark,G.subject3,G.subject3_mark,G.subject4,G.subject4_mark,G.subject5,G.subject5_mark,G.subject6,G.subject6_mark from sec_grade G LEFT JOIN sec_student S on G.student_id=S.id HAVING gg = ? && cc = ? && name= ? ) AA,(select (@rownum:=0)) BB) CC where CC.rownum<? && CC.rownum>? order by sum ?;";
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, grade);
				stmt.setInt(2, classs);
				stmt.setString(3, searchName);
				stmt.setInt(4, start + pageSize + 1);
				stmt.setInt(5, start);
				stmt.setString(6, cn);
			}
			rs = stmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int gradee = rs.getInt("gg");
				int classss = rs.getInt("cc");
				String subject1 = rs.getString("subject1");
				String subject2 = rs.getString("subject2");
				String subject3 = rs.getString("subject3");
				String subject4 = rs.getString("subject4");
				String subject5 = rs.getString("subject5");
				String subject6 = rs.getString("subject6");
				float subject1_mark = rs.getFloat("subject1_mark");
				float subject2_mark = rs.getFloat("subject2_mark");
				float subject3_mark = rs.getFloat("subject3_mark");
				float subject4_mark = rs.getFloat("subject4_mark");
				float subject5_mark = rs.getFloat("subject5_mark");
				float subject6_mark = rs.getFloat("subject6_mark");
				float sum = rs.getFloat("sum");
				float average = rs.getFloat("average");
				Map m = new HashedMap();
				m.put("id", id);
				m.put("name", name);
				m.put("grade", gradee);
				m.put("class", classss);
				m.put("subject1_mark", subject1_mark);
				m.put("subject2_mark", subject2_mark);
				m.put("subject3_mark", subject3_mark);
				m.put("subject4_mark", subject4_mark);
				m.put("subject5_mark", subject5_mark);
				m.put("subject6_mark", subject6_mark);
				m.put("sum", sum);
				m.put("average", average);
				System.out.println("jieguo:" + m);

				list.add(m);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.getInstance().close(rs, stmt);
		}
		return list;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private static String[] columun2 ={"grade","class","sum_1","sum_2","sum_3","sum_4","sum_5","sum_6","sum_sum","sum_avg"};
	
	public static String getSql(String sql,String cn,String order){
		String subsql =" order by sum_avg desc";
		subsql= subsql.replace("column", cn);
		subsql= subsql.replace("desc", order);
		return sql+subsql;
	}
	
	public static List<Map> getClassMarkMap1(Map param) {
		String sql = "select grade,class,sum(subject1_mark)/6 as sum_1,sum(subject2_mark)/6 as sum_2,sum(subject3_mark)/6 as sum_3"
				+ ",sum(subject4_mark)/6 as sum_4,sum(subject5_mark)/6 as sum_5,sum(subject6_mark)/6 as sum_6,"
				+ "(sum(subject1_mark)+sum(subject2_mark)+sum(subject3_mark)+sum(subject4_mark)+sum(subject5_mark)+sum(subject6_mark))/6 as sum_sum,"
				+ "round((sum(subject1_mark)+sum(subject2_mark)+sum(subject3_mark)+sum(subject4_mark)+sum(subject5_mark)+sum(subject6_mark))/6,2)/6 as sum_avg from"
				+ "(select *,@rownum:=@rownum+1 as rownum from (select AA.grade,BB.class,AA.subject1_mark,AA.subject2_mark,AA.subject3_mark,AA.subject4_mark,AA.subject5_mark,AA.subject6_mark "
				+ "from sec_grade AA LEFT JOIN sec_student BB on AA.student_id=BB.id having AA.grade=?) CC,(select @rownum:=0) DD) EE GROUP BY class";
		
		List<Map> list = new LinkedList<Map>();
		Connection conn = DBUtil.getInstance().getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		/**
		 * 分离排序参数
		 */
		String order = (String) param.get("order");
		int column = (int) param.get("column");
		String cn = columnName2[column];
		System.out.println("选了列:" + cn);
		sql = getSql(sql,cn,order);

		/**
		 * 分离key
		 */
		String kc = (String) param.get("key");
		System.out.println("kc:" + kc);
		String[] two = null;
		int grade = 0;
		if (kc != null) {
			two = kc.split(",");
			grade = Integer.parseInt(two[0]);
		}
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, grade);
			System.out.println("getmap"+stmt);
			rs = stmt.executeQuery();
			while(rs.next()){
				String classs = rs.getString("class");
				float sum_1 = rs.getFloat("sum_1");
				float sum_2 = rs.getFloat("sum_2");
				float sum_3 = rs.getFloat("sum_3");
				float sum_4 = rs.getFloat("sum_4");
				float sum_5 = rs.getFloat("sum_5");
				float sum_6 = rs.getFloat("sum_6");
				float sum_sum = rs.getFloat("sum_sum");
				float sum_avg = rs.getFloat("sum_avg");
				Map m = new HashMap<String, String>();
				m.put("grade", grade);
				m.put("class", classs);
				m.put("sum_1", sum_1);
				m.put("sum_2", sum_2);
				m.put("sum_3", sum_3);
				m.put("sum_4", sum_4);
				m.put("sum_5", sum_5);
				m.put("sum_6", sum_6);
				m.put("sum_sum", sum_sum);
				m.put("sum_avg", sum_avg);
				System.out.println("班的平均"+m);
				
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	finally{
			DBUtil.getInstance().close(rs, stmt);
		}
		return list;
	}

	public static int getClassMarkMap1Count(Map param) {
		String sql = "SELECT COUNT(*) FROM (select DISTINCT(BB.class),AA.grade from sec_grade AA LEFT JOIN sec_student BB ON AA.student_id = BB.id having grade=?) CC";
		Connection conn = DBUtil.getInstance().getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int count = 0;
		/**
		 * 分离key
		 */
		String kc = (String) param.get("key");
		String[] two = null;
		int grade = 0;
		if (kc != null) {
			two = kc.split(",");
			grade = Integer.parseInt(two[0]);
		}
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, grade);
			rs = stmt.executeQuery();
			while(rs.next()){
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.getInstance().close(rs, stmt);
		}
		return count;
	}
	
	
	
}
