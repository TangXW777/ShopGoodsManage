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
	<link rel="stylesheet" href="css/form.css" />
	<script type="text/javascript" src="js/jquery-2.2.3.js"></script>
	<script type="text/javascript" src="js/jquery.validate.js"></script>
	<script type="text/javascript" src="js/jquery-validate-extend.js"></script>
	<script type="text/javascript" src="js/jquery-validate-extend.js"></script>
	<script type="text/javascript" src="js/addgoods.js"></script>
  </head>
  
  <body>
    <h2>添加商品</h2>
    <form action="${pageContext.request.contextPath }/servlet/StartAddGoodsServlet" method="post" id="goodsform">
   	<fieldset>
   		<legend>商品添加表单</legend>
   		<div class="item">
   			<label for="goodsno" class="item-label">商品编号</label>
   			<input type="text" id="goodsno" name="goodsno"  class="item-text" placeholder="设置商品编号"
   			autocomplete="off" tip="请输入商品编号"/>
   		</div>
   		<div class="item">
   			<label for="goodsname" class="item-label">商品名</label>
   			<input type="text" id="goodsname" name="goodsname" class="item-text" placeholder="设置商品编号"
   			autocomplete="off" tip="请输入商品编号"/>
   		</div>
   		<div class="item">
   			<label for="goodsprice" class="item-label">商品价格</label>
   			<input type="text" id="goodsprice" name="goodsprice" class="item-text" placeholder="设置商品价格"
   			autocomplete="off" tip="请输入商品价格"/>
   		</div>
   		<div class="item">
   			<label for="categoryno" class="item-label">商品分类</label>
   			<select name="categoryno" class="item-select">		
   				<c:forEach items="${sessionScope.categoryList}" var="category">
    				<option value="${category.categoryno }">${category.categoryname }</option>
    			</c:forEach>
   			</select>
   		</div>
   		<div class="item">
   			<label for="goodsdate" class="item-label">生产日期</label>
   			<input type="text" id="goodsdate" name="goodsdate" class="item-text" placeholder="设置商品的生产日期"
   			autocomplete="off" tip="请输入商品的生产日期"/>
   		</div>
   		<div class="item">
   			<label for="goodswarranty" class="item-label">保质期</label>
   			<input type="text" id="goodswarranty" name="goodswarranty" class="item-text" placeholder="设置商品的保质期"
   			autocomplete="off" tip="请输入商品的保质期"/>
   		</div>
   		<div class="item">
   			<input type="submit" value="提交"/>
   		</div>
   </fieldset>
   </form>
     <h2><a href="index.jsp">返回主页</a></h2>
  </body>
<script type="text/javascript">
$(function(){
	$('#goodsform').validate({
		debug : false,
		onkeyup : true,
		rules : {
			goodsno : {
				required : true,
				digits : true,
				remote : {
					url : '/ShopGoodsManage/servlet/CheckGoodsNo',
					type : 'post'
				}
			},
			goodsname : {
				required : true
			},
			goodsprice : {
				required : true,
				price : true			
			},
			categoryno : {
				required : true
			},
			goodsdate : {
				required : true,
				dateISO : true,
				remote : {
					url : '/ShopGoodsManage/servlet/CheckGoodsDate',
					type : 'post'
				}
			},
			goodswarranty : {
				required : true,
				digits : true
			}
		},
		messages : {
			goodsno : {
				required : '请输入商品编号ddd',
				digits : '请输入正确的编号',
				remote : '该商品编号已经存在'
			},
			goodsname : {
				required : '请输入商品名'
			},
			goodsprice : {
				required : '请输入商品价格',
				price : '精确到小数点后两位'			
			},
			categoryno : {
				required : '请选择分类'
			},
			goodsdate : {
				required : '请输入商品生产日期',
				dateISO : '请输入正确格式yyyy-MM-dd',
				remote : '日期格式错误'
			},
			goodswarranty : {
				required : '请输入商品保质期',
				digits : '请输入正确格式'
			}
		}
	});
});
</script>
</html>
