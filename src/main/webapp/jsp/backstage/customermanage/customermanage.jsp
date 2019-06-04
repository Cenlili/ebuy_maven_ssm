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
    <title>网站后台管理系统HTML模板--模板之家 www.cssmoban.com</title>
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
            
            $("a[name='deleteCustomer']").click(function () {
                var url=$(this).attr("href");
                var username=$(this).attr("id");
                if(window.confirm("确认删除该账户("+username+")吗？")){
                    return true;//执行链接跳转
                }else{
                    return false;//不执行链接的跳转
                }
            });

        });
    </script>


</head>


<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
        <li><a href="#">客户模块</a></li>
        <li><a href="#">客户管理</a></li>
    </ul>
</div>

<div class="rightinfo">

    <div class="tools">

        <ul class="toolbar">
            <a href="<%=basePath%>backstage/customer/toAddCustomer">
                <li class="click"><span><img src="<%=basePath%>jsp/backstage/images/t01.png"/></span>添加客户</li>
            </a>
        </ul>


        <ul class="toolbar1">

        </ul>

    </div>


    <table class="tablelist">
        <thead>
        <tr>
            <th><input name="" type="checkbox" value="" checked="checked"/></th>
            <th>账户名</th>
            <th>姓名</th>
            <th>电子邮箱</th>
            <th>注册时间</th>
            <th>订单数量</th>
            <th>消费金额</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="customer" items="${requestScope.list}">
        <tr>
            <td><input name="" type="checkbox" value=""/></td>
            <td>${customer.username}</td>
            <td>${customer.name}</td>
            <td>${customer.email}</td>
            <td><fmt:formatDate value="${customer.createTime}" pattern="yyyy年MM月dd日 HH:mm"/></td>
            <td>${customer.zip}</td>
            <td></td>
            <td><a href="<%=basePath%>backstage/customer/toUpdateCustomer?id=${customer.id}" class="tablelink">修改</a> <a id="${customer.username}" name="deleteCustomer"  href="<%=basePath%>backstage/customer/doDeleteCustomer?id=${customer.id}" class="tablelink"> 删除</a></td>
            <%--<td><a href="<%=basePath%>backstage/adminmanage/toUpdateAdmin?id=${customer.id}" class="tablelink">修改</a> <a id="${admin.username}" name="deleteAdmin"  href="<%=basePath%>backstage/adminmanage/doDeleteAdmin?id=${admin.id}" class="tablelink"> 删除</a></td>--%>
        </tr>
        </c:forEach>

        </tbody>
    </table>


    <div class="pagin">
        <div class="message">共<i class="blue">${fn:length(list)}</i>条记录</div>
        <ul class="paginList">

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
