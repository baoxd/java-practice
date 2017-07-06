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
          <h1>登录页面</h1><small>豆瓣电影</small>
        </div>
      </div>
    </div>
    
    <jsp:include page="./common.jsp" />

    <div class="container">
      <div class="row">
        <div class="col-md-4">
          <form method="POST" action="/user/login">
            <div class="modal-body">
              <div class="form-group">
                <label for="signinName">用户名</label>
                <input id="signinName" name="name" type="text" class="form-control">
              </div>
              <div class="form-group">
                <label for="signinPassword">密码</label>
                <input id="signinPassword" name="password" type="password" class="form-control">
              </div>
              <div class="form-group">
                  <button type="submit" class="btn btn-success">登陆</button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>