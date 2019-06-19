<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>橙汁园餐厅 -- 列表</title>
<link href="<%=basePath%>jsp/shop/resources/css/shoplists.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="wrap">
		<iframe src="<%=basePath%>jsp/shop/header.jsp" style="height: 168px;"></iframe>
		<div class="content">
			<div class="block">
				<div class="crumb">
					<ul>
						<li><a href="<%=basePath%>proscenium/toIndex">首页</a></li>
						<li><span>/</span></li>
						<li><a id="lists" href="#">${productTypesed.name}</a></li>
					</ul>
				</div>
				<div class="quick">
					<button class="all cur">全部</button>
					<button class="buy">已定</button>
					<button class="price">价格</button>
					<button class="sales">销量</button>
				</div>
				<div class="block-wrap">
					<c:forEach var="productTypes" items="${requestScope.productTypes}">
					<div class="item">
						<a href="<%=basePath%>proscenium/toDetailProduct?id=${product.id}"><img style="width: 244px;height: 200px" alt="" src="${productTypes.picUrl}"></a>
						<label><em>${productTypes.price}</em><span>${productTypes.originalPrice}</span>库存：${productTypes.number}</label>
						<h3>${productTypes.name}<button class="buy">购买</button></h3>

					</div>
					</c:forEach>
				</div>
				<div class="pager">
					<button>&lt;&lt;</button>
					<button>1</button>
					<button>2</button>
					<button>3</button>
					<button>&gt;&gt;</button>
				</div>
			</div>
			<br>
		</div>
		<iframe src="<%=basePath%>jsp/shop/footer.jsp" style="height: 120px;"></iframe>
	</div>
</body>
</html>