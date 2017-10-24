<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="/common/meta.jsp" %>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
</head>
<body>
<div class="cl pd-20" style=" background-color:#5bacb6">
  <img class="avatar size-XL l" src="${contextPath }/static/images/user.png">
  <dl style="margin-left:80px; color:#fff">
    <dt><span class="f-18">${user.username}</span></dt>
    <dd class="pt-10 f-12" style="margin-left:0">${user.remark==''?'这家伙很懒，什么也没有留下':user.remark }</dd>
  </dl>
</div>
<div class="pd-20">
  <table class="table">
    <tbody>
      <tr>
        <th class="text-r" width="80">性别：</th>
        <td>${user.sex}</td>
      </tr>
      <tr>
        <th class="text-r">手机：</th>
        <td>${user.phone}</td>
      </tr>
      <tr>
        <th class="text-r">状态：</th>
        <td>${user.status==001?'有效':'无效'}</td>
      </tr>
      <tr>
        <th class="text-r">注册时间：</th>
        <td>${user.createdTime}</td>
      </tr>
      <tr>
        <th class="text-r">备注：</th>
        <td>${user.remark}</td>
      </tr>
    </tbody>
  </table>
</div>
</body>
</html>