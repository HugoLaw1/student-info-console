<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="seehope.security.SecurityContext"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="/common/meta.jsp"%>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<title>用户管理</title>
<script type="text/javascript"
	src="${contextPath }/module/mark/js/mark-list.js"></script>
</head>
<body>
	<a class="hidden context"><%=SecurityContext.getCurrentContext()%></a>
	<a class="hidden userId"><%=SecurityContext.getCurrentUser().getId()%></a>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
		用户中心 <span class="c-gray en">&gt;</span> 用户管理 <a
			class="btn btn-success radius r mr-20"
			style="line-height: 1.6em; margin-top: 3px"
			href="javascript:location.replace(location.href);" title="刷新"><i
			class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="pd-20">

		<div class="text-c" id="query">
			年级：
			<select id="grade" class="input-text" style="width: 60px">
				<option value=""></option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
			</select>
			班级：
			<select id="class" class="input-text" style="width: 60px">
				<option value=""></option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
			</select>
			合格分数：
			<input id="qualified" name="qualified" class="input-text" style="width: 60px"/>
			一等奖学金分数线：
			<input id="scholarship1" name="scholarship1" class="input-text" style="width: 60px"/>
			二等奖学金分数线：
			<input id="scholarship2" name="scholarship3" class="input-text" style="width: 60px"/>
			三等奖学金分数线：
			<input id="scholarship3" name="scholarship4" class="input-text" style="width: 60px"/>
			
			 <input type="hidden" class="input-text" style="width: 60px"
				placeholder="" id="key" name="key">
			<button type="button" class="btn btn-success radius" id="search"
				name="search">
				<i class="Hui-iconfont">&#xe665;</i> 搜
			</button>
			
		</div>
		
		
		
<!-- 		<div class="cl pd-5 bg-1 bk-gray mt-20">
			<span class="l"> <a href="javascript:;"
				onclick="datasDelete()" class="btn btn-danger radius"> <i
					class="Hui-iconfont">&#xe6e2;</i> 批量删除
			</a> <a href="javascript:;"
				onclick="member_add('添加学生','StudentController/addOrEditStudent.do','','510')"
				class="btn btn-primary radius"> <i class="Hui-iconfont">&#xe600;</i>
					添加学生
			</a>
			</span>
		</div> -->
		<div class="mt-20">
			<table id="myTable"
				class="table table-border table-bordered table-hover table-bg table-sort">
				<thead>
					<tr id="subject" class="text-c">
						<th width="10"><input type="checkbox" name="" value=""></th>
						<th width="20">学生学号</th>
						<th width="20">学生姓名</th>
						<th width="20">年级</th>
						<th width="20">班别</th>
						<th id="subject1" width="20"></th>
						<th id="subject2" width="20"></th>
						<th id="subject3" width="20"></th>
						<th id="subject4" width="20"></th>
						<th id="subject5" width="20"></th>
						<th id="subject6" width="20"></th>
						<th id="sum" width="20">总成绩</th>
						<th id="average" width="20">平均成绩</th>
						<th id="average" width="20">奖学金等级</th>
 						<th id="average" width="20">奖学金</th>
 						<th id="" width="20"></th>
					</tr>
				</thead>
				<tbody id="user-list">
				
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>