<%@ page language="java" 
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.test.maven.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>页面注册</title>
<% 
	String contextPath = request.getContextPath();
%>

<link href="<%=contextPath %>/resources/libs/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="<%=contextPath %>/resources/libs/jquery/dist/jquery.min.js"></script>
<script Src="<%=contextPath %>/resources/libs/bootstrap/dist/js/bootstrap.min.js"></script>

  </head>
  <body style="margin-bottom:50px">
    <div class="container">
      <div class="row">
        <div class="page-header">
          <h1>用户列表</h1><small>豆瓣电影</small>
        </div>
      </div>
    </div>
    
    <jsp:include page="./common.jsp" />
    
    <div class="container">
      <div class="row">
        <table class="table table-hover table-bordered">
          <thead>
            <tr>
              <th>用户名</th>
              <th>角色</th>
              <th>时间</th>
              <th>查看</th>
              <th>更新</th>
              <th>删除</th>
            </tr>
            <tbody>
              <c:forEach items="${userList}" var="user">
              	<tr class="item-id-${user.id}">
                        <td>${user.name}</td>
                        <td>
                        	<c:if test="${user.role==1}">
                        		管理员
                        	</c:if>
                        	<c:if test="${user.role!=1}">
                        		普通用户
                        	</c:if>
                        <td>
                        	<fmt:formatDate pattern="yyyy-MM-dd" value="${user.createtimeForPage}" />
                        </td>
                        <td><a target="_blank" href="../datial/${user.id}">查看</a></td>
                        <td><a target="_blank" href="../admin/control/update/${user.id}">修改</a></td>
                        <td>
                          <button type="button" data-id="${user.id}" class="btn btn-danger del">删除</button>
                        </td>
                      </tr>
              </c:forEach>
            </tbody>
          </thead>
        </table>
      </div>
    </div>
    
  </body>
</html>