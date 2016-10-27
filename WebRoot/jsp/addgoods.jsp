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
    
    <title>My JSP 'addgoods.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-2.2.3.js"></script>
	<script type="text/javascript" src="js/addgoods.js"></script>
  </head>
  
  <body>
    <h2>添加商品</h2>
    <form action="${pageContext.request.contextPath }/servlet/ShowGoodsServlet" method="post" onsubmit="return checkForm()">
    	编号：<input type="text" name="goodsno" /><span></span>(*正整数)<br> 
    	名称：<input type="text" name="goodsname" /><span></span><br> 
    	价格：<input type="text" name="goodsprice" /><span></span>(*小数点两位)<br> 
    	所属分类： 
    	<select name="categoryno"> 
    		<c:forEach items="${sessionScope.categoryList}" var="category">
    			<option value="${category.categoryno }">${category.categoryname }</option>
    		</c:forEach>
    	</select> <br/>
    	生产日期：<input type="text" name="goodsdate" /><span></span>(*格式：xxxx-xx-xx)<br> 
    	保质期(天)：<input type="text" name="goodswarranty" /><span></span>(*单位：天)<br/>
    	<input type="submit" value="提交"/><input type="reset" value="重置"/><span></span>
    </form>
     <h2><a href="index.jsp">返回主页</a></h2>
  </body>
</html>
