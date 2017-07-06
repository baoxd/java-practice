<%@ page language="java" 
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
          <h1>注册页面</h1><small>豆瓣电影</small>
        </div>
      </div>
    </div>

   <jsp:include page="./common.jsp" />
    
    <div class="container">
      <div class="row">
        <div class="col-md-4">
          <form method="POST" action="/user/register">
            <div class="modal-body">
              <div class="form-group">
                <label for="signupName">用户名</label>
                <input id="signupName" name="name" type="text" class="form-control">
              </div>
              <div class="form-group">
                <label for="signupPassword">密码</label>
                <input id="signupPassword" name="password" type="password" class="form-control">
              </div>
              <div class="form-group">
                <label for="signupRole">角色(1: 管理员 2: 普通用户)</label>
                <input id="signupRole" name="role" type="text" class="form-control">
              </div>
              <div class="form-group">
                  <button type="submit" class="btn btn-success">注册</button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>