<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="DateChange" scope="page" class="com.tang.tools.DateChange"></jsp:useBean>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showgoods.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
 
  	<table border="1">
  		<tr>
  			<td>编号</td>
  			<td>商品名</td>
  			<td>单价</td>
  			<td>所属分类</td>
  			<td>生产日期</td>
  			<td>保质期(天)</td>
  		</tr>
  		<c:forEach items="${sessionScope.goodsList}" var="goods">
  			<tr>
  				<td>${goods.goodsno }</td>
  				<td>${goods.goodsname }</td>
  				<td>${goods.goodsprice }</td>
  				<td>${goods.categoryno }</td>
  				<td> <fmt:formatDate value="${goods.goodsdate}" type="date"/></td>	
  				<!-- 判断有无期限 -->	
  				<c:choose>
  					<c:when test="${goods.goodswarranty == 999999}">
  						<td>无期限</td>
  					</c:when>
  					<c:otherwise>
  						<td>${goods.goodswarranty }</td>
  					</c:otherwise>
  				</c:choose>
  			</tr>
  		</c:forEach>
  	</table>
  	<h2><a href="${pageContext.request.contextPath }/servlet/AddGoodsServlet">添加商品</a></h2>
  	<h2><a href="index.jsp">返回主页</a></h2>
  </body>
</html>
