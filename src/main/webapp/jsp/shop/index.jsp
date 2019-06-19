<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>橙汁园餐厅 -- 首页</title>
	<link href="<%=basePath%>jsp/shop/resources/css/index.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="wrap">
	<iframe src="<%=basePath%>jsp/shop/header.jsp" style="height: 168px;"></iframe>
	<div class="content">
		<div class="logo">
			<img alt="" src="<%=basePath%>jsp/shop/resources/images/index-logo.jpg">
			<div class="menu">
				<ul>
                    <c:forEach var="producttype" items="${requestScope.productType}">
						<li><a href="<%=basePath%>proscenium/toProductType?id=${producttype.id}"><img class="left" alt="" src="${producttype.imageUrl}">${producttype.name}<img class="right" alt="" src="<%=basePath%>jsp/shop/resources/images/menu-right.png"></a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="block">
			<div class="title">
				<label class="new">今日新品</label>
				<a href="<%=basePath%>jsp/shop/shoplists.html">更多&gt;&gt;</a>
			</div>
			<div class="block-wrap">
				<c:forEach var="product" items="${requestScope.newProducts}">
				<div class="item">
					<a href="<%=basePath%>proscenium/toDetailProduct?id=${product.id}"><img style="width: 244px;height: 200px" alt="" src="${product.picUrl}"></a>
					<label><em>${product.price}</em><span>${product.originalPrice}</span>库存：${product.number}</label>
					<h3>${product.name}</h3>
				</div>
				</c:forEach>
				</div>
			</div>
		<div class="block">
			<div class="title">
				<label class="hot">热门订单</label>
				<a href="<%=basePath%>jsp/shop/shoplists.html">更多&gt;&gt;</a>
			</div>
			<div class="block-wrap">
				<c:forEach var="product" items="${requestScope.hotProducts}">
				<div class="item">
						<a href="<%=basePath%>proscenium/toDetailProduct?id=${product.id}"><img style="width: 244px;height: 200px" alt="" src="${product.picUrl}"></a>
						<label><em>${product.price}</em><span>${product.originalPrice}</span>库存：${product.number}</label>
						<h3>${product.name}</h3>
				</div>
				</c:forEach>
			</div>
         </div>
<iframe src="<%=basePath%>jsp/shop/footer.jsp" style="height: 120px;"></iframe>
</div>
</div>
</body>
</html>