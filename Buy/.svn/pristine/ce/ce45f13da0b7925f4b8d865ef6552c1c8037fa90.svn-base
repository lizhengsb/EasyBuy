<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
	<%@ include file="MainIndex.jsp" %>
	
	
	<div id="main" class="wrap">
		
		<div id="product" class="main">
			<h1>${Productviews.name}</h1>
			<div class="infos">
				<div class="thumb">
					<img src="/img/${Productviews.url }"  width="320px" height="178px"/>
				</div>
				<div class="buy">
					<p>
						商城价：<span class="price">${Productviews.price }</span>
					</p>
					<p>库 存：${Productviews.numl }</p>
					
					<div class="button">
						<a href="shopping.jsp" />购买</a>&nbsp;&nbsp;&nbsp;&nbsp;<a
							href="ShoppingServlet?action=buy&pid=${Productviews.id}&price=${Productviews.price }&uid=${user.id}">放入购物车</a>
					</div>
				</div>
				<div class="clear"></div>
			</div>
			<div class="introduce">
				<h2>
					<strong>商品详情</strong>
				</h2>
				<div class="text">
					<p>描述：${Productviews.description}</p>
				</div>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2015 天智立软件教育 All Rights
		Reserved. 京ICP证1000001号</div>


</body>
</html>