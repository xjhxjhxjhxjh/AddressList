<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>编辑联系人</title>
<!-- 创建视口 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--导入jquery文件-->
<script src="js/jquery-1.11.0.min.js" type="text/javascript"charset="utf-8"></script>
<!--导入bootstrap.css文件-->
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<!--导入bootstrap.js-->
<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript" src="js/messages_zh.js"></script>
</head>
<body>
	<!--创建布局容器-->
	<div class="container-fluid"; style="background: url(img/logInBg.jpg) no-repeat; background-size: cover;">
		<form action="${pageContext.request.contextPath}/homePage"method="post" id="formId">
			<input type="hidden" name="method" value="update"> 
			<input type="hidden" name="id" value="${contact.id}"> 
			<table width="60%" height="60%"  align="center">
			<input type="hidden" name="pageNumber" value="1">
                    <tr align="center">
                      <td >联系人姓名：</td>
                      <td><input type="text" name="name" value="${contact.name}"></td>
                    </tr>
                    <tr align="center">
                      <td>联系人性别：</td>
                       <td>
                            <input type="radio" name="sex" value="0" checked> 男
                            <input type="radio" name="sex" value="1" />女
                        </td>
                    </tr>
                    <tr align="center">
                      <td>联系人电话号码：</td>
                      <td><input type="text" name="telephoneNumber" value="${contact.telephoneNumber}"></td>
                    </tr>
                    <tr align="center">
                      <td>联系人地址：</td>
                      <td><input type="text" name="address" value="${contact.address}"></td>
                    </tr>
                    <tr align="center">
                      <td>联系人qq号码：</td>
                      <td><input type="text" name="qqNumber" value="${contact.qqNumber}"></td>
                    </tr>
                    <tr align="center">
                      <td>联系人分组：</td>
                      <td><input type="text" name="ugroup" value="${contact.ugroup}"></td>
                    </tr>
                    <tr >
                        <td align="right"><input type="submit" value="确认修改"></td>
                    </tr>
            </table>
		</form>
	</div>
</body>
<script>
$(function(){
    //获取要校验的表单
    $("#formId").validate({
        rules:{
            name:{
                required:true
            },
            telephoneNumber:{
                required:true
            },
            address:{
                required:true
            },
            qqNumber:{
                required:true
            },
            ugroup:{
                required:true
            }
        },
        messages:{
            name:{
                required:"姓名不能为空"
            },
            telephoneNumber:{
                required:"电话号码不能为空"
            },
            address:{
                required:"地址不能为空"
            },
            qqNumber:{
                required:"qq号不能为空"
            },
            ugroup:{
                required:"联系人分组不能为空"
            } 
        }
    })
})
</script>
</html>

