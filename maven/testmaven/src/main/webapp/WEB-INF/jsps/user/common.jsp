<%@ page language="java" 
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <div class="navbar navbar-default navbar-fixed-bottom">
     <div class="container">
       <div class="navbar-header"><a href="/" class="navbar-brand">豆瓣电影</a></div>
        <c:choose>
        	<c:when test="${sessionScope.user !=null}">
        		<p class="navbar-text navbar-right"><span>欢迎你，${sessionScope.user.name}</span><span>&nbsp;|&nbsp;</span>
        		<a href="/user/logout" class="navbar-link">登出</a></p>
        	</c:when>
        	<c:otherwise>
        		<p class="navbar-text navbar-right">
        			<a href="#" data-toggle="modal" data-target="#signupModal" class="navbar-link">注册</a><span>&nbsp;|&nbsp;</span>
        			<a href="#" data-toggle="modal" data-target="#signinModal" class="navbar-link">登陆</a></p>
        	</c:otherwise>
        </c:choose>
     </div>
   </div>

   <div id="signupModal" class="modal fade">
     <div class="modal-dialog">
       <div class="modal-content">
         <form method="POST" action="/user/register">
           <div class="modal-header">注册</div>
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
               <label for="signupRole">角色</label>
               <input id="signupRole" name="role" type="text" class="form-control">
             </div>
           </div>
           <div class="modal-footer">
             <button type="button" data-dismiss="modal" class="btn btn-default">关闭</button>
             <button type="submit" class="btn btn-success">提交</button>
           </div>
         </form>
       </div>
     </div>
   </div>

   <div id="signinModal" class="modal fade">
     <div class="modal-dialog">
       <div class="modal-content">
         <form method="POST" action="/user/login">
           <div class="modal-header">登陆</div>
           <div class="modal-body">
             <div class="form-group">
               <label for="signinName">用户名</label>
               <input id="signinName" name="name" type="text" class="form-control">
             </div>
             <div class="form-group">
               <label for="signinPassword">密码</label>
               <input id="signinPassword" name="password" type="password" class="form-control">
             </div>
           </div>
           <div class="modal-footer">
             <button type="button" data-dismiss="modal" class="btn btn-default">关闭</button>
             <button type="submit" class="btn btn-success">提交</button>
           </div>
         </form>
       </div>
     </div>
   </div>