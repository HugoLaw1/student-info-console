package seehope.service;

import java.util.List;
import java.util.Map;

import seehope.model.ResultModel;
import seehope.model.StudentModel;

public interface IStudentService {
	
	List<Map> getAllStudentByPage(Map param);
	int getAllStudentByPageCount(Map param);
	ResultModel addStudent(StudentModel student);
	ResultModel deleteStudent(String[] args);
	ResultModel getStudentById(String id);
	ResultModel editStudent(StudentModel student);
}
