<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>橙汁园餐厅 -- 登录</title>
	<link href="<%=basePath%>jsp/shop/resources/css/signin.css" rel="stylesheet" type="text/css">
	<script language="JavaScript" src="<%=basePath%>jsp/shop/resources/js/jquery.js"></script>
	<script src="<%=basePath%>jsp/shop/resources/js/cloud.js" type="text/javascript"></script>

	<script language="javascript">
        $(function() {
            //处理登录按钮之后的事件
            $("#login_button").click(function () {

                $.post("<%=basePath%>proscenium/doLogin",
                    $("#myForm").serialize(),
                    function (data) {
                        if(data.status==1){
                            window.location.href="<%=basePath%>proscenium/toIndex"
                        }else{
                            alert("登录失败");
                        }

                    }
                );
            })
        })
	</script>

</head>
<div class="wrap signin">
	<div class="content">
		<div class="title">
			<a href="<%=basePath%>proscenium/toIndex">&nbsp;首页&nbsp;</a>
			<a href="<%=basePath%>jsp/shop/signin.jsp">&nbsp;登录/注册&nbsp;</a>
			<a href="<%=basePath%>jsp/shop/shopcart.jsp">&nbsp;购物车&nbsp;</a>
		</div>
		<div class="main">
			<div class="header">
				<a href="<%=basePath%>proscenium/toLogon">注册</a>
			</div>
			<div class="logo">
				<div>
					<img alt="" src="<%=basePath%>jsp/shop/resources/images/signin-logo.png">
					<span>用户登陆</span>
				</div>
			</div>
			<form id="myForm" method="post">
				<div class="input-wrap">
					<img alt="" src="<%=basePath%>jsp/shop/resources/images/signin-user.png">
					<input type="username" name="username" placeholder="请输入用户名">
				</div>
				<div class="input-wrap">
					<img alt="" src="<%=basePath%>jsp/shop/resources/images/signin-pwd.png">
					<input type="password" name="password" placeholder="请输入密码">
				</div>
				<div class="input-wrap nobg">
					<button class="btn-inline lbtn" id="login_button" type="button"></a> 登录</button>
					<button class="btn-inline" id="pback">找回密码</button>
				</div>
			</form>
		</div>
	</div>
	<div class="footer">
		<h1>订餐热线：0772-1234567</h1>
		<p>版权所有@ 2012-2019 南方橙汁园连锁有限公司   桂ICP备90887766号  桂餐证字2010110108002888<br>
			地址：桂柳市文林区中文苑路1号橙汁园大厦B座111层11号</p>
	</div>
</div>
</html>