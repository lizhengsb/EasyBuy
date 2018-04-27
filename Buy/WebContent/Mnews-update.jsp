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
		<h2>修改新闻</h2>
		<div class="manage">
			<form action="MnewsServlet?action=updatenews" method="post">
				<table class="form">
					<tr>
						<td></td>
						<td><input type="hidden" name="id" value="${news.id }"/></td>
					</tr>
					<tr>
						<td class="field">新闻标题：</td>
						<td><input type="text" class="text" name="title" value="${news.title }" /></td>
					</tr>
					<tr>
						<td class="field">新闻内容：</td>
						<td><textarea name="content" >${news.body }</textarea></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="修改" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2015 天智立软件教育 All Rights Reserved. 京ICP证1000001号
</div>

</body>
</html>