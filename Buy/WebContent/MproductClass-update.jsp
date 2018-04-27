<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/function-manage.js"></script>
</head>
<body>
<%@ include file="ManageMain.jsp" %>


<div id="main" class="wrap">
	<div class="main">
		<h2>修改分类</h2>
		<div class="manage">
			<form action="MproductServlet?action=update" method="post">
				<table class="form">
					<tr>
						<td class="field">父分类：</td>
						<td>
							<input type="hidden"  name="id" value="${Pclass.parentId}"/>
							<select name="parentId">
								<option value="0">根目录</option>
								<c:forEach items="${ProductClass}" var="plist">
									<option value="${plist.parentId }">${plist.name }</option>
								</c:forEach>
							</select>
							<script>
								document.getElementsByName("parentId")[0].value='${Pclass.childId}';
							</script>
						</td>
					</tr>
					<tr>
						<td class="field">分类名称：</td>
						
						<td><input type="text" class="text" name="className" value="${Pclass.name}" /></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="更新" /></label></td>
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