<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function-manage.js"></script>
</head>
<body>
	<%@include file="ManageMain.jsp" %>
	
	
	<div id="main" class="wrap">
		<div class="main">
			<h2>新增用户</h2>
			<div class="manage">
				<form action="MnewsServlet?action=add" method="post">
					<table class="form">
						<tr>
							<td class="field">用户名：</td>
							<td><input type="text" class="text" name="userName" value="" /></td>
						</tr>
						<tr>
							<td class="field">密码：</td>
							<td><input type="text" class="text" name="passWord" value="" /></td>
						</tr>
						<tr>
							<td class="field">身份：</td>
							<td>
							<select name="status">
									<option value="管理员">管理员</option>
									<option value="普通顾客">普通顾客</option>
							</select>
							</td>
						</tr>
						<tr>
							<td></td>
							<td><label class="ui-blue"><input type="submit"
									name="submit" value="添加" /></label></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2015 天智立软件教育 All Rights
		Reserved. 京ICP证1000001号</div>

</body>
</html>