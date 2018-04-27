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
	<%@include file="ManageMain.jsp"%>


	<div id="main" class="wrap">
		<div class="main">
			<h2>添加商品</h2>
			<div class="manage">
				<form action="UploadServlet?action=add" method="post" enctype="multipart/form-data">
					<table class="form">
						<tr>
							<td class="field">商品名称：</td>
							<td><input type="text" class="text" name="productName"
								value="${Productp.name}" /></td>
						</tr>
						<tr>
							<td class="field">所属分类：</td>
							<td><select name="sel">
									<c:forEach items="${ProductClass}" var="pc">
										<option value="${pc.parentId }">${pc.name}</option>
										<c:forEach items="${ProductClass_}" var="pc_">
											<c:if test="${pc.parentId==pc_.childId }">
												<option value="${pc_.parentId}">&nbsp;&nbsp;&nbsp;${pc_.name}</option>
											</c:if>
										</c:forEach>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<td class="field">商品图片：</td>
							<td><input type="file" class="text" name="photo" value="dd"/></td>
						</tr>
						<tr>
							<td class="field">商品价格：</td>
							<td><input type="text" class="text tiny" name="productPrice" value="${Productp.price }"/>
								元</td>
						</tr>
						<tr>
							<td class="field">描述：</td>
							<td><input type="text" class="text" name="productMiaoshu" value="${Productp.description }"/></td>
						</tr>
						<tr>
							<td class="field">库存：</td>
							<td><input type="text" class="text tiny" name="productNuml" value="${Productp.numl }"/></td>
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
		
	<script>
		document.getElementsByName("sel")[0].value='${Productp.cid}';
	</script>
</body>
</html>