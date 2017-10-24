package seehope.service;

import java.util.List;
import java.util.Map;

import seehope.model.ResultModel;


public interface IMarkService {
	List<Map> getAllMarkByPage(Map param);
	int getAllMarkByPageCount(Map param);
	
	ResultModel getMarkById(String id); 
	ResultModel updateMark(Map param);
	

	List<Map> getAllClassMarkByPage(Map param);
	int getAllClassMarkByPageCount(Map param);
}
