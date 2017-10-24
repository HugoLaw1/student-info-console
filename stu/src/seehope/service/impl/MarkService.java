package seehope.service.impl;

import java.util.List;
import java.util.Map;

import seehope.dao.MarkDao;
import seehope.model.GradeModel;
import seehope.model.ResultModel;
import seehope.service.IMarkService;

public class MarkService implements IMarkService {

	@Override
	public List<Map> getAllMarkByPage(Map param) {
		return MarkDao.getMarkMap(param);
	}

	@Override
	public int getAllMarkByPageCount(Map param) {
		return MarkDao.getMarkMapCount(param);
	}

	@Override
	public ResultModel getMarkById(String id) {
		return new ResultModel("001",MarkDao.getMarkById(id));
	}

	@Override
	public ResultModel updateMark(Map map) {
		if(MarkDao.updateMark(map)){
			return new ResultModel("001","更新成功");
		}
		return new ResultModel("002","更新失败");
	}

	@Override
	public List<Map> getAllClassMarkByPage(Map param) {
		return MarkDao.getClassMarkMap1(param);
	}

	@Override
	public int getAllClassMarkByPageCount(Map param) {
		return MarkDao.getClassMarkMap1Count(param);
	}
}
