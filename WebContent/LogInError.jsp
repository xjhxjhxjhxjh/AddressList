<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error</title>

</head>
<body>
	<h1>${msg}</h1>
	<a style="font-style: 52px; color: red"
		href="${pageContext.request.contextPath}/index.jsp">点击跳转到登陆页面</a>
	<font  style="font-size: 22px;">还有</font>
	<span id="totalSecond" style="font-size: 22px; color: red">5</span>
	<script language="javascript" type="text/javascript">
		var second = totalSecond.innerText;
		setInterval("redirect()", 1000);
		function redirect() {
			totalSecond.innerText = --second;
			if (second <= 0)
				location.href = "${pageContext.request.contextPath}/index.jsp";
		}
	</script>
	<font style="font-size: 22px">秒跳转</font>

</body>
</html>
