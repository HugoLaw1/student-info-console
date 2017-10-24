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
	src="${contextPath }/module/student/js/student-update.js"></script>
</head>
<body>
	<div class="pd-20">
		<form action="" onsubmit="return updateStudent();" method="post"
			class="form form-horizontal" id="form-member-add">
			<div class="row cl">
				<label class="form-label col-3"><span class="c-red">*</span>学号：</label>
				<div class="formControls col-5">
					<input type="text" class="input-text" placeholder="" id="id"
						name="id" datatype="*1-16" value="${student.id }"
						${student.id==null?'':'readonly'}>
				</div>
				<div class="col-4"></div>
			</div>
			<div class="row cl">
				<label class="form-label col-3"><span class="c-red">*</span>姓名：</label>
				<div class="formControls col-5 skin-minimal">
					<input type="text" class="input-text" name="name" id="name"
						value="${student.name }" nullmsg="姓名不能为空" />
				</div>
				<div class="col-4"></div>
			</div>
			<div class="row cl">
				<label class="form-label col-3"><span class="c-red">*</span>籍贯：</label>
				<div class="formControls col-5">
					<input type="text" class="input-text" value="${student.born }"
						placeholder="" id="born" name="born" nullmsg="籍贯不能为空">
				</div>
				<div class="col-4"></div>
			</div>
			<div class="row cl">
				<label class="form-label col-3"><span class="c-red">*</span>性别：</label>
				<div class="formControls col-1">
					<select id="sex">
						<option ${student.sex=='男'?'selected':''}>男</option>
						<option ${student.sex=='女'?'selected':''}>女</option>
					</select>
				</div>
				<div class="col-4"></div>
			</div>
			<div class="row cl">
				<label class="form-label col-3"><span class="c-red">*</span>年级：</label>
				<div class="formControls col-1">
					<select id="grade">
						<option ${student.grade=='1'?'selected':''}>1</option>
						<option ${student.grade=='2'?'selected':''}>2</option>
						<option ${student.grade=='3'?'selected':''}>3</option>
						<option ${student.grade=='4'?'selected':''}>4</option>
						<option ${student.grade=='5'?'selected':''}>5</option>
						<option ${student.grade=='6'?'selected':''}>6</option>
					</select>
				</div>
				<label class="form-label col-3"><span class="c-red">*</span>班级：</label>
				<div class="formControls col-3">
					<select id="classs">
						<option ${student.classs=='1'?'selected':''}>1</option>
						<option ${student.classs=='2'?'selected':''}>2</option>
						<option ${student.classs=='3'?'selected':''}>3</option>
						<option ${student.classs=='4'?'selected':''}>4</option>
						<option ${student.classs=='5'?'selected':''}>5</option>
						<option ${student.classs=='6'?'selected':''}>6</option>
					</select>
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-3">备注：</label>
				<div class="formControls col-5">
					<textarea name="remark" cols="" rows="" class="textarea"
						placeholder="说点什么...最少输入10个字符" datatype="*2-100" dragonfly="true"
						onKeyUp="textarealength(this,100)">${student.remark }</textarea>
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