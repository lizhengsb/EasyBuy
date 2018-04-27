<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			<h2>留言管理</h2>
			<div class="manage">
				<table class="list">
					<tr>
						<th>ID</th>
						<th>姓名</th>
						<th>留言内容</th>
						<th>状态</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${Guestlist.list }" var="g">
					<tr>
						<td class="first w4 c">${g.id }</td>
						<td class="w1 c">${g.name }</td>
						<td>${g.content }</td>
						<td class="w1 c">${g.status }</td>
						<td class="w1 c"><a href="McommentServlet?action=get&id=${g.id }">回复</a> <a
							href="McommentServlet?action=delete&id=${g.id }">删除</a></td>
					</tr>
					</c:forEach>
				</table>
				<%@ include file="PageHelp-guest.jsp" %>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2015 天智立软件教育 All Rights
		Reserved. 京ICP证1000001号</div>


</body>
</html>