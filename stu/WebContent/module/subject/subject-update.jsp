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
	src="${contextPath }/module/subject/js/subject-update.js"></script>
</head>
<body>
	<div class="pd-20">
		<form action="" onsubmit="return updateSubject();" method="post"
			class="form form-horizontal" id="form-member-add">
			<div class="row cl">
				<label class="form-label col-3"><span class="c-red">*</span>学科编号：</label>
				<div class="formControls col-5">
					<input type="text" class="input-text" placeholder="" id="sub_id"
						name="sub_id" datatype="*1-16" value="${subject.sub_id }"
						${subject.sub_id==null?'':'readonly'}
						onkeyup="value=value.replace(/[^\d]/g,'')">
				</div>
				<div class="col-4"></div>
			</div>
			<div class="row cl">
				<label class="form-label col-3"><span class="c-red">*</span>学科名称：</label>
				<div class="formControls col-5 skin-minimal">
					<input type="text" class="input-text" name="sub_name" id="sub_name"
						value="${subject.sub_name }" nullmsg=""
						onkeyup="value=value.replace(/[^\u4E00-\u9FA5]/g,'')" />
				</div>
				<div class="col-4"></div>
			</div>
			<div class="row cl">
				<label class="form-label col-3"><span class="c-red">*</span>学时：</label>
				<div class="formControls col-5">
					<input type="text" class="input-text" value="${subject.sub_hours }"
						placeholder="" id="sub_hours" name="sub_hours" nullmsg=""
						onkeyup="num(this)" />
				</div>
				<div class="col-4"></div>
			</div>
			<div class="row cl">
				<label class="form-label col-3"><span class="c-red">*</span>学分：</label>
				<div class="formControls col-5">
					<input type="text" class="input-text"
						value="${subject.sub_weight }" placeholder="" id="sub_weight"
						name="sub_weight" nullmsg="" onkeyup="num(this)" />
				</div>
				<div class="col-4"></div>
			</div>
			<div class="row cl">
				<label class="form-label col-3"><span class="c-red">*</span>先修课：</label>
				<div class="formControls col-5 skin-minimal">
					<input type="text" class="input-text" name="sub_pre" id="sub_pre"
						value="${subject.sub_pre }" nullmsg="" />
				</div>
				<div class="col-4"></div>
			</div>
			<div class="row cl">
				<label class="form-label col-3">备注：</label>
				<div class="formControls col-5">
					<textarea id="sub_remark" name="sub_remark" cols="" rows=""
						class="textarea" placeholder="说点什么...最少输入10个字符" datatype="*2-100"
						dragonfly="true" onKeyUp="textarealength(this,100)">${subject.sub_remark }</textarea>
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