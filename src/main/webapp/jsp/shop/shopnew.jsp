<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>橙汁园餐厅 -- 今日新品</title>
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
                    <li><a id="lists" href="#">今日新品</a></li>
                </ul>
            </div>
            <div class="quick">
                <button class="all cur">全部</button>
                <button class="buy">已定</button>
                <button class="price">价格</button>
                <button class="sales">销量</button>
            </div>
            <div class="block-wrap">
                <c:forEach var="newShops" items="${requestScope.newShops}">
                    <div class="item">
                        <a href="<%=basePath%>proscenium/toDetailProduct?id=${newShops.id}"><img style="width: 244px;height: 200px" alt="" src="${newShops.picUrl}"></a>
                        <label><em>${newShops.price}</em><span>${newShops.originalPrice}</span>库存：${newShops.number}</label>
                        <h3>${newShops.name}<button class="buy">购买</button></h3>

                    </div>
                </c:forEach>
            </div>
    </div>
    </div>
    <iframe src="<%=basePath%>jsp/shop/footer.jsp" style="height: 120px;"></iframe>
</div>
</body>
</html>