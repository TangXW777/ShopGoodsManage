<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showcategory.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-2.2.3.js"></script>
	<script type="text/javascript" src="js/addcategory.js"></script>
  </head>
  
  <body>
   <h2>展示所有分类</h2>
   <table border="1">
   	<tr>
   		<td>编号</td>
   		<td>分类</td>
   	</tr>
   	<c:forEach items="${sessionScope.categoryList}" var="category">
   		<tr>
   			<td>${category.categoryno }</td>
   			<td>${category.categoryname }</td>
   		</tr>
   	</c:forEach>
   </table>
   <h2><a href="javascript::" id="addSort">添加分类</a></h2>
   
   <!-- 添加商品区 -->
   <div id="add" style="display:none">
   	<form action="${pageContext.request.contextPath }/servlet/ShowCategoryServlet" method="post" >
   		分类名：<input type="text" name="sort"/><span class="error"></span><br/>
   		<input type="button" value="提交"/><input type="reset" value="重置"/>
   	</form>
   </div>
   <h2><a href="index.jsp">返回主页</a></h2>
  </body>
</html>
