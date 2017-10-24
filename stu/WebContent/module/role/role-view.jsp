<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <dt><span class="f-18">${role.rolename}</span></dt>
  </dl>
</div>
<div class="pd-20">
  <table class="table">
    <tbody>
      <tr>
        <th class="text-r" width="80">可显示内容：</th>
        <c:if test="${fn:contains(role.context,'1')}">
       		 <td><a class="btn btn-primary">角色列表</a></td>
        </c:if>
        <c:if test="${fn:contains(role.context,'2')}">
       		 <td><a class="btn btn-primary">分配角色</a></td>
        </c:if>
        <c:if test="${fn:contains(role.context,'3')}">
       		 <td><a class="btn btn-primary">激活按钮</a></td>
        </c:if>
        <c:if test="${fn:contains(role.context,'4')}">
       		 <td><a class="btn btn-primary">删除用户按钮</a></td>
        </c:if>
        <c:if test="${fn:contains(role.context,'5')}">
       		 <td><a class="btn btn-primary">添加用户按钮</a></td>
        </c:if>
        <c:if test="${fn:contains(role.context,'6')}">
       		 <td><a class="btn btn-primary">性别字典</a></td>
        </c:if>
        <c:if test="${fn:contains(role.context,'7')}">
       		 <td><a class="btn btn-primary">日志</a></td>
        </c:if>
      </tr>
      <tr>
        <th class="text-r">注册时间：</th>
        <td>${role.createdTime}</td>
      </tr>
    </tbody>
  </table>
</div>
</body>
</html>