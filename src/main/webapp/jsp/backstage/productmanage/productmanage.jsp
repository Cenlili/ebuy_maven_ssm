<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>后台管理系统</title>
    <link href="<%=basePath%>jsp/backstage/css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="<%=basePath%>jsp/backstage/js/jquery.js"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            $(".click").click(function () {
                $(".tip").fadeIn(200);
            });

            $(".tiptop a").click(function () {
                $(".tip").fadeOut(200);
            });

            $(".sure").click(function () {
                $(".tip").fadeOut(100);
            });

            $(".cancel").click(function () {
                $(".tip").fadeOut(100);
            });

            $("a[name='deleteProduct']").click(function () {
                $this = $(this);
                if (window.confirm("确认删除该产品吗？删除后无法复原！")) {
                    var url = $(this).attr("href");
                    $.get(url, function (data) {
                            if (data.status == 1) {
                                $this.parent().parent().remove();
                            }
                        }
                    );
                }
                return false;//不执行链接的跳转

            });

        });
    </script>


</head>


<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
        <li><a href="#">产品模式</a></li>
        <li><a href="#">产品管理</a></li>
    </ul>
</div>

<div class="rightinfo">

    <div class="tools">

        <ul class="toolbar">
            <a href="<%=basePath%>backstage/product/toAddProduct">
                <li class="click"><span><img src="<%=basePath%>jsp/backstage/images/t01.png"/></span>添加产品</li>
            </a>
        </ul>


        <ul class="toolbar1">

        </ul>

    </div>


    <table class="tablelist">
        <thead>
        <tr>
            <th width="100px;">产品图片</th>
            <th style="width:25%;">产品名</th>
            <th style="width:10%;">产品分类</th>
            <th style="width:8%;">产品价格</th>
            <th style="width:10%;">发布人</th>
            <th style="width:8%;">是否上架</th>
            <th style="width:8%;">库存</th>
            <th style="width:8%;">点击数</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${requestScope.list}">
            <tr>
                <td >
                        <c:choose>
                            <c:when test="${product.picUrl==null||product.picUrl==''}">
                                <td>没有图片</td>
                            </c:when>
                <c:otherwise>
                    <img src="${product.picUrl}" width="75px" height="60px"/>
                </c:otherwise>
                        </c:choose>
                </td>
                <td >${product.name}
                   <br/><li style="color: rgba(75,79,88,0.52)"> 发布时间：<fmt:formatDate value="${product.createTime}" pattern="yyyy-MM-dd HH:mm"/></td>


                <td >${product.productType.name}
                 <br/><li style="color: rgba(75,79,88,0.52)"> ID：${product.productType.id}</td>

                <td ><li style="color: red">${product.price}</li>
                  <li style="color: rgba(75,79,88,0.52)"><s>${product.originalPrice}</s></li></td>

                <td >${product.creator.name}</td>
                <td >
                    <c:choose>
                        <c:when test="${product.onSale==true}">
                            上架中
                        </c:when>
                        <c:otherwise>
                            <i>已下架</i>
                        </c:otherwise>
                    </c:choose>
                   </td>
                <td >${product.number}</td>
                <td >${product.click}</td>
                <td><a href="<%=basePath%>backstage/product/toUpdateProduct?id=${product.id}" class="tablelink">修改</a>  <a id="${product.name}" name="deleteProduct"  href="<%=basePath%>backstage/product/doDeleteProduct?id=${product.id}" class="tablelink">删除</a></td>
                <%--<td><a href="<%=basePath%>backstage/producttype/toUpdateProductType?id=${producttype.id}" class="tablelink">修改</a>  <a id="${producttype.name}" name="deleteProductType"  href="<%=basePath%>backstage/producttype/doDeleteProductType?id=${producttype.id}" class="tablelink">删除</a></td>--%>
        </tr>
        </c:forEach>

        </tbody>
    </table>


    <div class="pagin">
        <div class="message">
            共<i class="blue">${fn:length(list)}</i>条记录,当前显示第<i class="blue">${requestScope.page}</i>页，共<i
                class="blue">${requestScope.maxPage}</i>页
        </div>
        <ul class="paginList">
        <li class="paginItem"><a href="<%=basePath%>backstage/product/toProductPage?page=1" >首页</a> </li>
            <li class="paginItem"><a href="<%=basePath%>backstage/product/toProductPage?page=${requestScope.page-1}" >上一页</a> </li>
            <li class="paginItem"><a href="<%=basePath%>backstage/product/toProductPage?page=${requestScope.page+1}" >下一页</a> </li>
            <li class="paginItem"><a href="<%=basePath%>backstage/product/toProductPage?page=${requestScope.maxPage}" >尾页</a> </li>
        </ul>
        </ul>

        </ul>
        </ul>
    </div>


    <div class="tip">
        <div class="tiptop"><span>提示信息</span><a></a></div>

        <div class="tipinfo">
            <span><img src="images/ticon.png"/></span>
            <div class="tipright">
                <p>是否确认对信息的修改 ？</p>
                <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
            </div>
        </div>

        <div class="tipbtn">
            <input name="" type="button" class="sure" value="确定"/>&nbsp;
            <input name="" type="button" class="cancel" value="取消"/>
        </div>

    </div>


</div>

<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>
</body>
</html>
