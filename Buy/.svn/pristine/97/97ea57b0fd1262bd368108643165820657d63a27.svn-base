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
	<div id="header" class="wrap">
		<div id="logo">
			<img src="images/logo.gif" />
		</div>
		<div class="help">
			<a href="index.jsp">返回前台页面</a>
		</div>
		<div class="navbar">
			<ul class="clearfix">
				<li class="current"><a href="mindex.jsp">首页</a></li>
				<li><a href="ManageServlet?action=selectAll-user">用户</a></li>
				<li><a href="MproductServlet?action=selectAll-product">商品</a></li>
				<li><a href="MorderServlet?action=selectAll-order">订单</a></li>
				<li><a href="McommentServlet?action=selectAll-guest">留言</a></li>
				<li><a href="MnewsServlet?action=selectAll-news">新闻</a></li>
			</ul>
		</div>
	</div>
	<div id="childNav">
		<div class="welcome wrap">${mlogin}</div>
	</div>
	<div id="position" class="wrap">
		您现在的位置：<a href="mindex.jsp">易买网</a> &gt; 管理后台
	</div>
	<div id="main" class="wrap">
		<div id="menu-mng" class="lefter">
			<div class="box">
				<dl>
					<dt>用户管理</dt>
					<dd>
						<em><a href="Muser-add.jsp">新增</a></em><a
							href="ManageServlet?action=selectAll-user">用户管理</a>
					</dd>
					<dt>商品信息</dt>
					<dd>
						<em><a href="MproductClass-add.jsp">新增</a></em><a
							href="MproductServlet?action=selectAll-productClass">分类管理</a>
					</dd>
					<dd>
						<em><a href="Mproduct-add.jsp">新增</a></em><a
							href="MproductServlet?action=selectAll-product">商品管理</a>
					</dd>
					<dt>订单管理</dt>
					<dd>
						<a href="MorderServlet?action=selectAll-order">订单管理</a>
					</dd>
					<dt>留言管理</dt>
					<dd>
						<a href="McommentServlet?action=selectAll-guest">留言管理</a>
					</dd>
					<dt>新闻管理</dt>
					<dd>
						<em><a href="Mnews-add.jsp">新增</a></em><a
							href="MnewsServlet?action=selectAll-news">新闻管理</a>
					</dd>
				</dl>
			</div>
		</div>
	</div>
</body>
</html>