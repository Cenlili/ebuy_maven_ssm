<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>橙汁园餐厅 -- 详情</title>
<link href="<%=basePath%>jsp/shop/resources/css/shopdetail.css" rel="stylesheet" type="text/css">
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

						<li><a id="lists" href="<%=basePath%>jsp/shop/shopdetial.jsp">商品详情</a></li>
					</ul>
				</div>
				<c:forEach var="detailProduct" items="${requestScope.detailProduct}">
				<div class="block-wrap">
					<h3>${detailProduct.name}</h3>
					<div>
						<div class="images">
							<div class="img-wrap">
								<img  style="width: 355px;height: 300px" alr="" src="${detailProduct.picUrl}">
							</div>
						</div>
						<div class="detials">
							<ul>
								<li class="hot">优惠活动：11:30-14:30点餐7折</li>
								<li>促销价：<em class="hot">${detailProduct.price}</em></li>
								<li>
									<div class="item-wrap">
										<div class="item">原价：<span>${detailProduct.originalPrice}</span></div>
										<div class="item">累计销量：${detailProduct.click} 份</div>
									</div>
								</li>
								<li class="detial-wrap">
									<label>详情：</label>
									<div class="detial">
											${detailProduct.content}
									</div>
								</li>
								<li class="form-wrap">
									<form>
										数量：
										<div class="input-wrap">
											<button class="sub">-</button>
											<input type="text" class="number" value="1">
											<button class="add">+</button>
										</div> 
										库存<span class="numbers">${detailProduct.number}</span>份
										<div class="btn-wrap">
											<button class="buy">立刻购买</button>
											<button class="add">加入购物车</button>
										</div>
									</form>
								</li>
							</ul>
						</div>

					</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<hr color="#e3e3e2">
		<iframe src="<%=basePath%>jsp/shop/footer.jsp" style="height: 120px;"></iframe>
	</div>
</body>
</html>