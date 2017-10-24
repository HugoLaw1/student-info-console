package seehope.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import seehope.util.JsonTools;

public class Page {

	private Integer sEcho;// 记录操作的次数 每次加1
	private Integer iDisplayStart;// 起始
	private Integer iDisplayLength = 10;// size默认10
	private Integer count = 0;// 查询出来的数量

	/**
	 * 根据分页插件传来的aoData，封装page实体
	 * 
	 * aoData没有数据将默认显示前10条记录
	 * @param aoData
	 */
	public Page(String aoData) {
		if (aoData != null && aoData.trim().length() > 0) {
			List<Map> ja = JsonTools.parseJSON2List(aoData);
			for (int i = 0; i < ja.size(); i++) {
				Map obj = ja.get(i);
				if (obj.get("name").equals("sEcho"))
					sEcho = obj.get("value").toString() == null ? 0 : Integer.parseInt(obj.get("value").toString().replace(".0", ""));
				if (obj.get("name").equals("iDisplayStart"))
					iDisplayStart = obj.get("value").toString() == null ? 0
							: Integer.parseInt(obj.get("value").toString().replace(".0", ""));
				if (obj.get("name").equals("iDisplayLength"))
					iDisplayLength = obj.get("value").toString() == null ? iDisplayLength
							: Integer.parseInt(obj.get("value").toString().replace(".0", ""));
			}
		} else {// 没有数据将默认显示前10条记录
			sEcho = 0;
			iDisplayStart = 0;
			iDisplayLength = 10;
		}
	}

	/**
	 * 返回插件分页所需要的参数map
	 * @param map
	 * @return
	 */
	public Map pageObjToMap(Map map) {
		if (map == null) {
			map = new HashMap();
		}
		map.put("iTotalDisplayRecords", count);
		map.put("sEcho", sEcho + 1);
		map.put("iTotalRecords", count);
		return map;
	}

	public Integer getsEcho() {
		return sEcho;
	}

	public void setsEcho(Integer sEcho) {
		this.sEcho = sEcho;
	}

	public Integer getiDisplayStart() {
		return iDisplayStart;
	}

	public void setiDisplayStart(Integer iDisplayStart) {
		this.iDisplayStart = iDisplayStart;
	}

	public Integer getiDisplayLength() {
		return iDisplayLength;
	}

	public void setiDisplayLength(Integer iDisplayLength) {
		this.iDisplayLength = iDisplayLength;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
