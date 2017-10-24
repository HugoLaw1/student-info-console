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
	src="${contextPath }/module/mark/js/mark-edit.js"></script>
</head>
<body>
	<div class="pd-20">
		<form action="" onsubmit="return updateMark();" method="post"
			class="form form-horizontal" id="form-member-add">
			<div class="row cl">
				<label class="form-label col-3"><span class="c-red">*</span>学号：</label>
				<div class="formControls col-5">
					<input type="text" class="input-text" placeholder="" id="id"
						name="id" datatype="*1-16" value="${mark.id }"
						${mark.id==null?'':'readonly'}>
				</div>
				<div class="col-4"></div>
			</div>
			<div class="row cl">
				<label class="form-label col-3"><span class="c-red">*</span>姓名：</label>
				<div class="formControls col-5">
					<input type="text" class="input-text" placeholder="" id="name"
						name="name" datatype="*1-16" value="${mark.name }"
						${mark.name==null?'':'readonly'}>
				</div>
				<div class="col-4"></div>
			</div>
			<div class="row cl">
				<label class="form-label col-3"><span class="c-red">*</span>年级：</label>
				<div class="formControls col-5">
					<input type="text" class="input-text" placeholder="" id="grade"
						name="grade" datatype="*1-16" value="${mark.grade }"
						${mark.grade==null?'':'readonly'}>
				</div>
				<div class="col-4"></div>
			</div>
			<div class="row cl">
				<label class="form-label col-3"><span class="c-red">*</span>班别：</label>
				<div class="formControls col-5">
					<input type="text" class="input-text" placeholder="" id="classs"
						name="classs" datatype="*1-16" value="${mark.classs }"
						${mark.classs==null?'':'readonly'}>
				</div>
				<div class="col-4"></div>
			</div>
			<div class="row cl">
				<label class="form-label col-3"><span class="c-red">*</span>${mark.subject1 }：</label>
				<div class="formControls col-5">
					<input type="text" class="input-text" placeholder="" id="subject1_mark"
						name="subject1_mark" datatype="*1-16" value="${mark.subject1_mark }" onkeyup="num(this)">
				</div>
				<div class="col-4"></div>
			</div>
			<div class="row cl">
				<label class="form-label col-3"><span class="c-red">*</span>${mark.subject2 }：</label>
				<div class="formControls col-5">
					<input type="text" class="input-text" placeholder="" id="subject2_mark"
						name="subject2_mark" datatype="*1-16" value="${mark.subject2_mark } " onkeyup="num(this)">
				</div>
				<div class="col-4"></div>
			</div>
			<div class="row cl">
				<label class="form-label col-3"><span class="c-red">*</span>${mark.subject3 }：</label>
				<div class="formControls col-5">
					<input type="text" class="input-text" placeholder="" id="subject3_mark"
						name="subject3_mark" datatype="*1-16" value="${mark.subject3_mark }" onkeyup="num(this)">
				</div>
				<div class="col-4"></div>
			</div>
			<div class="row cl">
				<label class="form-label col-3"><span class="c-red">*</span>${mark.subject4 }：</label>
				<div class="formControls col-5">
					<input type="text" class="input-text" placeholder="" id="subject4_mark"
						name="subject4_mark" datatype="*1-16" value="${mark.subject4_mark }" onkeyup="num(this)">
				</div>
				<div class="col-4"></div>
			</div>
			<div class="row cl">
				<label class="form-label col-3"><span class="c-red">*</span>${mark.subject5 }：</label>
				<div class="formControls col-5">
					<input type="text" class="input-text" placeholder="" id="subject5_mark"
						name="subject5_mark" datatype="*1-16" value="${mark.subject5_mark }" onkeyup="num(this)">
				</div>
				<div class="col-4"></div>
			</div>
			<div class="row cl">
				<label class="form-label col-3"><span class="c-red">*</span>${mark.subject6 }：</label>
				<div class="formControls col-5">
					<input type="text" class="input-text" placeholder="" id="subject6_mark"
						name="subject6_mark" datatype="*1-16" value="${mark.subject6_mark }" onkeyup="num(this)">
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