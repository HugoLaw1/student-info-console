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
<title>修改密码</title>
<script type="text/javascript"
	src="${contextPath }/module/user/js/user-setPassword.js"></script>
</head>
<body>
	<div class="pd-20">
		<form action="" onsubmit="return setStatus();" method="post"
			class="form form-horizontal" id="form-member-add">
			<input type="hidden" name="id" id="id" value="${user.id }" />
			
			<div class="row cl">
					<label class="form-label col-3"><span class="c-red">*</span>旧密码：</label>
					<div class="formControls col-5">
						<input type="password" class="input-text" 
							placeholder="" id="oldp" name="oldp" datatype="*1-16"
							nullmsg="密码不能为空" 
							onblur="checkOp()">
					</div>
					<div class="col-4" id="append"></div>
			</div>
			<div class="row cl">
					<label class="form-label col-3"><span class="c-red">*</span>新密码：</label>
					<div class="formControls col-5">
						<input type="password" class="input-text" 
							placeholder="" id="newp" name="newp" datatype="*1-16"
							nullmsg="密码不能为空">
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