<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
<base href="http://localhost:8080/BookProject/">
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
	<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
		<%@include file="/pages/common/login_success_common.jsp"%>


		<script type="text/javascript">
			$(function () {
				$(".updateC").change(function () {
					var name = $(this).attr("bookName");
					var id = $(this).attr('bookId');
					// 获取商品数量
					var count = this.value;
					if ( confirm("你确定要将【" + name + "】商品修改数量为：" + count + " 吗?") ) {
						//发起请求。给服务器保存修改
						location.href = "http://localhost:8080/BookProject/cartService?action=update&id="+id+"&count="+count;
					} else {
						// defaultValue属性是表单项Dom对象的属性。它表示默认的value属性值。
						this.value = this.defaultValue;
					}
				});
			});
		</script>
	</div>

	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>		
			<tr>
				<c:forEach items="${sessionScope.cart.cartItem}" var="item">
					<td>${item.name}</td>
					<td>
					<input class="updateC" type="text"

						   style="width: 80px;" value="${item.number} " bookName="${item.name}"
						   bookId="${item.id}">

					
					</td>


					<td>${item.unitPrice}</td>
					<td>${item.totalPrice}</td>

					<td><a href="/BookProject/cartService?action=delete&id=${item.id}">删除</a></td>
					<tr></tr>
					<tr></tr>
				</c:forEach>

			</tr>	
			

			
		</table>
		
		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalNumber}</span>件商品</span>
			<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalMoney}</span>元</span>
			<span class="cart_span"><a href="cartService?action=clear">清空购物车</a></span>
			<span class="cart_span"><a href="orderServlet?action=create">去结账</a></span>
		</div>
	
	</div>
	
	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>