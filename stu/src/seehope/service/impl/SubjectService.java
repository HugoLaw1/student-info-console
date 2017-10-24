package seehope.service.impl;

import java.util.List;
import java.util.Map;

import seehope.dao.SubjectDao;
import seehope.model.ResultModel;
import seehope.model.SubjectModel;
import seehope.service.ISubjectService;

public class SubjectService implements ISubjectService {

	@Override
	public ResultModel getSubjectById(String id) {
		return new ResultModel("001", SubjectDao.getSubjectById(id));
	}

	@Override
	public ResultModel deleteSubject(String[] ids) {
		boolean result = SubjectDao.deleteSubject(ids);
		if (result) {
			return new ResultModel("001", "删除成功");
		}
		return new ResultModel("002", "删除失败");
	}

	@Override
	public List<Map> getAllSubjectByPage(Map param) {
		return SubjectDao.getSubjectMap(param);
	}

	@Override
	public int getAllSubjectByPageCount(Map param) {
		return SubjectDao.getSubjectMapCount(param);
	}

	@Override
	public ResultModel addSubject(SubjectModel subject) {
		String result = SubjectDao.addSubject(subject);
		if (result.equals("001")) {
			return new ResultModel("001", "添加成功");
		} else if (result.equals("003")) {
			return new ResultModel("003", "已有此学科编号");
		} else if (result.equals("004")) {
			return new ResultModel("004", "不存在此先修课");
		} else {
			return new ResultModel("002", "添加失败");
		}
	}

	@Override
	public ResultModel editSubject(SubjectModel subject) {
		String result = SubjectDao.editSubject(subject);
		if (result.equals("001")) {
			return new ResultModel("001", "更新成功");
		} else if (result.equals("004")) {
			return new ResultModel("004", "没有此先修课");
		} else {
			return new ResultModel("002", "更新失败");
		}
	}
}
