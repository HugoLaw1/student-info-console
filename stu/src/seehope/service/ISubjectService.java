package seehope.service;

import java.util.List;
import java.util.Map;

import seehope.model.ResultModel;
import seehope.model.SubjectModel;

public interface ISubjectService {
	
	List<Map> getAllSubjectByPage(Map param);
	int getAllSubjectByPageCount(Map param);
	ResultModel addSubject(SubjectModel subject);
	ResultModel deleteSubject(String[] args);
	ResultModel getSubjectById(String id);
	ResultModel editSubject(SubjectModel subject);
}
