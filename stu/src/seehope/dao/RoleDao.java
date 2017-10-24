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
import seehope.model.RoleModel;
import seehope.model.UserModel;
import seehope.security.SecurityContext;

public class RoleDao {
	/**
	 * 根据ID删除指定的角色
	 * 
	 * @param id
	 * @return
	 */
	public static boolean deleteRole(String[] ids) {
		
		
		
		boolean result = false;
		String sql = "DELETE FROM SEC_ROLE WHERE ID = ?";
		try {
			Connection conn = DBUtil.getInstance().getConnection();
			conn.setAutoCommit(false);
			PreparedStatement stmt = conn.prepareStatement(sql);
			for (String id : ids) {
				
				RoleModel role = RoleDao.getRoleById(id);
				if(role.getRolename().equals("super"))
					continue;
				if(UserDao.hasRole(role.getRolename()))
					continue;
				stmt.setString(1, id);
				stmt.addBatch();
			}
			int[] c = stmt.executeBatch();
			conn.commit();
			if (c.length > 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 获取所有的角色数据
	 * 
	 * @return
	 */
	public static List<RoleModel> getRoles() {
		List<RoleModel> list = new LinkedList<RoleModel>();
		Connection conn = DBUtil.getInstance().getConnection();
		String sql = "SELECT * FROM SEC_ROLE U ";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("ID");
				String rolename = rs.getString("ROLENAME");
				String context = rs.getString("CONTEXT");
				Date createdTime = rs.getDate("CREATED_TIME");
				Date lastUpdateTime = rs.getDate("LAST_UPDATE_TIME");
				RoleModel role = new RoleModel();
				role.setId(id);
				role.setContext(context);
				role.setRolename(rolename);
				role.setCreatedTime(createdTime);
				role.setLastUpdateTime(lastUpdateTime);
				list.add(role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.getInstance().close(rs, stmt);
		}
		return list;
	}

	/**
	 * 获取所有的角色数据总量
	 * 
	 * @return
	 */
	public static int getRolesMapCount(Map param) {
		int count = 0;
		Connection conn = DBUtil.getInstance().getConnection();
		String sql = "SELECT COUNT(1) FROM SEC_ROLE U";
		String sSearch = (String) param.get("sSearch");
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			if(sSearch!=null&&!sSearch.trim().equals("")){
				sql = "SELECT COUNT(1) FROM SEC_ROLE WHERE ROLENAME=?";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, sSearch.trim());
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
	 * 获取所有的角色数据
	 * 
	 * @return
	 */
	public static List<Map> getRolesMap(Map param) {
		List<Map> list = new LinkedList<Map>();
		Connection conn = DBUtil.getInstance().getConnection();
		String sql = "SELECT * FROM SEC_ROLE";
		String sSearch = (String) param.get("sSearch");
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			if(sSearch!=null&&!sSearch.trim().equals("")){
				sql = "SELECT * FROM SEC_ROLE WHERE ROLENAME=?";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, sSearch.trim());
			}
			rs = stmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("ID");
				String rolename = rs.getString("ROLENAME");
				String context = rs.getString("CONTEXT");
				Date createdTime = rs.getDate("CREATED_TIME");
				Date lastUpdateTime = rs.getDate("LAST_UPDATE_TIME");
				
				Map m = new HashedMap();
				m.put("id", id);
				m.put("rolename", rolename);
				m.put("context", context);
				m.put("createdTime", createdTime);
				m.put("lastUpdateTime", lastUpdateTime);
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.getInstance().close(rs, stmt);
		}
		//System.out.println(list);
		return list;
	}

	/**
	 * 新增角色
	 * 
	 * @param user
	 * @return
	 */
	public static boolean addRole(RoleModel role) {
		if(role.getRolename().equals("primary"))
			return false;
		if(RoleDao.hasRole(role.getRolename()))
			return false;
		
		boolean result = false;
		String sql = "INSERT INTO SEC_ROLE (ID,ROLENAME,CONTEXT,CREATED_TIME,LAST_UPDATE_TIME)"
				+ "VALUES(?,?,?,SYSDATE,SYSDATE)";
		Connection conn = DBUtil.getInstance().getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, role.getId());
			stmt.setString(2, role.getRolename());
			stmt.setString(3, role.getContext());
			int c = stmt.executeUpdate();
			if (c > 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static RoleModel getRoleById(String id) {
		RoleModel role = null;
		Connection conn = DBUtil.getInstance().getConnection();
		String sql = "SELECT * FROM SEC_ROLE U WHERE U.ID = ?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String rolename = rs.getString("ROLENAME");
				String context = rs.getString("CONTEXT");
				Date createdTime = rs.getDate("CREATED_TIME");
				Date lastUpdateTime = rs.getDate("LAST_UPDATE_TIME");
				role = new RoleModel();
				role.setId(id);
				role.setContext(context);
				role.setRolename(rolename);
				role.setCreatedTime(createdTime);
				role.setLastUpdateTime(lastUpdateTime);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.getInstance().close(rs, stmt);
		}
		return role;
	}
	
	public static RoleModel getRole(String rolename) {
		
		if(rolename.equals("primary")){
			RoleModel role = new RoleModel();
			role.setContext("");
			role.setRolename("primary");
			return role;
		}
		
		RoleModel role = null;
		Connection conn = DBUtil.getInstance().getConnection();
		String sql = "SELECT * FROM SEC_ROLE U WHERE U.ROLENAME = ? ";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, rolename);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("ID");
				rolename = rs.getString("ROLENAME");
				String context = rs.getString("CONTEXT");
				Date createdTime = rs.getDate("CREATED_TIME");
				Date lastUpdateTime = rs.getDate("LAST_UPDATE_TIME");
				role = new RoleModel();
				role.setId(id);
				role.setContext(context);
				role.setRolename(rolename);
				role.setCreatedTime(createdTime);
				role.setLastUpdateTime(lastUpdateTime);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.getInstance().close(rs, stmt);
		}
		return role;
	}
	
	
	public static boolean hasRole(String rolename) {
		
		Connection conn = DBUtil.getInstance().getConnection();
		String sql = "SELECT * FROM SEC_ROLE U WHERE U.ROLENAME = ? ";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, rolename);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.getInstance().close(rs, stmt);
		}
		return false;
	}
	
	public static boolean updateRole(RoleModel role) {
		boolean result = false;
		String sql = "UPDATE SEC_ROLE SET CONTEXT=?,LAST_UPDATE_TIME=SYSDATE"
				+ " WHERE ID = ?";
		Connection conn = DBUtil.getInstance().getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, role.getContext());
			stmt.setString(2, role.getId());
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
