package seehope.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import seehope.dao.RoleDao;
import seehope.dao.UserDao;
import seehope.model.ResultModel;
import seehope.model.RoleModel;
import seehope.model.UserModel;
import seehope.security.SecurityContext;
import seehope.service.IRoleService;

public class RoleService implements IRoleService{

	@Override
	public ResultModel deleteRole(String[] ids) {
		if(RoleDao.deleteRole(ids)){
			return new ResultModel("001","删除成功！");
		}
		return new ResultModel("000","删除失败！");
	}

	@Override
	public ResultModel addRole(RoleModel role) {
		
		role.setId(UUID.randomUUID().toString());
		if (!RoleDao.addRole(role)) {
			return new ResultModel("000", "新增角色失败！");
		}
		return new ResultModel("001", "新增角色成功！",role);
		
		
	}

	@Override
	public ResultModel editRole(RoleModel role) {
		boolean result = RoleDao.updateRole(role);
		if (!result) {
			return new ResultModel("000", "修改用户失败！");
		}
		return new ResultModel("001", "修改用户成功！",role);
	}

	@Override
	public ResultModel getRoleById(String id) {
		RoleModel role = RoleDao.getRoleById(id);
		ResultModel result = new ResultModel("001", role);
		return result;
	}

	@Override
	public ResultModel getAllRole() {
		List<RoleModel> roles = RoleDao.getRoles();
		return new ResultModel("001", roles);
	}
	
	public List<Map> getAllRoleByPage(Map param) {
		return RoleDao.getRolesMap(param);
	}

	public int getAllRoleByPageCount(Map param) {
		return RoleDao.getRolesMapCount(param);
	}

	@Override
	public RoleModel getRoleModel(String rolename) {
		return RoleDao.getRole(rolename);
	}

}
