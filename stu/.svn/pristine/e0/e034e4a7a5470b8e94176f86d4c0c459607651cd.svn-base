<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<title>添加角色</title>
<script type="text/javascript"
	src="${contextPath }/module/role/js/role-add.js"></script>
</head>
<body>
	<div class="pd-20">
		<form action="" onsubmit="return addRole();" method="post"
			class="form form-horizontal" id="form-member-add">
			<input type="hidden" name="id" id="id" value="${role.id }" />
			<c:if test="${empty role.id }">
				<div class="row cl">
					<label class="form-label col-3"><span class="c-red">*</span>角色名：</label>
					<div class="formControls col-5">
						<input type="text" class="input-text" value="${role.rolename }"
							placeholder="" id="rolename" name="rolename" datatype="*2-16"
							nullmsg="角色不能为空">
					</div>
					<div class="col-4"></div>
				</div>
			</c:if>
			<div class="row cl">
				<label class="form-label col-3"><span class="c-red">*</span>可显示内容：</label>
				<div class="formControls skin-minimal">
					<div class="radio-box">
						<input type="checkbox" id="c1" name="context" 
							value="1" 
							${fn:contains(role.context,'1')?'checked':'' } 
							>
						<label for="c1">角色列表</label>
					</div>
					<div class="radio-box">
						<input type="checkbox" id="c2" name="context" value="2"
						${fn:contains(role.context,'2')?'checked':'' }
							> <label for="c2">分配角色</label>
					</div>
					<div class="radio-box">
						<input type="checkbox" id="c3" name="context" value="3"
						${fn:contains(role.context,'3')?'checked':'' }
							> <label for="c3">激活按钮</label>
					</div>
					<div class="radio-box">
						<input type="checkbox" id="c4" name="context" value="4"
						${fn:contains(role.context,'4')?'checked':'' }
							> <label for="c4">删除用户按钮</label>
					</div>
					<div class="radio-box">
						<input type="checkbox" id="c5" name="context" value="5"
						${fn:contains(role.context,'5')?'checked':'' }
							> <label for="c5">添加用户按钮</label>
					</div>
					<div class="radio-box">
						<input type="checkbox" id="c6" name="context" value="6"
						${fn:contains(role.context,'6')?'checked':'' }
							> <label for="c6">性别字典</label>
					</div>
					<div class="radio-box">
						<input type="checkbox" id="c7" name="context" value="7"
						${fn:contains(role.context,'7')?'checked':'' }
							> <label for="c7">日志</label>
					</div>
				</div>
			<div class="row cl">
				<div class="col-9 col-offset-3">
					<input class="btn btn-primary radius" type="submit"
						value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
				</div>
			</div>
		</form>
	</div>
	</div>
</body>
</html>