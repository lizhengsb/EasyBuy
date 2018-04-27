<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="form" action="McommentServlet?action=selectAll-guest" method="post">
		<table align="right">
			<tr>
				<td>总共${Guestlist.totalPage}页</td>
				<td></td>
				<td><input type="button" id="before"
					onclick="changepage(this.id)" value="<"/></td>
				<td>当前第<select name="nowPage" id="sel"
					onchange="gopage(this.value)">
						<c:forEach begin="1" end="${Guestlist.totalPage}" var="p">
							<option value="${p }">${p }</option>
						</c:forEach>
				</select>页
				</td>
				<td><input type="button" id="next"
					onclick="changepage(this.id)" value=">" /></td>
		</table>
</form>
	<script>
		var p=document.getElementById("sel").value = ${Guestlist.nowPage};
		if(p=="1"){
			var obj=document.getElementById("before");
			obj.style.display="none";
		}else if(p=="${Guestlist.totalPage}"){
			var ob=document.getElementById("next");
			ob.style.display="none";
		}else if("1"=="${Guestlist.totalPage}"){
			var obj=document.getElementById("before");
			obj.style.display="none";
			var ob=document.getElementById("next");
			ob.style.display="none";
		}
		
		function gopage(value) {
			form.submit();
		}
		function changepage(id) {
			var nowPageStr = document.getElementById("sel").value;
			var nowPage = parseInt(nowPageStr);
			if (id == "next") {
				document.getElementById("sel").value = nowPage + 1;
				form.submit();
			} else {
				document.getElementById("sel").value = nowPage - 1;
				form.submit();
			}
		}
	</script>
</body>
</html>