<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html"; charset=UTF-8">
<title>通讯录主页</title>
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
	<div class="container-fluid"; style="background: url(img/logInBg.jpg) no-repeat; background-size:cover; width: 75%" >
		<table border="1px" align="center">
			<tr align="right">
				<td colspan="8" align="center">
					<form action="${pageContext.request.contextPath}/homePage"
						method="post">
						<input type="hidden" name="method" value="search"> 
						联系人名字：<input type="text" name="name" value="${name}">
					       联系人分组：<input type="text" name="ugroup" value="${ugroup}"> <input type="submit" value="搜索">
					</form>
					<a href="${pageContext.request.contextPath}/homePage?method=findAll&pageNumber=1">查询联系人</a>
					<a href="${pageContext.request.contextPath}/homePage?method=addUI">添加联系人</a>
				</td>
				<td colspan="1"><input type="button" value="删除勾选" id="btn"></td>
			</tr>
			<tr>
				<th width="3%"><input type="checkbox" id="thId">全选/全不选</th>
				<th width="8%" align="center">联系人id</th>
				<th width="8%">联系人姓名</th>
				<th width="8%">联系人性别</th>
				<th width="8%">联系人地址</th>
				<th width="8%">联系人qq</th>
				<th width="8%">联系人电话号码</th>
				<th width="8%">联系人分组</th>
				<th width="8%" align="center">操作</th>
			</tr>
			<c:if test="${empty page.list}">
				<tr>
					<td colspan="9" align="center">暂无联系人</td>
				</tr>
			</c:if>
			<c:if test="${not empty page.list}">
				<form id="formId"
					action="${pageContext.request.contextPath}/homePage" method="post">
					<input type="hidden" name="method" value="batchDelete">
					<c:forEach items="${page.list}" var="contact">
						<tr height="70px">
							<td align="center"><input type="checkbox" name="id" value="${contact.id}"></td>
							<td align="center">${contact.id}</td>
                            <td align="center">${contact.name}</td>
                            <td align="center">${contact.sex}</td>
                            <td align="center">${contact.telephoneNumber}</td>
                            <td align="center">${contact.address}</td>
                            <td align="center">${contact.qqNumber}</td>
                            <td align="center">${contact.ugroup}</td>
							<td align="center"><a
								href="${pageContext.request.contextPath}/homePage?method=edit&id=${contact.id}">修改</a>
								<!-- 注意：在js中写el表达式的时候需要加上引号 --> <a href="#"
								onclick="del('${contact.id}')">删除</a></td>
						</tr>
					</c:forEach>
				</form>
			</c:if>
		</table>
 	 <center>
            <c:if test="${page.pageNumber!=1}">
                <a href="${pageContext.request.contextPath}/homePage?method=findAll&pageNumber=${page.pageNumber-1}">[上一页]</a>
            </c:if>
        
            <c:forEach begin="1" end="${page.pageSumSize}" step="1" var="n">
                <c:if test="${page.pageNumber==n}">
                    ${n}
                </c:if>
        
                <c:if test="${page.pageNumber!=n}">
                    <a href="${pageContext.request.contextPath}/homePage?method=findAll&pageNumber=${n}">${n}</a>
                </c:if>
        
            </c:forEach>
        
            <c:if test="${page.pageNumber!=page.pageSumSize}">
                <a href="${pageContext.request.contextPath}/homePage?method=findAll&pageNumber=${page.pageNumber+1}">[下一页]</a>
            </c:if>
                      第${page.pageNumber}页/共${page.pageSumSize}页
        </center> 
	</div>
</body>
<script type="text/javascript">
    //确认删除
	function del(id) {
		var flag = confirm("您确认要删除吗？");
		//根据返回值判断是否删除
		if (flag) {
			//执行删除操作
			location.href = "${pageContext.request.contextPath}/homePage?method=delete&id="+id;
		}
	}

	//实现全选全不选
	$("#thId").click(function() {
		$("[name=id]").prop("checked", $("#thId").prop("checked"));
	})

	//给按钮派发单击事件，提交表单
	$("#btn").click(function() {
		//获取表单
		$("#formId").submit();
	})
</script>
</html>
