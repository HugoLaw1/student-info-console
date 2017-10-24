package seehope.service.impl;

import seehope.dao.GradeDao;
import seehope.model.GradeModel;
import seehope.model.ResultModel;
import seehope.service.IGradeService;

public class GradeService implements IGradeService {

	@Override
	public ResultModel getSubjectByGrade(int grade) {
		GradeModel gM = GradeDao.getSubjectByGrade(grade);
		if(gM != null){
			return new ResultModel("001",gM);
		}
		return new ResultModel("002",gM);
	}

}
