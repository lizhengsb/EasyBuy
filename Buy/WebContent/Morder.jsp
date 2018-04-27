<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="/css/style.css" />
<script type="text/javascript" src="/scripts/function-manage.js"></script>
</head>
<body>
	<%@ include file="ManageMain.jsp"%>



	<div id="main" class="wrap">
		<div class="main">
			<h2>订单管理</h2>
			<div class="manage">
				<div class="search">
					<form method="get">
						订单号：<input type="text" class="text" name="orderId" /> 订货人：<input
							type="text" class="text" name="userName" /> <label
							class="ui-blue"><a href="##">查询</a>
							</label>
					</form>
				</div>
				<div class="spacer"></div>
				<table class="list">
					<tr>
						<th>ID</th>
						<th>姓名</th>
						<th>发货地址</th>
						<th>状态</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${orderlist.list}" var="o">
						<tr>
							<td class="first w4 c">${o.oid }</td>
							<td class="w1 c">${o.uname }</td>
							<td>${o.adress }</td>
							<td class="w1 c">${o.status}</td>
							<td class="w1 c"><a href="MorderServlet?action=get&oid=${o.oid}">修改</a> <a
								href="MorderServlet?action=delete&oid=${o.oid}">删除</a></td>
						</tr>
					</c:forEach>

				</table>
				<%@ include file="PageHelp-order.jsp"%>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2015 天智立软件教育 All Rights
		Reserved. 京ICP证1000001号</div>


</body>
</html>