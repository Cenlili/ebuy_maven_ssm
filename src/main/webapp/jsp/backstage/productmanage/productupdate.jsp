<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="<%=basePath%>jsp/backstage/css/style.css" rel="stylesheet" type="text/css"/>
    <script language="JavaScript" src="<%=basePath%>jsp/backstage/js/jquery.js"></script>
    <!-- 导入kindEditor所需插件 -->
    <link rel="stylesheet" href="<%=basePath%>plugins/kindeditor-4.1.10/themes/default/default.css"/>
    <script src="<%=basePath%>plugins/kindeditor-4.1.10/kindeditor.js"></script>
    <script src="<%=basePath%>plugins/kindeditor-4.1.10/lang/zh_CN.js"></script>

    <script>
        //用于弹出窗口，将服务器返回的数据提交，本处用于账户提交后的状态
        function alert_myMessage() {
            var message = "${requestScope.myMessage}";
            if (message != "") {
                alert(message);
            }
        }

        $(document).ready(function () {
            //用于弹出窗口，将服务器返回的数据提交，本处用于账户提交后的状态
            alert_myMessage();


        });

        //实现kindeditor弹出图片上传窗口
        KindEditor.ready(function(K) {
            var editor = K.editor({//图片上传
                //指定上传文件的服务器端程序。
                uploadJson:  '<%=basePath%>plugins/kindeditor-4.1.10/jsp/upload_json.jsp',
                //指定浏览远程图片的服务器端程序
                fileManagerJson: '<%=basePath%>plugins/kindeditor-4.1.10/jsp/file_manager_json.jsp',
                allowFileManager : true
            });
            K('#image1').click(function() {
                editor.loadPlugin('image', function() {//动态加载插件，image为插件名
                    editor.plugin.imageDialog({
                        showLocal : true,//是否显示本地图片上传窗口
                        showRemote : true,//是否显示网络图片窗口
                        fillDescAfterUploadImage:false,//个人建议只在文本编辑器中使用true，true时图片上传成功后切换到图片编辑标签，false时插入图片后关闭弹出框。
                        imageUrl : K('#url1').val(),
                        clickFn : function(url, title, width, height, border, align) {
                            K('#url1').val(url);
                            editor.hideDialog();
                        }
                    });
                });
            });
        });

    </script>
</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
        <li><a href="#">产品分类</a></li>
        <li><a href="#">产品管理</a></li>
        <li><a href="#">修改产品管理</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>编辑产品管理</span></div>
    <form action="<%=basePath%>backstage/product/doUpdateProduct" method="post">
        <input name="id" type="hidden" class="dfinput"
               value="${requestScope.product.id}"/>
        <ul class="forminfo">
            <li>
                <label>*产品分类</label>
                <select name="productTypeId" id="productTypeId" class="dfinput" >
                    <option value="">请选择</option>
                    <c:forEach var="productTyped" items="${requestScope.productTyped}">
                        <option value="${productTyped.id}">${productTyped.name}</option>
                    </c:forEach>
                </select>
                <i></i>
            </li>
            <li><label>*产品名称</label><input name="name" type="text" class="dfinput" value="${requestScope.product.name}"/><i>${requestScope.errors["name"]}</i></li>
            <li><label>*产品图片</label>
                <input id="url1" name="picUrl" type="text" class="dfinput" value="${requestScope.product.picUrl}" readonly="readonly"/>
                <input type="button" id="image1" class="dfinput" style="width:120px;" value="点我选择图片" />
                <a href="#" id="clearImagePath1">清除选择图片路径</a>
                <i>${requestScope.errors["picUrl"]}</i>
            </li>
            <li><label>*产品原价</label><input name="originalPrice" type="text" class="dfinput" value="${requestScope.product.originalPrice}"/><i>${requestScope.errors["originalPrice"]}</i></li>
            <li><label>*产品现价</label><input name="price" type="text" class="dfinput" value="${requestScope.product.price}"/><i>${requestScope.errors["price"]}</i></li>
            <li><label>*产品库存</label><input name="number" type="text" class="dfinput" value="${requestScope.product.number}"/><i>${requestScope.errors["number"]}</i></li>
            <li><label>*优先级</label><input name="orderNum" type="text" class="dfinput" value="${requestScope.product.orderNum}"/><i>${requestScope.errors["orderNum"]}</i></li>
            <li><label>*点击数</label><input name="click" type="text" class="dfinput" value="${requestScope.product.click}"/><i>${requestScope.errors["click"]}</i></li>
            <li><label>*是否上架</label>
                <select name="onSale" class="dfinput" >


                    <option value="true" selected="selected">上架</option>
                    <option value="false">下架</option>



                </select>
                <i></i>
            </li>
            <li><label>*产品描述</label>
                <textarea name="description" cols="" rows="" class="textinput">${requestScope.product.description}</textarea><i></i>
            </li>
            <li><label>*产品内容</label>
                <textarea id="content" name="content" class="textinput">${requestScope.product.content}</textarea><i></i>
            </li>
            <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="编辑产品"/></li>
        </ul>


    </form>

</div>
</body>
</html>
