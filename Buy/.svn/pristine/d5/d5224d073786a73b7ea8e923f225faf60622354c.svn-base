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
	<div id="header" class="wrap">
		<div id="logo">
			<img src="images/logo.gif" />
		</div>
		<div class="help">
			${login}<a href="#" class="shopping">购物车</a><a href="login.jsp">登录</a><a
				href="zhuce.jsp">注册</a><a href="McommentServlet?action=index-fenye">留言</a>
		</div>
		<div class="navbar">
			<ul class="clearfix">
				<li class="current"><a href="index.jsp">首页</a></li>
				<li><a href="#">图书</a></li>
				<li><a href="#">百货</a></li>
				<li><a href="#">品牌</a></li>
				<li><a href="#">促销</a></li>
			</ul>
		</div>
	</div>
	<div id="childNav">
		<div class="wrap">
			<ul class="clearfix">
				<li class="first"><a href="#">音乐</a></li>
				<li><a href="#">影视</a></li>
				<li><a href="#">少儿</a></li>
				<li><a href="#">动漫</a></li>
				<li><a href="#">小说</a></li>
				<li><a href="#">外语</a></li>
				<li><a href="#">数码相机</a></li>
				<li><a href="#">笔记本</a></li>
				<li><a href="#">羽绒服</a></li>
				<li><a href="#">秋冬靴</a></li>
				<li><a href="#">运动鞋</a></li>
				<li><a href="#">美容护肤</a></li>
				<li><a href="#">家纺用品</a></li>
				<li><a href="#">婴幼奶粉</a></li>
				<li><a href="#">饰品</a></li>
				<li class="last"><a href="#">Investor Relations</a></li>
			</ul>
		</div>
	</div>
	<div class="wrap">
		<div id="shopping">
			<form action="ShoppingServlet?action=order" method="post">
				<table>
					<tr>
						<th>商品名称</th>
						<th>商品价格</th>
						<th>购买数量</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${cartlist }" var="c">
						<c:forEach items="${carturl}" var="url">
							<c:if test="${c.productid==url.id }">
								<tr id="product_id_1">
									<td class="thumb">
									<input type="hidden" name="uid" value="${c.userid }" onclick="total()"/>
									<input type="checkbox" name="check" value="${c.id }"/>
									<img src="/img/${url.url } " width="38px" height="50px" />
									<a href="MproductServlet?action=getproductIndex&id=${url.id}">${url.name}</a></td>
									<td class="price" id="price_id_1"><span >￥${c.total }</span> 
									<input type="hidden" name="priceee" value="${c.total }" /></td>
									<td >
											<a href="ShoppingServlet?action=jian&uid=${c.userid }&pid=${c.productid} " name="jian">减少</a>
											
											<input type="text" name="numl" value="${c.numl }" size="5" readonly="readonly"/>
											
											<a href="ShoppingServlet?action=jia&uid=${c.userid }&pid=${c.productid }">增加</a>
										
									</td>
									<td class="delete"><a href="ShoppingServlet?action=delete&uid=${c.userid }&pid=${c.productid }">删除</a></td>
								</tr>
							</c:if>
						</c:forEach>
					</c:forEach>
				</table>
				<input type="hidden" id="totals" name="totals" value=""/>
				<div class="button">
					<input type="submit" value="" />
				</div>
			</form>
		</div>
	</div>
	<div id="footer">Copyright &copy; 2015 天智立软件教育 All Rights
		Reserved. 京ICP证1000001号</div>
		
<script type="text/javascript">
	
	var cs=document.getElementsByName("check");
	var total=document.getElementsByName("priceee");
	for(var i=0;i< cs.length;i++){
    	cs[i].onclick=function cal(){
    		call()
    	};
	}
   	function call() {
   		var totals=0;
       for(var j=0;j<cs.length;j++){
    	   if(cs[j].checked==true){
    		  	totals+=parseFloat(total[j].value);
    		  	
    	   }
       }
       document.getElementById("totals").value=totals;
    }
    


</script>		
</body>
</html>
