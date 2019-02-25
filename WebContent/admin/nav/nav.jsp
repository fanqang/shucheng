<%@ page contentType="text/html; charset=utf-8"%>
<%
String name = (String)session.getAttribute("success");
%>
<script src="../js/jQuery-2.1.4.min.js"></script>
<div class="nav">
		<div class="nav_main">
			<div class="nav_a"><img src="../img/img.ico"/><div class="nav_a_son">网上书城</div></div>
			<div class="nav_b">
				<div class="nav_b_son"><a href="ShowAllBook.jsp">浏览图书</a></div>
				<div class="nav_b_son"><a href="ShoppingCar.jsp">购物车</a></div>
				<div class="nav_b_son"><a href="address.jsp">我的地址</a></div>
				<div class="nav_b_son"><a href="order.jsp">我的订单</a></div>
				<div class="nav_b_son"><a href="secede.jsp">退出登录</a></div>
			</div>
			<div class="nav_login">
				<div class="nav_login_message" id="nav_login_message">${success}</div>
				<div class="nav_login_img" id="nav_login_img"><img src="../img/user.png"/></div>
			</div>
		</div>
			
</div>
	