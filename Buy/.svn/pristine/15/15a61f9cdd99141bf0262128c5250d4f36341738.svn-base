<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function-manage.js"></script>
</head>
<body>
	<%@ include file="ManageMain.jsp" %>
	

	
	<div id="main" class="wrap">
		<div class="main">
			<h2>用户管理</h2>
			<div class="manage">
				<table class="list">
					<tr>
						<th>ID</th>
						<th>姓名</th>
						<th>身份</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${muser.list}" var="u">
						<tr>
							<td class="first w4 c">${u.id }</td>
							<td class="w1 c">${u.name }</td>
							<td class="w4 c">${u.status }</td>
							<td class="w1 c"><a
								href="ManageServlet?action=get&id=${u.id }">修改</a> <a
								href="ManageServlet?action=delete&id=${u.id }">删除</a></td>
						</tr>
					</c:forEach>
				</table>
				
				<!-- 导入分页 -->
				<%@ include file="PaperHelp.jsp"%>
				
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2015 天智立软件教育 All Rights
		Reserved. 京ICP证1000001号</div>
</body>
</html>