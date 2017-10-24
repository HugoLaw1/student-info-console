<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>添加用户</title>
<script type="text/javascript"
	src="${contextPath }/module/user/js/user-add.js"></script>
</head>
<body>
	<div class="pd-20">
		<form action="" onsubmit="return addUser();" method="post"
			class="form form-horizontal" id="form-member-add">
			<input type="hidden" name="id" id="id" value="${user.id }" />
			<c:if test="${empty user.id }">
				<div class="row cl">
					<label class="form-label col-3"><span class="c-red">*</span>用户名：</label>
					<div class="formControls col-5">
						<input type="text" class="input-text" value="${user.username }"
							placeholder="" id="username" name="username" datatype="*1-16"
							nullmsg="用户名不能为空">
					</div>
					<div class="col-4"></div>
				</div>
			</c:if>
			<div class="row cl">
				<label class="form-label col-3"><span class="c-red">*</span>性别：</label>
				<div class="formControls col-5 skin-minimal">
					<input type="hidden" name="sexname" id="sexname" value="${user.sex }" />
				</div>
				<div class="col-4"></div>
			</div>
			<div class="row cl">
				<label class="form-label col-3"><span class="c-red">*</span>手机：</label>
				<div class="formControls col-5">
					<input type="text" class="input-text" value="${user.phone }"
						placeholder="" id="phone" name="phone" datatype="m"
						nullmsg="手机不能为空">
				</div>
				<div class="col-4"></div>
			</div>
			<div class="row cl">
				<label class="form-label col-3">备注：</label>
				<div class="formControls col-5">
					<textarea name="remark" cols="" rows="" class="textarea"
						placeholder="说点什么...最少输入10个字符" datatype="*2-100" dragonfly="true"
						 onKeyUp="textarealength(this,100)"></textarea>
					<p class="textarea-numberbar">
						<em class="textarea-length">0</em>/100
					</p>
				</div>
				<div class="col-4"></div>
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