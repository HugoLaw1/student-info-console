package seehope.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import seehope.model.Page;
import seehope.util.InvokeTools;
import seehope.util.JsonTools;

public class DataTableService {

	public Map getData(String service, String method, String aoData, String param) {
		// 解析分页参数
		Page page = new Page(aoData);
		// 检索参数
		String sSearch = null;

		String order = "asc";
		int column = 1;
		
		List<Map> ja = JsonTools.parseJSON2List(aoData);
		for (int i = 0; i < ja.size(); i++) {
			Map obj = ja.get(i);
			if (obj.get("name").equals("sSearch")){
				sSearch = obj.get("value").toString();
			}
			if(	obj.get("name").equals("iSortCol_0")){
				column = Integer.parseInt(obj.get("value").toString());
			}
			if( obj.get("name").equals("sSortDir_0")){
				order = obj.get("value").toString();
			}
		}
		
		// 分页查询参数
		Map queryParam = new HashMap();
		queryParam.put("start", page.getiDisplayStart());
		queryParam.put("pageSize", page.getiDisplayLength());
		queryParam.put("sSearch", sSearch);
		queryParam.put("order", order);
		queryParam.put("column", column);
		// 解析参数
		Map<String, Object> jsonParam = JsonTools.parseJSON2Map(param);
		for (String key : jsonParam.keySet()) {
			queryParam.put(key, jsonParam.get(key));
		}

		// queryparam {sSearch=, start=0, pageSize=10}

		service = "seehope.service.impl." + service;
		// 查询列表数据
		List<Map> resultList = (LinkedList<Map>) InvokeTools.invoke(service, method, new Class[] { Map.class },
				new Object[] { queryParam });
		// 条件查询记录总数
		int count = (Integer) InvokeTools.invoke(service, method + "Count", new Class[] { Map.class },
				new Object[] { queryParam });
		page.setCount(count);
		
		// 返回界面数据
		Map map = new HashMap();
		page.pageObjToMap(map);
		map.put("aaData", resultList);

		return map;

	}

}
