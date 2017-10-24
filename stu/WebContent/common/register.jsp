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
<title>注册账号</title>
<script type="text/javascript" src="${contextPath }/common/js/register.js"></script>

</head>
<body>
	<div class="loginWraper">
		<div id="registerform" class="loginBox">
			<form class="form form-horizontal" method="post"
				onsubmit="return registerFunc();">
				<div class="row cl">
					<label class="form-label col-3"><i class="Hui-iconfont">&#xe60d;</i></label>
					<div class="formControls col-8">
						<input id="sellerid" name="sellerid" type="text"
							placeholder="卖家ID" class="input-text size-L">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-3"><i class="Hui-iconfont">&#xe60d;</i></label>
					<div class="formControls col-8">
						<input id="username" name="username" type="text" placeholder="账户"
							class="input-text size-L">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-3"><i class="Hui-iconfont">&#xe60e;</i></label>
					<div class="formControls col-8">
						<input id="password" name="password" type="password"
							placeholder="密码" class="input-text size-L">
					</div>
				</div>
				<div class="row">
					<div class="formControls col-8 col-offset-3">
						<button type="submit" name="register"
							class="btn btn-primary radius size-L" value="1" >注册</button>
						<button type="reset" class="btn btn-warnning radius size-L">取消</button>
					</div>
				</div>
			</form>
		</div>
	</div>

</body>

</html>