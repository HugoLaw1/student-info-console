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
<title>激活用户</title>
<script type="text/javascript"
	src="${contextPath }/module/user/js/user-setStatus.js"></script>
</head>
<body>
	<div class="pd-20">
		<form action="" onsubmit="return setStatus();" method="post"
			class="form form-horizontal" id="form-member-add">
			<input type="hidden" name="id" id="id" value="${user.id }" />
			
			<div class="row cl">
				<label class="form-label col-3"><span class="c-red">*</span>选择：</label>
				<div class="formControls col-5 skin-minimal">
					<div class="radio-box">
						<input type="radio" id="s-1" name="s" datatype="*"
							nullmsg="请设置！" value="001" ${user.status=='001'?'checked':''}>
						<label for="s-1">激活</label>
					</div>
					<div class="radio-box">
						<input type="radio" id="s-2" name="s" value="002"
							${user.status=='002'?'checked':''}> <label for="s-2">注销</label>
					</div>
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
</body>
</html>