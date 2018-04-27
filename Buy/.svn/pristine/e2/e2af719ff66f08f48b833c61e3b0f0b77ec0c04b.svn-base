<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>  
	<%@ include file="MainIndex.jsp"%>
	<div id="main" class="wrap">
		<div class="main">
			<div class="guestbook">
				<h2>全部留言</h2>
				<ul>
					<c:forEach items="${Guestindex.list}" var="g">
						<li>
							<dl>
								<dt>${g.content}</dt>
								<dd class="author">
									网友：${g.name }<span class="timer">${g.contentdate }</span>
								</dd>
								<c:forEach items="${Replyindex}" var="r">
									<c:if test="${g.id==r.id }">
										<dd>管理员回复：${r.reply}</dd>
									</c:if>
								</c:forEach>

							</dl>
						</li>

					</c:forEach>
				</ul>
				<%@ include file="PageHelp-guest-index.jsp"%>
				<div class="clear"></div>

				<div id="reply-box">
					<form action="McommentServlet?action=add" method="post">
						<table>
							<tr>
								<td class="field">昵称</td>
								<td><input class="text" type="text" name="guestName" /></td>
							</tr>
							<tr>
								<td class="field">留言内容</td>
								<td><textarea name="guestContent"></textarea></td>
							</tr>
							<tr>
								<td></td>
								<td><label class="ui-blue"><input type="submit"
										name="submit" value="提交留言" /></label></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2015 天智立软件教育 All Rights
		Reserved. 京ICP证1000001号</div>



</body>
</html>