<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>登陆通讯录</title>
<!-- 创建视口 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--导入jquery文件-->
<script src="js/jquery-1.11.0.min.js" type="text/javascript"
	charset="utf-8"></script>
<!--导入bootstrap.css文件-->
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<!--导入bootstrap.js-->
<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
	<!--创建布局容器-->
	<div class="container-fluid"
		style="width: 100%; height: 72.25rem; background: url(img/logInBg.jpg) no-repeat;"
		align="center">
		<div
			style="width: 33%; border: 1px solid #E7E7E7; padding: 20px 0 20px 30px; border-radius: 5px; margin-top: 60px; background: #fff;">
			<div style="font-size: 2.75rem;" align="center">登陆通讯录</div>
			<form class="form-horizontal"
				action="${pageContext.request.contextPath}/logIn" method="post">
				<input type="hidden" name="pageNumber" value="1">
				<div class="form-group">
					<label for="username" class="col-sm-2 control-label">用户名</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" name="username"
							id="username" placeholder="请输入用户名">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
					<div class="col-sm-6">
						<input type="password" class="form-control" name="password"
							id="inputPassword3" placeholder="请输入密码">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">验证码</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="verificationCode"
							id="verificationCode" placeholder="请输入验证码">
					</div>
					<div class="col-sm-3">
						<img id="imgId"
							src="${pageContext.request.contextPath}/verificationCode"  onclick="changeImg()">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10" align="left">
						<input type="submit" width="100" value="登录" name="submit" border="0"
							style="background: url(img/logInBg.jpg) no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
<script type="text/javascript">
    //切换验证码
    function changeImg() {
        var imgObj = document.getElementById("imgId");
        imgObj.src = "${pageContext.request.contextPath}/verificationCode?number="+Math.random();
    }
</script>
</script>
</html>
