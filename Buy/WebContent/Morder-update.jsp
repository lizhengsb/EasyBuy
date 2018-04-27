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
			<h2>修改订单</h2>
			<div class="manage">
				<div class="spacer"></div>
				<form action="MorderServlet?action=update" method="post">
					<table class="list">
						<tr>
							<td>订单编号：<input type="hidden" name="oid" value="${o.oid }"/></td>
							<td><input type="text" value="${o.oid }" disabled="disabled"/></td>
						</tr>
						<tr>
							<td>订单人姓名：</td>
							<td><input type="text" value="${o.uname }" disabled="disabled"/></td>
						</tr>
						<tr>
							<td>订购人地址：</td>
							<td><input type="text" value="${o.adress }" disabled="disabled"/></td>
						</tr>
						<tr>
							<td>总金额：</td>
							<td><input type="text" value="${o.total }" disabled="disabled"/></td>
						</tr>
						<tr>
							<td>下单日期：</td>
							<td><input type="text" value="${o.date }" disabled="disabled"/></td>
						</tr>
						<tr>
							<td>订单状态：</td>
							<td>
								<select name="sel">
									<option value="待审核">待审核</option>
									<option value="审核通过">审核通过</option>
									<option value="送货中">送货中</option>
									<option value="确认收货">确认收货</option>
								</select>
							</td>
						</tr>
					</table>
					<input type="submit" value="更新" style="margin-left: 300px" />
				</form>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2015 天智立软件教育 All Rights
		Reserved. 京ICP证1000001号</div>
<script>
	docuement.getElementsByName("sel")[0].value='${o.status}';
</script>

</body>
</html>