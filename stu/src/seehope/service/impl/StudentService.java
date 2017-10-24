package seehope.service.impl;

import java.util.List;
import java.util.Map;

import seehope.dao.StudentDao;
import seehope.model.ResultModel;
import seehope.model.StudentModel;
import seehope.service.IStudentService;

public class StudentService implements IStudentService {

	
	
	@Override
	public ResultModel getStudentById(String id) {
		return new ResultModel("001",StudentDao.getStudentById(id));
	}
	
	@Override
	public ResultModel deleteStudent(String[] ids) {
		boolean result = StudentDao.deleteStudent(ids);
		if(result){
			return new ResultModel("001","删除成功");
		}
		return new ResultModel("002","删除失败");
	}
	
	@Override
	public List<Map> getAllStudentByPage(Map param) {
		return StudentDao.getStudentMap(param);
	}

	@Override
	public int getAllStudentByPageCount(Map param) {
		return StudentDao.getStudentMapCount(param);
	}

	@Override
	public ResultModel addStudent(StudentModel student) {
		String result = StudentDao.addStudent(student);
		if (result.equals("001")){
			return new ResultModel("001","添加成功");
		}else if(result.equals("003")){
			return new ResultModel("003","已有此学生");
		}else{
			return new ResultModel("002","添加失败");
		}
	}

	@Override
	public ResultModel editStudent(StudentModel student) {
		if(StudentDao.editStudent(student)){
			return new ResultModel("001","更新成功");
		}
		return new ResultModel("002","更新失败");
	}

}
